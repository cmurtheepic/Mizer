package com.spizer.mizer2.utilityclasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by connor on 10/6/2015.
 */
public class SQL_Sessions_Database {

//    SessionReaderDbHelper mDbHelper = new SessionReaderDbHelper(getContext());

    public final class SessionListReaderContract {
        // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        public SessionListReaderContract() {}

        // This class defines the database that holds the Session(s) data
        public abstract class SessionEntry implements BaseColumns {
            public static final String TABLE_NAME = "sessionentry";
            public static final String COLUMN_NAME_SESSIONENTRY_ID = "entryid";
            public static final String COLUMN_FORMAT_DATE = "sessiondatecode";
            public static final String COLUMN_TYPE_ARITHMETIC = "sessionmatharithmetictype";
            public static final String COLUMN_TYPE_OPERATION_NAME = "sessionoperation";
            public static final String COLUMN_DATA_PROBLEMNUMBER_1 = "sessionproblemnum1";
            public static final String COLUMN_DATA_PROBLEMNUMBER_2 = "sessionproblemnum2";
            public static final String COLUMN_DATA_SCORE = "sessionscore";
        }

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String LINE_SEP = "|";

        // creates the entries for the database
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + SessionListReaderContract.SessionEntry.TABLE_NAME + " (" +
                        SessionListReaderContract.SessionEntry._ID + " INTEGER PRIMARY KEY," +
                        SessionListReaderContract.SessionEntry.COLUMN_NAME_SESSIONENTRY_ID +
                        TEXT_TYPE + COMMA_SEP +
                        SessionListReaderContract.SessionEntry.COLUMN_FORMAT_DATE + TEXT_TYPE +
                        LINE_SEP + SessionListReaderContract.SessionEntry.COLUMN_TYPE_ARITHMETIC +
                        TEXT_TYPE + COMMA_SEP +
                        SessionListReaderContract.SessionEntry.COLUMN_TYPE_OPERATION_NAME +
                        TEXT_TYPE + COMMA_SEP +
                        SessionListReaderContract.SessionEntry.COLUMN_DATA_PROBLEMNUMBER_1 +
                        TEXT_TYPE + COMMA_SEP +
                        SessionListReaderContract.SessionEntry.COLUMN_DATA_PROBLEMNUMBER_2 +
                        TEXT_TYPE + COMMA_SEP +
                        SessionListReaderContract.SessionEntry.COLUMN_DATA_SCORE + " )";

        // Deletes entries
        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + SessionListReaderContract.SessionEntry.TABLE_NAME;

        // Gets the data repository in write mode
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
//        values.put(SessionListReaderContract.SessionEntry.COLUMN_NAME_SESSIONENTRY_ID, id);
//        values.put(SessionListReaderContract.SessionEntry.COLUMN_NAME_TITLE, title);
//        values.put(SessionListReaderContract.SessionEntry.COLUMN_NAME_CONTENT, content);
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId = db.insert(
//                SessionListReaderContract.SessionEntry.TABLE_NAME,
//                SessionListReaderContract.SessionEntry.COLUMN_NAME_NULLABLE, values);

    }

    public class SessionReaderDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Sessions.db";

        public SessionReaderDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SessionListReaderContract.SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SessionListReaderContract.SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
