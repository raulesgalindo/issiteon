package com.galindo.raules.issiteon.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.galindo.raules.issiteon.Model.database.FeedReaderDbHelper;
import com.galindo.raules.issiteon.Model.database.ddl.SQLinsert;

/**
 * Created by raul on 16/06/2017.
 */

public class DBController {
    private FeedReaderDbHelper mDbHelper;

    public DBController(Context context){
        mDbHelper = new FeedReaderDbHelper(context);
        SQLinsert sqlInsert = new SQLinsert(mDbHelper);
        sqlInsert.addIcon("e4598asejfoijase4");


    }
}
