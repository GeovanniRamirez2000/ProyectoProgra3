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
import org.interfaces.CrudUser;
import org.models.ModelUser;

/**
 *
 * @author GEOVARU
 */
public class DaoUser implements CrudUser {

    //Se crea un objeto publico del Cliente
    ModelUser usuario = new ModelUser();
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
        ArrayList<ModelUser> listModel = new ArrayList<>();
        try {
            strSql = "SELECT U.ID_USUARIO, U.NOMBRE, U.APELLIDO, U.USUARIO, U.PASSWORD, U.ID_ROL, "
                    + "U.FECHA_CREA, U.ACTIVO, U.FECHA_MOD, U.USUARIO_CREA, U.USUARIO_MOD, U.CODIGO,"
                    + " R.NOMBRE DESCROL FROM USUARIO U JOIN ROL R ON R.ID_ROL = U.ID_ROL;";
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                ModelUser user = new ModelUser();
                user.setIdUsuario(rs.getInt("ID_USUARIO"));
                user.setNombre(rs.getString("NOMBRE"));
                user.setApellido(rs.getString("APELLIDO"));
                user.setUsuario(rs.getString("USUARIO"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setIdRol(rs.getInt("ID_ROL"));
                user.setFechaCrea(rs.getString("FECHA_CREA"));
                user.setActivo(rs.getInt("ACTIVO"));
                user.setFechaMod(rs.getString("FECHA_MOD"));
                user.setUsuarioCrea(rs.getString("USUARIO_CREA"));
                user.setUsuarioMod(rs.getString("USUARIO_MOD"));
                user.setCodigo(rs.getString("CODIGO"));
                user.setDescRol(rs.getString("DESCROL"));
                listModel.add(user);
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

    @Override
    public ModelUser list(int id) {
        try {
            strSql = "SELECT U.ID_USUARIO, U.NOMBRE, U.APELLIDO, U.USUARIO, U.PASSWORD, U.ID_ROL, "
                    + "U.FECHA_CREA, U.ACTIVO, U.FECHA_MOD, U.USUARIO_CREA, U.USUARIO_MOD, U.CODIGO,"
                    + " R.NOMBRE DESCROL FROM USUARIO U JOIN ROL R ON R.ID_ROL = U.ID_ROL WHERE U.ID_USUARIO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido(rs.getString("APELLIDO"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setIdRol(rs.getInt("ID_ROL"));
                usuario.setFechaCrea(rs.getString("FECHA_CREA"));
                usuario.setActivo(rs.getInt("ACTIVO"));
                usuario.setFechaMod(rs.getString("FECHA_MOD"));
                usuario.setUsuarioCrea(rs.getString("USUARIO_CREA"));
                usuario.setUsuarioMod(rs.getString("USUARIO_MOD"));
                usuario.setCodigo(rs.getString("CODIGO"));
                usuario.setDescRol(rs.getString("DESCROL"));
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public boolean insertar(ModelUser usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO USUARIO (ID_USUARIO, NOMBRE, APELLIDO, USUARIO, PASSWORD, ID_ROL, FECHA_CREA, ACTIVO, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, CODIGO)"
                + "VALUES ( (SELECT ISNULL(MAX(ID_USUARIO),0) + 1 FROM USUARIO), "
                + "'" + usuario.getNombre() + "', "
                + "'" + usuario.getApellido() + "', "
                + "'" + usuario.getUsuario() + "', "
                + "'" + usuario.getPassword() + "', "
                + "'" + usuario.getIdRol() + "', "
                + "'" + usuario.getFechaCrea() + "', "
                + "'" + usuario.getActivo() + "', "
                + "'" + usuario.getFechaMod() + "', "
                + "'" + usuario.getUsuarioCrea() + "', "
                + "'" + usuario.getUsuarioMod() + "', "
                + "'" + usuario.getCodigo() + "'"
                + ")";
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelUser usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE USUARIO "
                + "SET "
                + "NOMBRE = '" + usuario.getNombre() + "', "
                + "APELLIDO = '" + usuario.getApellido() + "', "
                + "USUARIO = '" + usuario.getUsuario() + "', "
                + "PASSWORD = '" + usuario.getPassword() + "', "
                + "ID_ROL = '" + usuario.getIdRol() + "', "
                + "FECHA_CREA = '" + usuario.getFechaCrea() + "', "
                + "ACTIVO = '" + usuario.getActivo() + "', "
                + "FECHA_MOD = '" + usuario.getFechaMod() + "', "
                + "USUARIO_CREA = '" + usuario.getUsuarioCrea() + "', "
                + "USUARIO_MOD = '" + usuario.getUsuarioMod() + "', "
                + "CODIGO = '" + usuario.getCodigo() + "' "
                + "WHERE ID_USUARIO =  " + usuario.getIdUsuario();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelUser usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE USUARIO WHERE ID_USUARIO = " + usuario.getIdUsuario();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
