/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.objects;

/**
 *
 * @author Usuario
 */
public class Trabajador {
    
    private int idTrabajador;
    private String nombre;
    private String dni;
    private int horasTrabajadas;
    private int horasExtra;
    
    public Trabajador(){
        
    }

    public Trabajador(int idTrabajador, String nombre, String dni, int horasTrabajadas, int horasExtra) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.dni = dni;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtra = horasExtra;
    }
    
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    } 
    
    public int getSueldoT(Empresa e){
        return getHorasTrabajadas()*e.getPagoPorHora();
    }
    
    public int getSueldoEx(Empresa e){
        return getHorasExtra()*e.getPagoPorHora();
    }
}
