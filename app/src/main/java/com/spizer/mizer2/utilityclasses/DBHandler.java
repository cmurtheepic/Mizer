package com.spizer.mizer2.utilityclasses;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_NAME = "sessionentry";
    public static final String COLUMN_NAME_SESSIONENTRY_ID = "entryid";
    public static final String COLUMN_FORMAT_DATE = "sessiondatecode";
    public static final String COLUMN_TYPE_ARITHMETIC = "sessionmatharithmetictype";
    public static final String COLUMN_TYPE_OPERATION_NAME = "sessionoperation";
    public static final String COLUMN_DATA_PROBLEMNUMBER_1 = "sessionproblemnum1";
    public static final String COLUMN_DATA_PROBLEMNUMBER_2 = "sessionproblemnum2";
    public static final String COLUMN_DATA_SCORE = "sessionscore";

    public DBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

    }

}