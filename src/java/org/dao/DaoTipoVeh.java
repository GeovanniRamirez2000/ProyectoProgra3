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
import org.models.ModelTipo_Vehiculo;

/**
 *
 * @author MSarazua
 */
public class DaoTipoVeh {
    ModelTipo_Vehiculo tipo = new ModelTipo_Vehiculo();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    
    public List listar() {
        ArrayList<ModelTipo_Vehiculo>lstTipoVeh = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM TIPO_VEHICULO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelTipo_Vehiculo tipo = new ModelTipo_Vehiculo();
                tipo.setId_tipo_vehiculo(rs.getInt("ID_TIPO_VEHICULO"));
                tipo.setDescripcion(rs.getString("DESCRIPCION"));
                lstTipoVeh.add(tipo);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstTipoVeh;
    }
    
    public boolean insertar(ModelTipo_Vehiculo tipo) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO TIPO_VEHICULO(ID_TIPO_VEHICULO, DESCRIPCION) VALUES((SELECT COUNT(ID_TIPO_VEHICULO) FROM TIPO_VEHICULO)+1, '" + tipo.getDescripcion() + "')";
        System.out.println("Insertar tipo: " + strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    
    public boolean modificar(ModelTipo_Vehiculo tipo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE TIPO_VEHICULO SET DESCRIPCION = '" + tipo.getDescripcion()+ "' WHERE ID_TIPO_VEHICULO =  " + tipo.getId_tipo_vehiculo();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    
    public ModelTipo_Vehiculo list(int id) {
        try {            
            strSql = "SELECT * FROM TIPO_VEHICULO WHERE ID_TIPO_VEHICULO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                tipo.setId_tipo_vehiculo(rs.getInt("ID_TIPO_VEHICULO"));
                tipo.setDescripcion(rs.getString("DESCRIPCION"));           
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return tipo;
    }
    
    public boolean eliminar(ModelTipo_Vehiculo tipo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE TIPO_VEHICULO WHERE ID_TIPO_VEHICULO = " + tipo.getId_tipo_vehiculo();
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
}
