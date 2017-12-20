package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.AnulacionComercioAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.VoucherPagoConsumo;

import java.util.ArrayList;

public class ListadoAnulacionesComercio extends Activity {

    String id_comercio, numUnico;
    ArrayList<VoucherPagoConsumo> voucherPagoConsumoArrayList;
    AnulacionComercioAdapter anulacionComercioAdapter;
    ListView lv_lista_anulaciones;
    Button btn_regresar;
    private Comercio comercio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_anulaciones_comercio);

        lv_lista_anulaciones = (ListView) findViewById(R.id.lv_lista_anulaciones);

        btn_regresar = (Button) findViewById(R.id.btn_regresar);

        Bundle bundle = getIntent().getExtras();
        comercio = bundle.getParcelable("comercio");

        voucherPagoConsumoArrayList = null;
        anulacionComercioAdapter = new AnulacionComercioAdapter(voucherPagoConsumoArrayList, getApplication());
        lv_lista_anulaciones.setAdapter(anulacionComercioAdapter);

        ejecutarLista();

        lv_lista_anulaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numUnico = anulacionComercioAdapter.getItem(position).getNumeroUnico();
                Intent intent = new Intent(ListadoAnulacionesComercio.this, DetalleConsumo.class);
                intent.putExtra("numUnico", numUnico);
                intent.putExtra("comercio", comercio);
                startActivity(intent);
                finish();
            }
        });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListadoAnulacionesComercio.this, MenuCliente.class);
                intent.putExtra("comercio", comercio);
                startActivity(intent);
                finish();
            }
        });
    }

    private void ejecutarLista(){

        try {
            ListadoAnulacionesComercio.ListadoTarjetas listadoBeneficiario = new ListadoAnulacionesComercio.ListadoTarjetas();
            listadoBeneficiario.execute();
        } catch (Exception e){
            //listadoBeneficiario = null;
        }

    }

    private class ListadoTarjetas extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                voucherPagoConsumoArrayList = dao.ListadoAnulacionesComercio(comercio.getIdComercio());
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            anulacionComercioAdapter.setNewListAnulaciones(voucherPagoConsumoArrayList);
            anulacionComercioAdapter.notifyDataSetChanged();
        }
    }
}
