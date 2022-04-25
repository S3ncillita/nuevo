package com.example.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_coche,et_empresa,et_validador,et_serialE,et_seriaP,et_fecha,et_obs,et_tecnico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_coche = (EditText) findViewById(R.id.txt_coche);
        et_empresa = (EditText) findViewById(R.id.txt_empresa);
        et_validador = (EditText) findViewById(R.id.txt_validador);
        et_serialE = (EditText) findViewById(R.id.txt_serialE);
        et_seriaP = (EditText) findViewById(R.id.txt_serialP);
        et_fecha = (EditText) findViewById(R.id.txt_fecha);
        et_obs = (EditText) findViewById(R.id.txt_obs);
        et_tecnico = (EditText) findViewById(R.id.txt_tecnico);

    }
    //metodos para nuestros botonoes
    public void Guardar (View view){
    AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String coche = et_coche.getText().toString();
        String empresa= et_empresa.getText().toString();
        String validador = et_validador.getText().toString();
        String serialE = et_serialE.getText().toString();
        String serialP = et_seriaP.getText().toString();
        String fecha = et_fecha.getText().toString();
        String obs = et_obs.getText().toString();
        String tecnico = et_tecnico.getText().toString();

        if (!coche.isEmpty() && !empresa.isEmpty() && !validador.isEmpty() && !fecha.isEmpty() && !obs.isEmpty() && !tecnico.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("coche",coche);
            registro.put("empresa",empresa);
            registro.put("validador",validador);
            registro.put("serialE",serialE);
            registro.put("serialP",serialP);
            registro.put("fecha",fecha);
            registro.put("obs",obs);
            registro.put("tecnico",tecnico);
            BaseDeDatos.insert("datos",null,registro);

            BaseDeDatos.close();
            Toast.makeText(this,"Registro guardado",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"Debes rellenar los campos faltantes, excepto  los seriales",Toast.LENGTH_LONG).show();
        }

    }
    //Modificar
        public void Modificar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            String coche = et_coche.getText().toString();
            String empresa= et_empresa.getText().toString();
            String validador = et_validador.getText().toString();
            String serialE = et_serialE.getText().toString();
            String serialP = et_seriaP.getText().toString();
            String fecha = et_fecha.getText().toString();
            String obs = et_obs.getText().toString();
            String tecnico = et_tecnico.getText().toString();

            if (!coche.isEmpty() && !empresa.isEmpty() && !validador.isEmpty() && !fecha.isEmpty() && !obs.isEmpty() && !tecnico.isEmpty()){
                ContentValues registro = new ContentValues();
                registro.put("coche",coche);
                registro.put("empresa",empresa);
                registro.put("validador",validador);
                registro.put("serialE",serialE);
                registro.put("serialP",serialP);
                registro.put("fecha",fecha);
                registro.put("obs",obs);
                registro.put("tecnico",tecnico);

                int cantidad = BaseDeDatos.update("datos",registro,"coche" + coche,null);
                BaseDeDatos.close();
                if(cantidad == 1){
                    Toast.makeText(this,"Articulo modificado correctamente",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Articulo no existe",Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this,"rellenar los faltantes,excepto los seriales si no hiciste un cambio de validador",Toast.LENGTH_LONG).show();
            }

    }
    public void salir(){


    }
}