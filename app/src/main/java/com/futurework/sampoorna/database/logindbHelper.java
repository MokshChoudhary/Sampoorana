package com.futurework.sampoorna.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class logindbHelper extends SQLiteOpenHelper {
    /** use to create table in this class*/
    private final static String CREATE_LOGIN_USER = "CREATE TABLE "+ BlankContract.BlankEnter.LOGIN_TABLE_NAME+"( " +
            BlankContract.BlankEnter._ID+"INTIGER NOT NULL PRIMARY KEY," +
            BlankContract.BlankEnter.COLUMNS_USER_NAME+"TEXT NOT NULL ,"+
            BlankContract.BlankEnter.COLUMNS_USER_BLOOD+"INTEGER NOT NULL,"+
            BlankContract.BlankEnter.COLUMNS_USER_DOB+"INTEGER NOT NULL,"+
            BlankContract.BlankEnter.COLUMNS_USER_GENDER+"INTEGER NOT NULL,"+
            BlankContract.BlankEnter.COLUMNS_USER_WEIGHT+"TEXT NOT NULL," +
            BlankContract.BlankEnter.COLUMNS_USER_PASSWORD+"PASSWORD NOT NULL"+
            ");";
    /**use to drop sampoorn user login table */
    public static final String DROP_LOGIN_TABLE = "DROP TABLE IF EXISTS "+BlankContract.BlankEnter.LOGIN_TABLE_NAME;

    /**Variable for version control in Login table*/

    public static final int LOGIN_TABLE_VERSION = 1;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public logindbHelper(@Nullable Context context) {
        super(context, BlankContract.BlankEnter.DATABASE_NAME, null, LOGIN_TABLE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LOGIN_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_LOGIN_TABLE);
        onCreate(db);
    }
}
