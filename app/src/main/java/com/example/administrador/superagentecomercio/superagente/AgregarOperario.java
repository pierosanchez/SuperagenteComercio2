package com.example.administrador.superagentecomercio.superagente;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.administrador.superagentecomercio.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class AgregarOperario extends Activity {

    FloatingActionButton btn_guardar,btn_menu,btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_operario);

        btn_regresar = (FloatingActionButton) findViewById(R.id.action_return);

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarOperario.this, ListarOperario.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
