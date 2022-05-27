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
import org.models.ModelMarca;

/**
 *
 * @author MSarazua
 */
public class DaoMarcas {
    ModelMarca marca = new ModelMarca();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    
    public List listar() {
        ArrayList<ModelMarca>lstMarcas = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM MARCA";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelMarca marca = new ModelMarca();
                marca.setId_marca(rs.getInt("ID_MARCA"));
                marca.setDescripcion(rs.getString("DESCRIPCION"));
                lstMarcas.add(marca);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstMarcas;
    }
    
    public boolean insertar(ModelMarca marca) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO MARCA(ID_MARCA, DESCRIPCION) VALUES((SELECT COUNT(ID_MARCA) FROM MARCA)+1, '" + marca.getDescripcion() + "')";
        System.out.println("Insertar marca: " + strSql);
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
    
    public boolean modificar(ModelMarca marca) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE MARCA SET DESCRIPCION = '" + marca.getDescripcion()+ "' WHERE ID_MARCA =  " + marca.getId_marca();
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
    
    public ModelMarca list(int id) {
        try {            
            strSql = "SELECT * FROM MARCA WHERE ID_MARCA = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                marca.setId_marca(rs.getInt("ID_MARCA"));
                marca.setDescripcion(rs.getString("DESCRIPCION"));           
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return marca;
    }
}
