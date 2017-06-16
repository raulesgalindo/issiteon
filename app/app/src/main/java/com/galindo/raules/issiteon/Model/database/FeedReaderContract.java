package com.galindo.raules.issiteon.Model.database;

import android.provider.BaseColumns;

/**
 * Created by raul on 16/06/2017.
 */

public final class FeedReaderContract {
    private static String TEXT_TYPE = " TEXT";
    private static String NUMERIC_TYPE = " NUMERIC";
    private static String INT_TYPE = " INTEGER";
    private static String BLOB_TYPE = " BLOB";
    private static String COMMA_SEP = " ,";
    private static String SEMICOLON_SEP = " ;";
    private static String PRIMARY_ORNAMENTS = " PRIMARY KEY AUTOINCREMENT";
    private static String formatForeignKey(String columnName, String tableRef, String columnNameRef){
        return String.format("FOREIGN KEY(%s) REFERENCES %s(%s)", columnName, tableRef, columnNameRef);
    }
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedIcon implements BaseColumns {
        public static final String TABLE_NAME = "icon";
        public static final String COLUMN_NAME_ICON_IMAGE = "icon_image";
    }
    public static class FeedAlarmCounter implements BaseColumns {
        public static final String TABLE_NAME = "alarm_counter";
        public static final String COLUMN_NAME_IS_ACTIVE = "is_active";
        public static final String COLUMN_NAME_IS_ALARM_ACTIVE = "is_alarm_active";
        public static final String COLUMN_NAME_REMAINING_TIME = "remaining_time";
    }
    public static class FeedSite implements BaseColumns {
        public static final String TABLE_NAME = "site";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_NOTIFY_TIME = "notify_time";
        public static final String COLUMN_NAME_ID_ICON = "id_icon";
        public static final String COLUMN_NAME_ID_ALARM_COUNTER = "id_alarm_counter";
    }
    public static class FeedLog implements BaseColumns {
        public static final String TABLE_NAME = "log";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_LOG_TIMESTAMP = "subtitle";
        public static final String COLUMN_NAME_ID_SITE = "id_site";

    }
    private static String SQL_CREATE_TABLE_ICON =
            "CREATE TABLE " + FeedIcon.TABLE_NAME + " (" +
                    FeedIcon._ID + INT_TYPE+ PRIMARY_ORNAMENTS + COMMA_SEP +
                    FeedIcon.COLUMN_NAME_ICON_IMAGE + BLOB_TYPE + " )";
    private static String SQL_CREATE_TABLE_ALARM_COUNTER =
            "CREATE TABLE " + FeedAlarmCounter.TABLE_NAME + " (" +
                    FeedAlarmCounter._ID + INT_TYPE+ PRIMARY_ORNAMENTS + COMMA_SEP +
                    FeedAlarmCounter.COLUMN_NAME_IS_ACTIVE + NUMERIC_TYPE + COMMA_SEP +
                    FeedAlarmCounter.COLUMN_NAME_IS_ALARM_ACTIVE + NUMERIC_TYPE + COMMA_SEP +
                    FeedAlarmCounter.COLUMN_NAME_REMAINING_TIME + INT_TYPE + " )";
    private static String SQL_CREATE_TABLE_SITE =
            "CREATE TABLE " + FeedSite.TABLE_NAME + " (" +
                    FeedSite._ID + INT_TYPE+ PRIMARY_ORNAMENTS + COMMA_SEP +
                    FeedSite.COLUMN_NAME_URL + TEXT_TYPE + COMMA_SEP +
                    FeedSite.COLUMN_NAME_NOTIFY_TIME + INT_TYPE + COMMA_SEP +
                    FeedSite.COLUMN_NAME_ID_ICON + INT_TYPE + COMMA_SEP +
                    FeedSite.COLUMN_NAME_ID_ALARM_COUNTER + INT_TYPE + COMMA_SEP +
                    formatForeignKey(FeedSite.COLUMN_NAME_ID_ICON, FeedIcon.TABLE_NAME, FeedIcon._ID)+ COMMA_SEP +
                    formatForeignKey(FeedSite.COLUMN_NAME_ID_ALARM_COUNTER, FeedAlarmCounter.TABLE_NAME, FeedAlarmCounter._ID) +
                    " )";
    private static String SQL_CREATE_TABLE_LOG =
            "CREATE TABLE " + FeedLog.TABLE_NAME + " (" +
                    FeedLog._ID + INT_TYPE+ PRIMARY_ORNAMENTS + COMMA_SEP +
                    FeedLog.COLUMN_NAME_STATUS + INT_TYPE + COMMA_SEP +
                    FeedLog.COLUMN_NAME_LOG_TIMESTAMP + TEXT_TYPE + COMMA_SEP +
                    FeedLog.COLUMN_NAME_ID_SITE + INT_TYPE + COMMA_SEP +
                    formatForeignKey(FeedLog.COLUMN_NAME_ID_SITE, FeedSite.TABLE_NAME, FeedSite._ID) +
                     " )";
    public static final String SQL_CREATE_ENTRIES =
            SQL_CREATE_TABLE_ICON + SEMICOLON_SEP +
            SQL_CREATE_TABLE_ALARM_COUNTER + SEMICOLON_SEP +
            SQL_CREATE_TABLE_SITE + SEMICOLON_SEP +
            SQL_CREATE_TABLE_LOG + SEMICOLON_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedLog.TABLE_NAME + SEMICOLON_SEP +
            "DROP TABLE IF EXISTS " + FeedSite.TABLE_NAME + SEMICOLON_SEP +
            "DROP TABLE IF EXISTS " + FeedAlarmCounter.TABLE_NAME + SEMICOLON_SEP +
            "DROP TABLE IF EXISTS " + FeedIcon.TABLE_NAME + SEMICOLON_SEP ;

}
