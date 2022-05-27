
package org.models;


public class ModelTipo_Vehiculo {
    int id_tipo_vehiculo;
    String descripcion;

    public ModelTipo_Vehiculo() {
    }

    public ModelTipo_Vehiculo(int id_tipo_vehiculo, String descripcion) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.descripcion = descripcion;
    }

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
