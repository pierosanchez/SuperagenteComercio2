package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.DepartamentosUbigeoAdapter;
import com.example.administrador.superagentecomercio.adapter.DistritoUbigeoAdapter;
import com.example.administrador.superagentecomercio.adapter.ProvinciaUbigeoAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.Operario;
import com.example.administrador.superagentecomercio.entity.UbigeoEntity;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AgregarOperario2 extends Activity {

    Spinner sp_departamento, sp_provincia, sp_distrito;

    EditText et_direccion;

    FloatingActionButton btn_guardar,btn_menu,btn_regresar;

    Button btn_guardarOperario;

    ArrayList<UbigeoEntity> ubigeoArrayListDepartamento;
    ArrayList<UbigeoEntity> ubigeoArrayListDistrito;
    ArrayList<UbigeoEntity> ubigeoArrayListProvincia;
    DepartamentosUbigeoAdapter departamentosUbigeoAdapter;
    DistritoUbigeoAdapter distritoUbigeoAdapter;
    ProvinciaUbigeoAdapter provinciaUbigeoAdapter;

    private Comercio idcomercio;

    String dni,nombre,paterno,materno,celular,fono,sexo;

    String departamentoUbigeo, departamentoUbigeoDesc, distritoUbigeo,
            distritoUbigeoDesc, provinciaUbigeo, provinciaUbigeoDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_operario2);

        btn_regresar = (FloatingActionButton) findViewById(R.id.action_return);
        btn_guardarOperario = (Button) findViewById(R.id.btn_guardarOperario);

        et_direccion = (EditText) findViewById(R.id.et_direccion);

        sp_departamento = (Spinner) findViewById(R.id.sp_departamento);
        sp_provincia = (Spinner) findViewById(R.id.sp_provincia);
        sp_distrito = (Spinner) findViewById(R.id.sp_distrito);


        ubigeoArrayListDepartamento = null;
        departamentosUbigeoAdapter = new DepartamentosUbigeoAdapter(ubigeoArrayListDepartamento, getApplication());
        sp_departamento.setAdapter(departamentosUbigeoAdapter);

        ejecutarListaDepartamentos();


        Bundle bundle = getIntent().getExtras();
        idcomercio = bundle.getParcelable("idcomercio");
        dni = bundle.getString("dni");
        nombre = bundle.getString("nombre");
        paterno = bundle.getString("paterno");
        materno = bundle.getString("materno");
        celular = bundle.getString("celular");
        fono = bundle.getString("fono");
        sexo = bundle.getString("sexo");


        sp_departamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departamentoUbigeo = departamentosUbigeoAdapter.getItem(position).getUbigeo1();
                departamentoUbigeoDesc = departamentosUbigeoAdapter.getItem(position).getDepartamento();

                ubigeoArrayListProvincia = null;
                provinciaUbigeoAdapter = new ProvinciaUbigeoAdapter(ubigeoArrayListProvincia, getApplication());
                sp_provincia.setAdapter(provinciaUbigeoAdapter);

                ejecutarListaProvincias();

                sp_provincia.setEnabled(true);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                provinciaUbigeo = provinciaUbigeoAdapter.getItem(position).getUbigeo2();
                provinciaUbigeoDesc = provinciaUbigeoAdapter.getItem(position).getProvincia();

                ubigeoArrayListDistrito = null;
                distritoUbigeoAdapter = new DistritoUbigeoAdapter(ubigeoArrayListDistrito, getApplication());
                sp_distrito.setAdapter(distritoUbigeoAdapter);

                ejecutarListaDistritos();

                sp_distrito.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_distrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distritoUbigeo = distritoUbigeoAdapter.getItem(position).getUbigeo3();
                distritoUbigeoDesc = distritoUbigeoAdapter.getItem(position).getDistrito();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarOperario2.this, ListarOperario.class);
                intent.putExtra("comercio", idcomercio);
                startActivity(intent);
                finish();
            }
        });


        btn_guardarOperario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AgregarOperario2.insertarOperario insertar = new AgregarOperario2.insertarOperario();
                insertar.execute();


            }
        });

    }


    //Métodos:

    private class insertarOperario extends AsyncTask<String, Void, Operario> {

        String direccion = et_direccion.getText().toString();

        @Override
        protected Operario doInBackground(String... params) {
            Operario user = null;
            try {

                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                user = dao.InsertarOperario( dni, nombre,  paterno,  materno, celular, fono,  sexo, idcomercio.getIdComercio(), departamentoUbigeoDesc, distritoUbigeoDesc, provinciaUbigeoDesc, direccion, "934103162");

            } catch (Exception e) {
                user = null;
                //fldag_clic_ingreso = 0;;
            }
            return user;
        }

    }


    private void ejecutarListaDepartamentos() {

        try {
            AgregarOperario2.ListadoDepartamentos listadoEmpresas = new AgregarOperario2.ListadoDepartamentos();
            listadoEmpresas.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoDepartamentos extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                ubigeoArrayListDepartamento = dao.ListarDepartamento();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            departamentosUbigeoAdapter.setNewListDepartamentoUbigeo(ubigeoArrayListDepartamento);
            departamentosUbigeoAdapter.notifyDataSetChanged();
        }
    }

    private void ejecutarListaDistritos() {

        try {
            AgregarOperario2.ListadoDistritos listadoEmpresas = new AgregarOperario2.ListadoDistritos();
            listadoEmpresas.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoDistritos extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                ubigeoArrayListDistrito = dao.ListarDistritoUbigeo(departamentoUbigeo, provinciaUbigeo);
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            distritoUbigeoAdapter.setNewListDistritoUbigeo(ubigeoArrayListDistrito);
            distritoUbigeoAdapter.notifyDataSetChanged();
        }
    }

    private void ejecutarListaProvincias() {

        try {
            AgregarOperario2.ListadoProvincias listadoEmpresas = new AgregarOperario2.ListadoProvincias();
            listadoEmpresas.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoProvincias extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                ubigeoArrayListProvincia = dao.ListarProvinciaUbigeo(departamentoUbigeo);
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            provinciaUbigeoAdapter.setNewListProvinciaUbigeo(ubigeoArrayListProvincia);
            provinciaUbigeoAdapter.notifyDataSetChanged();
        }
    }

}
