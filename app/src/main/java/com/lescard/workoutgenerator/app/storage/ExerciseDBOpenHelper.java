package com.lescard.workoutgenerator.app.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lescard.workoutgenerator.app.assist.VarHelper;

/**
 * Created by davidlescard on 4/26/14.
 */
public class ExerciseDBOpenHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase database;


    private static final String EXERCISE_TABLE_CREATE =
            "CREATE TABLE " + VarHelper.EXERCISE_TABLE_NAME + " (" +
                    VarHelper.EXERCISE_TABLE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    VarHelper.EXERCISE_TABLE_COL_EXERCISE_NAME + " TEXT, " +
                    VarHelper.EXERCISE_TABLE_COL_MUSC_GRP_NAME + " TEXT, " +
                    VarHelper.EXERCISE_TABLE_COL_EQUIP_NAME + " TEXT);";

    ExerciseDBOpenHelper(Context context) {
        super(context, VarHelper.DATABASE_NAME, null, VarHelper.DATABASE_VERSION);
    }

    private void populateDatabase(SQLiteDatabase db) {
        VarHelper.populateArray();
        ContentValues values = new ContentValues();
        for(int i = 0; i < VarHelper.MAX_RECORDS; i++) {
            values.put(VarHelper.EXERCISE_TABLE_COL_EXERCISE_NAME, VarHelper.allExercises[i][0]);
            values.put(VarHelper.EXERCISE_TABLE_COL_MUSC_GRP_NAME, VarHelper.allExercises[i][1]);
            values.put(VarHelper.EXERCISE_TABLE_COL_EQUIP_NAME, VarHelper.allExercises[i][2]);
            db.insert(VarHelper.EXERCISE_TABLE_NAME, null, values);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + VarHelper.EXERCISE_TABLE_NAME + ";");
        Log.i("ExerciseDBOpenHelper", "onCreate called");
        db.execSQL(EXERCISE_TABLE_CREATE);
        populateDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do not much
    }
}
