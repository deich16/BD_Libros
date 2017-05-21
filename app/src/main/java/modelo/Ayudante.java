package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Ayudante extends SQLiteOpenHelper{

    public Ayudante(Context context, String name) {
        //constructor con dos parametros. Actividad ctx y Nombre bd
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //----instruccion SQL xa crear la tabla
        String sqlCreaTabla="create table libros (";
        sqlCreaTabla+="_id integer primary key autoincrement,";
        sqlCreaTabla+="titulo text,";
        sqlCreaTabla+="isbn text,";
        sqlCreaTabla+="precio double)";
        //----ejecutar instruccion
        db.execSQL(sqlCreaTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
