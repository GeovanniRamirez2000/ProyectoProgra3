/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModuleModel;

/**
 *
 * @author MSarazua
 */
public interface CrudModule {
    public List listarMenu();
    public List listarSubMenu();
    public boolean insertar(ModuleModel module);
}
