package org.models;


public class ModelRol {
    int idRol;
    String Nombre;
    String Descripcion;
    int activo;
    String usuarioCrea;
    String UsuarioMod;
    String FechaCrea;
    String FechaMod;

    public ModelRol() {
    }

    public ModelRol(int idRol, String Nombre, String Descripcion, int activo, String usuarioCrea, String UsuarioMod, String FechaCrea, String FechaMod) {
        this.idRol = idRol;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.activo = activo;
        this.usuarioCrea = usuarioCrea;
        this.UsuarioMod = UsuarioMod;
        this.FechaCrea = FechaCrea;
        this.FechaMod = FechaMod;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getUsuarioMod() {
        return UsuarioMod;
    }

    public void setUsuarioMod(String UsuarioMod) {
        this.UsuarioMod = UsuarioMod;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String FechaCrea) {
        this.FechaCrea = FechaCrea;
    }

    public String getFechaMod() {
        return FechaMod;
    }

    public void setFechaMod(String FechaMod) {
        this.FechaMod = FechaMod;
    }
    
    
    
}
