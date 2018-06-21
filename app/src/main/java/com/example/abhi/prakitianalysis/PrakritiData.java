package com.example.abhi.prakitianalysis;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PrakritiData {

    public static void insertPrakritiData(SQLiteDatabase db){
        if(db ==null )
            return;


        List<ContentValues> list = new ArrayList<>();

        ContentValues cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How does your body frame/ body type/ frame size, look like?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Lean, difficulty in gaining weight");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Medium , can gain and loose weight easily");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Overweight , tendency towards weight gain easily and loose slowly");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"What is your skin type?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Dry ,dark ,tanned easily");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Wheatish to fair, oily , prone to acne");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Fair ,Thick and smooth");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How is your digestion?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Prone towards gas and constipation");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Frequent acidity,stomach clearing twice a dayplan");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"stomach clearing once a day ,sluggish digestion");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"What do you feel about your voice quality?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"fast and not clear ");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"sharp and commanding");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Soft ,slow and gentle");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How is your memory?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Grasp quickly and forget quickly");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Sharp and clear");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Slow to learn but retain");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How do you see your lifestyle?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Enthusiastic and lively");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Organised and perfectionist");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Calm,humorous and easy going");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How is your body temperature?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Prefer warm ,less sweating");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Prefer cold,Intense sweating");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Adaptable to both climates, moderate sweating");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How often do you feel thirsty ? ");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Variable (sometime more /sometime less)");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Excesive thirst (10-12 glasses /day or more)");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Low (less than 5 glasses /day)");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How is you appetite (desire to have food)?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Variable (sometime more /sometime less )");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Strong, cannot skip meals");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Low and constant");
        list.add(cv);

        cv = new ContentValues();
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION,"How is your behavior, thinking or say reaction towards others?");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_VATA,"Feels insecure with many people");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_PITTA,"Outgoing and assertive");
        cv.put(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA,"Follower and good listener");
        list.add(cv);

        try{
            db.beginTransaction();
            db.delete(PrakritiContract.PrakritiQuestion.TABLE_NAME,null,null);
            for(ContentValues c:list)
            {
                db.insert(PrakritiContract.PrakritiQuestion.TABLE_NAME,null,c);
            }
            db.setTransactionSuccessful();
        }
        catch(SQLException E){

        }
        finally
        {
            db.endTransaction();
        }
    }
}
