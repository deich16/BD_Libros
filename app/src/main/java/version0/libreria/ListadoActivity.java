package version0.libreria;

import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import modelo.GestionLibros;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ListView lstDatos=(ListView)this.findViewById(R.id.lstLibros);
        GestionLibros glibros=new GestionLibros(this);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
                R.layout.fila,
                glibros.obtenerLibros(),
                new String[]{"titulo","isbn","precio"},
                new int[]{R.id.tvFilaTitulo,R.id.tvFilaIsbn,R.id.tvFilaPrecio},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        //Asignamos adaptador al listview
        lstDatos.setAdapter(adapter);
        glibros.cerrar();
    }

    public void salir(View v){
        this.finish();
    }
}
