
package org.models;


public class Modelvehiculo {
    int id_vehiculo;
    int id_marca;
    String marca;
    int id_tipo_vehiculo;
    String tipo_de_vehiculo;
    int id_vehiculo_estado;
    String estado;
    String modelo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo_de_vehiculo() {
        return tipo_de_vehiculo;
    }

    public void setTipo_de_vehiculo(String tipo_de_vehiculo) {
        this.tipo_de_vehiculo = tipo_de_vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Modelvehiculo() {
    }

    public Modelvehiculo(int id_vehiculo, int id_marca, int id_tipo_vehiculo, int id_vehiculo_estado, String modelo) {
        this.id_vehiculo = id_vehiculo;
        this.id_marca = id_marca;
        this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.id_vehiculo_estado = id_vehiculo_estado;
        this.modelo = modelo;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public int getId_vehiculo_estado() {
        return id_vehiculo_estado;
    }

    public void setId_vehiculo_estado(int id_vehiculo_estado) {
        this.id_vehiculo_estado = id_vehiculo_estado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
}
