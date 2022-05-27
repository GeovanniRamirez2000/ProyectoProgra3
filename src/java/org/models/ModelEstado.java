
package org.models;


public class ModelEstado {
    int id_vehiculo_estado;
    String Descripcion;

    public ModelEstado() {
    }

    public ModelEstado(int id_vehiculo_estado, String Descripcion) {
        this.id_vehiculo_estado = id_vehiculo_estado;
        this.Descripcion = Descripcion;
    }

    public int getId_vehiculo_estado() {
        return id_vehiculo_estado;
    }

    public void setId_vehiculo_estado(int id_vehiculo_estado) {
        this.id_vehiculo_estado = id_vehiculo_estado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
