/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelUser;

/**
 *
 * @author GEOVARU
 */
public interface CrudUser {

    public List listar();

    public ModelUser list(int id);

    public boolean insertar(ModelUser usuario);

    public boolean modificar(ModelUser usuario);

    public boolean eliminar(ModelUser usuario);
}
