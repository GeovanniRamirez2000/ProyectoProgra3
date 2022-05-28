
package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.ModelCliente;
import org.models.ModelMarca;
import org.models.ModelPermisos;
import org.models.ModelRenta;
import org.models.ModelTipoPago;
import org.models.ModelUser;
import org.models.Modelvehiculo;


public class DaoRenta {
     ModelCliente cliente = new ModelCliente();
     Modelvehiculo objve = new Modelvehiculo();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;
    
    public List listarCliente() {
        ArrayList<ModelCliente>lstCliente = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM CLIENTE";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelCliente cliente = new ModelCliente();
                cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                cliente.setNit(rs.getString("NIT"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setApellido(rs.getString("APELLIDO"));
                cliente.setTelefono(rs.getString("TELEFONO"));
                cliente.setDireccion(rs.getString("TELEFONO"));
                
                lstCliente.add(cliente);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstCliente;
    }
       public List listarTipoPago() {
        ArrayList<ModelTipoPago>lstTipoPago = new ArrayList<>();
         try {            
            strSql = "select * from TIPO_PAGO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelTipoPago pago = new ModelTipoPago();
                pago.setIdTipoPago(rs.getInt("ID_TIPO_PAGO"));
                pago.setDescripcion(rs.getString("DESCRIPCION"));
                
                lstTipoPago.add(pago);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstTipoPago;
    }
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
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }
       
  /*  public boolean insertar(ModelRenta renta) {
         //Se prepara la sentencia SQL a ejecutar en la BD
         System.out.println(strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.SetAutoCommit(false);
            Statement stmt=conexion.createStatement();
            String SQL="insert into RENTA(ID_RENTA, SERIE, ID_CLIENTE,ID_USUARIO, ID_TIPO_PAGO, FECHA_PRESTAMO, FECHA_DEVOLUCION, TOTAL) VALUES((SELECT ISNULL(MAX(ID_RENTA),0) + 1 FROM RENTA),'" + renta.getSERIE() + "'," + renta.getID_CLIENTE() + "," + renta.getID_USUARIO() + "," + renta.getID_TIPO_PAGO() + ",'" + renta.getFECHA_PRESTAMO() + "','" + renta.getFECHA_DEVOLUCION() + "'," + renta.getTotal() + ")";
            stmt.executeUpdate(SQL);
            String SQL1="insert into DETALLE_RENTA(ID_RENTA,SERIE,ID_DETALLE_RENTA,ID_VEHICULO,PRECIO_ALQUILER)VALUES((SELECT ISNULL(MAX(ID_RENTA),0) + 1 FROM DETALLE_RENTA),'" + renta.getSERIE() + "',(SELECT ISNULL(MAX(ID_DETALLE_RENTA),0) + 1 FROM DETALLE_RENTA)," + renta.getID_VEHICULO() + "," + renta.getPRECIO_ALQUILER() + ")";
            stmt.executeUpdate(SQL1);
            /*String SQL2="update VEHICULO SET ID_VEHICULO_ESTADO=" + renta.getID_VEHICULO_ESTADO() + " where ID_VEHICULO=" + renta.getID_VEHICULO() + ";";
            stmt.executeUpdate(SQL2);
            conexion.commit();
             
        } catch (SQLException se) {
             conexion.rolback();
        }
        return respuesta;
    }*/
       
        public boolean insertarRenta(ModelRenta renta) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "insert into RENTA(ID_RENTA, SERIE, ID_CLIENTE,ID_USUARIO, ID_TIPO_PAGO, FECHA_PRESTAMO, FECHA_DEVOLUCION, TOTAL) "
                + "VALUES((SELECT ISNULL(MAX(ID_RENTA),0) + 1 FROM RENTA),'" + renta.getSERIE() + "'," + renta.getID_CLIENTE() + "," + renta.getID_USUARIO() + "," + renta.getID_TIPO_PAGO() + ",'" + renta.getFECHA_PRESTAMO() + "','" + renta.getFECHA_DEVOLUCION() + "'," + renta.getTotal() + ")";
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
     public boolean Detalle_renta(ModelRenta renta) {
         //Se prepara la sentencia SQL a ejecutar en la BD
         String strSql="insert into DETALLE_RENTA(ID_RENTA,SERIE,ID_DETALLE_RENTA,ID_VEHICULO,PRECIO_ALQUILER)VALUES((SELECT ISNULL(MAX(ID_RENTA),0) + 1 FROM DETALLE_RENTA),'" + renta.getSERIE() + "',(SELECT ISNULL(MAX(ID_DETALLE_RENTA),0) + 1 FROM DETALLE_RENTA)," + renta.getID_VEHICULO() + "," + renta.getPRECIO_ALQUILER() + ")";
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
     public boolean actualizarVehiculo(ModelRenta renta) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        String strSql="update VEHICULO SET ID_VEHICULO_ESTADO=2 where ID_VEHICULO=" + renta.getID_VEHICULO() + ";";
            
        
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
    
      public List listarVehiculosDisponibles() {
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
                    + "WHERE ce.ID_VEHICULO_ESTADO=1 ";
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
       public List MostrarRentas() {
        ArrayList<ModelRenta>lstRentas = new ArrayList<>();
         try {            
            strSql = "select re.ID_RENTA,re.SERIE,ce.NOMBRE,tp.DESCRIPCION,re.FECHA_PRESTAMO,re.FECHA_DEVOLUCION,re.TOTAL\n" +
"    from RENTA re\n" +
"	inner join CLIENTE ce\n" +
"	on RE.ID_CLIENTE=ce.ID_CLIENTE\n" +
"	inner join USUARIO us\n" +
"	on re.ID_USUARIO=us.ID_USUARIO\n" +
"	inner join tipo_pago tp\n" +
"	on re.ID_TIPO_PAGO=tp.ID_TIPO_PAGO";
            conexion.open();
            rs = conexion.executeQuery(strSql);       
             System.out.println(strSql);
            
            while (rs.next()) {
                ModelRenta objre = new ModelRenta();
                objre.setID_RENTA(rs.getInt("ID_RENTA"));
                objre.setSERIE(rs.getString("SERIE"));
                objre.setNombre(rs.getString("NOMBRE"));
                objre.setDescripcion(rs.getString("DESCRIPCION"));
                objre.setFECHA_PRESTAMO(rs.getString("FECHA_PRESTAMO"));
                objre.setFECHA_DEVOLUCION(rs.getString("FECHA_DEVOLUCION"));
                objre.setTotal(rs.getInt("TOTAL"));
                
                lstRentas.add(objre);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstRentas;
    }
    
}
