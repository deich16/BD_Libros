package version0.libreria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Javabean.Libro;
import modelo.GestionLibros;

public class BuscarActivity extends AppCompatActivity {
    EditText edtBusqueda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        edtBusqueda=(EditText)this.findViewById(R.id.edtBusca);
    }

    public void buscar (View v) {
        GestionLibros glibros=new GestionLibros(this);
        Libro lib=glibros.buscarLibro(edtBusqueda.getText().toString());
        String mensaje;
        if(lib!=null){
            mensaje="Título: "+lib.getTitulo();
        }else{
            mensaje="Libro no encontrado";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();

    }
}
