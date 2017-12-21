package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
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
