
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.ModelEstado;
import org.models.ModelMarca;
import org.models.ModelTipo_Vehiculo;
import org.models.Modelvehiculo;


public class DaoVehiculos {
    Modelvehiculo module = new Modelvehiculo();
     Modelvehiculo objve = new Modelvehiculo();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    
    public List listarMarca() {
        ArrayList<ModelMarca>lstMarca = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM MARCA";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelMarca marca = new ModelMarca();
                marca.setId_marca(rs.getInt("ID_MARCA"));
                marca.setDescripcion(rs.getString("DESCRIPCION"));
                lstMarca.add(marca);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstMarca;
    }
       public List listarTipo_V() {
        ArrayList<ModelTipo_Vehiculo>lstvehiculo = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM TIPO_VEHICULO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelTipo_Vehiculo objV = new ModelTipo_Vehiculo();
                objV.setId_tipo_vehiculo(rs.getInt("ID_TIPO_VEHICULO"));
                objV.setDescripcion(rs.getString("DESCRIPCION"));
                lstvehiculo.add(objV);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstvehiculo;
    }
       
    public List listarEstado() {
        ArrayList<ModelEstado>lstEstado = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM VEHICULO_ESTADO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelEstado objestado = new ModelEstado();
                objestado.setId_vehiculo_estado(rs.getInt("ID_VEHICULO_ESTADO"));
                objestado.setDescripcion(rs.getString("DESCRIPCION"));
                lstEstado.add(objestado);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstEstado;
    }
    public List listarVehiculos() {
        ArrayList<Modelvehiculo>lstvehiculos = new ArrayList<>();
         try {            
            strSql = "select ce.ID_VEHICULO 'id_vehiculo',dm.ID_MARCA, dm.DESCRIPCION 'marca',dv.ID_TIPO_VEHICULO, dv.DESCRIPCION 'tipo_vehiculo',ve.ID_VEHICULO_ESTADO,ve.DESCRIPCION 'estadoVe',ce.MODELO\n" +
"  from VEHICULO ce\n" +
"  inner join MARCA dm\n" +
"   on ce.ID_MARCA=dm.ID_MARCA\n" +
"  inner join TIPO_VEHICULO dv\n" +
"  on ce.ID_TIPO_VEHICULO=dv.ID_TIPO_VEHICULO\n" +
"  inner join VEHICULO_ESTADO ve\n" +
"  on ce.ID_VEHICULO_ESTADO=ve.ID_VEHICULO_ESTADO";
            conexion.open();
            rs = conexion.executeQuery(strSql);       
             System.out.println(strSql);
            
            while (rs.next()) {
                Modelvehiculo objve = new Modelvehiculo();
                objve.setId_vehiculo(rs.getInt("ID_VEHICULO"));
                objve.setId_marca(rs.getInt("ID_MARCA"));
                objve.setMarca(rs.getString("marca"));
                objve.setId_tipo_vehiculo(rs.getInt("ID_TIPO_VEHICULO"));
                objve.setTipo_de_vehiculo(rs.getString("tipo_vehiculo"));
                objve.setId_vehiculo_estado(rs.getInt("ID_VEHICULO_ESTADO"));
                objve.setEstado(rs.getString("estadoVe"));
                objve.setModelo(rs.getString("MODELO"));
                lstvehiculos.add(objve);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstvehiculos;
    }
    
    public List listarVehiculosRentados() {
        ArrayList<Modelvehiculo>lstvehiculos = new ArrayList<>();
         try {            
            strSql = "select ce.ID_VEHICULO 'id_vehiculo',dm.ID_MARCA, dm.DESCRIPCION 'marca',dv.ID_TIPO_VEHICULO, dv.DESCRIPCION 'tipo_vehiculo',ve.ID_VEHICULO_ESTADO,ve.DESCRIPCION 'estadoVe',ce.MODELO\n" +
"  from VEHICULO ce\n" +
"  inner join MARCA dm\n" +
"   on ce.ID_MARCA=dm.ID_MARCA\n" +
"  inner join TIPO_VEHICULO dv\n" +
"  on ce.ID_TIPO_VEHICULO=dv.ID_TIPO_VEHICULO\n" +
"  inner join VEHICULO_ESTADO ve\n" +
"  on ce.ID_VEHICULO_ESTADO=ve.ID_VEHICULO_ESTADO \n"
                    + "WHERE ce.ID_VEHICULO_ESTADO=3 ";
            conexion.open();
            rs = conexion.executeQuery(strSql);       
             System.out.println(strSql);
            
            while (rs.next()) {
                Modelvehiculo objve = new Modelvehiculo();
                objve.setId_vehiculo(rs.getInt("ID_VEHICULO"));
                objve.setId_marca(rs.getInt("ID_MARCA"));
                objve.setMarca(rs.getString("marca"));
                objve.setId_tipo_vehiculo(rs.getInt("ID_TIPO_VEHICULO"));
                objve.setTipo_de_vehiculo(rs.getString("tipo_vehiculo"));
                objve.setId_vehiculo_estado(rs.getInt("ID_VEHICULO_ESTADO"));
                objve.setEstado(rs.getString("estadoVe"));
                objve.setModelo(rs.getString("MODELO"));
                lstvehiculos.add(objve);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstvehiculos;
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
    
    public boolean insertar(Modelvehiculo vehiculo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "insert into VEHICULO(ID_VEHICULO,ID_MARCA,ID_TIPO_VEHICULO,ID_VEHICULO_ESTADO,MODELO)values"
                + "( (SELECT ISNULL(MAX(ID_VEHICULO),0) + 1 FROM VEHICULO), " +                   
                 "" + vehiculo.getId_marca() + ", " +                 
                "" + vehiculo.getId_tipo_vehiculo()+ ", " +       
                 "" + vehiculo.getId_vehiculo_estado()+ ", " +
                "'" + vehiculo.getModelo()+ "'"
                + ")";
         System.out.println(strSql);
        
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
