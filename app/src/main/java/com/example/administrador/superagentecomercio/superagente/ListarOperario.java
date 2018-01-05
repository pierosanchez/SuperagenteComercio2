package com.example.administrador.superagentecomercio.superagente;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.adapter.OperarioAdapter;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoImplement;
import com.example.administrador.superagentecomercio.dao.SuperAgenteDaoInterface;
import com.example.administrador.superagentecomercio.entity.Comercio;
import com.example.administrador.superagentecomercio.entity.Operario;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListarOperario extends Activity {

    FloatingActionButton btn_menu,btn_agregar;
    private Operario operario;
    private Comercio idcomercio;
    ListView lv_listado_operario;
    private ProgressBar circleProgressBar;

    OperarioAdapter operarioAdapter;
    ArrayList<Operario> arrayoperario;

    private String id_ope,dni_ope,nom_ope,pater_ope,mater_ope,celular,fono_fijo,sexoj,comercio,
            comercioj,paisj,departamentoj,distritoj,provinciaj,direccion;
    private int sexo,pais,departamento,distrito,provincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_operario);

        lv_listado_operario = (ListView) findViewById(R.id.lv_listado_operario);

        btn_menu = (FloatingActionButton) findViewById(R.id.action_menu);
        btn_agregar = (FloatingActionButton) findViewById(R.id.action_agregar);

        Bundle bundle = getIntent().getExtras();
        idcomercio = bundle.getParcelable("comercio");

        arrayoperario = null;

        operarioAdapter = new OperarioAdapter(arrayoperario, getApplication());

        lv_listado_operario.setAdapter(operarioAdapter);

        ejecutarLista();

        /*lv_listado_operario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id_ope = OperarioAdapter.getItem(position).getNumeroTarjeta();
                id_ope = OperarioAdapter.getItem(position)
            }
        });*/

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarOperario.this, DetalleOperario.class);
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


    private void ejecutarLista(){
        //idcomercio = operario.getComercio();

        try {
            ListarOperario.ListadoOperario listadoOperario = new ListarOperario.ListadoOperario();
            listadoOperario.execute();
        } catch (Exception e){
            //listadoBeneficiario = null;
        }

    }

    private class ListadoOperario extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {
                SuperAgenteDaoInterface dao = new SuperAgenteDaoImplement();
                arrayoperario = dao.ListadoOperario(idcomercio.getIdComercio());
            } catch (Exception e) {
                //fldag_clic_ingreso = 0;;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            operarioAdapter.setNewListOperario(arrayoperario);
            /*operarioAdapter.notifyDataSetChanged();
            circleProgressBar.setVisibility(View.GONE);*/
        }
    }





}
