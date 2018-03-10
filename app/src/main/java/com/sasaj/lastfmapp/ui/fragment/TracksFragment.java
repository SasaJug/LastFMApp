package com.sasaj.lastfmapp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sasaj.lastfmapp.LastFmApplication;
import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.di.LastFmComponent;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Track;
import com.sasaj.lastfmapp.ui.SingleItemActivity;
import com.sasaj.lastfmapp.ui.adapter.ReactiveArtistItemHolder;
import com.sasaj.lastfmapp.ui.adapter.ArtistReactiveRecyclerAdapter;
import com.sasaj.lastfmapp.ui.adapter.ReactiveTrackItemHolder;
import com.sasaj.lastfmapp.ui.adapter.TrackReactiveRecyclerAdapter;
import com.sasaj.lastfmapp.ui.interfaces.OnFragmentInteractionListener;

import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link TracksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TracksFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView list;
    private Disposable disposable;

    public TracksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TracksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TracksFragment newInstance(String param1, String param2) {
        TracksFragment fragment = new TracksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tracks, container, false);

        list = root.findViewById(R.id.track_list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        TrackReactiveRecyclerAdapter.ReactiveViewHolderFactory<Track> viewAndHolderFactory = (parent, pViewType) -> {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tracks, parent, false);
            return new TrackReactiveRecyclerAdapter.ReactiveViewHolderFactory.ViewAndHolder<Track>(
                    view,
                    new ReactiveTrackItemHolder<>(view, getActivity())
            );
        };
        LastFmComponent component = ((LastFmApplication)getActivity().getApplication()).getLastFmComponent();
        TrackReactiveRecyclerAdapter<Track> reactiveRecyclerAdapter = new TrackReactiveRecyclerAdapter<Track>(component.getRepository().getTracks().toObservable(), viewAndHolderFactory);
        list.setAdapter(reactiveRecyclerAdapter);
        if (savedInstanceState == null) {
            component.getRepository().refreshTracks();
        }
        disposable = reactiveRecyclerAdapter.getViewClickedObservable()
                .subscribe(track -> {
                    Intent intent = SingleItemActivity.intentFactory(getContext(), SingleItemActivity.TRACK, track.getId());
                    startActivity(intent);
                });
        return root;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        disposable.dispose();
        mListener = null;
    }

}
