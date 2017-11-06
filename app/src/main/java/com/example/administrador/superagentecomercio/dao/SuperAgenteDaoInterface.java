package com.example.administrador.superagentecomercio.dao;

/**
 * Created by CTORRES on 05/05/2017.
 */

import com.example.administrador.superagentecomercio.entity.*;

import java.util.ArrayList;

public interface SuperAgenteDaoInterface {
    Comercio InsertarComercio(String rucComercio, String razSocialComercio, String direccionComercio, String representanteComercio, String dniRepresentante, int departamento, int provincia, int distrito);
    Cuentas IngresarCuentasComercio(int tipoCuentaComercio, int banco, int moneda, String numCuentaComercio, String idComercio, String cciComercio);
    PasswordComercio IngresarPasswordComercio(String idComercio, String claveAcceso, String pregunta, String respuesta, String correoComercio, String celularComercio);
    ArrayList<Pregunta> ListarPreguntas();
    ArrayList<Distrito> ListarDistrito();
    ArrayList<Departamento> ListarDepartamentos();
    ArrayList<Provincia> ListarProvincias();
    ArrayList<Banco> ListadoBancos();
    ArrayList<Moneda> ListarMoneda();
}
