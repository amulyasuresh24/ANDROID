package com.example.sois.loginactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="REGISTERATION.db";
    public static final String TABLE_NAME= "LOGINTABLE";
    public static final String C1="name";
    public static final String C2="age";
    public static final String C3="height";
    public static final String C4="weight";
    public static final String C5="bloodgroup";
    public static final String C6="sugarlevel";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (name TEXT, age TEXT,height TEXT,weight TEXT,bloodgroup TEXT,sugarlevel TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String age,String height,String weight,String bloodgroup,String sugarlevel)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(C1,name);
        contentValues.put(C2,age);
        contentValues.put(C3,height);
        contentValues.put(C4,weight);
        contentValues.put(C5,bloodgroup);
        contentValues.put(C6,sugarlevel);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public Cursor getAlldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cr=db.rawQuery("SELECT  * from "+ TABLE_NAME,null);

        return cr;

    }

  public int checkUser(String name,String age,String height,String weight,String bloodgroup,String sugarlevel)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        //String params=new String[]{Name,Password};

        String SelectQuerry="Select * from " +TABLE_NAME+ " where name=? and age=? and height=? and weight=? and bloodgroup=? and sugarlevel=?";
        Cursor cr= db.rawQuery(SelectQuerry,new String[]{name,age,height,weight,bloodgroup,sugarlevel});
        int flag=0;

        if(cr.moveToFirst())
        {
            do {
                flag = 1;

            }while (cr.moveToNext());
        }
        return flag;





    }

}