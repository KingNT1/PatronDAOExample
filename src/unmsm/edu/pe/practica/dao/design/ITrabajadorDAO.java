/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.design;

import java.util.ArrayList;
import unmsm.edu.pe.practica.dao.objects.Trabajador;

/**
 *
 * @author Usuario
 */
public interface ITrabajadorDAO {
    
    public abstract ArrayList<Trabajador> getListaTrabajadores();
    public abstract Trabajador getTrabajador(int idTrabajador);
    
}
