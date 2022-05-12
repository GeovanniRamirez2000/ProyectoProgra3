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
    
    public boolean insertar(ModuleModel module) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO MODULO(ID_MODULO, NOMBRE, DESCRIPCION, PATH, NIVEL, ID_MODULO_PADRE, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, ACTIVO) VALUES((SELECT COUNT(ID_FACTURA) FROM FACTURA)+1, '" + module.getNombre() + "', '" + module.getDescripcion() + "', '" + module.getPath() + "', '" + module.getNivel() + "', "+ module.getIdModPadre() +", '" + module.getFechaCreacion() + "', '" + module.getFechaMod() + "', '" + module.getUCreador() + "', '" + module.getUMod() + "', " + module.getEstado() + ")";
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
}
