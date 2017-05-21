package modelo;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Javabean.Libro;

public class GestionLibros {
    private Ayudante helper;
    private SQLiteDatabase bd;
    public GestionLibros(Context ctx){
        helper=new Ayudante(ctx,"libreria");
        bd=helper.getWritableDatabase();
    }

    public void altaLibro(Libro lb){
        String sql="insert into libros (titulo,isbn,precio) ";
        sql+="values('"+lb.getTitulo()+"','"+lb.getIsbn()+"',"+lb.getPrecio()+")";
        bd.execSQL(sql);
    }

    public Cursor obtenerLibros(){
        String sql="select * from libros";
        return bd.rawQuery(sql,null);
    }
    public Cursor obtenerLibroPorIsbn(String isbn){
        String sql="select * from libros where isbn='"+isbn+"'";
        return bd.rawQuery(sql,null);
    }

    public Libro buscarLibro(String isbn){
        String sql="select * from libros where isbn='"+isbn+"'";
        Cursor c=bd.rawQuery(sql,null);
        Libro lib=null;
        //si se ha encontrado el libro, habrá una fila y creamos
        //un objeto Libro con los datos de esa fila
        if(c.moveToNext()){
            lib=new Libro(c.getString(1),c.getString(2),c.getDouble(3));
        }
        return lib;
    }
    public ArrayList<Libro> recuperarTodosLibros(){
        String sql="select * from libros";
        ArrayList<Libro> todos=new ArrayList<>();
        Cursor c=bd.rawQuery(sql,null);
        while(c.moveToNext()){
            Libro lib=new Libro(c.getString(1),c.getString(2),c.getDouble(3));
            todos.add(lib);
        }
        return todos;
    }
    public void cerrar(){
        helper.close();
    }
}
