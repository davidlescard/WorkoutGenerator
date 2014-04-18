package com.lescard.workoutgenerator.app.components;

/**
 * Created by davidlescard on 4/17/14.
 */
public class EquipmentLIST {

    private final int MAX_SIZE = 100;
    private String equipment[] = new String[MAX_SIZE];

    public void addItem(String s) {
        int next = findEmpty();
        equipment[next] = s;
    }

    public void removeItem(String s) {
        int locationItem = search(s);
        if (locationItem == -1) {
            // do nothing, item doesnt exist
        } else {
            equipment[locationItem] = null;
        }
    }

    public boolean isFull() {
        if (findEmpty() == -1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        boolean result = true;
        for(int i = 0; i < MAX_SIZE; i++) {
            if (!equipment[i].equals(null)) {
                result = false;
            }
        }
        return result;
    }

    public int search(String s) {
        int location = -1;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (equipment[i].equals(s)) {
                location = i;
            }
        }
        return location;
    }

    private int findEmpty() {
        int next = -1;
        for (int i = 0; i < MAX_SIZE-1; i++) {
            if (equipment[i] == null) {
               next = i;
               break;
            }
        }
        return next;
    }
}
