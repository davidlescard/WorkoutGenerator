package com.lescard.workoutgenerator.app.components;

import com.lescard.workoutgenerator.app.activity.ExerciseListActivity;

/**
 * Created by davidlescard on 5/4/14.
 */
public class RequestedConfig {
    private static EquipmentLIST equipmentLIST;
    private static int numExercises;
    private static String muscleGroup;

    public RequestedConfig() {};

    public RequestedConfig(EquipmentLIST list, int num, String mscGrp) {
        setEquipmentLIST(list);
        setNumExercises(num);
        setMuscleGroup(mscGrp);
    };

    public static EquipmentLIST getEquipmentList () {
        return equipmentLIST;
    }

    public static int getNumExercises() {
        return numExercises;
    }

    public static String getMuscleGroup() {
        return muscleGroup;
    }

    public static void setEquipmentLIST(EquipmentLIST list) {
        equipmentLIST = list;
    }

    public static void setNumExercises(int num) {
        numExercises = num;
    }

    public static void setMuscleGroup(String mscGrp) {
        muscleGroup = mscGrp;
    }
}
