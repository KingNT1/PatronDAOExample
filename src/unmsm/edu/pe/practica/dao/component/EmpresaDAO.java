/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.component;

import unmsm.edu.pe.practica.dao.design.IEmpresaDAO;
import unmsm.edu.pe.practica.dao.ds.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import unmsm.edu.pe.practica.dao.objects.Empresa;


/**
 *
 * @author Usuario
 */
public class EmpresaDAO implements IEmpresaDAO {

    private DBAccess db;
    
    public EmpresaDAO(){
        db = new DBAccess();
    }
    
    @Override
    public ArrayList<Empresa> getListaEmpresas() {
        
        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
        Empresa ep = null;
        
        
        Connection cn = db.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT IDEMPRESA, NOMEMPRESA, PRESIDENTE, TIPOFILIAL, PAGOPORHORA "
                    + "FROM EMPRESA");
            ResultSet resultSet = ps.executeQuery();

            
            while (resultSet.next()) {
                
                ep = new Empresa(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                resultSet.getInt(5));
                
                listaEmpresas.add(ep); 
                
            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return listaEmpresas;
        
        
    }
    
    
    
}
