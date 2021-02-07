package com.example.demo;

import java.sql.*;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost/projet_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String login = "root";
    private String pwd = "";
    private static Connection conn;

    private DatabaseConnection() {
        try{
            java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, pwd);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection getInstance(){
        if(conn == null){
            new DatabaseConnection();
        }
        System.out.print("111111");
        return conn;
    }
    public static ResultSet selectAllTeacher(String s) throws SQLException {
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();

        String sql = "SELECT * FROM `" + s + "`";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    //public Result function
}