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
    
    public List listar() {
        ArrayList<ModuleModel>lstModulos = new ArrayList<>();
         try {            
            strSql = "SELECT *, CASE WHEN ACTIVO = 1 THEN 'ACTVO' WHEN ACTIVO = 0 THEN 'INACTIVO' END AS ACTIVO FROM MODULO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModuleModel mod = new ModuleModel();
                mod.setIdModulo(rs.getInt("ID_MODULO"));
                mod.setNombre(rs.getString("NOMBRE"));
                mod.setDescripcion(rs.getString("DESCRIPCION"));
                mod.setPath(rs.getString("PATH"));
                mod.setNivel(rs.getString("NIVEL"));
                mod.setIdModPadre(rs.getInt("ID_MODULO_PADRE"));
                mod.setFechaCreacion(rs.getString("FECHA_CREA"));
                mod.setFechaMod(rs.getString("FECHA_MOD"));
                mod.setUCreador(rs.getString("USUARIO_CREA"));
                mod.setUMod(rs.getString("USUARIO_MOD"));
                mod.setEstado(rs.getInt("ACTIVO"));
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
    
    public ModuleModel list(int id) {
        try {            
            strSql = "SELECT * FROM MODULO WHERE ID_MODULO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                module.setIdModulo(rs.getInt("ID_MODULO"));
                module.setNombre(rs.getString("NOMBRE"));
                module.setDescripcion(rs.getString("DESCRIPCION"));
                module.setPath(rs.getString("PATH"));
                module.setNivel(rs.getString("NIVEL"));
                module.setIdModPadre(rs.getInt("ID_MODULO_PADRE"));
                module.setFechaCreacion(rs.getString("FECHA_CREA"));
                module.setFechaMod(rs.getString("FECHA_MOD"));
                module.setUCreador(rs.getString("USUARIO_CREA"));
                module.setUMod(rs.getString("USUARIO_MOD"));
                module.setEstado(rs.getInt("ACTIVO"));             
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModule.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return module;
    }
    
    public List listarMenu() {
        ArrayList<ModuleModel>lstModulos = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM MODULO WHERE ACTIVO = 1";
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
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO MODULO(ID_MODULO, NOMBRE, DESCRIPCION, PATH, NIVEL, ID_MODULO_PADRE, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, ACTIVO) VALUES((SELECT COUNT(ID_MODULO) FROM MODULO)+1, '" + module.getNombre() + "', '" + module.getDescripcion() + "', '" + module.getPath() + "', '" + module.getNivel() + "', 1, '" + module.getFechaCreacion() + "', '" + module.getFechaMod() + "', '" + module.getUCreador() + "', '" + module.getUMod() + "', " + module.getEstado() + ")";
        System.out.println("Insertar usuario: " + strSql);
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
    
    public boolean modificar(ModuleModel module) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE MODULO SET NOMBRE = '" + module.getNombre() + "',DESCRIPCION = '" + module.getDescripcion()+ "', PATH = '" + module.getPath()+ "', NIVEL = '" + module.getNivel()+ "', ID_MODULO_PADRE = 1, FECHA_CREA = '14-05-2022', FECHA_MOD = '14-05-2022', USUARIO_CREA = '" + module.getUCreador()+ "', USUARIO_MOD = '" + module.getFechaMod()+ "',ACTIVO = " + module.getEstado()+ " WHERE ID_MODULO =  " + module.getIdModulo();
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
