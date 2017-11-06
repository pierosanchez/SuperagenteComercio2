package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.DepartamentosAdapter;
import com.example.administrador.superagentecomercio.adapter.DistritoAdapter;
import com.example.administrador.superagentecomercio.adapter.ProvinciaAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.Departamento;
import com.example.administrador.superagentecomercio.entity.Distrito;
import com.example.administrador.superagentecomercio.entity.Provincia;

import java.util.ArrayList;

public class IngresoInformacionComercio extends Activity {

    Button btn_continuar;
    EditText txt_ruc, txt_raz_social, txt_direccion, txt_rep_legal, txt_dni;
    Spinner sp_departamento, sp_provincia, sp_distrito;
    ArrayList<Departamento> departamentoArrayList;
    ArrayList<Provincia> provinciaArrayList;
    ArrayList<Distrito> distritoArrayList;
    DepartamentosAdapter departamentosAdapter;
    ProvinciaAdapter provinciasAdapter;
    DistritoAdapter distritosAdapter;
    int distrito, provincia, departamento;
    private Comercio comercio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_informacion_comercio);

        btn_continuar = (Button) findViewById(R.id.btn_continuar);

        txt_ruc = (EditText) findViewById(R.id.txt_ruc);
        txt_raz_social = (EditText) findViewById(R.id.txt_raz_social);
        txt_direccion = (EditText) findViewById(R.id.txt_direccion);
        txt_rep_legal = (EditText) findViewById(R.id.txt_rep_legal);
        txt_dni = (EditText) findViewById(R.id.txt_dni);

        sp_departamento = (Spinner) findViewById(R.id.sp_departamento);
        sp_provincia = (Spinner) findViewById(R.id.sp_provincia);
        sp_distrito = (Spinner) findViewById(R.id.sp_distrito);

        provinciaArrayList = null;
        provinciasAdapter = new ProvinciaAdapter(provinciaArrayList, getApplication());
        sp_provincia.setAdapter(provinciasAdapter);

        ejecutarListaProvincias();

        departamentoArrayList = null;
        departamentosAdapter = new DepartamentosAdapter(departamentoArrayList, getApplication());
        sp_departamento.setAdapter(departamentosAdapter);

        ejecutarListaDepartamentos();

        distritoArrayList = null;
        distritosAdapter = new DistritoAdapter(distritoArrayList, getApplication());
        sp_distrito.setAdapter(distritosAdapter);

        ejecutarListaDistritos();

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ruc = txt_ruc.getText().toString();
                String razSocial = txt_raz_social.getText().toString();
                String direccion = txt_direccion.getText().toString();
                String repLegal = txt_rep_legal.getText().toString();
                String dni = txt_dni.getText().toString();
                if (ruc.length() == 0 && razSocial.length() == 0 && direccion.length() == 0 && repLegal.length() == 0 && dni.length() == 0) {
                    Toast.makeText(IngresoInformacionComercio.this, "Ingrese los datos del comercio", Toast.LENGTH_LONG).show();
                } else if (ruc.length() == 0){
                    Toast.makeText(IngresoInformacionComercio.this, "Ingrese el número de ruc", Toast.LENGTH_LONG).show();
                } else if (razSocial.length() == 0){
                    Toast.makeText(IngresoInformacionComercio.this, "Ingrese la razón social", Toast.LENGTH_LONG).show();
                } else if (direccion.length() == 0){
                    Toast.makeText(IngresoInformacionComercio.this, "Ingrese la dirección", Toast.LENGTH_LONG).show();
                } else if (repLegal.length() == 0){
                    Toast.makeText(IngresoInformacionComercio.this, "Ingrese el representante legal", Toast.LENGTH_LONG).show();
                } else if (dni.length() == 0){
                    Toast.makeText(IngresoInformacionComercio.this, "Ingrese el número de DNI", Toast.LENGTH_LONG).show();
                } else {
                    IngresoInformacionComercio.ValidarUComercio validarComercio = new IngresoInformacionComercio.ValidarUComercio();
                    validarComercio.execute();

                    /*Intent intent = new Intent(IngresoInformacionComercio.this, AfiliacionComercio.class);
                    startActivity(intent);
                    finish();*/
                }
            }
        });
        sp_departamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departamento = departamentosAdapter.getItem(position).getIdDepartamento();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departamento = provinciasAdapter.getItem(position).getIdProvincia();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_distrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departamento = distritosAdapter.getItem(position).getIdDistrito();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private class ValidarUComercio extends AsyncTask<String, Void, Comercio> {
        String ruc = txt_ruc.getText().toString();
        String razSocial = txt_raz_social.getText().toString();
        String direccion = txt_direccion.getText().toString();
        String repLegal = txt_rep_legal.getText().toString();
        String dni = txt_dni.getText().toString();

        @Override
        protected Comercio doInBackground(String... params) {
            Comercio user;
            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                user = dao.InsertarComercio(ruc, razSocial, direccion, repLegal, dni, departamento, provincia, distrito);
            } catch (Exception e) {
                user = null;
                //fldag_clic_ingreso = 0;;
            }
            return user;
        }

        @Override
        protected void onPostExecute(Comercio com) {
            comercio = com;

            if (comercio != null) {//usuario.getUsuario() != null) {
                if (comercio.getIdComercio() != null) {

                    Intent intent = new Intent(IngresoInformacionComercio.this, AfiliacionComercio.class);
                    intent.putExtra("comercio", comercio);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(IngresoInformacionComercio.this, "Hubo un error al ingresar los datos", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(IngresoInformacionComercio.this, "Hubo un error al ingresar los datos", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void ejecutarListaDepartamentos() {

        try {
            IngresoInformacionComercio.ListadoDepartamentos listadoEmpresas = new IngresoInformacionComercio.ListadoDepartamentos();
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
                departamentoArrayList = dao.ListarDepartamentos();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            departamentosAdapter.setNewListDepartamento(departamentoArrayList);
            departamentosAdapter.notifyDataSetChanged();
        }
    }

    private void ejecutarListaDistritos() {

        try {
            IngresoInformacionComercio.ListadoDistritos listadoEmpresas = new IngresoInformacionComercio.ListadoDistritos();
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
                distritoArrayList = dao.ListarDistrito();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            distritosAdapter.setNewListDistrito(distritoArrayList);
            distritosAdapter.notifyDataSetChanged();
        }
    }

    private void ejecutarListaProvincias() {

        try {
            IngresoInformacionComercio.ListadoProvincias listadoEmpresas = new IngresoInformacionComercio.ListadoProvincias();
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
                provinciaArrayList = dao.ListarProvincias();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            provinciasAdapter.setNewListProvincia(provinciaArrayList);
            provinciasAdapter.notifyDataSetChanged();
        }
    }
}
