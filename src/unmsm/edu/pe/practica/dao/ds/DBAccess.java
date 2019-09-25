/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.practica.dao.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DBAccess {

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root", "3242303a");
        } catch (SQLException e) {
        } catch (Exception e) {
        }

        return cn;
    }

    public DBAccess() {

    }
}
