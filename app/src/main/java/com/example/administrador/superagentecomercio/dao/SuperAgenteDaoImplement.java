package com.example.administrador.superagentecomercio.dao;

/**
 * Created by CTORRES on 05/05/2017.
 */

import android.util.Log;

import com.example.administrador.superagentecomercio.utils.Constante;
import com.example.administrador.superagentecomercio.utils.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Jove on 22/03/2017.
 */
public class SuperAgenteDaoImplement implements SuperAgenteDaoInterface {

    private Utils utils;

    public SuperAgenteDaoImplement() {
        utils = new Utils();
    }

    /*@Override
    public UsuarioEntity InsertarFirmaCliente(String img, String idcliente) {
        UsuarioEntity user;

        try {
            user = new UsuarioEntity();

            String url = Constante.IPORHOST + "webApi_2/apigeneral/ApiGeneral/InsertarFirmaCliente/?img=" + URLEncoder.encode(img, "UTF-8") + "&keyCliente=" + URLEncoder.encode(idcliente, "UTF-8");

            Log.e("METHOD", "InsertarFirmaCliente");
            Log.e("URL", url);

            JSONArray jsonArray = utils.getJSONArrayfromURL(url);
            if (jsonArray != null) {
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    UsuarioEntity usuarioEntity = new UsuarioEntity();
                    usuarioEntity.setCodCliente(utils.getValueStringOrNull(jsonObject, "codcliente"));
                } else {
                    user = null;
                }
            } else {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }

        return user;
    }*/

    /*@Override
    public ArrayList<MonedaEntity> ListarMoneda() {

        ArrayList<MonedaEntity> listaMoneda = new ArrayList<>();

        String url = Constante.IPORHOST + "webApi_2/apigeneral/ApiGeneral/ListarMoneda/?blank=";

        try {
            JSONArray jsonArray = utils.getJSONArrayfromURL(url);
            if (jsonArray != null) {
                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        MonedaEntity monedaEntity = new MonedaEntity();
                        monedaEntity.setCod_tipo_moneda(Integer.parseInt(utils.getValueStringOrNull(jsonObject, "cod_tipo_moneda")));
                        monedaEntity.setSigno_moneda(utils.getValueStringOrNull(jsonObject, "signo_moneda"));
                        monedaEntity.setTipo_moneda(utils.getValueStringOrNull(jsonObject, "tipo_moneda"));
                        listaMoneda.add(monedaEntity);
                    }
                } else {
                    listaMoneda = null;
                }
            } else {
                listaMoneda = null;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaMoneda;
    }*/
}
