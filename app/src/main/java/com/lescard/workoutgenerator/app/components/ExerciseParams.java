package com.lescard.workoutgenerator.app.components;

import com.lescard.workoutgenerator.app.assist.Util;

/**
 * This is a class containing static members to be used to
 * allow user-inputted exercise parameters to persist between
 * screens ("activities").  Since no more than one instance of
 * the class is ever needed, its attributes are called directly
 * (ie. ExerciseParams.getEquipment), and the constructors
 * are never used.
 */
public class ExerciseParams {
    private static EquipmentList equipmentList;
    private static int numEquipment;
    private static int numExercises;
    private static String muscleGroup;
    private static Boolean isSpecificMuscGrp = false;
    private static Boolean hasEquipment = false;

    public ExerciseParams() {};

    public ExerciseParams(EquipmentList list, int num, String mscGrp) {
        setEquipmentList(list);
        setNumExercises(num);
        setMuscleGroup(mscGrp);
    };

    public static String getEquipment (int pos) {
        return equipmentList.getEquipment(pos);
    }

    public static int getNumEquipment() {
        return numEquipment;
    }

    public static int getNumExercises() {
        return numExercises;
    }

    public static String getMuscleGroup() {
        return muscleGroup;
    }

    public static Boolean getIsSpecificMuscGrp(){
        return isSpecificMuscGrp;
    }

    public static Boolean getHasEquipment(){
        return hasEquipment;
    }

    public static void setEquipmentList(EquipmentList list) {
        equipmentList = list;
        numEquipment = list.getCurrentSize();
        hasEquipment = numEquipment == 0 ? false : true;
    }

    public static void setNumExercises(int num) {
        numExercises = num;
    }

    public static void setMuscleGroup(String mscGrp) {
        muscleGroup = mscGrp;
        isSpecificMuscGrp = muscleGroup.equals(Util.GRP_ANY) ? false : true;
    }
}
