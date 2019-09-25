package unmsm.edu.pe.practica.dao;


import unmsm.edu.pe.practica.dao.component.EmpresaDAO;
import unmsm.edu.pe.practica.dao.component.ReporteDAO;
import unmsm.edu.pe.practica.dao.component.TrabajadorDAO;
import unmsm.edu.pe.practica.dao.design.IEmpresaDAO;
import unmsm.edu.pe.practica.dao.design.IReporteDAO;
import unmsm.edu.pe.practica.dao.design.ITrabajadorDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class DAOFactory {

    private static DAOFactory daoFac;

    static {
        daoFac = new DAOFactory();
    }

    public static DAOFactory getInstance() {
        return daoFac;
    }
    
    public ITrabajadorDAO getTrabajadorDAO(){
        return new TrabajadorDAO();
    }
    
    public IEmpresaDAO getEmpresaDAO(){
        return new EmpresaDAO();
    }
    
    public IReporteDAO getReporteDAO(){
        return new ReporteDAO();
    }

}
