package com.galindo.raules.issiteon.Model.database.ddl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.galindo.raules.issiteon.Model.database.FeedReaderContract;

import com.galindo.raules.issiteon.Model.database.FeedReaderDbHelper;

/**
 * Created by raul on 16/06/2017.
 */

public class SQLinsert {
    private FeedReaderDbHelper mDbHelper;
    private SQLiteDatabase db;
    public SQLinsert(FeedReaderDbHelper mDbHelper){
        this.mDbHelper = mDbHelper;
    }
    public void addIcon(String data){
        db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedIcon.COLUMN_NAME_ICON_IMAGE, data);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedReaderContract.FeedIcon.TABLE_NAME, null, values);
        db.close();
    }
}
