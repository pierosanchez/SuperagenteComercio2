package com.example.administrador.superagentecomercio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.superagentecomercio.R;
import com.example.administrador.superagentecomercio.entity.Banco;
import com.example.administrador.superagentecomercio.entity.Pregunta;

import java.util.ArrayList;

/**
 * Created by Administrador on 03/11/2017.
 */

public class PreguntaAdapter extends BaseAdapter {

    ArrayList<Pregunta> items;
    Context context;
    LayoutInflater layoutInflater = null;

    public PreguntaAdapter(ArrayList<Pregunta> items, Context context) {
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
    public Pregunta getItem(int position) {
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
        View view = layoutInflater.inflate(R.layout.row_pregunta,null);

        viewHolder.tv_pregunta = (TextView) view.findViewById(R.id.tv_pregunta);

        viewHolder.tv_pregunta.setText(String.valueOf(getItem(position).getDescripcionPregunta()));

        Pregunta data = getItem(position);

        if(data!=null){
            viewHolder.tv_pregunta.setText(data.getDescripcionPregunta());
        } else {
            viewHolder.tv_pregunta.setText("");
        }

        return view;
    }

    public static final class ViewHolder{
        TextView tv_pregunta;
    }

    public void setNewListPregunta(ArrayList<Pregunta> listBeneficiario){
        items = listBeneficiario;
    }

}
