package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.administrador.superagentecomercio.R;

public class TerminosCondiciones extends Activity {

    RadioButton radioTerminosCondiciones;
    Button btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terminos_condiciones);

        radioTerminosCondiciones = (RadioButton) findViewById(R.id.radioTerminosCondiciones);

        btn_salir = (Button) findViewById(R.id.btn_salir);

        radioTerminosCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerminosCondiciones.this, IngresoInformacionComercio.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
