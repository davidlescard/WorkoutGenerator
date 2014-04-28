package com.lescard.workoutgenerator.app.storage;

/**
 * Created by davidlescard on 4/26/14.
 */
public class Exercise {
    private long ID;
    private String exerciseName;
    private String muscleGroupName;

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
}
