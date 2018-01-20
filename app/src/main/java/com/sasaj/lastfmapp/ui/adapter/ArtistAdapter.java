package com.sasaj.lastfmapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DS on 1/20/2018.
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {


    private final Context context;
    private List<Artist> artistList;

    public ArtistAdapter(Context context) {
        this.context = context;
        artistList = new ArrayList<>();
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_artist, parent, false);

        return new ArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        Artist artist = artistList.get(position);
        Picasso.with(context).load(artist.getImage().get(0).getText()).into(holder.thumbnail);
        holder.name.setText(artist.getName());
        holder.count.setText(artist.getPlaycount());
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public void setList(List<Artist> list){
        artistList = list;
        notifyDataSetChanged();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        private TextView name;
        private TextView count;

        public ArtistViewHolder(final View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            name = itemView.findViewById(R.id.name);
            count = itemView.findViewById(R.id.count);
        }

    }
}
