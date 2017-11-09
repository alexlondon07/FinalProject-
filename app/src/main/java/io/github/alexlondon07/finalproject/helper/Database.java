package io.github.alexlondon07.finalproject.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by alexlondon07 on 9/30/17.
 */

public class Database {

    private final Context context;
    private DatabaseHelper dbHelper;

    //DAO´S
    //public static ProductDao productDao;


    public Database(Context context) {
        this.context = context;
    }

    public Database open(){
        try {
            dbHelper = new DatabaseHelper(context);
            SQLiteDatabase sdb = dbHelper.getWritableDatabase();
            //productDao = new ProductDao(sdb);
            return this;
        }catch (SQLException ex){
            Log.e("SQL OPEN ", ex.getMessage());
            throw ex;
        }
    }

    public void close(){
        dbHelper.close();
    }
}
