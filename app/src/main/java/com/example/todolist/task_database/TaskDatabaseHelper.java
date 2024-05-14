package com.example.todolist.task_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDatabaseHelper extends SQLiteOpenHelper {

    public TaskDatabaseHelper(Context context) {
        super(context, com.example.todolist.task_database.TaskContract.DB_NAME, null, com.example.todolist.task_database.TaskContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + com.example.todolist.task_database.TaskContract.TaskEntry.TABLE + " ( " +
                com.example.todolist.task_database.TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                com.example.todolist.task_database.TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + com.example.todolist.task_database.TaskContract.TaskEntry.TABLE);
        onCreate(db);
    }
}
