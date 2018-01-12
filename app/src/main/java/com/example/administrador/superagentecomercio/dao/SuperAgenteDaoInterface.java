package com.example.administrador.superagentecomercio.dao;

/**
 * Created by CTORRES on 05/05/2017.
 */

import com.example.administrador.superagentecomercio.entity.*;

import java.util.ArrayList;

public interface SuperAgenteDaoInterface {
    Comercio InsertarComercio(String rucComercio, String razSocialComercio, String direccionComercio, String representanteComercio, String dniRepresentante, String departamento, String provincia, String distrito);
    Operario InsertarOperario(String dni_ope,String nom_ope, String pater_ope, String mater_ope, String celular, String fono_fijo, String sexo, String comercio, String departamento, String distrito, String provincia, String direccion, String usu_reg);
    Operario ActualizarOperario(String id_ope,String dni_ope,String nom_ope, String pater_ope, String mater_ope, String celular, String fono_fijo, String sexo, String comercio, String departamento, String distrito, String provincia, String direccion, String usu_reg);
    Operario EliminarOperario(String id_ope);
    Cuentas IngresarCuentasComercio(int tipoCuentaComercio, int banco, int moneda, String numCuentaComercio, String idComercio, String cciComercio);
    PasswordComercio IngresarPasswordComercio(String idComercio, String claveAcceso, String pregunta, String respuesta, String correoComercio, String celularComercio);
    ArrayList<Pregunta> ListarPreguntas();
    ArrayList<Distrito> ListarDistrito();
    ArrayList<Departamento> ListarDepartamentos();
    ArrayList<UbigeoEntity> ListarDepartamento();
    //ArrayList<Ubigeo> ListarDistritoUbigeo(String ubigeo1, String ubigeo2);
    ArrayList<UbigeoEntity> ListarProvinciaUbigeo(String ubigeo1);
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
    ArrayList<Operario> ListadoOperario(String idComercio);
    ArrayList<UbigeoEntity> ListarDistritoUbigeo(String ubigeo1, String ubigeo2);

}
