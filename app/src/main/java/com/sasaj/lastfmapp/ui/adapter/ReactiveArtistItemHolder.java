package com.sasaj.lastfmapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasaj.lastfmapp.R;
import com.sasaj.lastfmapp.domain.entity.Artist;
import com.squareup.picasso.Picasso;

/**
 * Created by sjugurdzija on 2/3/2018.
 */

public class ReactiveArtistItemHolder<T> extends ReactiveRecyclerAdapter.ReactiveViewHolder<T> {

    private Context context;
    private ImageView thumbnail;
    private TextView name;
    private TextView count;
    private T artist;

    public ReactiveArtistItemHolder(View itemView, Context context) {
        super(itemView);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        name = itemView.findViewById(R.id.name);
        count = itemView.findViewById(R.id.count);
        this.context = context;
    }

    @Override
    public void setCurrentItem(T currentItem) {
        this.artist = currentItem;

        try {
            Picasso.with(context).load(((Artist) artist).getImage().get(0).getText()).into(thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        name.setText(((Artist) artist).getName());
        count.setText(((Artist) artist).getPlaycount());


    }

    public T getCurrentItem() {
        return artist;
    }
}
