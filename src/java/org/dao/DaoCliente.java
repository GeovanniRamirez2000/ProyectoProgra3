/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudCliente;
import org.models.ModelCliente;

/**
 *
 * @author GEOVARU
 */
public class DaoCliente implements CrudCliente {

    //Se crea un objeto publico del Cliente
    ModelCliente cliente = new ModelCliente();
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
        ArrayList<ModelCliente> listModel = new ArrayList<>();
        try {
            strSql = "SELECT*FROM CLIENTE;";
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                ModelCliente cli = new ModelCliente();
                cli.setIdCliente(rs.getInt("ID_CLIENTE"));
                cli.setNit(rs.getString("NIT"));
                cli.setNombre(rs.getString("NOMBRE"));
                cli.setApellido(rs.getString("APELLIDO"));
                cli.setTelefono(rs.getString("TELEFONO"));
                cli.setDireccion(rs.getString("DIRECCION"));
                listModel.add(cli);
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

    @Override
    public ModelCliente list(int id) {
        try {
            strSql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                cliente.setNit(rs.getString("NIT"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setApellido(rs.getString("APELLIDO"));
                cliente.setTelefono(rs.getString("TELEFONO"));
                cliente.setDireccion(rs.getString("DIRECCION"));
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public boolean insertar(ModelCliente cliente) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO CLIENTE (ID_CLIENTE, NIT, NOMBRE, APELLIDO, TELEFONO, DIRECCION)"
                + "VALUES ( (SELECT ISNULL(MAX(ID_CLIENTE),0) + 1 FROM CLIENTE), "
                + "'" + cliente.getNit() + "', "
                + "'" + cliente.getNombre() + "', "
                + "'" + cliente.getApellido() + "', "
                + "'" + cliente.getTelefono() + "', "
                + "'" + cliente.getDireccion() + "', "
                + ")";
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelCliente cliente) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE CLIENTE "
                + "SET "
                + "ID_ROL = '" + cliente.getNit() + "', "
                + "NOMBRE = '" + cliente.getNombre() + "', "
                + "APELLIDO = '" + cliente.getApellido() + "', "
                + "FECHA_CREA = '" + cliente.getTelefono() + "', "
                + "ACTIVO = '" + cliente.getDireccion() + "' "
                + "WHERE ID_CLIENTE =  " + cliente.getIdCliente();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelCliente cliente) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        System.out.print("elimina");
        strSql = "DELETE  CLIENTE WHERE ID_CLIENTE =" + cliente.getIdCliente() + ";";
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
