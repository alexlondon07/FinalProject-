package io.github.alexlondon07.finalproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.model.Billboard;

public class BillboardActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> billboards;
    private Billboard billboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billboard);

        listView = findViewById(R.id.billboard_list_view);

        //Data Example
        billboards = new ArrayList<>();
        billboards.add("6 DAYS");
        billboards.add("PANDEMIA");
        billboards.add("ATÓMICA");
        billboards.add("SLEIGHT");
        billboards.add("DESAPARECIDO");
        billboards.add("TORRE OSCURA");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(BillboardActivity.this, "Clicked " +billboards.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //My adapter Example
        MyadapterExample myadapterExample = new MyadapterExample(this, R.layout.billboard_item, billboards);
        listView.setAdapter(myadapterExample);
    }
}
