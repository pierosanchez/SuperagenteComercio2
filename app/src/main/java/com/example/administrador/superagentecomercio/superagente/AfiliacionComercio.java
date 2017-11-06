package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.DistritoAdapter;
import com.example.administrador.superagentecomercio.adapter.PreguntaAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.Pregunta;

import java.util.ArrayList;

public class AfiliacionComercio extends Activity {

    Button btn_continuar;
    ArrayList<Pregunta> preguntaArrayList;
    PreguntaAdapter preguntaAdapter;
    Spinner sp_pregunta;
    EditText txt_clave_acceso, txt_confirma_clave_acceso, txt_respuesta, txt_confirme, txt_correo_electronico, txt_celular;
    private Comercio comercio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afiliacion_comercio);

        btn_continuar = (Button) findViewById(R.id.btn_continuar);

        txt_clave_acceso = (EditText) findViewById(R.id.txt_clave_acceso);
        txt_confirma_clave_acceso = (EditText) findViewById(R.id.txt_confirma_clave_acceso);
        txt_respuesta = (EditText) findViewById(R.id.txt_respuesta);
        txt_confirme = (EditText) findViewById(R.id.txt_confirme);
        txt_correo_electronico = (EditText) findViewById(R.id.txt_correo_electronico);
        txt_celular = (EditText) findViewById(R.id.txt_celular);

        sp_pregunta = (Spinner) findViewById(R.id.sp_pregunta);

        Bundle bundle = getIntent().getExtras();
        comercio = bundle.getParcelable("comercio");

        preguntaArrayList = null;
        preguntaAdapter = new PreguntaAdapter(preguntaArrayList, getApplication());
        sp_pregunta.setAdapter(preguntaAdapter);

        ejecutarListaPreguntas();

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clave = txt_clave_acceso.getText().toString();
                String confirm_clave = txt_confirma_clave_acceso.getText().toString();
                String respuesta = txt_respuesta.getText().toString();
                String confirm_respuesta = txt_confirme.getText().toString();
                String correo = txt_correo_electronico.getText().toString();
                String celular = txt_celular.getText().toString();
                if (clave.length() != 0 && confirm_clave.length() != 0 && respuesta.length() != 0 && confirm_respuesta.length() != 0 &&
                        correo.length() != 0 && celular.length() != 0) {
                    if (clave.equals(confirm_clave)) {
                        if (respuesta.equals(confirm_respuesta)) {
                            Intent intent = new Intent(AfiliacionComercio.this, IngresoCuentasComercio.class);
                            startActivity(intent);
                            finish();
                        } else if (!respuesta.equals(confirm_respuesta)){
                            Toast.makeText(AfiliacionComercio.this, "Las respuestas no coinciden", Toast.LENGTH_LONG).show();
                        }
                    } else if(!clave.equals(confirm_clave)){
                        Toast.makeText(AfiliacionComercio.this, "Las claves de acceso no coinciden", Toast.LENGTH_LONG).show();
                    }
                } else if (clave.length() == 0){
                    Toast.makeText(AfiliacionComercio.this, "Ingrese la clave de acceso", Toast.LENGTH_LONG).show();
                } else if (confirm_clave.length() == 0){
                    Toast.makeText(AfiliacionComercio.this, "Ingrese la confirmacion de la clave de acceso", Toast.LENGTH_LONG).show();
                } else if (respuesta.length() == 0){
                    Toast.makeText(AfiliacionComercio.this, "Ingrese la respuesta a la pregunta", Toast.LENGTH_LONG).show();
                } else if (confirm_respuesta.length() == 0){
                    Toast.makeText(AfiliacionComercio.this, "Ingrese la confirmacion de la respuesta", Toast.LENGTH_LONG).show();
                } else if (correo.length() == 0){
                    Toast.makeText(AfiliacionComercio.this, "Ingrese su correo electronico", Toast.LENGTH_LONG).show();
                } else if (celular.length() == 0){
                    Toast.makeText(AfiliacionComercio.this, "Ingrese su celular", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void ejecutarListaPreguntas() {

        try {
            AfiliacionComercio.ListadoPreguntas listadoEmpresas = new AfiliacionComercio.ListadoPreguntas();
            listadoEmpresas.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoPreguntas extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                preguntaArrayList = dao.ListarPreguntas();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            preguntaAdapter.setNewListPregunta(preguntaArrayList);
            preguntaAdapter.notifyDataSetChanged();
        }
    }
}
