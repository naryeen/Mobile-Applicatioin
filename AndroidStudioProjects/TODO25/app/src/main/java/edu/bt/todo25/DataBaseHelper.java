package edu.bt.todo25;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.icu.lang.UProperty.NAME;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Employee.db";
    public static final String TABLE_NAME = "employee_table";
    public static final String VAL_1 = "ID";
    public static final String VAL_2 = "NAME";
    public static final String VAL_3 = "LASTNAME";
    public static final String VAL_4 = "MARKS";

    public DataBaseHelper(Context contex ){
        super(contex,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME
                +"(ID INTEGER PRIMARY KEY, "+
                " NAME TEXT,LASTNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String id, String firstname,String lastname,String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VAL_1,id);
        contentValues.put(VAL_2,firstname);
        contentValues.put(VAL_3,lastname);
        contentValues.put(VAL_4,marks);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id, String firstname, String lastname,String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VAL_1,id);
        contentValues.put(VAL_2,firstname);
        contentValues.put(VAL_3,lastname);
        contentValues.put(VAL_4,marks);

        long result = db.update(TABLE_NAME,contentValues,"ID = ?",
                new String[]{id});
        if(result!=0){
            return true;
        }
        return false;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[]{id});
    }
}
