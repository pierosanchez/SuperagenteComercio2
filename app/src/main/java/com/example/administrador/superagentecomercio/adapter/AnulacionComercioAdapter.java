package com.example.administrador.superagentecomercio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.entity.Departamento;
import com.example.administrador.superagentecomercio.entity.VoucherPagoConsumo;

import java.util.ArrayList;

/**
 * Created by Administrador on 03/11/2017.
 */

public class AnulacionComercioAdapter extends BaseAdapter {

    ArrayList<VoucherPagoConsumo> items;
    Context context;
    LayoutInflater layoutInflater = null;

    public AnulacionComercioAdapter(ArrayList<VoucherPagoConsumo> items, Context context) {
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
    public VoucherPagoConsumo getItem(int position) {
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
        View view = layoutInflater.inflate(R.layout.row_anulacion_comercio,null);

        viewHolder.tv_numero_unico = (TextView) view.findViewById(R.id.tv_numero_unico);
        viewHolder.tv_nombre = (TextView) view.findViewById(R.id.tv_nombre);

        viewHolder.tv_numero_unico.setText(String.valueOf(getItem(position).getNumeroUnico()));
        viewHolder.tv_nombre.setText(String.valueOf(getItem(position).getNomCliente()));

        VoucherPagoConsumo data = getItem(position);

        if(data!=null){
            viewHolder.tv_numero_unico.setText(data.getNumeroUnico());
            viewHolder.tv_nombre.setText(data.getNomCliente());
        } else {
            viewHolder.tv_numero_unico.setText("");
            viewHolder.tv_nombre.setText("");
        }

        return view;
    }

    public static final class ViewHolder{
        TextView tv_numero_unico, tv_nombre;
    }

    public void setNewListDepartamento(ArrayList<VoucherPagoConsumo> listBeneficiario){
        items = listBeneficiario;
    }

}
