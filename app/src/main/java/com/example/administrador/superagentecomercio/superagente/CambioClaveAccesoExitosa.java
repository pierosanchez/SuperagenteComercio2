package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.entity.PasswordComercio;

public class CambioClaveAccesoExitosa extends Activity {

    private PasswordComercio usuario;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambio_clave_acceso_exitosa);

        btn_ok = (Button) findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CambioClaveAccesoExitosa.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
