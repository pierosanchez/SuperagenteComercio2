package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrador.superagentecomercio.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class DetalleOperario extends Activity {

    FloatingActionButton btn_editar,btn_eliminar,btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_operario);

        btn_editar = (FloatingActionButton) findViewById(R.id.action_editar);
        btn_eliminar = (FloatingActionButton) findViewById(R.id.action_agregar);
        btn_regresar = (FloatingActionButton) findViewById(R.id.action_return);

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleOperario.this, EditarOperario.class);
                startActivity(intent);
                finish();
            }
        });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleOperario.this, ListarOperario.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
