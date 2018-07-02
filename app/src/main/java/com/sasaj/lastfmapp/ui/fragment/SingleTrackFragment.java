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
import com.sasaj.lastfmapp.di.LastFmComponent;
import com.sasaj.lastfmapp.repository.Repository;
import com.sasaj.lastfmapp.domain.Track;
import com.sasaj.lastfmapp.ui.interfaces.OnSingleFragmentInteractionListener;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnSingleFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SingleTrackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleTrackFragment extends Fragment {
    private static final String MBID = "mbid";
    private static final String ID = "id";

    private long id;

    private OnSingleFragmentInteractionListener mListener;

    public SingleTrackFragment() {
        // Required empty public constructor
    }

    public static SingleTrackFragment newInstance(long id) {
        SingleTrackFragment fragment = new SingleTrackFragment();
        Bundle args = new Bundle();
        args.putLong(ID, id);
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
            id = getArguments().getLong(ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_single_track, container, false);
        TextView name = root.findViewById(R.id.track_name);
        ImageView image = root.findViewById(R.id.track_image);

        LastFmComponent component = ((LastFmApplication)getActivity().getApplication()).getLastFmComponent();
        Repository repository = component.getRepository();

        Track track = repository.getTrack(id).blockingFirst();

        name.setText(track.getName());
        Picasso.with(getActivity()).load(track.getImages().get(track.getImages().size() - 1).getText()).into(image);
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
