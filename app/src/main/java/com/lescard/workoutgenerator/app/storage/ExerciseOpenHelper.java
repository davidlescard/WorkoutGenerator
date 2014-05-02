package com.lescard.workoutgenerator.app.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lescard.workoutgenerator.app.assist.StringHelper;

import java.util.HashMap;

/**
 * Created by davidlescard on 4/26/14.
 */
public class ExerciseOpenHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase database;


    private static final String EXERCISE_TABLE_CREATE =
            "CREATE TABLE " + StringHelper.EXERCISE_TABLE_NAME + " (" +
                    StringHelper.EXERCISE_TABLE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    StringHelper.EXERCISE_TABLE_COL_EXERCISE_NAME + " TEXT, " +
                    StringHelper.EXERCISE_TABLE_COL_MUSC_GRP_NAME + " TEXT, " +
                    StringHelper.EXERCISE_TABLE_COL_EQUIP_NAME + " TEXT);";

    private String[][] allExercises = new String[15][3];

    ExerciseOpenHelper(Context context) {
        super(context, StringHelper.DATABASE_NAME, null, StringHelper.DATABASE_VERSION);
    }

    private void populateArray(){
        allExercises[0][0] = StringHelper.EX_BICYCLECRUNCHES;
        allExercises[0][1] = StringHelper.GRP_CORE;
        allExercises[0][2] = StringHelper.EQUIP_NONE;
        allExercises[1][0] = StringHelper.EX_REVERSECRUNCHES;
        allExercises[1][1] = StringHelper.GRP_CORE;
        allExercises[1][2] = StringHelper.EQUIP_NONE;
        allExercises[2][0] = StringHelper.EX_RAISEDLEGPLANKALT;
        allExercises[2][1] = StringHelper.GRP_CORE;
        allExercises[2][2] = StringHelper.EQUIP_NONE;
        allExercises[3][0] = StringHelper.EX_TOETOUCHSITUPS;
        allExercises[3][1] = StringHelper.GRP_CORE;
        allExercises[3][2] = StringHelper.EQUIP_NONE;
        allExercises[4][0] = StringHelper.EX_HIGHKNEES;
        allExercises[4][1] = StringHelper.GRP_CORE;
        allExercises[4][2] = StringHelper.EQUIP_NONE;
        allExercises[5][0] = StringHelper.EX_BURPEE;
        allExercises[5][1] = StringHelper.GRP_LOWER;
        allExercises[5][2] = StringHelper.EQUIP_NONE;
        allExercises[6][0] = StringHelper.EX_JUMPTUCKS;
        allExercises[6][1] = StringHelper.GRP_LOWER;
        allExercises[6][2] = StringHelper.EQUIP_NONE;
        allExercises[7][0] = StringHelper.EX_BACKWARDLUNGESALT;
        allExercises[7][1] = StringHelper.GRP_LOWER;
        allExercises[7][2] = StringHelper.EQUIP_NONE;
        allExercises[8][0] = StringHelper.EX_DUMBELLLUNGES;
        allExercises[8][1] = StringHelper.GRP_LOWER;
        allExercises[8][2] = StringHelper.EQUIP_DUMBELL;
        allExercises[9][0] = StringHelper.EX_SQUATS;
        allExercises[9][1] = StringHelper.GRP_LOWER;
        allExercises[9][2] = StringHelper.EQUIP_BARBELL;
        allExercises[10][0] = StringHelper.EX_BENCHPRESS;
        allExercises[10][1] = StringHelper.GRP_UPPER;
        allExercises[10][2] = StringHelper.EQUIP_BENCH;
        allExercises[11][0] = StringHelper.EX_DUMBELLCURLS;
        allExercises[11][1] = StringHelper.GRP_UPPER;
        allExercises[11][2] = StringHelper.EQUIP_DUMBELL;
        allExercises[12][0] = StringHelper.EX_TRICEPEXTENSIONS;
        allExercises[12][1] = StringHelper.GRP_UPPER;
        allExercises[12][2] = StringHelper.EQUIP_KETTLEBELL;
        allExercises[13][0] = StringHelper.EX_MILITARYPRESS;
        allExercises[13][1] = StringHelper.GRP_UPPER;
        allExercises[13][2] = StringHelper.EQUIP_BARBELL;
        allExercises[14][0] = StringHelper.EX_BATTLEROPES;
        allExercises[14][1] = StringHelper.GRP_UPPER;
        allExercises[14][2] = StringHelper.EQUIP_BATTLEROPE;
    }

    private void populateDatabase(SQLiteDatabase db) {
        populateArray();
        ContentValues values = new ContentValues();
        for(int i = 0; i < StringHelper.MAX_RECORDS; i++) {
//            ContentValues values = new ContentValues();
            values.put(StringHelper.EXERCISE_TABLE_COL_EXERCISE_NAME, allExercises[i][0]);
            values.put(StringHelper.EXERCISE_TABLE_COL_MUSC_GRP_NAME, allExercises[i][1]);
            values.put(StringHelper.EXERCISE_TABLE_COL_EQUIP_NAME, allExercises[i][2]);
            db.insert(StringHelper.EXERCISE_TABLE_NAME, null, values);
        }
//        db.insert(ExerciseOpenHelper.EXERCISE_TABLE_NAME, null, values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + StringHelper.EXERCISE_TABLE_NAME + ";");
        Log.i("ExerciseOpenHelper", "onCreate called");
        db.execSQL(EXERCISE_TABLE_CREATE);
        populateDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do not much
    }
}
