package com.example.ikitama_larose_crud_db_interne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*
    *NOMS:EBONGA IKITAMA
    * PRENOMS:Bellevie Larose
    * Classe:Master-PRG18-Sup'Info
    * */

    Button btnStudentFormular,btnStudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStudentFormular=findViewById(R.id.btnStudentFormular);
        btnStudentFormular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, StudentFormularActivity.class);
                startActivity(intent);
            }
        });

        btnStudentList=findViewById(R.id.btnStudentList);
        btnStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });
    }
}