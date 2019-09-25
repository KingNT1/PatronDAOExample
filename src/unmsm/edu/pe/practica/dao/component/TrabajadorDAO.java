/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.component;

import unmsm.edu.pe.practica.dao.design.ITrabajadorDAO;
import unmsm.edu.pe.practica.dao.ds.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import unmsm.edu.pe.practica.dao.objects.Trabajador;

/**
 *
 * @author Usuario
 */
public class TrabajadorDAO implements ITrabajadorDAO {
    
    private DBAccess db;
    
    public TrabajadorDAO(){
        db = new DBAccess();
    }
    
    @Override
    public ArrayList<Trabajador> getListaTrabajadores() {
        
        ArrayList<Trabajador> list = new ArrayList<Trabajador>();
        Trabajador t = null;

        Connection cn = db.getConnection();

        Statement statement = null;
        try {
            statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT IDTRABAJADOR, NOMBRE, DNI FROM TRABAJADOR;");

            while (resultSet.next()) {
                
                t = new Trabajador();
                t.setIdTrabajador(resultSet.getInt(1)); 
                t.setNombre(resultSet.getString(2));
                t.setDni(resultSet.getString(3));
                
                list.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return list;
        
    }

    @Override
    public Trabajador getTrabajador(int idTrabajador) {
        
        Trabajador t = null;

        Connection cn = db.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT IDTRABAJADOR, NOMBRE, DNI, HORASTRABAJADAS, HORASEXTRA "
                    + "FROM TRABAJADOR WHERE IDTRABAJADOR = ?");
            ps.setInt(1, idTrabajador);
            ResultSet resultSet = ps.executeQuery();

            
            while (resultSet.next()) {

                 t = new Trabajador(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getInt(4), resultSet.getInt(5));
                
            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return t;
    }
    
}
