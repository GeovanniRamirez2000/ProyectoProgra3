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
import org.interfaces.CrudModule;
import org.interfaces.CrudRoll;
import org.models.ModelRoll;
import org.models.ModuleModel;

/**
 *
 * @author INSPIRON 7000 SERIES
 */
public class DaoRoll implements CrudRoll{
  
    ModelRoll roll = new ModelRoll();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    
    public List listar() {
        ArrayList<ModelRoll> lstRoll = new ArrayList<>();
        try {
         
          strSql = "SELECT * FROM ROL"; 
            conexion.open();
            rs = conexion.executeQuery(strSql);
            

            while (rs.next()) {
                ModelRoll roll = new ModelRoll();
                roll.setIdRol(rs.getInt("ID_ROL"));
                roll.setNombre(rs.getString("NOMBRE"));
                roll.setDescripcion(rs.getString("DESCRIPCION"));
                roll.setActivo(rs.getInt("ACTIVO"));
                roll.setUCreador(rs.getString("USUARIO_CREA"));
                roll.setUMod(rs.getString("USUARIO_MOD"));
                roll.setFechaCrea(rs.getString("FECHA_CREA"));
                roll.setFechaMod(rs.getString("FECHA_MOD"));
                lstRoll.add(roll);
              
               
               
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRoll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoRoll.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstRoll;
    }

    
    @Override
    public ModelRoll list(int id) {
        /*
        try {
            strSql = "SELECT * FROM KARDEX WHERE ID_KARDEX = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
             
                kaardex.setIdKardex(rs.getInt("ID_KARDEX"));
                kaardex.setIdUsuario(rs.getString("ID_USUARIO"));
                kaardex.setIdProducto(rs.getString("ID_PRODUCTO"));
                kaardex.setIdTipoMov(rs.getString("ID_TIPO_MOVIMIENTO"));
                kaardex.setCantidad(rs.getInt("CANTIDAD"));
                kaardex.setExistencia(rs.getInt("EXISTENCIA"));
                kaardex.setSaldo(rs.getInt("SALDO"));
                kaardex.setDescripcion(rs.getString("DESCRIPCION"));
                kaardex.setFecha(rs.getDate("FECHA"));
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kaardex;
        */
        return null;
    }
    
    
    @Override
    public boolean insertar(ModelRoll roll) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        
        strSql = "insert into ROL(ID_ROL,NOMBRE,DESCRIPCION,ACTIVO,USUARIO_CREA,USUARIO_MOD,FECHA_CREA,FECHA_MOD) \n" +
"values ((SELECT ISNULL(MAX(ID_ROL),0) + 1 FROM ROL),'"+roll.getNombre()+"','"+roll.getDescripcion()+"',"+roll.getActivo()+",'"+roll.getUCreador()+"','"+roll.getUMod()+"','"+roll.getFechaCrea()+"','"+roll.getFechaMod()+"');";
        
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
    
     @Override
    public boolean modificar(ModelRoll roll) {
         //Se prepara la sentencia SQL a ejecutar en la BD
       strSql = "UPDATE ROL \n" +
"SET NOMBRE='"+roll.getNombre()+"',\n" +
"DESCRIPCION='"+roll.getDescripcion()+"',\n" +
"ACTIVO="+roll.getActivo()+",\n" +
"USUARIO_CREA='"+roll.getUCreador()+"',\n" +
"USUARIO_MOD='"+roll.getUCreador()+"',\n" +
"FECHA_CREA='"+roll.getFechaCrea()+"',\n" +
"FECHA_MOD='"+roll.getFechaMod()+"'\n" +
"WHERE ID_ROL="+roll.getIdRol()+";";
         /* strSql = "UPDATE CLIENTE " +
                 "SET " +
                 "NOMBRE = '" + cliente.getNombre() + "', " +
                 "APELLIDO = '" + cliente.getApellido()+ "', " + 
                 "NIT = '" + cliente.getNit() + "', " + 
                 "TELEFONO = '" + cliente.getTelefono() + "', " +
                 "DIRECCION = '" + cliente.getDireccion()+ "' " +
                 "WHERE ID_CLIENTE =  " + cliente.getIdCliente();*/
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRoll.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoRoll.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
}
