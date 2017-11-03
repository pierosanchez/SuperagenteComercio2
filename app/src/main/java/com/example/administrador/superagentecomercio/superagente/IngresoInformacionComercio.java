package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrador.superagentecomercio.R;

public class IngresoInformacionComercio extends Activity {

    Button btn_continuar;
    EditText txt_ruc, txt_raz_social, txt_direccion, txt_rep_legal, txt_dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_informacion_comercio);

        btn_continuar = (Button) findViewById(R.id.btn_continuar);

        txt_ruc = (EditText) findViewById(R.id.txt_ruc);
        txt_raz_social = (EditText) findViewById(R.id.txt_raz_social);
        txt_direccion = (EditText) findViewById(R.id.txt_direccion);
        txt_rep_legal = (EditText) findViewById(R.id.txt_rep_legal);
        txt_dni = (EditText) findViewById(R.id.txt_dni);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IngresoInformacionComercio.this, AfiliacionComercio.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
