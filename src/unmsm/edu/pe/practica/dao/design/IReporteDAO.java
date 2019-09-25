/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.design;

import java.util.ArrayList;
import unmsm.edu.pe.practica.dao.objects.ReporteTrabajador;

/**
 *
 * @author Usuario
 */
public interface IReporteDAO {
    
    public abstract boolean createReporte(String dni); //Crear reporte (usa getDataReporte y existeReporte)
    public abstract ReporteTrabajador getDataReporte(String dni); //Sacar datos
    public abstract boolean existeReporte(int idTrabajador); //Verificar si existe reporte
    public abstract ReporteTrabajador getReporte(String dni); //Muestra la data de un reporte
    public abstract ArrayList<ReporteTrabajador> getListaReportes();
    
}
