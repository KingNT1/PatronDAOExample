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
public class Empresa {
    
    private int idEmpresa;
    private String nombre;
    private String presidente;
    private String tipoFilial;
    private int pagoPorHora;
    
    public Empresa(){
        
    }
    
    public Empresa(int idEmpresa, String nombre, String presidente, String tipoFilial, int pagoPorHora) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.presidente = presidente;
        this.tipoFilial = tipoFilial;
        this.pagoPorHora = pagoPorHora;
    }
    
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getTipoFilial() {
        return tipoFilial;
    }

    public void setTipoFilial(String tipoFilial) {
        this.tipoFilial = tipoFilial;
    }

    public int getPagoPorHora() {
        return pagoPorHora;
    }

    public void setPagoPorHora(int pagoPorHora) {
        this.pagoPorHora = pagoPorHora;
    }
    
    
    
}
