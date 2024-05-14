package com.example.ikitama_larose_crud_db_interne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentFormularActivity extends AppCompatActivity {

    /*
     *NOMS:EBONGA IKITAMA
     * PRENOMS:Bellevie Larose
     * Classe:Master-PRG18-Sup'Info
     * */
    EditText edtName,edtFirstname,edtClassroom,edtYear;
    Button btnCreate;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_formular);

        edtName=findViewById(R.id.edtName);
        edtFirstname=findViewById(R.id.edtFirstname);
        edtClassroom=findViewById(R.id.edtClassroom);
        edtYear=findViewById(R.id.edtYear);

        btnCreate=findViewById(R.id.btnCreate);

        DB= new DBHelper(this);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT=edtName.getText().toString();
                String firstnameTXT=edtFirstname.getText().toString();
                String classroomTXT=edtClassroom.getText().toString();
                String yearTXT=edtYear.getText().toString();

                Boolean checkInsertData=DB.insertStudentData(nameTXT,firstnameTXT,classroomTXT,yearTXT);

                if (checkInsertData==true){
                    Toast.makeText(StudentFormularActivity.this,"Etudiant ajouter",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(StudentFormularActivity.this, StudentListActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(StudentFormularActivity.this,"Erreur d'ajout",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}