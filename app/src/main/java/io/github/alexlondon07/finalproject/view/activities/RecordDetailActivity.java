package io.github.alexlondon07.finalproject.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.Constants;
import io.github.alexlondon07.finalproject.model.MovieInfo;
import io.github.alexlondon07.finalproject.presenter.DetailRecordPresenter;
import io.github.alexlondon07.finalproject.repository.RecordRepository;
import io.github.alexlondon07.finalproject.view.BaseActivity;

public class RecordDetailActivity extends BaseActivity<DetailRecordPresenter> implements IRecordDetail  {

    private static final String TAG = "RecordDetailActivity";
    private TextView name, date, sipnosis, genre;
    private ImageView avatar;
    private MovieInfo movieInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setPresenter(new DetailRecordPresenter(new RecordRepository()));
        getPresenter().inject(this, getValidateInternet());
        createProgresDialog();

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
    public void showAlertDialog(int error) {

    }


    @Override
    public void showToast(String msg) {

    }

    public void goToMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
