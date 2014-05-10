package com.lescard.workoutgenerator.app.components;

/**
 * This class is the "model" for the table in the SQLite
 * database which will store the master list of exercises,
 * along with their respective attributes (muscle group,
 * equipment required, name, and ID).
 */
public class Exercise {
    private long ID;
    private String exerciseName;
    private String muscleGroupName;
    private String equipmentName;

    public long getID() {
        return ID;
    }

    public void setID(long id) {
        this.ID = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String name) {
        this.exerciseName = name;
    }

    public String getMuscleGroupName() {
        return muscleGroupName;
    }

    public void setMuscleGroupName(String muscleName) {
        this.muscleGroupName = muscleName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipName) {
        this.equipmentName = equipName;
    }

    @Override
    public String toString() {
        return exerciseName;
    }
}
