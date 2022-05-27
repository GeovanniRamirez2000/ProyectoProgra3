/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelTipoPago;

/**
 *
 * @author GEOVARU
 */
public interface CrudTipoPago {

    public List listar();

    public ModelTipoPago list(int id);

    public boolean insertar(ModelTipoPago cliente);

    public boolean modificar(ModelTipoPago cliente);

    public boolean eliminar(ModelTipoPago cliente);
}
