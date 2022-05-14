/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author josea
 */
public class ModelPermisos {
    int id_permiso;
    int id_modulo;
    int id_rol;
    String fechaCrea;
    String fechaMod;
    String usuarioCrea;
    String usuarioMod;
    int activo;
    String descrol;

    public String getDescrol() {
        return descrol;
    }

    public void setDescrol(String descrol) {
        this.descrol = descrol;
    }

    public ModelPermisos() {
    }
    
    public ModelPermisos(int id_permiso, int id_modulo, int id_rol, String fechaCrea, String fechaMod, String usuarioCrea, String usuarioMod, int activo) {
        this.id_permiso = id_permiso;
        this.id_modulo = id_modulo;
        this.id_rol = id_rol;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
        this.usuarioCrea = usuarioCrea;
        this.usuarioMod = usuarioMod;
        this.activo = activo;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fechaMod) {
        this.fechaMod = fechaMod;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
}
