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
    Comercio validarLoginComercio(String num_cel_comercio, String pass_comercio);
    PasswordComercio ClaveAccesoOlvidada(String id_com, String nueva_clave_comercio, String resp_preg_comercio);
    PasswordComercio actualizarClaveAcceso(String clave, String idcom, String nueva_clave, String respuesta);
    ArrayList<PasswordComercio> detalleClaveAcceso(String idCliente);
    PasswordComercio validarCelularComercio(String numCel);
    ArrayList<VoucherPagoConsumo> ListadoAnulacionesComercio(String id_com);
    ArrayList<VoucherPagoConsumo> detalleComercio(String numUnico);
    ArrayList<VoucherPagoConsumo> reporteMovimientos(String idComercio);
}
