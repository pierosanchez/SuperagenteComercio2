package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.BancosAdapter;
import com.example.administrador.superagentecomercio.adapter.MonedaAdapter;
import com.example.administrador.superagentecomercio.adapter.PreguntaAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Banco;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.Cuentas;
import com.example.administrador.superagentecomercio.entity.Moneda;
import com.example.administrador.superagentecomercio.entity.PasswordComercio;

import java.util.ArrayList;

public class IngresoCuentasComercio extends Activity {

    EditText txt_numero_cuenta, txt_codigo_interbancario;
    Button btn_aceptar;
    RadioGroup rg_tipo_cuenta;
    RadioButton rbtn_cuenta_ahorros, rbtn_cuenta_corriente;
    Spinner sp_banco, sp_moneda;
    ArrayList<Banco> bancoArrayList;
    ArrayList<Moneda> monedasArrayList;
    BancosAdapter bancosAdapter;
    MonedaAdapter monedaAdapter;
    private Comercio comercio;
    int banco, moneda, tipo_cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_cuentas_comercio);

        txt_numero_cuenta = (EditText) findViewById(R.id.txt_numero_cuenta);
        txt_codigo_interbancario = (EditText) findViewById(R.id.txt_codigo_interbancario);

        rg_tipo_cuenta = (RadioGroup) findViewById(R.id.rg_tipo_cuenta);

        rbtn_cuenta_ahorros = (RadioButton) findViewById(R.id.rbtn_cuenta_ahorros);
        rbtn_cuenta_corriente = (RadioButton) findViewById(R.id.rbtn_cuenta_corriente);

        sp_banco = (Spinner) findViewById(R.id.sp_banco);
        sp_moneda = (Spinner) findViewById(R.id.sp_moneda);

        btn_aceptar = (Button) findViewById(R.id.btn_aceptar);

        Bundle bundle = getIntent().getExtras();
        comercio = bundle.getParcelable("comercio");

        bancoArrayList = null;
        bancosAdapter = new BancosAdapter(bancoArrayList, getApplication());
        sp_banco.setAdapter(bancosAdapter);

        ejecutarListaBanco();

        monedasArrayList = null;
        monedaAdapter = new MonedaAdapter(monedasArrayList, getApplication());
        sp_moneda.setAdapter(monedaAdapter);

        ejecutarListaMoneda();

        rg_tipo_cuenta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbtn_cuenta_corriente){
                    tipo_cuenta = 2;
                } else if(checkedId == R.id.rbtn_cuenta_ahorros){
                    tipo_cuenta = 1;
                }
                /*int id = group.getCheckedRadioButtonId();
                RadioButton tipoCuenta = (RadioButton) findViewById(id);
                cuenta = tipoCuenta.getText().toString();*/
            }
        });

        sp_banco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                banco = bancosAdapter.getItem(position).getCod_banco();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_moneda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moneda = monedaAdapter.getItem(position).getCod_tipo_moneda();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cuenta = txt_numero_cuenta.getText().toString();
                String cci = txt_codigo_interbancario.getText().toString();
                if (cuenta.length()!=0 && cci.length()!=0) {
                    if (!rbtn_cuenta_corriente.isChecked() & !rbtn_cuenta_ahorros.isChecked()){
                        Toast.makeText(IngresoCuentasComercio.this, "Seleccione un tipo de cuenta", Toast.LENGTH_LONG).show();
                    } else {
                        IngresoCuentasComercio.IngresarCuentaComercio ingresarCuentaComercio = new IngresoCuentasComercio.IngresarCuentaComercio();
                        ingresarCuentaComercio.execute();

                        Toast.makeText(IngresoCuentasComercio.this, "Flujo terminado", Toast.LENGTH_LONG).show();
                    }
                } else if (cuenta.length() == 0){
                    Toast.makeText(IngresoCuentasComercio.this, "Ingrese su número de cuenta", Toast.LENGTH_LONG).show();
                } else if (cci.length() == 0){
                    Toast.makeText(IngresoCuentasComercio.this, "Ingrese su codigo de cuenta interbancario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private class IngresarCuentaComercio extends AsyncTask<String, Void, Cuentas> {
        String cuenta = txt_numero_cuenta.getText().toString();
        String cci = txt_codigo_interbancario.getText().toString();

        @Override
        protected Cuentas doInBackground(String... params) {
            Cuentas password;
            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                password = dao.IngresarCuentasComercio(tipo_cuenta, banco, moneda, cuenta, comercio.getIdComercio(), cci);
            } catch (Exception e) {
                password = null;
                //fldag_clic_ingreso = 0;;
            }
            return password;
        }
    }

    private void ejecutarListaBanco() {

        try {
            IngresoCuentasComercio.ListadoBanco listadoBanco = new IngresoCuentasComercio.ListadoBanco();
            listadoBanco.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoBanco extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                bancoArrayList = dao.ListadoBancos();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            bancosAdapter.setNewListbancos(bancoArrayList);
            bancosAdapter.notifyDataSetChanged();
        }
    }

    private void ejecutarListaMoneda() {

        try {
            IngresoCuentasComercio.ListadoMoneda listadoMoneda = new IngresoCuentasComercio.ListadoMoneda();
            listadoMoneda.execute();
        } catch (Exception e) {
            //listadoBeneficiario = null;
        }

    }

    private class ListadoMoneda extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                monedasArrayList = dao.ListarMoneda();
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //usuarioEntityArrayList.remove(banco = banco_tarjeta);
            monedaAdapter.setNewListMoneda(monedasArrayList);
            monedaAdapter.notifyDataSetChanged();
        }
    }
}
