package co.edu.udistrtital.sebastianvergara.fastfood;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnsingin;
    Button btnsingup;
    EditText edCorreo;
    EditText edContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsingin = (Button)findViewById(R.id.btnin);
        btnsingup = (Button)findViewById(R.id.btnup);
        edCorreo = (EditText)findViewById(R.id.correo);
        edContraseña = (EditText)findViewById(R.id.pass);


         final BaseDeDatos ayudaDatos = new BaseDeDatos(getApplicationContext());

        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudaDatos.getReadableDatabase();
                ContentValues misDatos = new ContentValues();
                misDatos.put(BaseDeDatos.DatosDeTabla.COLUMNA_CORREO,edCorreo.getText().toString());
                misDatos.put(BaseDeDatos.DatosDeTabla.COLUMNA_CONTRASEÑA,edContraseña.getText().toString());

                Long DatoGuardado = db.insert(BaseDeDatos.DatosDeTabla.NOMBRE_TABLA, BaseDeDatos.DatosDeTabla.COLUMNA_CORREO, misDatos);
                Toast.makeText(getApplicationContext(), "Ha creado su cuenta.", Toast.LENGTH_LONG).show();

            }
        });

         btnsingin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 SQLiteDatabase db = ayudaDatos.getReadableDatabase();
                 String[] projection = {BaseDeDatos.DatosDeTabla.COLUMNA_CORREO};
                 String [] argsel = {edContraseña.getText().toString()};
                 Cursor c = db.query(BaseDeDatos.NOMBRE_BASEDATOS, projection, BaseDeDatos.DatosDeTabla.COLUMNA_CORREO+"=?",argsel, null,null,null);

                 /*c.moveToFirst();
                 edCorreo.setText(c.getString(0));
                 edContraseña.setText(c.getString(1));*/

                 if(projection.equals(argsel)){
                     Toast.makeText(getApplicationContext(),"Bienvenido", Toast.LENGTH_LONG).show();
                 }else {
                     Toast.makeText(getApplicationContext(),"Por Favor cree un usuario", Toast.LENGTH_LONG).show();
                 }
             }
         });


    }

}
