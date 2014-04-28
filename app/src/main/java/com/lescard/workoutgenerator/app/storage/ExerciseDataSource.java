package com.lescard.workoutgenerator.app.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidlescard on 4/26/14.
 */
public class ExerciseDataSource {

    // Database fields
    private SQLiteDatabase database;
    private ExerciseOpenHelper dbHelper;
    private String[] allColumns = {
        ExerciseOpenHelper.EXERCISE_TABLE_COL_ID,
            ExerciseOpenHelper.EXERCISE_TABLE_COL_NAME,
            ExerciseOpenHelper.EXERCISE_TABLE_COL_MUSC_GRP
    };

    public ExerciseDataSource(Context context) {
        dbHelper = new ExerciseOpenHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Exercise createExercise(String exercise, String muscGrp) {
        ContentValues values = new ContentValues();
        values.put(ExerciseOpenHelper.EXERCISE_TABLE_COL_NAME, exercise);
        values.put(ExerciseOpenHelper.EXERCISE_TABLE_COL_MUSC_GRP, muscGrp);
        long insertId = database.insert(ExerciseOpenHelper.EXERCISE_TABLE_NAME, null, values);
        Cursor cursor = database.query(ExerciseOpenHelper.EXERCISE_TABLE_NAME, allColumns,
                ExerciseOpenHelper.EXERCISE_TABLE_COL_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Exercise newExercise = cursorToExercise(cursor);
        cursor.close();
        return newExercise;
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<Exercise>();

        Cursor cursor = database.query(ExerciseOpenHelper.EXERCISE_TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Exercise exercise = cursorToExercise(cursor);
            exercises.add(exercise);
            cursor.moveToNext();
        }
        // close cursor
        cursor.close();
        return exercises;
    }

    private Exercise cursorToExercise(Cursor cursor) {
        Exercise exercise = new Exercise();
        exercise.setID(cursor.getLong(0));
        exercise.setExerciseName(cursor.getString(1));
        return exercise;
    }
}