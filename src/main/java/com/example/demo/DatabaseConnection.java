package com.example.demo;

import java.sql.*;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost/ecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
        return conn;
    }
    public static ResultSet selectAll(String s) throws SQLException {
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();

        String sql = "SELECT * FROM `" + s + "`";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public static void deleteById(String _s, Integer _id) throws SQLException {
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();

        String sql = "DELETE From `" + _s  + "` Where `id_" + _s + "` = ?";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, _id);
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*public static void insert(String _s) throws SQLException {
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO `" + _s  + "`(`id_teacher`, `firstname`, `lastname`, `login`, `password`) VALUES (null, ?, ?,?,?)";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, _id);
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public static void addTeacherToDB(String _firstname, String _lastname, String _login, String _password) throws SQLException {
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO `teacher`(`id_teacher`, `firstname`, `lastname`, `login`, `password`) VALUES (null, ?, ?,?,?) ";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, _firstname);
            preparedStmt.setString (2, _lastname);
            preparedStmt.setString (3, _login);
            preparedStmt.setString (4, _password);
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addStudentToDb(String _firstname, String _lastname, String _login, String _password) throws SQLException {
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO `student`(`id_student`, `firstname`, `lastname`, `login`, `password`) VALUES (null, ?, ?,?,?) ";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, _firstname);
            preparedStmt.setString (2, _lastname);
            preparedStmt.setString (3, _login);
            preparedStmt.setString (4, _password);
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}