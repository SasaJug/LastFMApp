package com.sasaj.lastfmapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.domain.Track;
import com.squareup.picasso.Picasso;

/**
 * Created by sjugurdzija on 3/10/2018.
 */

public class ReactiveTrackItemHolder<T> extends TrackReactiveRecyclerAdapter.ReactiveViewHolder<T>  {

    private Context context;
    private ImageView thumbnail;
    private TextView name;
    private TextView artist;
    private T track;

    public ReactiveTrackItemHolder(View itemView, Context context) {
        super(itemView);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        name = itemView.findViewById(R.id.name);
        artist = itemView.findViewById(R.id.artist);
        this.context = context;
    }

    @Override
    public void setCurrentItem(T currentItem) {
        this.track = currentItem;

        try {
            Picasso.with(context).load(((Track)track).getImages().get(0).getText()).placeholder(R.drawable.ic_launcher_foreground).into(thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        name.setText(((Track)track).getName());
        artist.setText(((Track)track).getArtist().getName());


    }

    public T getCurrentItem() {
        return track;
    }
}
