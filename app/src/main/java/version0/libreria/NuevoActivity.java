package version0.libreria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import Javabean.Libro;
import modelo.GestionLibros;

public class NuevoActivity extends AppCompatActivity {

    EditText edt1;
    EditText edt2;
    EditText edt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        edt1=(EditText)this.findViewById(R.id.edtNombre);
        edt2=(EditText)this.findViewById(R.id.edtIsbn);
        edt3=(EditText)this.findViewById(R.id.edtPrecio);
    }

    public void guardar(View v){
        //obtenemos referencias a los campos de texto

        //creamos el objeto libro
        Libro libro=new Libro(edt1.getText().toString(),
                edt2.getText().toString(),
                Double.parseDouble(edt3.getText().toString()));
        GestionLibros glibros=new GestionLibros(this);
        //añadimos el libro a la bd
        glibros.altaLibro(libro);
        glibros.cerrar();
        this.finish();
    }
}
