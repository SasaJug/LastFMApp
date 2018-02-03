package com.sasaj.lastfmapp.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.ui.interfaces.OnSingleFragmentInteractionListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnSingleFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link SingleArtistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleArtistFragment extends Fragment {
    private static final String MBID = "mbid";

    private String mbid;

    private OnSingleFragmentInteractionListener mListener;

    public SingleArtistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mbid mbid.
     * @return A new instance of fragment SingleArtistFragment.
     */
    public static SingleArtistFragment newInstance(String mbid) {
        SingleArtistFragment fragment = new SingleArtistFragment();
        Bundle args = new Bundle();
        args.putString(MBID, mbid);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSingleFragmentInteractionListener) {
            mListener = (OnSingleFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mbid = getArguments().getString(MBID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_artist, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
