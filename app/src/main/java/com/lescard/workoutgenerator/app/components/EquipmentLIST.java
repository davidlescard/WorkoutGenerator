package com.lescard.workoutgenerator.app.components;

import com.lescard.workoutgenerator.app.assist.Util;

/**
 * Created by davidlescard on 4/17/14.
 *
 * This class is a custom List structure (as required by CPTN278)
 * It is an array-based list implementation, which is used to store
 * the equipment selected by the user.
 */
public class EquipmentList {

    private int CURRENT_SIZE = 0;
    private String equipment[] = new String[Util.EQUIP_LIST_COUNT];

    public void addItem(String s) {
        int next = findEmpty();
        equipment[next] = s;
        CURRENT_SIZE++;
    }

    public void removeItem(String s) {
        int locationItem = search(s);
        if (locationItem == -1) {
            // do nothing, item doesnt exist
        } else {
            equipment[locationItem] = null;
            CURRENT_SIZE--;
        }
    }

    public String getEquipment(int pos) {
        return equipment[pos];
    }

    public boolean isFull() {
        if (findEmpty() == -1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        boolean result = true;
        for(int i = 0; i < Util.EQUIP_LIST_COUNT; i++) {
            if (!(equipment[i] == null)) {
                result = false;
            }
        }
        return result;
    }

    public int getCurrentSize() {
        return CURRENT_SIZE;
    }

    public int search(String s) {
        int location = -1;
        for (int i = 0; i < Util.EQUIP_LIST_COUNT; i++) {
            if (equipment[i].equals(s)) {
                location = i;
            }
        }
        return location;
    }

    private int findEmpty() {
        int next = -1;
        for (int i = 0; i < Util.EQUIP_LIST_COUNT-1; i++) {
            if (equipment[i] == null) {
               next = i;
               break;
            }
        }
        return next;
    }
}
