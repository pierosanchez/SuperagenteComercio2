package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrador.superagentecomercio.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class EditarOperario extends Activity {

    FloatingActionButton btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_operario);

        btn_regresar = (FloatingActionButton) findViewById(R.id.action_return);

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarOperario.this, DetalleOperario.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
