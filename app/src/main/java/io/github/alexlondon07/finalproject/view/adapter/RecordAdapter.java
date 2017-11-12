package io.github.alexlondon07.finalproject.view.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.model.Records;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public class RecordAdapter extends ArrayAdapter<Records>  {

    private ArrayList<Records> recordsArrayList;
    private Activity context;
    private Records records;
    private ImageView imageViewAvatar;
    private TextView textView_name, textView_genre, textView_date;



    public RecordAdapter(Activity context,  int resource, ArrayList<Records> recordsArrayList){
        super(context, resource, recordsArrayList);
        this.context = context;
        this.recordsArrayList = recordsArrayList;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item, parent, false);
        this.records = this.recordsArrayList.get(position);

        loadView(convertView);

        //avatar
        imageViewAvatar.setImageURI(Uri.parse(records.getMovieInfo().get(0).getPoster().get(0).getLocation()));

        //date
        textView_date.setText(records.getDate());

        //Title movie
        textView_name.setText(records.getMovieInfo().get(0).getInfo().getTitle());

        //textView_genre.setText(records.getMovieInfo().get(0).getGenre().get(0).getName());

        return convertView;
    }


    private void loadView(View convertView) {
        textView_name = convertView.findViewById(R.id.record_item_name);
        textView_date = convertView.findViewById(R.id.record_item_date);
        imageViewAvatar = convertView.findViewById(R.id.record_item_avatar);
        textView_genre = convertView.findViewById(R.id.record_item_genre);
    }
}
