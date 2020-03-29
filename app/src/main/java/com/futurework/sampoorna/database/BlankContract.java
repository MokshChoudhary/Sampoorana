package com.futurework.sampoorna.database;

import android.provider.BaseColumns;

public class BlankContract {
    public static class BlankEnter implements BaseColumns{
        /**@DATABASE_NAME : Database name */
        public final static String DATABASE_NAME = "sampoorn.db";

        public final static String _ID = BaseColumns._ID;
        public final static String LOGIN_TABLE_NAME = "sampoorna_user";
        public final static String COLUMNS_USER_NAME = "name";
        public final static String COLUMNS_USER_BLOOD = "blood group";
        public final static String COLUMNS_USER_GENDER = "gender";
        public static final String COLUMNS_USER_DOB = "dob";
        public final static String COLUMNS_USER_WEIGHT = "weight";
        public final static  String COLUMNS_USER_PASSWORD = "password";

        /** these variable defining the type of gender using in the application*/
        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;
        public final static int GENDER_OTHER = 3;

        /** This variable are for defining the type of blood used in the application*/
        public final static int BLOOD_UNKNOWN = 0;
        //This are for positive blood group
        public final static int BLOOD_O = 1;
        public final static int BLOOD_A = 2;
        public final static int BLOOD_B = 3;
        public final static int BLOOD_AB = 4;
        //This are for negative blood group
        public final static int BLOOD_NEG_O = -1;
        public final static int BLOOD_NEG_A = -2;
        public final static int BLOOD_NEG_B = -3;
        public final static int BLOOD_NEG_AB = -4;
    }
}
