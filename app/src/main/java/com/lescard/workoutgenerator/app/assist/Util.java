package com.lescard.workoutgenerator.app.assist;

/**
 * Created by davidlescard on 5/1/14.
 */
public class Util {

    //Update as equipment or exercise list is revised
    public static int EQUIP_LIST_COUNT = 10;
    public static int MAX_NUM_EXERCISES = 15;

    //Equipment
    public static String EQUIP_BARBELL = "Barbell";
    public static String EQUIP_BENCH = "AdjustableBench";
    public static String EQUIP_DUMBELL = "Dumbell";
    public static String EQUIP_KETTLEBELL = "Kettlebell";
    public static String EQUIP_MEDICINEBALL = "MedicineBall";
    public static String EQUIP_BATTLEROPE = "BattleRope";
    public static String EQUIP_PULLUPBAR = "PullUpBar";
    public static String EQUIP_SWISSBALL = "SwissBall";
    public static String EQUIP_TRX = "TRXSuspension";
    public static String EQUIP_NONE = "None";

    //Muscle Groups
    public static String GRP_ANY = "Any";
    public static String GRP_UPPER = "Upper";
    public static String GRP_LOWER = "Lower";
    public static String GRP_CORE = "Core";
    
    //Exercises
    public static String EX_BICYCLECRUNCHES = "bicycle crunches";
    public static String EX_REVERSECRUNCHES = "reverse crunches";
    public static String EX_RAISEDLEGPLANKALT = "raised leg plank, alternating";
    public static String EX_TOETOUCHSITUPS = "toe touch sit-ups";
    public static String EX_HIGHKNEES = "high knees";
    public static String EX_BURPEE = "burpee";
    public static String EX_JUMPTUCKS = "jump tucks";
    public static String EX_BACKWARDLUNGESALT = "backward lunges, alternating";
    public static String EX_DUMBELLLUNGES = "dumbell lunges";
    public static String EX_SQUATS = "squats";
    public static String EX_BENCHPRESS = "bench press";
    public static String EX_DUMBELLCURLS = "dumbell curls";
    public static String EX_TRICEPEXTENSIONS = "tricep extensions";
    public static String EX_MILITARYPRESS = "military press";
    public static String EX_BATTLEROPES = "battle ropes";
    
    //Database Constants
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ExerciseListActivity";
    public static final String EXERCISE_TABLE_NAME = "exercises";
    public static final String EXERCISE_TABLE_COL_ID = "_id";
    public static final String EXERCISE_TABLE_COL_EXERCISE_NAME = "exerciseName";
    public static final String EXERCISE_TABLE_COL_MUSC_GRP_NAME = "exerciseMscGrp";
    public static final String EXERCISE_TABLE_COL_EQUIP_NAME = "equipmentName";
    public static final String[] allColumns = {
            EXERCISE_TABLE_COL_ID,
            EXERCISE_TABLE_COL_EXERCISE_NAME,
            EXERCISE_TABLE_COL_MUSC_GRP_NAME,
            EXERCISE_TABLE_COL_EQUIP_NAME
    };

    public static String[][] allExercises = new String[MAX_NUM_EXERCISES][3];
    public static void populateArray(){
        allExercises[0][0] = EX_BICYCLECRUNCHES;
        allExercises[0][1] = GRP_CORE;
        allExercises[0][2] = EQUIP_NONE;
        allExercises[1][0] = EX_REVERSECRUNCHES;
        allExercises[1][1] = GRP_CORE;
        allExercises[1][2] = EQUIP_NONE;
        allExercises[2][0] = EX_RAISEDLEGPLANKALT;
        allExercises[2][1] = GRP_CORE;
        allExercises[2][2] = EQUIP_NONE;
        allExercises[3][0] = EX_TOETOUCHSITUPS;
        allExercises[3][1] = GRP_CORE;
        allExercises[3][2] = EQUIP_NONE;
        allExercises[4][0] = EX_HIGHKNEES;
        allExercises[4][1] = GRP_CORE;
        allExercises[4][2] = EQUIP_NONE;
        allExercises[5][0] = EX_BURPEE;
        allExercises[5][1] = GRP_LOWER;
        allExercises[5][2] = EQUIP_NONE;
        allExercises[6][0] = EX_JUMPTUCKS;
        allExercises[6][1] = GRP_LOWER;
        allExercises[6][2] = EQUIP_NONE;
        allExercises[7][0] = EX_BACKWARDLUNGESALT;
        allExercises[7][1] = GRP_LOWER;
        allExercises[7][2] = EQUIP_NONE;
        allExercises[8][0] = EX_DUMBELLLUNGES;
        allExercises[8][1] = GRP_LOWER;
        allExercises[8][2] = EQUIP_DUMBELL;
        allExercises[9][0] = EX_SQUATS;
        allExercises[9][1] = GRP_LOWER;
        allExercises[9][2] = EQUIP_BARBELL;
        allExercises[10][0] = EX_BENCHPRESS;
        allExercises[10][1] = GRP_UPPER;
        allExercises[10][2] = EQUIP_BENCH;
        allExercises[11][0] = EX_DUMBELLCURLS;
        allExercises[11][1] = GRP_UPPER;
        allExercises[11][2] = EQUIP_DUMBELL;
        allExercises[12][0] = EX_TRICEPEXTENSIONS;
        allExercises[12][1] = GRP_UPPER;
        allExercises[12][2] = EQUIP_KETTLEBELL;
        allExercises[13][0] = EX_MILITARYPRESS;
        allExercises[13][1] = GRP_UPPER;
        allExercises[13][2] = EQUIP_BARBELL;
        allExercises[14][0] = EX_BATTLEROPES;
        allExercises[14][1] = GRP_UPPER;
        allExercises[14][2] = EQUIP_BATTLEROPE;
    }




}
