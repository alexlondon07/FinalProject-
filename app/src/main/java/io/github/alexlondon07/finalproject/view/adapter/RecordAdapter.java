package io.github.alexlondon07.finalproject.view.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.model.MovieInfo;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public class RecordAdapter extends ArrayAdapter<MovieInfo> {

    private Activity context;
    private ImageView imageViewAvatar;
    private TextView textView_name, textView_genre, textView_date;
    private List<MovieInfo> movieInfoList;


    public RecordAdapter(Activity context,  int resource, List<MovieInfo> movieInfoList){
        super(context, resource, movieInfoList);
        this.context = context;
        this.movieInfoList = movieInfoList;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item, parent, false);
        loadView(convertView);

        Picasso.with(context).load(movieInfoList.get(position).getPoster().get(0).getXlarge()).into(imageViewAvatar);

        textView_date.setText(movieInfoList.get(position).getInfo().getPostdate());
        textView_name.setText(movieInfoList.get(position).getInfo().getTitle());
        textView_genre.setText(movieInfoList.get(position).getGenre().get(0).getName().toString());
        return convertView;
    }

    private void loadView(View convertView) {
        textView_name = convertView.findViewById(R.id.record_item_name);
        textView_date = convertView.findViewById(R.id.record_item_date);
        imageViewAvatar = convertView.findViewById(R.id.record_item_avatar);
        textView_genre = convertView.findViewById(R.id.record_item_genre);
    }
}
