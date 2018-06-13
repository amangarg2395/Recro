package com.amangarg.recrotask2.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
    Context context;
//    private static SQLiteHandler dbHandler;
    private static SQLiteDatabase dbHandlerWrite;
    private static SQLiteDatabase dbHandlerRead;

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "android_api.db";

    // Login table name
    private static final String TABLE_USER = "user";
    // Login Table Columns names
    private static final String KEY_ID = "userid";
    private static final String KEY_FIRST_NAME = "firstname";
    private static final String KEY_LAST_NAME = "lastname";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String KEY_PHOTO_KEY = "photo";

    public Database(Context context){
        this.context = context;
    }

    private class SQLiteHelper extends SQLiteOpenHelper {

        public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
