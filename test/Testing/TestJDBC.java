/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.util.ArrayList;
import unmsm.edu.pe.practica.dao.DAOFactory;
import unmsm.edu.pe.practica.dao.design.IEmpresaDAO;
import unmsm.edu.pe.practica.dao.design.IReporteDAO;
import unmsm.edu.pe.practica.dao.design.ITrabajadorDAO;
import unmsm.edu.pe.practica.dao.ds.DBAccess;
import unmsm.edu.pe.practica.dao.objects.Empresa;
import unmsm.edu.pe.practica.dao.objects.ReporteTrabajador;
import unmsm.edu.pe.practica.dao.objects.Trabajador;

/**
 *
 * @author Usuario
 */
public class TestJDBC {

    public static void main(String[] args) {

        DBAccess db = new DBAccess();
        db.getConnection();

        ITrabajadorDAO trabajadorDAO = DAOFactory.getInstance().getTrabajadorDAO();
        ArrayList<Trabajador> lista = trabajadorDAO.getListaTrabajadores();

        for (Trabajador t : lista) {
            System.out.println(t.getNombre() + " " + t.getDni() + "!!!");
        }

        Trabajador aux = trabajadorDAO.getTrabajador(2);

        System.out.println(aux.getNombre() + " " + aux.getDni() + " - Buscado solo ");

        IReporteDAO reporte = DAOFactory.getInstance().getReporteDAO();
        /*boolean resultado = reporte.createReporte("71825675");
        //Funcionó, pero lo quite para que ya no inserte oWO
        if(resultado){
            System.out.println("creado.");
        }else{
            System.out.println("No se creo el reporte, tal vez ya exista.");
        }*/

        ReporteTrabajador rt = reporte.getReporte("72468245");
        System.out.println(rt.getE().getNombre() + " - Funciono! ");

        //Lista de reportes
        ArrayList<ReporteTrabajador> listaReporte = reporte.getListaReportes();
        for (ReporteTrabajador rep : listaReporte) {
            System.out.println(rep.getSueldoBase() + " " + rep.getT().getNombre());
        }

        IEmpresaDAO empresaDAO = DAOFactory.getInstance().getEmpresaDAO();
        ArrayList<Empresa> listaEmpresas = empresaDAO.getListaEmpresas();

        for (Empresa emp : listaEmpresas) {
            System.out.println(emp.getNombre() + " - " + emp.getPresidente() + " - Funciono!");
        }

        
        ArrayList<Trabajador> listaTrabajadores = trabajadorDAO.getListaTrabajadores();
        
        for (Trabajador trab : listaTrabajadores) {
            System.out.println(trab.getNombre() + " - GOGO!!");
        }

    }

}
