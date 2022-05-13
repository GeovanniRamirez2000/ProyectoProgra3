/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelRoll;

/**
 *
 * @author INSPIRON 7000 SERIES
 */
public interface CrudRoll {
    public List listar();

    public ModelRoll list(int id);

    public boolean insertar(ModelRoll roll);
     public boolean modificar(ModelRoll roll);
     public boolean eliminar(ModelRoll roll);
}
