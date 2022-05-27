
package org.models;

public class ModelMarca {
    int id_marca;
    String descripcion;

    public ModelMarca() {
    }

    public ModelMarca(int id_marca, String descripcion) {
        this.id_marca = id_marca;
        this.descripcion = descripcion;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
