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
import org.models.ModelDevolucion;
import org.models.ModelEstado;
import org.models.ModelMarca;
import org.models.ModelTipo_Vehiculo;
import org.models.Modelvehiculo;

/**
 *
 * @author INSPIRON 7000 SERIES
 */
public class DaoDevolucion {
        Modelvehiculo module = new Modelvehiculo();
     Modelvehiculo objve = new Modelvehiculo();
     ModelDevolucion moduledevo = new ModelDevolucion();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    String strSql2 =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    

    public List listarDevoluciones() {
        ArrayList<ModelDevolucion>lstdevoluciones = new ArrayList<>();
         try {            
            strSql = "select  \n" +
"a.ID_DEVOLUCION, \n" +
"a.ID_RENTA,  \n" +
"a.SERIE,  \n" +
"a.FECHA,\n" +
"a.OBSERVACIONES,\n" +
"b.NOMBRE as USUARIO,\n" +
"a.DIAS_ATRASO,\n" +
"a.MORA\n" +
"\n" +
"from DEVOLUCION a \n" +
"left join USUARIO b on b.ID_USUARIO = a.ID_USUARIO ";
            conexion.open();
            rs = conexion.executeQuery(strSql);       
             System.out.println(strSql);
            
            while (rs.next()) {
                ModelDevolucion dev = new ModelDevolucion();
                dev.setId_devolucion(rs.getInt("ID_DEVOLUCION"));
                dev.setId_renta(rs.getInt("ID_RENTA"));
                dev.setSerie(rs.getString("SERIE"));
                dev.setFecha(rs.getString("FECHA"));
                dev.setObservaciones(rs.getString("OBSERVACIONES"));
                dev.setUsuario(rs.getString("USUARIO"));
                dev.setDias_atraso(rs.getInt("DIAS_ATRASO"));
                dev.setMora(rs.getDouble("MORA"));
                lstdevoluciones.add(dev);
                
               
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstdevoluciones;
    }
     public Modelvehiculo list(int id) {
           
        try {
            strSql = "select ce.ID_VEHICULO 'id_vehiculo',dm.ID_MARCA, dm.DESCRIPCION 'marca',dv.ID_TIPO_VEHICULO, dv.DESCRIPCION 'tipo_vehiculo',ve.ID_VEHICULO_ESTADO,ve.DESCRIPCION 'estadoVe',ce.MODELO\n" +
"  from VEHICULO ce\n" +
"  inner join MARCA dm\n" +
"   on ce.ID_MARCA=dm.ID_MARCA\n" +
"  inner join TIPO_VEHICULO dv\n" +
"  on ce.ID_TIPO_VEHICULO=dv.ID_TIPO_VEHICULO\n" +
"  inner join VEHICULO_ESTADO ve\n" +
"  on ce.ID_VEHICULO_ESTADO=ve.ID_VEHICULO_ESTADO WHERE ID_VEHICULO ="+id;
            conexion.open();
            rs = conexion.executeQuery(strSql);
            System.out.println(strSql);
            while (rs.next()) {
             
               
                
                objve.setId_vehiculo(rs.getInt("ID_VEHICULO"));
                objve.setId_marca(rs.getInt("ID_MARCA"));
                objve.setMarca(rs.getString("marca"));
                objve.setId_tipo_vehiculo(rs.getInt("ID_TIPO_VEHICULO"));
                objve.setTipo_de_vehiculo(rs.getString("tipo_vehiculo"));
                objve.setId_vehiculo_estado(rs.getInt("ID_VEHICULO_ESTADO"));
                objve.setEstado(rs.getString("estadoVe"));
                objve.setModelo(rs.getString("MODELO"));
                
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objve;
        
      
    }
    
    public boolean insertar(ModelDevolucion devolucion) {
         //Se prepara la sentencia SQL a ejecutar en la BD
         strSql = "insert into DEVOLUCION(ID_DEVOLUCION,ID_RENTA,SERIE,FECHA,OBSERVACIONES,ID_USUARIO,DIAS_ATRASO,MORA) \n" +
"VALUES ((SELECT ISNULL(MAX(ID_DEVOLUCION),0) + 1 FROM DEVOLUCION), "+ devolucion.getId_renta() +",'"+ devolucion.getSerie() +"','"+ devolucion.getFecha()+"','"+devolucion.getObservaciones()+"',"+devolucion.getId_usuario()+","+devolucion.getDias_atraso()+","+devolucion.getMora()+")";
        strSql2 = "UPDATE VEHICULO \n" +
                "SET ID_VEHICULO_ESTADO=1\n" +
                "WHERE ID_VEHICULO ="+devolucion.getId_vehiculo()+";";
         
         System.out.println(strSql);
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            respuesta = conexion.executeSql(strSql2);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    public boolean eliminar(Modelvehiculo vehiculo) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "delete VEHICULO where ID_VEHICULO=" + vehiculo.getId_vehiculo();
        System.out.println(strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            System.out.println(vehiculo.getId_vehiculo());
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
     public boolean editar(Modelvehiculo vehiculo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
       strSql = "UPDATE VEHICULO \n" +
                "SET ID_MARCA="+vehiculo.getId_marca()+",\n" +
                "ID_TIPO_VEHICULO="+vehiculo.getId_tipo_vehiculo()+",\n" +
                "ID_VEHICULO_ESTADO="+vehiculo.getId_vehiculo_estado()+",\n" +
                "MODELO='"+vehiculo.getModelo()+"'\n" +
                "WHERE ID_VEHICULO ="+vehiculo.getId_vehiculo()+";";
         System.out.println(strSql);
         System.out.println(vehiculo.getId_marca());
         
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
     public boolean editarEstado(Modelvehiculo vehiculo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
       strSql = "UPDATE VEHICULO \n" +
                "SET ID_VEHICULO_ESTADO="+vehiculo.getId_vehiculo_estado()+"\n" +
                "WHERE ID_VEHICULO ="+vehiculo.getId_vehiculo()+";";
     
      
         
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
}
