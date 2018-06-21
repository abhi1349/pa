package com.example.abhi.prakitianalysis;

import android.provider.BaseColumns;

public class PrakritiContract {

    public static  final class PrakritiQuestion implements BaseColumns{
        public static final String TABLE_NAME = "prakriti";
        public static final String COLUMN_PRAKRITI_QUESTION = "question";
        public static final String COLUMN_KAPHA = "kapha";
        public static final String COLUMN_PITTA = "pitta";
        public static final String COLUMN_VATA = "vata";
    }
}
