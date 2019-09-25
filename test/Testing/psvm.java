/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import unmsm.edu.pe.practica.dao.objects.Empresa;
import unmsm.edu.pe.practica.dao.objects.Trabajador;

/**
 *
 * @author Usuario
 */
public class psvm {
    public static void main(String[] args) {
        
        Empresa lol = new Empresa(1, "GoD", "popo", "Fabricacion", 20);
        
        Trabajador t = new Trabajador(1, "Christian", "72468245", 10, 1);
        
        System.out.println(lol.getTipoFilial());
        System.out.println(t.getSueldoT(lol));
        System.out.println(t.getSueldoEx(lol));
        
        
    }
}
