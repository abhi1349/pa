package com.example.abhi.prakitianalysis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PrakritiDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "app.db";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;

    public PrakritiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_PRAKRITI_TABLE = "CREATE TABLE "+ PrakritiContract.PrakritiQuestion.TABLE_NAME +"("
                + PrakritiContract.PrakritiQuestion._ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION + " TEXT NOT NULL,"
                + PrakritiContract.PrakritiQuestion.COLUMN_PITTA + " TEXT NOT NULL,"
                + PrakritiContract.PrakritiQuestion.COLUMN_KAPHA + " TEXT NOT NULL,"
                + PrakritiContract.PrakritiQuestion.COLUMN_VATA + " TEXT NOT NULL"
                + ");" ;

        db.execSQL(SQL_CREATE_PRAKRITI_TABLE);
        sqLiteDatabase = db;

    }

    public void insert(){
        sqLiteDatabase = this.getWritableDatabase();
        PrakritiData.insertPrakritiData(sqLiteDatabase);
    }
    public Cursor getAll(){
        sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+PrakritiContract.PrakritiQuestion.TABLE_NAME,null);
        if (cursor.getCount()>0){
            return cursor;
        }
        cursor.close();
        return null;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PrakritiContract.PrakritiQuestion.TABLE_NAME);
        onCreate(db);
    }
}
