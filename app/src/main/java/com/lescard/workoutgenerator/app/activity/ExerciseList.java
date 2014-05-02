package com.lescard.workoutgenerator.app.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lescard.workoutgenerator.app.R;
import com.lescard.workoutgenerator.app.storage.Exercise;
import com.lescard.workoutgenerator.app.storage.ExerciseDataSource;

import java.sql.SQLException;
import java.util.List;

public class ExerciseList extends ListActivity {

    private ExerciseDataSource exerciseDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        exerciseDataSource = new ExerciseDataSource(this);

        try {
            exerciseDataSource.open();
            Log.i("ExerciseList", "data source opened");
        } catch (SQLException e) {
            Log.e("ExerciseList", "data source open failed");
            e.printStackTrace();
        }

        List<Exercise> exerciseList = exerciseDataSource.getAllExercises();

        ArrayAdapter<Exercise> adapter = new ArrayAdapter<Exercise>(this,
                android.R.layout.simple_list_item_1, exerciseList);

        setListAdapter(adapter);
    }

    @Override
    protected void onResume() {
        try {
            exerciseDataSource.open();
            Log.i("ExerciseList", "data source opened");
        } catch (SQLException e) {
            Log.e("ExerciseList", "data source open failed");
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        exerciseDataSource.close();
        Log.i("ExerciseList", "data source closed");
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exercise_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_exit) {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

}
