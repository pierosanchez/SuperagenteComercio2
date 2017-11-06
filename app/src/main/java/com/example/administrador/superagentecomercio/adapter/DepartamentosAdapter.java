package com.example.administrador.superagentecomercio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.entity.Banco;
import com.example.administrador.superagentecomercio.entity.Departamento;

import java.util.ArrayList;

/**
 * Created by Administrador on 03/11/2017.
 */

public class DepartamentosAdapter extends BaseAdapter {

    ArrayList<Departamento> items;
    Context context;
    LayoutInflater layoutInflater = null;

    public DepartamentosAdapter(ArrayList<Departamento> items, Context context) {
        this.items = items;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(items == null){
            return 0;
        }else {
            return items.size();
        }
    }

    @Override
    public Departamento getItem(int position) {
        if(items == null){
            return null;
        }else{
            return items.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= new ViewHolder();
        View view = layoutInflater.inflate(R.layout.row_departamentos,null);

        viewHolder.tv_departamentos = (TextView) view.findViewById(R.id.tv_departamentos);

        viewHolder.tv_departamentos.setText(String.valueOf(getItem(position).getDescripcionDepartamento()));

        Departamento data = getItem(position);

        if(data!=null){
            viewHolder.tv_departamentos.setText(data.getDescripcionDepartamento());
        } else {
            viewHolder.tv_departamentos.setText("");
        }

        return view;
    }

    public static final class ViewHolder{
        TextView tv_departamentos;
    }

    public void setNewListDepartamento(ArrayList<Departamento> listBeneficiario){
        items = listBeneficiario;
    }

}
