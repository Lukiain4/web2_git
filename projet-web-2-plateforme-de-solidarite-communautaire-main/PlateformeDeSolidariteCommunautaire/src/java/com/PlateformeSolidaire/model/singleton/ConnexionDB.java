/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.singleton;

import com.PlateformeSolidaire.model.config.ConfigDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smilongo
 */
public class ConnexionDB {

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName(ConfigDB.DRIVER);
            conn = DriverManager.getConnection(ConfigDB.URL, ConfigDB.USER, ConfigDB.PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    public static void closeConnection() {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
