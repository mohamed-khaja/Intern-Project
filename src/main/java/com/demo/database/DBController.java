package com.demo.database;

import com.demo.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.*;

public class DBController {
    Logger log = LogManager.getLogger(DBController.class);
    
    Connection con = DBConnection.Connect();
    Statement st;
    PreparedStatement ps;
    ResultSet rs;

    public void dbAdd(Model model) {
        try {
            ps = con.prepareStatement("insert into catalogue VALUES (?,?,?);");
            ps.setInt(1, model.getId());
            ps.setString(2, model.getName());
            ps.setFloat(3, model.getPrice());
            ps.executeUpdate();
            log.debug("New Phone added!");
        } catch (SQLException e) {
            log.error(e.getSQLState());
            e.printStackTrace();
        }
    }
    
    public void dbView() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM catalogue;");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Price: " + rs.getFloat(3));
            }
        } catch (SQLException e) {
            log.error(e.getSQLState());
            e.printStackTrace();
        }
    }
    
    public void dbUpdate(Model model) {
        try {
            ps = con.prepareStatement("UPDATE catalogue SET price=? WHERE id=?;");
            ps.setFloat(1, model.getPrice());
            ps.setInt(2, model.getId());
            ps.executeUpdate();
            log.info("Price Updated!");
        } catch (SQLException e) {
            log.error(e.getSQLState());
            e.printStackTrace();
        }
    }
    
    public void dbRemove(Model model) {
        try {
            ps = con.prepareStatement("DELETE FROM catalogue WHERE id=?;");
            ps.setInt(1, model.getId());
            ps.executeUpdate();
            log.warn("Item Removed!");
        } catch (SQLException e) {
            log.error(e.getSQLState());
            e.printStackTrace();
        }
    }
}
