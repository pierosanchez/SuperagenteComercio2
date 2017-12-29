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
import com.example.administrador.superagentecomercio.adapter.ReporteMovimientoAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.VoucherPagoConsumo;

import java.util.ArrayList;

public class ReporteMovimientos extends Activity {

    ListView lv_reporte_movimientos;
    Button btn_regresar;
    ArrayList<VoucherPagoConsumo> voucherPagoConsumoArrayList;
    ReporteMovimientoAdapter reporteMovimientoAdapter;
    private Comercio comercio;
    String nroUnico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reporte_movimientos);

        lv_reporte_movimientos = (ListView) findViewById(R.id.lv_reporte_movimientos);

        btn_regresar = (Button) findViewById(R.id.btn_regresar);

        Bundle bundle = getIntent().getExtras();
        comercio = bundle.getParcelable("comercio");

        voucherPagoConsumoArrayList = null;
        reporteMovimientoAdapter = new ReporteMovimientoAdapter(voucherPagoConsumoArrayList, getApplication());
        lv_reporte_movimientos.setAdapter(reporteMovimientoAdapter);

        ejecutarLista();

        lv_reporte_movimientos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nroUnico = reporteMovimientoAdapter.getItem(position).getNumeroUnico();
                Intent intent = new Intent(ReporteMovimientos.this, VoucherConsumos.class);
                intent.putExtra("numUnico", nroUnico);
                intent.putExtra("comercio", comercio);
                startActivity(intent);
                finish();
            }
        });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReporteMovimientos.this, MenuCliente.class);
                intent.putExtra("comercio", comercio);
                startActivity(intent);
                finish();
            }
        });

    }

    private void ejecutarLista(){

        try {
            ReporteMovimientos.reporteMovimientos listadoBeneficiario = new ReporteMovimientos.reporteMovimientos();
            listadoBeneficiario.execute();
        } catch (Exception e){
            //listadoBeneficiario = null;
        }

    }

    private class reporteMovimientos extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                voucherPagoConsumoArrayList = dao.reporteMovimientos(comercio.getIdComercio());
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            reporteMovimientoAdapter.setNewListReporte(voucherPagoConsumoArrayList);
            reporteMovimientoAdapter.notifyDataSetChanged();
        }
    }
}
