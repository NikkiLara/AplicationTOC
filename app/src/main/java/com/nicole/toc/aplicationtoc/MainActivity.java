package com.nicole.toc.aplicationtoc;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    private Button historial;
    private Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historial = (Button)findViewById(R.id.historial);
        historial.setOnClickListener(this);

        agregar =(Button)findViewById(R.id.agregar);
        agregar.setOnClickListener(this);

        DataBaseManager manager = new DataBaseManager(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, historial.class);
        startActivity(intent);
        Intent intent2 = new Intent(this, NuevoPaciente.class);
        startActivity(intent2);
    }

}






