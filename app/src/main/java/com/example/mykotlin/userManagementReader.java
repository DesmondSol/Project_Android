package com.example.mykotlin;

import android.provider.BaseColumns;

public class userManagementReader {
        private userManagementReader(){}
        public static class feedEntry implements BaseColumns {
            public static final String TABLE_NAME="newUser";
           // public static final String  COLUMN_ID="id";
            public static final String FULL_NAME ="full_name";
            public static final String USER_NAME="user_name";
            public static final String E_MAIL="E_mail";
            public static final String PASSWORD="password";
            public static final String MOBILE="mobile";
            public static final String GENDER="selectedSex";







        }
    }


