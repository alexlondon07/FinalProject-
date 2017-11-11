package io.github.alexlondon07.finalproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.github.alexlondon07.finalproject.R;

public class RecordActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> billboards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        //My adapter Example
        MyadapterExample myadapterExample = new MyadapterExample(this, R.layout.billboard_item, billboards);
        listView.setAdapter(myadapterExample);
    }
}
