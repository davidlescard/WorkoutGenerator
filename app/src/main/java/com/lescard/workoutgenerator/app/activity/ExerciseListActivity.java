package com.lescard.workoutgenerator.app.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.lescard.workoutgenerator.app.R;
import com.lescard.workoutgenerator.app.components.Exercise;
import com.lescard.workoutgenerator.app.components.ExerciseParams;
import com.lescard.workoutgenerator.app.storage.ExerciseDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExerciseListActivity extends ListActivity {

    private ExerciseDataSource exerciseDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        exerciseDataSource = new ExerciseDataSource(this);

        try {
            exerciseDataSource.open();
            Log.i("ExerciseListActivity", "data source opened");
        } catch (SQLException e) {
            Log.e("ExerciseListActivity", "data source open failed");
            e.printStackTrace();
        }

        List<Exercise> exerciseList = exerciseDataSource.getCandidates();

        exerciseList = randomizeCandidates(exerciseList);

        ArrayAdapter<Exercise> adapter = new ArrayAdapter<Exercise>(this,
                android.R.layout.simple_list_item_1, exerciseList);

        setListAdapter(adapter);
    }

    private List<Exercise> randomizeCandidates(List<Exercise> candidateList) {
        List<Exercise> finalList = new ArrayList<Exercise>();
        int numResulted = candidateList.size();
        int numRequested = ExerciseParams.getNumExercises();
        numRequested = numResulted < numRequested ? numResulted : numRequested;
        int numRemaining = numResulted;

        for (int i = 0; i < numRequested; i++) {
            int random = (int) SystemClock.currentThreadTimeMillis() % numRemaining;
            finalList.add(candidateList.get(random));
            candidateList.remove(random);
            numRemaining--;
        }

        return finalList;
    }

    @Override
    protected void onResume() {
        try {
            exerciseDataSource.open();
            Log.i("ExerciseListActivity", "data source opened");
        } catch (SQLException e) {
            Log.e("ExerciseListActivity", "data source open failed");
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        exerciseDataSource.close();
        Log.i("ExerciseListActivity", "data source closed");
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
