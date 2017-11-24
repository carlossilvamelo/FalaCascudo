package com.falacascudo.dataLayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carlos on 03/10/2017.
 */

public class DataBaseCore extends SQLiteOpenHelper {
    private static final String BD_NAME = "falaCascudoDB";
    private static final int VERSION = 1;

    private static String[] tab_usuario = {"create table if not exists usuario(_id integer primary key autoincrement, " +
            "pais text, estado text, municipio text);"};
    private static String[] tab_feedback = {"create table if not exists " +
            "feedback(id_user integer, visitaEscolar text, profAluno text, escolaridade text, nota integer);"};


    public DataBaseCore(Context context) {
        super(context, BD_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tab_usuario[VERSION -1]);
        db.execSQL(tab_feedback[VERSION -1]);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table usuario;");
        db.execSQL("drop table feedback;");
        onCreate(db);
    }
}
