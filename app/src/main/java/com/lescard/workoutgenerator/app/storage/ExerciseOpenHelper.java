package com.lescard.workoutgenerator.app.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by davidlescard on 4/26/14.
 */
public class ExerciseOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ExerciseList";
    public static final String EXERCISE_TABLE_NAME = "exercises";
    public static final String EXERCISE_TABLE_COL_ID = "_id";
    public static final String EXERCISE_TABLE_COL_NAME = "exerciseName";
    public static final String EXERCISE_TABLE_COL_MUSC_GRP = "exerciseMscGrp";

    private static final String VIEW_EXERCISES = "viewExercises";

//    private static final String EXERCISE_TABLE_CREATE =
//            "CREATE TABLE " + EXERCISE_TABLE_NAME + " (" +
//                    KEY_WORD + " TEXT, " +
//                    KEY_DEFINITION + " TEXT);";

    private static final String EXERCISE_TABLE_CREATE =
            "CREATE TABLE " + EXERCISE_TABLE_NAME + " (" +
                    EXERCISE_TABLE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EXERCISE_TABLE_COL_NAME + " TEXT, " + EXERCISE_TABLE_COL_MUSC_GRP +
                    " TEXT);";

    ExerciseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXERCISE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do not much
    }
}
