package com.tigerrobocop.liv.localpersistence.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Livia on 12/08/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "dbLocal";
    public static final int DB_VERSION = 1;

    public static final String TBL_CAR = "tbl_Car";

    public static final String COL_dbID = "col_dbId";
    public static final String COL_ID = "col_id";
    public static final String COL_NAME = "col_Name";
    public static final String COL_YEAR = "col_Year";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TBL_CAR + "(" +
                COL_dbID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ID + " INTEGER NOT NULL, " +
                COL_NAME + " TEXT, " +
                COL_YEAR + " TEXT  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
