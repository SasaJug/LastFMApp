package com.sasaj.lastfmapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.httpclient.RetrofitClient;
import com.sasaj.lastfmapp.ui.adapter.ArtistAdapter;
import com.sasaj.lastfmapp.utility.InjectorUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArtistsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtistsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView list;
    private ArtistAdapter adapter;

    public ArtistsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArtistsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArtistsFragment newInstance(String param1, String param2) {
        ArtistsFragment fragment = new ArtistsFragment();
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
        View root = inflater.inflate(R.layout.fragment_artists, container, false);

        list = root.findViewById(R.id.artist_list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ArtistAdapter(getContext());
        list.setAdapter(adapter);
        getArtists();
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public void getArtists() {
        InjectorUtils.provideRepository(getContext()).getArtists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chart -> setArtistsList(chart.getArtists().getArtist()));
    }

    public void setArtistsList(List<Artist> artists) {
        if (adapter != null)
            adapter.setList(artists);
    }
}
