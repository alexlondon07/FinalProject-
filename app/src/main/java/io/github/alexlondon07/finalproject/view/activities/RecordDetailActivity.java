package io.github.alexlondon07.finalproject.view.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.Constants;
import io.github.alexlondon07.finalproject.model.MovieInfo;
import io.github.alexlondon07.finalproject.presenter.DetailRecordPresenter;
import io.github.alexlondon07.finalproject.repository.RecordRepository;
import io.github.alexlondon07.finalproject.view.BaseActivity;

public class RecordDetailActivity extends BaseActivity<DetailRecordPresenter> implements IRecordDetail  {

    private TextView name, date, sipnosis;
    private ImageView avatar;
    private MovieInfo movieInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setPresenter(new DetailRecordPresenter(new RecordRepository()));
        getPresenter().inject(this, getValidateInternet());
        createProgresDialog();

        loadView();
        movieInfo = (MovieInfo) getIntent().getSerializableExtra(Constants.ITEM_RECORD);
        setDataItem();

    }

    private void setDataItem() {
        name.setText(movieInfo.getInfo().getTitle());
        date.setText(movieInfo.getInfo().getPostdate());
        sipnosis.setText(movieInfo.getInfo().getDescription());
    }

    private void loadView() {
        name = findViewById(R.id.textView_name);
        date = findViewById(R.id.textView_date);
        sipnosis = findViewById(R.id.textView_sipnosis);
    }

    @Override
    public void showAlertDialog(int error) {

    }


    @Override
    public void showToast(String msg) {

    }

}
