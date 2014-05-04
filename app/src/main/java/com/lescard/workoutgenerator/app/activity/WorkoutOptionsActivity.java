package com.lescard.workoutgenerator.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.lescard.workoutgenerator.app.R;
import com.lescard.workoutgenerator.app.assist.VarHelper;
import com.lescard.workoutgenerator.app.components.EquipmentLIST;
import com.lescard.workoutgenerator.app.components.RequestedConfig;

public class WorkoutOptionsActivity extends Activity {

    private Spinner spinnerNumExercises;
    private Spinner spinnerMuscleGroup;
    private Button btnGenerate;
    private CheckBox chkBarbell, chkAdjustableBench, chkDumbell,
            chkKettlebell, chkMedicineBall, chkBattleRope,
            chkPullUpBar, chkSwissBall, chkTRXSuspension;

    private int numExercises;
    private String muscleGroup;
    private EquipmentLIST equipmentList;

    private int DEFAULT_NUM_EXERCISES = 1;
    private String DEFAULT_MUSCLE_GROUP = "Any";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_options);

        setUpSpinners();
        setUpUIElements();
        setUpButton();
    }

    private void setUpSpinners() {
        spinnerNumExercises = (Spinner)findViewById(R.id.spinner_num_exercises);
        ArrayAdapter<CharSequence> numExAdapter = ArrayAdapter.createFromResource(this,
                R.array.num_exercises_array, android.R.layout.simple_spinner_item);
        numExAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumExercises.setAdapter(numExAdapter);

        spinnerNumExercises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                numExercises = Integer.parseInt(s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                numExercises = DEFAULT_NUM_EXERCISES;
            }
        });

        spinnerMuscleGroup = (Spinner)findViewById(R.id.spinner_muscle_group);
        ArrayAdapter<CharSequence> muscGrpAdapter = ArrayAdapter.createFromResource(this,
                R.array.muscle_group_array, android.R.layout.simple_spinner_item);
        numExAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMuscleGroup.setAdapter(muscGrpAdapter);

        spinnerMuscleGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                muscleGroup = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                muscleGroup = DEFAULT_MUSCLE_GROUP;
            }
        });
    }

    private void setUpUIElements() {
        spinnerNumExercises = (Spinner)findViewById(R.id.spinner_num_exercises);
        spinnerMuscleGroup = (Spinner)findViewById(R.id.spinner_muscle_group);
        btnGenerate = (Button)findViewById(R.id.btn_generate);
        chkBarbell = (CheckBox)findViewById(R.id.chk_barbell);
        chkAdjustableBench = (CheckBox)findViewById(R.id.chk_adjustable_bench);
        chkDumbell = (CheckBox)findViewById(R.id.chk_dumbell);
        chkKettlebell = (CheckBox)findViewById(R.id.chk_kettlebell);
        chkMedicineBall = (CheckBox)findViewById(R.id.chk_medicine_ball);
        chkBattleRope = (CheckBox)findViewById(R.id.chk_battle_rope);
        chkPullUpBar = (CheckBox)findViewById(R.id.chk_pull_up_bar);
        chkSwissBall = (CheckBox)findViewById(R.id.chk_swiss_ball);
        chkTRXSuspension = (CheckBox)findViewById(R.id.chk_trx_suspension);
    }

    private void setUpButton(){
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildCriteria();
                nextActivity();
            }
        });
    }

    private void buildCriteria(){
        equipmentList = new EquipmentLIST();

        if (chkBarbell.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_BARBELL);
        }
        if (chkAdjustableBench.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_BENCH);
        }
        if (chkDumbell.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_DUMBELL);
        }
        if (chkKettlebell.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_KETTLEBELL);
        }
        if (chkMedicineBall.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_MEDICINEBALL);
        }
        if (chkBattleRope.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_BATTLEROPE);
        }
        if (chkPullUpBar.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_PULLUPBAR);
        }
        if (chkSwissBall.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_SWISSBALL);
        }
        if (chkTRXSuspension.isChecked()) {
            equipmentList.addItem(VarHelper.EQUIP_TRX);
        }
    }

    private void nextActivity(){
        RequestedConfig.setEquipmentLIST(equipmentList);
        RequestedConfig.setNumExercises(numExercises);
        RequestedConfig.setMuscleGroup(muscleGroup);
        Intent i = new Intent();
        i.setClass(this, ExerciseListActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.workout_options, menu);
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
