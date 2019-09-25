/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.component;

import unmsm.edu.pe.practica.dao.design.IReporteDAO;
import unmsm.edu.pe.practica.dao.ds.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import unmsm.edu.pe.practica.dao.objects.Empresa;
import unmsm.edu.pe.practica.dao.objects.ReporteTrabajador;
import unmsm.edu.pe.practica.dao.objects.Trabajador;

/**
 *
 * @author Usuario
 */
public class ReporteDAO implements IReporteDAO {

    private DBAccess db;

    public ReporteDAO() {
        db = new DBAccess();
    }

    @Override
    public boolean createReporte(String dni) {

        boolean resultado = true;
        ReporteTrabajador r = getDataReporte(dni);

        //Para verificar si ya existe reporte
        boolean existeReporte = existeReporte(r.getT().getIdTrabajador());

        Connection cn = db.getConnection();
        try {
            if (existeReporte) {
                resultado = false;
                return resultado;
            } else {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO REPORTE "
                        + "(SUELDOBASE, SUELDOEXTRA, IDTRABAJADOR, NOMBREEMPRESA, TIPOFILIAL) VALUES (?,?,?,?,?)");
                ps.setInt(1, r.getSueldoBase());
                ps.setInt(2, r.getSueldoExtra());
                ps.setInt(3, r.getT().getIdTrabajador());
                ps.setString(4, r.getE().getNombre());
                ps.setString(5, r.getE().getTipoFilial());

                ps.execute();
            }
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
            resultado = false;
        }
        return resultado;

    }

    @Override
    public ReporteTrabajador getDataReporte(String dni) { //Generar reporte según DNI ! (LO CREA SI NO EXISTE)!
        ReporteTrabajador r = null;

        Connection cn = db.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT idTrabajador, nombre, dni, horasTrabajadas, horasExtra, "
                    + "idEmpresa, nomempresa, tipoFilial, pagoPorHora "
                    + "FROM empresa e JOIN empresa_has_trabajador eh "
                    + "ON e.idEmpresa = eh.Empresa_idEmpresa JOIN trabajador t "
                    + "ON eh.Trabajador_idTrabajador = t.idTrabajador WHERE DNI = ?");
            ps.setString(1, dni);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                //Defino trabajador
                Trabajador t = new Trabajador(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getInt(5));

                //Defino empresa
                Empresa e = new Empresa();
                e.setIdEmpresa(resultSet.getInt(6)); //idEmpresa
                e.setNombre(resultSet.getString(7)); //nomEmpresa
                e.setTipoFilial(resultSet.getString(8)); //TipoFilial
                e.setPagoPorHora(resultSet.getInt(9)); //PagoPorHora

                //Calculo el sueldo
                int sueldoBase = t.getSueldoT(e);
                int sueldoExtra = t.getSueldoEx(e);

                // Definiendo reporte!
                r = new ReporteTrabajador();
                r.setE(e);
                r.setT(t);
                r.setSueldoBase(sueldoBase);
                r.setSueldoExtra(sueldoExtra);

            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return r;
    }

    @Override
    public boolean existeReporte(int idTrabajador) {

        boolean existe = true;
        Connection cn = db.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM REPORTE WHERE IDTRABAJADOR = ?");
            ps.setInt(1, idTrabajador);
            ResultSet resultSet = ps.executeQuery(); //resultSet.next() recorre las filas de la tabla

            if (resultSet.next() == false) { //Si apenas ejecutado el sql, no hay fila que recorrer, existe es false.
                existe = false;
                return existe;
            } else {

                while (resultSet.next()) {
                    /* Nada, solo verifica que exista. */
                }

            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
            existe = false;
        }
        return existe;
    }

    @Override
    public ReporteTrabajador getReporte(String dni) {
        ReporteTrabajador r = null;

        Connection cn = db.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre, dni, nombreEmpresa, tipoFilial, sueldoBase, sueldoExtra FROM reporte r JOIN trabajador t \n"
                    + "ON r.idTrabajador = t.idTrabajador WHERE DNI = ?");
            ps.setString(1, dni);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                /* Guardas datos de Empresa y Trabajador (Los qué necesitas) */
                //Datos Empresa
                Empresa e = new Empresa();
                e.setNombre(resultSet.getString(3));
                e.setTipoFilial(resultSet.getString(4));

                //Datos Trabajador
                Trabajador t = new Trabajador();
                t.setNombre(resultSet.getString(1));
                t.setDni(resultSet.getString(2));

                //Definimos el reporte
                r = new ReporteTrabajador();
                r.setE(e); //Set Empresa
                r.setT(t); //Set Trabajador
                r.setSueldoBase(resultSet.getInt(5));
                r.setSueldoExtra(resultSet.getInt(6));

            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return r;
    }

    @Override
    public ArrayList<ReporteTrabajador> getListaReportes() {
        ReporteTrabajador r = null;
        ArrayList<ReporteTrabajador> listaReportes = new ArrayList<>();
        
        Connection cn = db.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre, dni, nombreEmpresa, tipoFilial, sueldoBase, sueldoExtra FROM reporte r JOIN trabajador t \n"
                    + "ON r.idTrabajador = t.idTrabajador");
           
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                /* Guardas datos de Empresa y Trabajador (Los qué necesitas) */
                //Datos Empresa
                Empresa e = new Empresa();
                e.setNombre(resultSet.getString(3));
                e.setTipoFilial(resultSet.getString(4));

                //Datos Trabajador
                Trabajador t = new Trabajador();
                t.setNombre(resultSet.getString(1));
                t.setDni(resultSet.getString(2));

                //Definimos el reporte
                r = new ReporteTrabajador();
                r.setE(e); //Set Empresa
                r.setT(t); //Set Trabajador
                r.setSueldoBase(resultSet.getInt(5));
                r.setSueldoExtra(resultSet.getInt(6));
                
                listaReportes.add(r); //Añade el reporte a la lista
            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return listaReportes;
    }

}
