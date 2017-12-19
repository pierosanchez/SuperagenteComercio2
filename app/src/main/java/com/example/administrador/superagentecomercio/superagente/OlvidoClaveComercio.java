package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.DetalleClaveAccesoAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.PasswordComercio;

import java.util.ArrayList;

public class OlvidoClaveComercio extends Activity {

    private PasswordComercio comercio;
    ArrayList<PasswordComercio> usuarioEntityArrayList;
    DetalleClaveAccesoAdapter detalleClaveAccesoAdapter;
    String usu;
    EditText txt_pregunta_autenticacion, txt_respuesta_pregunta, txt_nueva_clave_por_olvido, tx_valida_num_cel_usuario;
    Button btn_aceptar, btn_salir, btn_validar;
    LinearLayout ll_botones_olvido_contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olvido_clave_comercio);

        txt_pregunta_autenticacion = (EditText) findViewById(R.id.txt_pregunta_autenticacion);
        txt_respuesta_pregunta = (EditText) findViewById(R.id.txt_respuesta_pregunta);
        txt_nueva_clave_por_olvido = (EditText) findViewById(R.id.txt_nueva_clave_por_olvido);
        tx_valida_num_cel_usuario = (EditText) findViewById(R.id.tx_valida_num_cel_usuario);

        ll_botones_olvido_contra = (LinearLayout) findViewById(R.id.ll_botones_olvido_contra);

        btn_aceptar = (Button) findViewById(R.id.btn_aceptar);
        btn_salir = (Button) findViewById(R.id.btn_salir);
        btn_validar = (Button) findViewById(R.id.btn_validar);

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clave = txt_nueva_clave_por_olvido.getText().toString();
                String respuesta = txt_respuesta_pregunta.getText().toString();
                if (clave.equals("") && respuesta.equals("")) {
                    Toast.makeText(OlvidoClaveComercio.this, "Ingrese los Datos", Toast.LENGTH_SHORT).show();
                } else if (clave.equals("")) {
                    Toast.makeText(OlvidoClaveComercio.this, "Ingrese su nueva Contraseña", Toast.LENGTH_SHORT).show();
                } else if (respuesta.equals("")) {
                    Toast.makeText(OlvidoClaveComercio.this, "Ingrese su Respuesta", Toast.LENGTH_SHORT).show();
                } else {
                    OlvidoClaveComercio.actualizarClaveAcceso actualizarClave = new OlvidoClaveComercio.actualizarClaveAcceso();
                    actualizarClave.execute();
                }
            }
        });

        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celular = tx_valida_num_cel_usuario.getText().toString();
                if (celular.equals("")) {
                    Toast.makeText(OlvidoClaveComercio.this, "Ingrese el número", Toast.LENGTH_SHORT).show();
                } else {
                    OlvidoClaveComercio.validarCelularCliente actualizarClave = new OlvidoClaveComercio.validarCelularCliente();
                    actualizarClave.execute();
                }
            }
        });
    }

    private class validarCelularCliente extends AsyncTask<String, Void, PasswordComercio> {

        String celular = tx_valida_num_cel_usuario.getText().toString();

        @Override
        protected PasswordComercio doInBackground(String... params) {
            PasswordComercio user;
            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                user = dao.validarCelularComercio(celular);
            } catch (Exception e) {
                user = null;
                //flag_clic_ingreso = 0;;
            }
            return user;
        }

        @Override
        protected void onPostExecute(PasswordComercio usuarioEntity) {
            comercio = usuarioEntity;

            if (comercio.getValidCelUsu() == 0) {
                ll_botones_olvido_contra.setVisibility(View.VISIBLE);

                usuarioEntityArrayList = null;
                detalleClaveAccesoAdapter = new DetalleClaveAccesoAdapter(usuarioEntityArrayList, getApplication());

                ejecutarLista();

                txt_respuesta_pregunta.setEnabled(true);
                txt_nueva_clave_por_olvido.setEnabled(true);
            } else if (comercio.getValidCelUsu() == 1) {
                Toast.makeText(OlvidoClaveComercio.this, "El numero ingresado no existe", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class actualizarClaveAcceso extends AsyncTask<String, Void, PasswordComercio> {

        String respuesta = txt_respuesta_pregunta.getText().toString();
        String newPass = txt_nueva_clave_por_olvido.getText().toString();

        @Override
        protected PasswordComercio doInBackground(String... params) {
            PasswordComercio user;
            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                user = dao.ClaveAccesoOlvidada(comercio.getIdComercio(), newPass, respuesta);
                //Log.e("idCliente", "CodCliente=" + user.getCodCliente() + ", usuarioId=" + comercio.getUsuarioId());
                //comercio.setClaveAcceso(user.getClaveAcceso());
            } catch (Exception e) {
                user = null;
                //flag_clic_ingreso = 0;;
            }
            return user;
        }

        @Override
        protected void onPostExecute(PasswordComercio usuarioEntity) {
            comercio = usuarioEntity;
            if (comercio.getReptaCambioCalve() != null) {
                if (comercio.getReptaCambioCalve().equals("1")) {
                    Toast.makeText(OlvidoClaveComercio.this, "La Contraseña ingresada, no es correcta", Toast.LENGTH_SHORT).show();
                } else if (comercio.getReptaCambioCalve().equals("2")) {
                    Toast.makeText(OlvidoClaveComercio.this, "La respuesta ingresada, no es correcta", Toast.LENGTH_SHORT).show();
                } else if (comercio.getReptaCambioCalve().equals("0")) {
                    Intent intent = new Intent(OlvidoClaveComercio.this, CambioClaveAccesoExitosa.class);
                    startActivity(intent);
                    finish();
                }
            } else {
                //mensaje_error = getString(R.string.msg_error_sin_conexion);
                //sinConexion = true;

            }
        }


    }

    private void ejecutarLista() {
        usu = comercio.getIdComercio();

        try {
            OlvidoClaveComercio.ListadoPregunta listadoBeneficiario = new OlvidoClaveComercio.ListadoPregunta();
            listadoBeneficiario.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoPregunta extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                usuarioEntityArrayList = dao.detalleClaveAcceso(usu);
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(tipo_tarjeta=2);
            detalleClaveAccesoAdapter.setNewListClaveOlvidadaComercio(usuarioEntityArrayList);
            detalleClaveAccesoAdapter.notifyDataSetChanged();
            txt_pregunta_autenticacion.setText(usuarioEntityArrayList.get(0).getPregunta());
        }
    }
}
