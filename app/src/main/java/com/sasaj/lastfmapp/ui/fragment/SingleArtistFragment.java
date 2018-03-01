package com.sasaj.lastfmapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasaj.lastfmapp.LastFmApplication;
import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.Repository;
import com.sasaj.lastfmapp.di.LastFmComponent;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.sasaj.lastfmapp.domain.entity.Image;
import com.sasaj.lastfmapp.ui.interfaces.OnSingleFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

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
        View root = inflater.inflate(R.layout.fragment_single_artist, container, false);
        TextView name = root.findViewById(R.id.artist_name);
        ImageView image = root.findViewById(R.id.artist_image);

        LastFmComponent component = ((LastFmApplication)getActivity().getApplication()).getLastFmComponent();
        Repository repository = component.getRepository();

        Artist artist = repository.getArtist(mbid).blockingFirst();
        List<Image> artistImages = repository.getImages(mbid).blockingFirst();

        name.setText(artist.getName());
        Picasso.with(getActivity()).load(artistImages.get(artistImages.size() - 1).getText()).into(image);
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
