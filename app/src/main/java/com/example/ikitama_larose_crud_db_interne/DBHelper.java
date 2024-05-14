package com.example.ikitama_larose_crud_db_interne;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"Studentdata.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Students (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,name TEXT,firstname TEXT,classroom TEXT,year TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Students");
    }

    public Boolean insertStudentData(String name,String firstname, String classroom,String year){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("firstname",firstname);
        contentValues.put("classroom",classroom);
        contentValues.put("year",year);

        long result=DB.insert("Students",null,contentValues);

        if (result==-1){
            return false;
        }else{
            return true;
        }

    }

    public Boolean updateStudentData(String name,String firstname, String classroom,String year){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("firstname",firstname);
        contentValues.put("classroom",classroom);
        contentValues.put("year",year);

        Cursor cursor=DB.rawQuery("SELECT * FROM Students WHERE name=?",new String[]{name});

        if (cursor.getCount()>0){
            long result=DB.update("Students",contentValues,"name=?",new String[]{name});

            if (result==-1){
                return false;
            }else{
                return true;
            }
        }else {
            return false;
        }

    }

    public Boolean deleteStudentData(String name){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM Students WHERE name=?",new String[]{name});

        if (cursor.getCount()>0){
            long result=DB.delete("Students","name=?",new String[]{name});

            if (result==-1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public Cursor getData(){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM Students",null);
        return cursor;
    }
}
