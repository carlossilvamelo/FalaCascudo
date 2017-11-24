package com.falacascudo.dataLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.falacascudo.models.FeedBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 27/09/2017.
 */

public class LocalDataBase implements IDataCrud {

    private SQLiteDatabase dataBase;

    public LocalDataBase(Context context){
        this.dataBase = new DataBaseCore(context).getWritableDatabase();
    }

    public LocalDataBase(){
    }

    public void setConext(Context context){
        this.dataBase = new DataBaseCore(context).getWritableDatabase();
    }

    @Override
    public void insert(FeedBack feedBack) {
        ContentValues values = new ContentValues();
        values.put("opiniao", feedBack.getFeedBackString());
        dataBase.insert("tabela",null, values);
    }
    /*
    public void update(FeedBack feedBack) {
        ContentValues values = new ContentValues();
        values.put("chave", feedBack.getFeedBackString());
        //dataBase.update("tabela", values,"where = ?","array de string");
    }
    */
    public void dropTable(FeedBack feedBack) {
        dataBase.execSQL("drop table falaCascudo;");
    }

    /*
    public void delete(FeedBack feedBack) {
        ContentValues values = new ContentValues();
        values.put("chave", feedBack.getFeedBackString());
        dataBase.delete("tabela", "id = 1", null);
    }

*/
    public List<FeedBack> getFeedbackList(){

        List<FeedBack> list = new ArrayList<FeedBack>();
        String[] columns = new String[]{"_id","tipo_visitante","opiniao"};
        Cursor cursor = dataBase.query("tabela", columns, null, null, null, null, "_id DES");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
              //  FeedBack fb = new FeedBack(cursor.getString(1),cursor.getInt(2));
              //  list.add(fb);

            }while(cursor.moveToNext());
        }
        return list;
    }
}
