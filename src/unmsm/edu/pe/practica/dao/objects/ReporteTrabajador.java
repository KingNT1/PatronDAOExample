/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.objects;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ReporteTrabajador {
    
    private Empresa e; //Recibe el nombre, tipoFilial
    private Trabajador t; //Recibe solo el id 
    private int sueldoBase;
    private int sueldoExtra;
    
    /* Insertas donde trabajo, sueldoExtra calculado segun tenga horas extra en la mismaEmpresa, mes y anio, se calcula
    directo en el DAO
    */
    
    public ReporteTrabajador(){
        
    }

    public Empresa getE() {
        return e;
    }

    public void setE(Empresa e) {
        this.e = e;
    }

    public Trabajador getT() {
        return t;
    }

    public void setT(Trabajador t) {
        this.t = t;
    }
    
    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getSueldoExtra() {
        return sueldoExtra;
    }

    public void setSueldoExtra(int sueldoExtra) {
        this.sueldoExtra = sueldoExtra;
    }
 
}
