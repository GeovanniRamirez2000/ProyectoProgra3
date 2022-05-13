/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.webServices;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.dao.DaoUser;
import org.models.ModelUser;

/**
 *
 * @author GEOVARU
 */
@WebService(serviceName = "ServicioUser")
public class ServicioUser {

    DaoUser infoDao = new DaoUser();

    @WebMethod(operationName = "getUsuarios")
    public List<ModelUser> getUsuarios() {
        List<ModelUser> lstUsuarios = infoDao.listar();
        return lstUsuarios;
    }

    @WebMethod(operationName = "getShowUsuario")
    public ModelUser getShowUsuario(int id) {
        ModelUser infoModel = new ModelUser();
        infoModel = infoDao.list(id);
        return infoModel;
    }

    @WebMethod(operationName = "InsertUsuario")
    public String InsertUsuario(int idRol, int activo, String nombre, String apellido, String usuario, String password, String fechaCrea, String fechaMod, String usuarioCrea, String usuarioMod, String codigo) {
        ModelUser infoModel = new ModelUser();
        infoModel.setIdRol(idRol);
        infoModel.setActivo(activo);
        infoModel.setNombre(nombre);
        infoModel.setApellido(apellido);
        infoModel.setUsuario(usuario);
        infoModel.setPassword(password);
        infoModel.setFechaCrea(fechaCrea);
        infoModel.setFechaMod(fechaMod);
        infoModel.setUsuarioCrea(usuarioCrea);
        infoModel.setUsuarioMod(usuarioMod);
        infoModel.setCodigo(codigo);
        infoDao.insertar(infoModel);
        return "Usuario Nombre: " + nombre + " " + apellido + " insertado correctamente" + " !";
    }

    @WebMethod(operationName = "EliminarUsuario")
    public String EliminarUsuario(int id) {
        ModelUser infoModel = new ModelUser();
        infoModel.setIdUsuario(id);
        infoDao.eliminar(infoModel);
        return "Usuario #" + id + " Eliminado correctamente." + " !";
    }

    @WebMethod(operationName = "UpdateUsuario")
    public String UpdateUsuario(int id, int idRol, int activo, String nombre, String apellido, String usuario, String password, String fechaCrea, String fechaMod, String usuarioCrea, String usuarioMod, String codigo) {
        ModelUser infoModel = new ModelUser();
        infoModel.setIdUsuario(id);
        infoModel.setIdRol(idRol);
        infoModel.setActivo(activo);
        infoModel.setNombre(nombre);
        infoModel.setApellido(apellido);
        infoModel.setUsuario(usuario);
        infoModel.setPassword(password);
        infoModel.setFechaCrea(fechaCrea);
        infoModel.setFechaMod(fechaMod);
        infoModel.setUsuarioCrea(usuarioCrea);
        infoModel.setUsuarioMod(usuarioMod);
        infoModel.setCodigo(codigo);
        infoDao.modificar(infoModel);
        return "Usuario Nombre: " + nombre + " " + apellido + " modificado correctamente" + " !";
    }
}
