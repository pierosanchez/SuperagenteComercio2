package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrador.superagentecomercio.R;

public class AfiliacionComercio extends Activity {

    Button btn_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afiliacion_comercio);

        btn_continuar = (Button) findViewById(R.id.btn_continuar);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfiliacionComercio.this, IngresoCuentasComercio.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
