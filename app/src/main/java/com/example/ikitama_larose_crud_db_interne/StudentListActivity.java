package com.example.ikitama_larose_crud_db_interne;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class StudentListActivity extends AppCompatActivity {
    /*
     *NOMS:EBONGA IKITAMA
     * PRENOMS:Bellevie Larose
     * Classe:Master-PRG18-Sup'Info
     * */
    ListView lvStudentItems;
    SimpleCursorAdapter simpleCursorAdapter;

    DBHelper DB;

    //TextView tvName;
    //Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        //btnDelete=findViewById(R.id.btnDelete);

        DB=new DBHelper(this);
        Cursor cursor=DB.getData();

        if (cursor.getCount()==0){
            Toast.makeText(StudentListActivity.this, "Aucun Etudiants enregistré", Toast.LENGTH_SHORT).show();
            return;
        }else{
            lvStudentItems=findViewById(R.id.lvStudentItems);
            String[] from={"name","firstname","classroom","year"};
            int [] to={R.id.tvName,R.id.tvFirstname,R.id.tvClassroom,R.id.tvYear};
            simpleCursorAdapter=new SimpleCursorAdapter(StudentListActivity.this,R.layout.student_list_item,cursor,from,to,0);
            lvStudentItems.setAdapter(simpleCursorAdapter);

            simpleCursorAdapter.changeCursor(cursor);



            //Delete Student
//            btnDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Boolean checkDeleteData=DB.deleteStudentData(tvName.getText().toString());
//
//                    if (checkDeleteData==true){
//                        Toast.makeText(StudentListActivity.this, "Etudiant supprimé", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(StudentListActivity.this, "Etudiant non supprimé", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
        }


    }
}