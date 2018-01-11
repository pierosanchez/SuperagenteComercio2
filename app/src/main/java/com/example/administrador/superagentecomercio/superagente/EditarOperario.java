package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.DepartamentosUbigeoAdapter;
import com.example.administrador.superagentecomercio.adapter.DistritoUbigeoAdapter;
import com.example.administrador.superagentecomercio.adapter.ProvinciaUbigeoAdapter;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.UbigeoEntity;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EditarOperario extends Activity {

    FloatingActionButton btn_regresar;

    FloatingActionButton btn_guardar,btn_menu;
    Button btn_siguiente;
    Spinner sp_sexo;
    TextView pruebas;
    private Comercio idcomercio;

    EditText et_dni,et_nombre,et_paterno,et_materno,et_celular,et_fono;
    String dni,nombre,paterno,materno,celular,fono,sexo,id_ope, direccion;

    String[] items;
    private boolean isFirstTime = true;


    ArrayList<UbigeoEntity> ubigeoArrayListDepartamento;
    ArrayList<UbigeoEntity> ubigeoArrayListDistrito;
    ArrayList<UbigeoEntity> ubigeoArrayListProvincia;
    DepartamentosUbigeoAdapter departamentosUbigeoAdapter;
    DistritoUbigeoAdapter distritoUbigeoAdapter;
    ProvinciaUbigeoAdapter provinciaUbigeoAdapter;

    String departamentoUbigeo, departamentoUbigeoDesc, distritoUbigeo,
            distritoUbigeoDesc, provinciaUbigeo, provinciaUbigeoDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_operario);

        btn_regresar = (FloatingActionButton) findViewById(R.id.action_return);

        btn_siguiente = (Button) findViewById(R.id.btn_siguiente);

        et_dni = (EditText) findViewById(R.id.et_dni);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_paterno = (EditText) findViewById(R.id.et_paterno);
        et_materno = (EditText) findViewById(R.id.et_materno);
        et_celular = (EditText) findViewById(R.id.et_celular);
        et_fono = (EditText) findViewById(R.id.et_fono);

        sp_sexo = (Spinner) findViewById(R.id.sp_sexo);
        pruebas = (TextView) findViewById(R.id.pruebas);

        Bundle bundle = getIntent().getExtras();
        idcomercio = bundle.getParcelable("idcomercio");
        id_ope = bundle.getString("id_ope");
        dni = bundle.getString("dni_ope");
        nombre = bundle.getString("nom_ope");
        paterno = bundle.getString("pater_ope");
        materno = bundle.getString("mater_ope");
        fono = bundle.getString("fono_fijo");
        /*departamento = bundle.getString("departamento");
        distrito = bundle.getString("distrito");
        provincia = bundle.getString("provincia");*/
        direccion = bundle.getString("direccion");
        celular = bundle.getString("celular");

        et_dni.setText(dni);
        et_nombre.setText(nombre);
        et_paterno.setText(paterno);
        et_materno.setText(materno);
        et_celular.setText(celular);
        et_fono.setText(fono);

        items = getResources().getStringArray(R.array.lista_sexos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_sexo.setAdapter(adapter);
        sp_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                sexo=items[position];
                /*if(isFirstTime){
                    isFirstTime = false;
                }
                else {
                    //Toast.makeText(getApplicationContext(),items[position],Toast.LENGTH_LONG).show();
                    //pruebas.setText(items[position]);

                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dni = et_dni.getText().toString();
                nombre = et_nombre.getText().toString();
                paterno = et_paterno.getText().toString();
                materno = et_materno.getText().toString();
                celular = et_celular.getText().toString();
                fono = et_fono.getText().toString();

                Intent intent = new Intent(EditarOperario.this, EditarOperario2.class);
                intent.putExtra("idcomercio", idcomercio);
                intent.putExtra("id_ope", id_ope);
                intent.putExtra("dni", dni);
                intent.putExtra("nombre", nombre);
                intent.putExtra("paterno", paterno);
                intent.putExtra("materno", materno);
                intent.putExtra("celular", celular);
                intent.putExtra("fono", fono);
                intent.putExtra("sexo", sexo);
                intent.putExtra("direccion",direccion);
                startActivity(intent);
                finish();
            }
        });


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
