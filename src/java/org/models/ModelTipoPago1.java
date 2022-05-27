
package org.models;


public class ModelTipoPago1 {
    int ID_TIPO_PAGO;
    String DESCRIPCION;

    public ModelTipoPago1() {
    }

    public ModelTipoPago1(int ID_TIPO_PAGO, String DESCRIPCION) {
        this.ID_TIPO_PAGO = ID_TIPO_PAGO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getID_TIPO_PAGO() {
        return ID_TIPO_PAGO;
    }

    public void setID_TIPO_PAGO(int ID_TIPO_PAGO) {
        this.ID_TIPO_PAGO = ID_TIPO_PAGO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }
    
    
}
