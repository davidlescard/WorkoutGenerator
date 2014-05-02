package com.lescard.workoutgenerator.app.assist;

/**
 * Created by davidlescard on 5/1/14.
 */
public class StringHelper {

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
    public static final int MAX_RECORDS = 15;
    public static final int MAX_COLUMNS = 2;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ExerciseList";
    public static final String EXERCISE_TABLE_NAME = "exercises";
    public static final String EXERCISE_TABLE_COL_ID = "_id";
    public static final String EXERCISE_TABLE_COL_EXERCISE_NAME = "exerciseName";
    public static final String EXERCISE_TABLE_COL_MUSC_GRP_NAME = "exerciseMscGrp";
    public static final String EXERCISE_TABLE_COL_EQUIP_NAME = "EquipmentName";
    public static final String[] allColumns = {
            EXERCISE_TABLE_COL_ID,
            EXERCISE_TABLE_COL_EXERCISE_NAME,
            EXERCISE_TABLE_COL_MUSC_GRP_NAME,
            EXERCISE_TABLE_COL_EQUIP_NAME
    };




}
