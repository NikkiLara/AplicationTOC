package com.nicole.toc.aplicationtoc;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class historial extends AppCompatActivity {

    private DataBaseManager manager;
    private Cursor cursor;
    private Spinner spinner;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        manager = new DataBaseManager(this);
        spinner = (Spinner) findViewById(R.id.ListaPaciente);

        String[] from = new String[]{manager.CN_NAME,manager.CN_AGE};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        cursor = manager.cargarPacientes();
        adapter = new SimpleCursorAdapter(this,android.R.layout.simple_dropdown_item_1line,from,to);
        spinner.setAdapter(adapter);
    }

}
