package io.github.alexlondon07.finalproject.view.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.presenter.RecordPresenter;
import io.github.alexlondon07.finalproject.repository.RecordRepository;
import io.github.alexlondon07.finalproject.view.BaseActivity;

public class RecordActivity extends BaseActivity<RecordPresenter> implements IRecordView {

    private static final String TAG = "RecordActivity";
    private ListView listView;
    private List<String> billboards;
    private RecordRepository recordRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        listView = findViewById(R.id.billboard_list_view);

        //Data Example
        billboards = new ArrayList<>();
        billboards.add("6 DAYS");
        billboards.add("PANDEMIA");
        billboards.add("ATÓMICA");
        billboards.add("SLEIGHT");
        billboards.add("DESAPARECIDO");
        billboards.add("TORRE OSCURA");


        Records records = recordRepository.getRecords();

        Log.i(TAG, records.getDate());

        //My adapter Example
        MyadapterExample myadapterExample = new MyadapterExample(this, R.layout.billboard_item, billboards);
        listView.setAdapter(myadapterExample);
    }

    @Override
    public void showRecords(ArrayList<Records> recordsArrayList) {

    }

    @Override
    public void showAlertDialogInternet(int error, int validate_internet) {

    }

    @Override
    public void showAlertError(int error, int error2) {

    }

    @Override
    public void showAlertError(int error, String error2) {

    }
}
