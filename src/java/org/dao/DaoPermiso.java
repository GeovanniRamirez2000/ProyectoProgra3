package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.ModelPermisos;


public class DaoPermiso {
     //Se crea un objeto publico del Cliente
    ModelPermisos cliente = new ModelPermisos();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    public List listar() {
        ArrayList<ModelPermisos>lstPermisos = new ArrayList<>();
         try {            
            strSql = "SELECT M.Nombre AS DESCMODULO, R.Nombre AS DESCROL, P.ID_PERMISO, P.ID_MODULO, P.ID_ROL, P.FECHA_CREA, P.FECHA_MOD, P.FECHA_MOD, P.USUARIO_CREA, P.USUARIO_MOD, P.ACTIVO FROM PERMISO P \n" +
"JOIN ROL R ON R.ID_ROL = P.ID_ROL JOIN MODULO M ON M.ID_MODULO = P.ID_MODULO;";
             System.out.println(strSql);
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelPermisos permiso = new ModelPermisos();
                permiso.setDescmodulo(rs.getString("DESCMODULO"));
                permiso.setDescrol(rs.getString("DESCROL"));
                permiso.setId_permiso(rs.getInt("ID_PERMISO"));
                permiso.setId_modulo(rs.getInt("ID_MODULO"));
                permiso.setId_rol(rs.getInt("ID_ROL"));
                permiso.setFechaCrea(rs.getString("FECHA_CREA"));
                permiso.setFechaMod(rs.getString("FECHA_MOD"));
                permiso.setUsuarioCrea(rs.getString("USUARIO_CREA"));
                permiso.setUsuarioMod(rs.getString("USUARIO_MOD"));
                permiso.setActivo(rs.getInt("ACTIVO"));
                lstPermisos.add(permiso);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstPermisos;
    }
     public boolean insertar(ModelPermisos permiso) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "insert into PERMISO(ID_PERMISO,ID_MODULO,ID_ROL,FECHA_CREA,FECHA_MOD,USUARIO_CREA,USUARIO_MOD,ACTIVO)values"
                + "( (SELECT ISNULL(MAX(ID_PERMISO),0) + 1 FROM PERMISO), " +                   
                 "" + permiso.getId_modulo() + ", " +                 
                "" + permiso.getId_rol()+ ", " +       
                 "'" + permiso.getFechaCrea() + "', " +
                "'" + permiso.getFechaMod()+ "', " +
                 "'" + permiso.getUsuarioCrea()+ "'," +
                 "'" + permiso.getUsuarioMod()+ "'," +
                 "" + permiso.getActivo()+ "" +
                  ")";
         System.out.println(strSql);
        
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

    public boolean eliminar(ModelPermisos permiso) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE PERMISO WHERE ID_PERMISO = " + permiso.getId_permiso();
        
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
    
    public boolean modificar(ModelPermisos permiso) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE PERMISO " +
                 "SET " +
                 "ID_MODULO = '" + permiso.getId_modulo() + "', " +
                 "ID_ROL = '" + permiso.getId_rol()+ "', " + 
                 "FECHA_CREA = '" + permiso.getFechaCrea() + "', " + 
                 "FECHA_MOD = '" + permiso.getFechaMod() + "', " +
                 "USUARIO_CREA = '" + permiso.getUsuarioCrea()+ "', " +
                 "USUARIO_MOD = '" + permiso.getUsuarioMod()+ "', " +
                 "ACTIVO = '" + permiso.getActivo()+ "' " +
                 "WHERE ID_PERMISO =  " + permiso.getId_permiso();
        System.out.println(strSql);
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
