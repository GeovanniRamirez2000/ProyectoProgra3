/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

/**
 *
 * @author MSarazua
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudModule;
import org.models.ModuleModel;

public class DaoModule implements CrudModule{
    ModuleModel module = new ModuleModel();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    
    public List listarMenu() {
        ArrayList<ModuleModel>lstModulos = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM MODULO WHERE ACTIVO = 1 AND NIVEL = 1";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModuleModel mod = new ModuleModel();
                mod.setIdModulo(rs.getInt("ID_MODULO"));
                mod.setNombre(rs.getString("NOMBRE"));
                mod.setPath(rs.getString("PATH"));
                lstModulos.add(mod);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstModulos;
    }
    
    public List listarSubMenu() {
        ArrayList<ModuleModel>lstModulos = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM MODULO WHERE ACTIVO = 1 AND NIVEL = 2";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModuleModel mod = new ModuleModel();
                mod.setIdModulo(rs.getInt("ID_MODULO"));
                mod.setNombre(rs.getString("NOMBRE"));
                mod.setPath(rs.getString("PATH"));
                lstModulos.add(mod);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstModulos;
    }
    
    public boolean insertar(ModuleModel module) {
        if(module.getIdModPadre() == 0){
            strSql = "INSERT INTO MODULO(ID_MODULO, NOMBRE, DESCRIPCION, PATH, NIVEL, ID_MODULO_PADRE, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, ACTIVO) VALUES((SELECT COUNT(ID_MODULO) FROM MODULO)+1, '" + module.getNombre() + "', '" + module.getDescripcion() + "', '" + module.getPath() + "', '" + module.getNivel() + "',(SELECT COUNT(ID_MODULO) FROM MODULO)+1, '" + module.getFechaCreacion() + "', '" + module.getFechaMod() + "', '" + module.getUCreador() + "', '" + module.getUMod() + "', " + module.getEstado() + ")";
            System.out.println("Insertar modulo: " + strSql);
        }else{
            //Se prepara la sentencia SQL a ejecutar en la BD
            strSql = "INSERT INTO MODULO(ID_MODULO, NOMBRE, DESCRIPCION, PATH, NIVEL, ID_MODULO_PADRE, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, ACTIVO) VALUES((SELECT COUNT(ID_MODULO) FROM MODULO)+1, '" + module.getNombre() + "', '" + module.getDescripcion() + "', '" + module.getPath() + "', '" + module.getNivel() + "', "+ module.getIdModPadre() +", '" + module.getFechaCreacion() + "', '" + module.getFechaMod() + "', '" + module.getUCreador() + "', '" + module.getUMod() + "', " + module.getEstado() + ")";
            System.out.println("Insertar usuario: " + strSql);
        }
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
}
