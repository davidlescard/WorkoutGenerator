package com.lescard.workoutgenerator.app.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lescard.workoutgenerator.app.assist.Util;

/**
 * Created by davidlescard on 4/26/14.
 */
public class ExerciseDBOpenHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase database;


    private static final String EXERCISE_TABLE_CREATE =
            "CREATE TABLE " + Util.EXERCISE_TABLE_NAME + " (" +
                    Util.EXERCISE_TABLE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Util.EXERCISE_TABLE_COL_EXERCISE_NAME + " TEXT, " +
                    Util.EXERCISE_TABLE_COL_MUSC_GRP_NAME + " TEXT, " +
                    Util.EXERCISE_TABLE_COL_EQUIP_NAME + " TEXT);";

    ExerciseDBOpenHelper(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    private void populateDatabase(SQLiteDatabase db) {
        Util.populateArray();
        ContentValues values = new ContentValues();
        for(int i = 0; i < Util.MAX_NUM_EXERCISES; i++) {
            values.put(Util.EXERCISE_TABLE_COL_EXERCISE_NAME, Util.allExercises[i][0]);
            values.put(Util.EXERCISE_TABLE_COL_MUSC_GRP_NAME, Util.allExercises[i][1]);
            values.put(Util.EXERCISE_TABLE_COL_EQUIP_NAME, Util.allExercises[i][2]);
            db.insert(Util.EXERCISE_TABLE_NAME, null, values);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + Util.EXERCISE_TABLE_NAME + ";");
        Log.i("ExerciseDBOpenHelper", "onCreate called");
        db.execSQL(EXERCISE_TABLE_CREATE);
        populateDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do not much
    }
}
