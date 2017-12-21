package com.example.administrador.superagentecomercio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.entity.VoucherPagoConsumo;

import java.util.ArrayList;

/**
 * Created by Administrador on 03/11/2017.
 */

public class ReporteMovimientoAdapter extends BaseAdapter {

    ArrayList<VoucherPagoConsumo> items;
    Context context;
    LayoutInflater layoutInflater = null;

    public ReporteMovimientoAdapter(ArrayList<VoucherPagoConsumo> items, Context context) {
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
        View view = layoutInflater.inflate(R.layout.row_reporte_movimientos,null);

        viewHolder.tv_numero_unico = (TextView) view.findViewById(R.id.tv_numero_unico);
        viewHolder.tv_fecha = (TextView) view.findViewById(R.id.tv_fecha);
        viewHolder.tv_hora = (TextView) view.findViewById(R.id.tv_hora);
        viewHolder.tv_importe = (TextView) view.findViewById(R.id.tv_importe);

        viewHolder.tv_numero_unico.setText(String.valueOf(getItem(position).getNumeroUnico()));
        viewHolder.tv_fecha.setText(String.valueOf(getItem(position).getFecha()));
        viewHolder.tv_hora.setText(String.valueOf(getItem(position).getHora()));
        viewHolder.tv_importe.setText(String.valueOf(getItem(position).getImporte()));

        VoucherPagoConsumo data = getItem(position);

        if(data!=null){
            viewHolder.tv_numero_unico.setText(data.getNumeroUnico());
            viewHolder.tv_fecha.setText(data.getFecha());
            viewHolder.tv_hora.setText(data.getHora());
            viewHolder.tv_importe.setText(data.getImporte());
        } else {
            viewHolder.tv_numero_unico.setText("");
            viewHolder.tv_fecha.setText("");
            viewHolder.tv_hora.setText("");
            viewHolder.tv_importe.setText("");
        }

        return view;
    }

    public static final class ViewHolder{
        TextView tv_numero_unico, tv_fecha, tv_hora, tv_importe;
    }

    public void setNewListReporte(ArrayList<VoucherPagoConsumo> listBeneficiario){
        items = listBeneficiario;
    }

}
