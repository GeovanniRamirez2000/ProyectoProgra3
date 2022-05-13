/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author INSPIRON 7000 SERIES
 */
public class ModelRoll {
    private int idRol;
    private String nombre;
    private String descripcion;
    private int activo;
    private String UCreador;
    private String UMod;
    private String fechaCrea;
    private String fechaMod;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getUCreador() {
        return UCreador;
    }

    public void setUCreador(String UCreador) {
        this.UCreador = UCreador;
    }

    public String getUMod() {
        return UMod;
    }

    public void setUMod(String UMod) {
        this.UMod = UMod;
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
    
    
}
