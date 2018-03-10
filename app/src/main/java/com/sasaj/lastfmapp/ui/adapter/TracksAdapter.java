package com.sasaj.lastfmapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.domain.entity.Track;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjugurdzija on 1/21/2018.
 */

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.TracksViewHolder> {


    private final Context context;
    private List<Track> tracksList;

    public TracksAdapter(Context context) {
        this.context = context;
        tracksList = new ArrayList<>();
    }

    @Override
    public TracksAdapter.TracksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_tracks, parent, false);

        return new TracksAdapter.TracksViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TracksAdapter.TracksViewHolder holder, int position) {
        Track track = tracksList.get(position);
        Picasso.with(context).load(track.getImages().get(0).getText()).into(holder.thumbnail);
        holder.name.setText(track.getName());
        holder.artist.setText(track.getArtist().getName());
    }

    @Override
    public int getItemCount() {
        return tracksList.size();
    }

    public void setList(List<Track> list){
        tracksList = list;
        notifyDataSetChanged();
    }

    public class TracksViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        private TextView name;
        private TextView artist;

        public TracksViewHolder(final View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            name = itemView.findViewById(R.id.name);
            artist = itemView.findViewById(R.id.artist);
        }

    }
}