package io.github.alexlondon07.finalproject.view.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.Constants;
import io.github.alexlondon07.finalproject.model.MovieInfo;
import io.github.alexlondon07.finalproject.presenter.RecordPresenter;
import io.github.alexlondon07.finalproject.view.BaseActivity;
import io.github.alexlondon07.finalproject.view.adapter.RecordAdapter;

public class RecordActivity extends BaseActivity<RecordPresenter> implements IRecordView {

    private static final String TAG = "RecordActivity";
    private ListView recordsList;
    private RecordAdapter recordAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        setPresenter(new RecordPresenter());
        getPresenter().inject(this, getValidateInternet());
        createProgresDialog();
        getPresenter().getRecordPresenter();
        recordsList = findViewById(R.id.records_list_view);
    }


    private void callAdapter(final ArrayList<MovieInfo> movieInfoList) {
        recordAdapter = new RecordAdapter(this, R.id.records_list_view, movieInfoList);
        recordsList.setAdapter(recordAdapter);

        recordsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(RecordActivity.this, RecordDetailActivity.class);
                MovieInfo movieInfo = movieInfoList.get(position);
                Log.i(TAG, movieInfo.getId());
                intent.putExtra(Constants.ITEM_RECORD, movieInfo);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getRecordPresenter();
    }


    @Override
    public void showMovies(final ArrayList<MovieInfo> movieInfoArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callAdapter(movieInfoArrayList);
            }
        });
    }

    @Override
    public void showAlertDialogInternet( int title,  int message) {
        showAlertDialog(title, message);
    }

    private void showAlertDialog(final int title, final int message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().getRecordPresenter();
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

    @Override
    public void showAlertError(int error, int error2) {

    }

    @Override
    public void showAlertError(int error, String error2) {

    }
}
