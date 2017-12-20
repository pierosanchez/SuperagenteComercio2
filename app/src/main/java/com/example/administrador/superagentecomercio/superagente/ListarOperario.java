package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrador.superagentecomercio.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class ListarOperario extends Activity {

    FloatingActionButton btn_menu,btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_operario);

        btn_menu = (FloatingActionButton) findViewById(R.id.action_menu);
        btn_agregar = (FloatingActionButton) findViewById(R.id.action_agregar);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarOperario.this, AgregarOperario.class);
                startActivity(intent);
                finish();
            }
        });

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarOperario.this, AgregarOperario.class);
                startActivity(intent);
                finish();
            }
        });


    }



}
