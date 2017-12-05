package io.github.alexlondon07.finalproject.view.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.Constants;
import io.github.alexlondon07.finalproject.model.MovieInfo;
import io.github.alexlondon07.finalproject.model.cinemas.Cinema;
import io.github.alexlondon07.finalproject.presenter.DetailRecordPresenter;
import io.github.alexlondon07.finalproject.view.BaseActivity;

public class RecordDetailActivity extends BaseActivity<DetailRecordPresenter> implements IRecordDetail  {

    private static final String TAG = "RecordDetailActivity";
    private TextView name, date, sipnosis, genre;
    private ImageView avatar;
    private MovieInfo movieInfo;
    private ArrayList<Cinema> cinemaArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadView();
        movieInfo = (MovieInfo) getIntent().getSerializableExtra(Constants.ITEM_RECORD);
        setDataItem();
    }

    private void setDataItem() {
        Picasso.with(this).load(movieInfo.getPoster().get(0).getXlarge()).into(avatar);
        name.setText(movieInfo.getInfo().getTitle());
        date.setText(movieInfo.getInfo().getReleasedate());
        sipnosis.setText(movieInfo.getInfo().getDescription());
        genre.setText(movieInfo.getGenre().get(0).getName().toString());
    }

    private void loadView() {
        avatar = findViewById(R.id.activity_record_detail_imageViewAvatar);
        name = findViewById(R.id.activity_record_detail_textView_name);
        date = findViewById(R.id.activity_record_detail_textView_date);
        sipnosis = findViewById(R.id.activity_record_detail_textView_sipnosis);
        genre = findViewById(R.id.activity_record_detail_textView_genre);
    }


    @Override
    public void showCinemas(ArrayList<Cinema> cinemas) {
        this.cinemaArrayList = cinemas;
    }

    public void showAlertDialog(final int title, final int message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().getCinemaPresenter();
                    }
                }, R.string.option_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        });
    }

    /**
     * Función para ir a la actividad de Mapas
     * @param view
     */
    public void goToMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}
