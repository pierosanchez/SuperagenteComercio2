package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;

import java.util.Timer;
import java.util.TimerTask;

public class Login extends Activity {

    private EditText usuario, clave_acceso;
    private Button btn_aceptar, btn_registrarse, btn_salir;
    private Comercio comercio;
    private TextView tv_olvido_contraseña;
    private ProgressBar circleProgressBar;
    private LinearLayout ll_olvido_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usuario = (EditText) findViewById(R.id.usuario);
        clave_acceso = (EditText) findViewById(R.id.clave_acceso);

        btn_aceptar = (Button) findViewById(R.id.btn_aceptar);
        btn_salir = (Button) findViewById(R.id.btn_salir);

        ll_olvido_contraseña = (LinearLayout) findViewById(R.id.ll_olvido_contraseña);

        circleProgressBar = (ProgressBar) findViewById(R.id.circleProgressBar);

        ll_olvido_contraseña.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Login.this, OlvidoClaveComercio.class);
                startActivity(intent);
                finish();
            }
        });

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleProgressBar.setVisibility(View.VISIBLE);

                String user = usuario.getText().toString();
                String clave = clave_acceso.getText().toString();

                if (!user.trim().equals("") && !clave.trim().equals("")) {
                    if (user.length() == 9) {
                        try {
                            TimerTask task = new TimerTask() {
                                @Override
                                public void run() {
                                    Login.ValidarLogin validador = new Login.ValidarLogin();
                                    validador.execute();
                                }
                            };
                            Timer timer = new Timer();
                            timer.schedule(task, 500);
                        } catch (Exception e) {
                            //flag_clic_ingreso = 0;
                        }
                    } else if (user.length() != 9) {
                        Toast.makeText(Login.this, "Número de celular no válido", Toast.LENGTH_LONG).show();
                        circleProgressBar.setVisibility(View.GONE);
                    }
                } else if (user.equals("") && clave.equals("")) {
                    Toast.makeText(Login.this, "Ingrese sus credenciales de acceso", Toast.LENGTH_LONG).show();
                    circleProgressBar.setVisibility(View.GONE);
                } else if (clave.equals("")) {
                    Toast.makeText(Login.this, "Ingrese su clave de acceso", Toast.LENGTH_LONG).show();
                    circleProgressBar.setVisibility(View.GONE);
                } else if (user.equals("")) {
                    Toast.makeText(Login.this, "Ingrese su número de celular", Toast.LENGTH_LONG).show();
                    circleProgressBar.setVisibility(View.GONE);
                }
            }
        });

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });
    }

    private class ValidarLogin extends AsyncTask<String, Void, Comercio> {
        String movil = usuario.getText().toString();
        String clave = clave_acceso.getText().toString();

        @Override
        protected Comercio doInBackground(String... params) {
            Comercio user;
            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                user = dao.validarLoginComercio(movil, clave);

            } catch (Exception e) {
                user = null;
                //fldag_clic_ingreso = 0;;
            }
            return user;
        }

        @Override
        protected void onPostExecute(Comercio usuarioEntity) {
            comercio = usuarioEntity;
            if (comercio.getIdComercio() != null) {
                if (comercio.getIdComercio().equals("02")) {
                    Toast.makeText(Login.this, "El número ingresado, no es correcto", Toast.LENGTH_LONG).show();
                    clave_acceso.setText("");
                    circleProgressBar.setVisibility(View.GONE);
                } else if (comercio.getIdComercio().equals("01")) {
                    Toast.makeText(Login.this, "La clave ingresada no es correcta", Toast.LENGTH_LONG).show();
                    clave_acceso.setText("");
                    circleProgressBar.setVisibility(View.GONE);
                    /*circleProgressBar.setVisibility(View.GONE);
                    Intent sanipesIntent = new Intent(Login.this, VentanaErrores.class);
                    sanipesIntent.putExtra("usuario", comercio);
                    sanipesIntent.putExtra("movil", movil);
                    sanipesIntent.putExtra("cliente", comercio.getNombreApellido());
                    startActivityForResult(sanipesIntent, 0);
                    finish();*/
                } else if (comercio.getIdComercio().equals("03")) {
                    //Toast.makeText(Login.this, "La cuenta ingresada no es correcta", Toast.LENGTH_LONG).show();
                    clave_acceso.setText("");
                    circleProgressBar.setVisibility(View.GONE);
                    Intent sanipesIntent = new Intent(Login.this, VentanaErrores.class);
                    sanipesIntent.putExtra("comercio", comercio);
                    /*sanipesIntent.putExtra("movil", movil);
                    sanipesIntent.putExtra("cliente", comercio.getNombreApellido());*/
                    startActivityForResult(sanipesIntent, 0);
                    finish();
                } else if (comercio.getIdComercio().equals("00")) {
                    //Toast.makeText(Login.this, "La cuenta ingresada no es correcta", Toast.LENGTH_LONG).show();
                    clave_acceso.setText("");
                    circleProgressBar.setVisibility(View.GONE);
                    Intent sanipesIntent = new Intent(Login.this, VentanaErrores.class);
                    sanipesIntent.putExtra("comercio", comercio);
                    /*sanipesIntent.putExtra("movil", movil);
                    sanipesIntent.putExtra("cliente", comercio.getNombreApellido());*/
                    startActivityForResult(sanipesIntent, 0);
                    finish();
                } else {
                    try {
                        String user = usuario.getText().toString();
                        circleProgressBar.setVisibility(View.GONE);
                        Intent sanipesIntent = new Intent(Login.this, MenuCliente.class);
                        sanipesIntent.putExtra("comercio", comercio);
                        sanipesIntent.putExtra("user", user);
                        /*anipesIntent.putExtra("cliente", comercio.getNombreApellido());
                        sanipesIntent.putExtra("cli_dni", comercio.getDni());*/
                        startActivity(sanipesIntent);
                        finish();
                    } catch (Exception e) {
                        //flag_clic_ingreso = 0;
                    }

                }
            } else {
                //mensaje_error = getString(R.string.msg_error_sin_conexion);
                //sinConexion = true;

            }
        }
    }
}
