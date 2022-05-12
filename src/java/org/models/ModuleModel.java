/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author MSarazua
 */
public class ModuleModel {
    private int idModulo;
    private String nombre;
    private String descripcion;
    private String path;
    private String nivel;
    private int idModPadre;
    private String fechaCreacion;
    private String fechaMod;
    private String UCreador;
    private String UMod;
    private int estado;

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getIdModPadre() {
        return idModPadre;
    }

    public void setIdModPadre(int idModPadre) {
        this.idModPadre = idModPadre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fechaMod) {
        this.fechaMod = fechaMod;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
