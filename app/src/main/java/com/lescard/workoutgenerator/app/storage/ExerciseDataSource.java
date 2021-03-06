package com.lescard.workoutgenerator.app.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lescard.workoutgenerator.app.assist.Util;
import com.lescard.workoutgenerator.app.components.Exercise;
import com.lescard.workoutgenerator.app.components.ExerciseParams;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is what provides and instance of the SQLite database
 * and contains strings to represent all queries used throughout
 * the program, and ultimately provides a public method to gather
 * and return the list of all candidate exercises based on the users
 * inputted criteria.  It leverages several private methods to
 * pivot on options selected by the user, to determine which would
 * be included in the candidate list.
 */
public class ExerciseDataSource {

    // Database fields
    private SQLiteDatabase database;
    private ExerciseDBOpenHelper dbHelper;
    private String whereClause;
    private String[] whereArgs;
    private int argCount;
    private StringBuilder whereClauseBuilder;

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

        Cursor cursor = database.query(Util.EXERCISE_TABLE_NAME,
                Util.allColumns, null, null, null, null, null);

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

    public List<Exercise> getCandidates() {
        List<Exercise> exercises = new ArrayList<Exercise>();
        buildWhereClause();
        buildWhereArgs();
        try {
        Cursor cursor = database.query(Util.EXERCISE_TABLE_NAME,
                Util.allColumns, whereClause, whereArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Exercise exercise = cursorToExercise(cursor);
            exercises.add(exercise);
            cursor.moveToNext();
        }
        cursor.close();
        } catch (Exception ex) {
            Log.e("ExerciseDataSource", ex.toString());
        }
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

    private void buildWhereClause() {
        argCount = 0;
        whereClauseBuilder = new StringBuilder();
        String defaultWhereClause = Util.EXERCISE_TABLE_COL_EQUIP_NAME +
                " = '" + Util.EQUIP_NONE + "'";
        StringBuilder muscGrpClauseBuilder = new StringBuilder();
        StringBuilder equipListClauseBuilder = new StringBuilder();
        Boolean partA = false;
        Boolean partB = false;

        if(ExerciseParams.getIsSpecificMuscGrp()) {
            muscGrpClauseBuilder.append(Util.EXERCISE_TABLE_COL_MUSC_GRP_NAME + " = ?");
            partA = true;
            argCount++;
        }

        if(ExerciseParams.getHasEquipment()) {
            equipListClauseBuilder.append(Util.EXERCISE_TABLE_COL_EQUIP_NAME + " = ?");
            argCount++;
            for (int i = 0; i < ExerciseParams.getNumEquipment() -1; i++) {
                equipListClauseBuilder.append(" OR ");
                equipListClauseBuilder.append(Util.EXERCISE_TABLE_COL_EQUIP_NAME + " = ?");
                argCount++;
            }
            partB = true;
        }

        if(partA && partB) {
            whereClauseBuilder.append(muscGrpClauseBuilder);
            whereClauseBuilder.append(" AND (");
            whereClauseBuilder.append(equipListClauseBuilder);
            whereClauseBuilder.append(" OR ");
            whereClauseBuilder.append(defaultWhereClause);
            whereClauseBuilder.append(")");
            whereClause = whereClauseBuilder.toString();
        }
        else if(partA && !partB) {
            whereClauseBuilder.append(muscGrpClauseBuilder);
            whereClauseBuilder.append(" AND ");
            whereClauseBuilder.append(defaultWhereClause);
            whereClause = whereClauseBuilder.toString();
        }
        else if (!partA && partB) {
            whereClauseBuilder.append(equipListClauseBuilder);
            whereClauseBuilder.append(" OR ");
            whereClauseBuilder.append(defaultWhereClause);
            whereClause = whereClauseBuilder.toString();
        }
        else
        {
            whereClauseBuilder.append(defaultWhereClause);
            whereClause = whereClauseBuilder.toString();
        }
    }

    private void buildWhereArgs() {
        whereArgs = new String[argCount];
        int argNum = 0;
        Boolean partA = false;
        Boolean partB = false;

        if(ExerciseParams.getIsSpecificMuscGrp()) {
            whereArgs[argNum] = ExerciseParams.getMuscleGroup();
            argNum++;
            partA = true;
        }

        if(ExerciseParams.getHasEquipment()) {
            for (int i = 0; i < ExerciseParams.getNumEquipment(); i++) {
                whereArgs[argNum] = ExerciseParams.getEquipment(i);
                argNum++;
            }
            partB = true;
        }

        if (!partA && !partB) {
            whereArgs = null;
        }
    }
}
