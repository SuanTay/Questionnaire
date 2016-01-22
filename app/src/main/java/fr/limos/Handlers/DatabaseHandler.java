package fr.limos.Handlers;

/**
 * Created by taysuan on 21/01/2016.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import fr.limos.entities.Labelchu;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_PATH = "/data/data/fr.limos.questionnaire/databases/";
    private static final String DATABASE_NAME = "chulite.sqlite3";

    // Labelchus table name
    private static final String TABLE_LABEL = "labelchu";

    // Labelchus Table Columns names
    private static final String KEY_ID_LABEL	= "	id_labelchu	";
    private static final String KEY_SHORTLABEL	= "	shortlabelchu	";
    private static final String KEY_LABELFR	= "	labelchufr	";
    private static final String KEY_LABELEN	= "	labelchuen	";
    private static final String KEY_COMMENTFR	= "	commentfr	";
    private static final String KEY_COMMENTEN	= "	commenten	";
    private static final String KEY_UNITEFR	= "	unitefr	";
    private static final String KEY_UNITEEN	= "	uniteen	";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_PATH + DATABASE_NAME, null, DATABASE_VERSION);
        Log.w("DB Path ", DATABASE_PATH + DATABASE_NAME);
       String dbname=this.getDatabaseName();

        Log.w("DB Name", dbname);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new labelchu
    void addLabelchuchu(Labelchu labelchu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_LABEL	,  	labelchu.getIdLabel());
        values.put(KEY_SHORTLABEL	,  	labelchu.getShortlabel());
        values.put(KEY_LABELFR	,  	labelchu.getLabelfr());
        values.put(KEY_LABELEN	,  	labelchu.getLabelen());
        values.put(KEY_COMMENTFR	,  	labelchu.getCommentfr());
        values.put(KEY_COMMENTEN	,  	labelchu.getCommenten());
        values.put(KEY_UNITEFR	,  	labelchu.getUnitefr());
        values.put(KEY_UNITEEN	,  	labelchu.getUniteen());

        // Inserting Row
        db.insert(TABLE_LABEL , null, values);
        db.close(); // Closing database connection
    }

    // Getting single labelchu
    Labelchu getLabelchu(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LABEL , new String[] {   KEY_ID_LABEL,
                                                                KEY_SHORTLABEL	,
                                                                KEY_LABELFR,
                                                                KEY_LABELEN	,
                                                                KEY_COMMENTFR	,
                                                                KEY_COMMENTEN	,
                                                                KEY_UNITEFR	,
                                                                KEY_UNITEEN }, KEY_ID_LABEL + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Labelchu labelchu = new Labelchu(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3), cursor.getString(4),cursor.getString(5), cursor.getString(6), cursor.getString(7));
        // return labelchu
        return labelchu;
    }

    // Getting All Labelchus
    public List<Labelchu> getAllLabelchus() {
        SQLiteDatabase db = this.getWritableDatabase();
        String name= "***";
       Log.d("db existe",name);

        List<Labelchu> labelchuList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LABEL ;


        Cursor cursor = db.rawQuery(selectQuery, null);
int i=0;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                i++;
                Log.w("CountWhile",i+" "+ cursor.getString(2));
                Labelchu labelchu = new Labelchu();
                labelchu.setIdLabel(Integer.parseInt(cursor.getString(0)));
                labelchu.setShortlabel(cursor.getString(1));
                labelchu.setLabelfr(cursor.getString(2));
                labelchu.setLabelen(cursor.getString(3));
                labelchu.setCommentfr(cursor.getString(4));
                labelchu.setCommenten(cursor.getString(5));
                labelchu.setUnitefr(cursor.getString(6));
                labelchu.setUniteen(cursor.getString(7));
                // Adding labelchu to list
                labelchuList.add(labelchu);
            } while (cursor.moveToNext());
        }

        // return labelchu list
        return labelchuList;
    }

    // Updating single labelchu
    public int updateLabelchu(Labelchu labelchu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_LABEL	,	labelchu.getIdLabel());
        values.put(KEY_SHORTLABEL	,	labelchu.getShortlabel());
        values.put(KEY_LABELFR	,	labelchu.getLabelfr());
        values.put(KEY_LABELEN	,	labelchu.getLabelen());
        values.put(KEY_COMMENTFR	,	labelchu.getCommentfr());
        values.put(KEY_COMMENTEN	,	labelchu.getCommenten());
        values.put(KEY_UNITEFR	,	labelchu.getUnitefr());
        values.put(KEY_UNITEEN	,	labelchu.getUniteen());

        // updating row
        return db.update(TABLE_LABEL , values, KEY_ID_LABEL + " = ?",
                new String[] { String.valueOf(labelchu.getIdLabel()) });
    }

    // Deleting single labelchu
    public void deleteLabelchu(Labelchu labelchu) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LABEL , KEY_ID_LABEL + " = ?",
                new String[] { String.valueOf(labelchu.getIdLabel()) });
        db.close();
    }


    // Getting labelchus Count
    public int getLabelchusCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LABEL ;

        SQLiteDatabase db = this.getReadableDatabase();

    Log.w("getLabalCount :",db.getPath());
        Cursor cursor = db.rawQuery(countQuery, null);
       // cursor.close();

        // return count
        return cursor.getCount();
    }

}