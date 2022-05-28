
package org.models;


public class ModelRenta {
    int ID_RENTA;
    String SERIE;
    String nombre;
    String descripcion;
    int ID_CLIENTE;
    int ID_USUARIO;
    int ID_TIPO_PAGO;
    String FECHA_PRESTAMO;
    String FECHA_DEVOLUCION;
    int ID_VEHICULO_ESTADO;
    int ID_VEHICULO;
    int PRECIO_ALQUILER;
    int Total;

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

    public int getID_VEHICULO_ESTADO() {
        return ID_VEHICULO_ESTADO;
    }

    public void setID_VEHICULO_ESTADO(int ID_VEHICULO_ESTADO) {
        this.ID_VEHICULO_ESTADO = ID_VEHICULO_ESTADO;
    }

  

    public int getID_VEHICULO() {
        return ID_VEHICULO;
    }

    public void setID_VEHICULO(int ID_VEHICULO) {
        this.ID_VEHICULO = ID_VEHICULO;
    }

    public int getPRECIO_ALQUILER() {
        return PRECIO_ALQUILER;
    }

    public void setPRECIO_ALQUILER(int PRECIO_ALQUILER) {
        this.PRECIO_ALQUILER = PRECIO_ALQUILER;
    }

    
    public ModelRenta(int ID_RENTA, String SERIE, int ID_CLIENTE, int ID_USUARIO, int ID_TIPO_PAGO, String FECHA_PRESTAMO, String FECHA_DEVOLUCION, int Total) {
        this.ID_RENTA = ID_RENTA;
        this.SERIE = SERIE;
        this.ID_CLIENTE = ID_CLIENTE;
        this.ID_USUARIO = ID_USUARIO;
        this.ID_TIPO_PAGO = ID_TIPO_PAGO;
        this.FECHA_PRESTAMO = FECHA_PRESTAMO;
        this.FECHA_DEVOLUCION = FECHA_DEVOLUCION;
        this.Total = Total;
    }

    public ModelRenta() {
    }

    public int getID_RENTA() {
        return ID_RENTA;
    }

    public void setID_RENTA(int ID_RENTA) {
        this.ID_RENTA = ID_RENTA;
    }

    public String getSERIE() {
        return SERIE;
    }

    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public int getID_TIPO_PAGO() {
        return ID_TIPO_PAGO;
    }

    public void setID_TIPO_PAGO(int ID_TIPO_PAGO) {
        this.ID_TIPO_PAGO = ID_TIPO_PAGO;
    }

    public String getFECHA_PRESTAMO() {
        return FECHA_PRESTAMO;
    }

    public void setFECHA_PRESTAMO(String FECHA_PRESTAMO) {
        this.FECHA_PRESTAMO = FECHA_PRESTAMO;
    }

    public String getFECHA_DEVOLUCION() {
        return FECHA_DEVOLUCION;
    }

    public void setFECHA_DEVOLUCION(String FECHA_DEVOLUCION) {
        this.FECHA_DEVOLUCION = FECHA_DEVOLUCION;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
            
}
