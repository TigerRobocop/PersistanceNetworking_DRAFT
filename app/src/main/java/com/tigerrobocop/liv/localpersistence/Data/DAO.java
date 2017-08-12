package com.tigerrobocop.liv.localpersistence.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tigerrobocop.liv.localpersistence.Model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Livia on 12/08/2017.
 */

public class DAO {

    private DBHelper helper;

    public DAO(Context ctx) {
        helper = new DBHelper(ctx);
    }

    public void Insert(Car car){

        try {
            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues cv = new ContentValues();

            cv.put(DBHelper.COL_ID, car.id);
            cv.put(DBHelper.COL_NAME, car.name);
            cv.put(DBHelper.COL_YEAR, car.year);

            long id = db.insert(DBHelper.TBL_CAR
            , null
            , cv);

            if (id == -1)
                throw new RuntimeException("Error inserting into db");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public int GetCount(){

        int ct = 0;
        try {
            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM "+ DBHelper.TBL_CAR
                , null);

            int length = cursor.getCount();

            ct = length +1;
            return ct;

        } catch(Exception e){
            e.printStackTrace();
        }

        return  ct;
    }

    public List<Car> GetAll(){

        List<Car> result = new ArrayList<Car>();
        try {

            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM "+ DBHelper.TBL_CAR
                    + " ORDER BY " + DBHelper.COL_NAME, null);

            int index_id = cursor.getColumnIndex(DBHelper.COL_ID);
            int index_name = cursor.getColumnIndex(DBHelper.COL_NAME);
            int index_year = cursor.getColumnIndex(DBHelper.COL_YEAR);

            while(cursor.moveToNext()){
                int id = cursor.getInt(index_id);
                String name = cursor.getString(index_name);
                String year = cursor.getString(index_year);

                Car c = new Car(id, name, year);
                result.add(c);
            }

            cursor.close();

        } catch(Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    public void Delete(Car car){
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete(DBHelper.TBL_CAR, DBHelper.COL_ID + " = ? "
                , new String[]{String.valueOf(car.id)}
        );

        db.close();

    }
}
