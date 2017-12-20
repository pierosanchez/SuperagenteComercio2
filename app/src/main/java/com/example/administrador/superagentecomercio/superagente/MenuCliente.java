package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.entity.Comercio;

public class MenuCliente extends Activity {

    Button btn_salir, btn_cambio_clave,btn_anulacion;
    private Comercio comercio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_cliente);

        btn_salir = (Button) findViewById(R.id.btn_salir);
        btn_cambio_clave = (Button) findViewById(R.id.btn_cambio_clave);
        btn_anulacion = (Button) findViewById(R.id.btn_anulacion);

        Bundle extra = getIntent().getExtras();
        comercio = extra.getParcelable("comercio");


        btn_cambio_clave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MenuCliente.this, CambioClaveAcceso.class);
                intent.putExtra("comercio", comercio);
                startActivity(intent);
                finish();
            }
        });

        btn_salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });

        btn_anulacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCliente.this, ListadoAnulacionesComercio.class);
                intent.putExtra("comercio", comercio);
                startActivity(intent);
                finish();
            }
        });
    }
}
