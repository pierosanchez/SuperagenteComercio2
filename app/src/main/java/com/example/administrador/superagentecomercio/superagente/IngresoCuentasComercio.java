package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrador.superagentecomercio.R;

public class IngresoCuentasComercio extends Activity {

    Button btn_aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_cuentas_comercio);

        btn_aceptar = (Button) findViewById(R.id.btn_aceptar);

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IngresoCuentasComercio.this, "Flujo terminado", Toast.LENGTH_LONG).show();
            }
        });
    }
}
