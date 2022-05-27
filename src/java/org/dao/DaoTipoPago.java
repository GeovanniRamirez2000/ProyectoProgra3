/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudTipoPago;
import org.models.ModelTipoPago;

/**
 *
 * @author GEOVARU
 */
public class DaoTipoPago implements CrudTipoPago {

    //Se crea un objeto publico del Cliente
    ModelTipoPago tipoPago = new ModelTipoPago();
    //Variable para crear las sentencias SQL
    String strSql = "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;

    @Override
    public List listar() {
        ArrayList<ModelTipoPago> listModel = new ArrayList<>();
        try {
            strSql = "SELECT*FROM TIPO_PAGO;";
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                ModelTipoPago tipPag = new ModelTipoPago();
                tipPag.setIdTipoPago(rs.getInt("ID_TIPO_PAGO"));
                tipPag.setDescripcion(rs.getString("DESCRIPCION"));
                listModel.add(tipPag);
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

    @Override
    public ModelTipoPago list(int id) {
        try {
            strSql = "SELECT * FROM TIPO_PAGO WHERE ID_TIPO_PAGO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                tipoPago.setIdTipoPago(rs.getInt("ID_TIPO_PAGO"));
                tipoPago.setDescripcion(rs.getString("DESCRIPCION"));
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoPago;
    }

    @Override
    public boolean insertar(ModelTipoPago tipoPago) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO TIPO_PAGO (ID_TIPO_PAGO, DESCRIPCION)"
                + "VALUES ( (SELECT ISNULL(MAX(ID_TIPO_PAGO),0) + 1 FROM TIPO_PAGO), "
                + "'" + tipoPago.getDescripcion() + "' "
                + ")";
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelTipoPago tipoPago) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE TIPO_PAGO "
                + "SET "
                + "DESCRIPCION = '" + tipoPago.getDescripcion() + "' "
                + "WHERE ID_TIPO_PAGO =  " + tipoPago.getIdTipoPago();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelTipoPago tipoPago) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        System.out.print("elimina");
        strSql = "DELETE  TIPO_PAGO WHERE ID_TIPO_PAGO =" + tipoPago.getIdTipoPago() + ";";
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
