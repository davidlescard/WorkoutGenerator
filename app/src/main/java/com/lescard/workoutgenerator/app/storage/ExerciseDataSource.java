package com.lescard.workoutgenerator.app.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lescard.workoutgenerator.app.assist.VarHelper;
import com.lescard.workoutgenerator.app.components.Exercise;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidlescard on 4/26/14.
 */
public class ExerciseDataSource {

    // Database fields
    private SQLiteDatabase database;
    private ExerciseDBOpenHelper dbHelper;

    public ExerciseDataSource(Context context) {
        dbHelper = new ExerciseDBOpenHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        dbHelper.onCreate(database);
    }

    public void close() {
        dbHelper.close();
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<Exercise>();

        Cursor cursor = database.query(VarHelper.EXERCISE_TABLE_NAME,
                VarHelper.allColumns, null, null, null, null, null);

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
        exercise.setMuscleGroupName(cursor.getString(2));
        exercise.setEquipmentName(cursor.getString(3));
        return exercise;
    }
}
