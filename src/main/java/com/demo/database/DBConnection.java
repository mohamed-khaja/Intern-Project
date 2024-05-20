package com.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public static Connection Connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:*portnumber*/*db_name*", "*username*", "*password*");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
