package com.sasaj.lastfmapp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sasaj.lastfmapp.LastFmApplication;
import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.di.LastFmComponent;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.ui.SingleItemActivity;
import com.sasaj.lastfmapp.ui.adapter.ReactiveArtistItemHolder;
import com.sasaj.lastfmapp.ui.adapter.ReactiveRecyclerAdapter;
import com.sasaj.lastfmapp.ui.interfaces.OnFragmentInteractionListener;
import com.sasaj.lastfmapp.ui.adapter.ArtistAdapter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link ArtistsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtistsFragment extends Fragment {

    public static final String TAG = ArtistsFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private RecyclerView list;
    private ArtistAdapter adapter;
    private Disposable disposable;

    public ArtistsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     */
    public static ArtistsFragment newInstance() {
        ArtistsFragment fragment = new ArtistsFragment();
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_artists, container, false);

        list = root.findViewById(R.id.artist_list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        ReactiveRecyclerAdapter.ReactiveViewHolderFactory<Artist> viewAndHolderFactory = (parent, pViewType) -> {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_artist, parent, false);
            return new ReactiveRecyclerAdapter.ReactiveViewHolderFactory.ViewAndHolder<>(
                    view,
                    new ReactiveArtistItemHolder<>(view, getActivity())
            );
        };
        LastFmComponent component = ((LastFmApplication)getActivity().getApplication()).getLastFmComponent();
        ReactiveRecyclerAdapter<Artist> reactiveRecyclerAdapter = new ReactiveRecyclerAdapter<>(component.getRepository().getArtists().toObservable(), viewAndHolderFactory);
        list.setAdapter(reactiveRecyclerAdapter);
        if (savedInstanceState == null) {
            component.getRepository().refreshArtists();
        }
        disposable = reactiveRecyclerAdapter.getViewClickedObservable()
                .subscribe(artist -> {
                    Intent intent = SingleItemActivity.intentFactory(getContext(), SingleItemActivity.ARTIST, artist.getMbid());
                    startActivity(intent);
                });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        disposable.dispose();
        mListener = null;
    }


}
