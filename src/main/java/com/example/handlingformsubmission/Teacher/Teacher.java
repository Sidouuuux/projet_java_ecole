package com.example.handlingformsubmission.Teacher;

import com.example.handlingformsubmission.Person;

import java.sql.*;

public class Teacher extends Person {

    public Teacher(Integer id, String name, String firstname, String login, String password){
        super(id, name, firstname, login, password);
    }

    public Teacher(String name, String firstname, String login, String password){
        super(name, firstname, login, password);
    }

    public Teacher(){
        super();
    }

    public ResultSet selectAllTeachers(Connection co, Statement stmt){
        String query = "SELECT * FROM `teacher`";

        try {
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addTeacher(Connection co, Statement stmt){
        String query = "INSERT INTO `teacher`(`id_teacher`, `firstname`, `lastname`, `login`, `password`) VALUES (null, ?, ?,?,?) ";

        try {
            PreparedStatement preparedStmt = co.prepareStatement(query);
            preparedStmt.setString(1, this.getFirstname());
            preparedStmt.setString(2, this.getName());
            preparedStmt.setString(3, this.getLogin());
            preparedStmt.setString(4, this.getPassword());
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet getTeacher(Connection co, Statement stmt) throws SQLException {

        String query = "SELECT * FROM `teacher` WHERE login = '" + this.getLogin() + "' AND password = '" + this.getPassword() + "'";
//        PreparedStatement preparedStmt = co.prepareStatement(query);
//        preparedStmt.setString(1, this.getLogin());
//        preparedStmt.setString(2, this.getPassword());
        stmt.executeQuery(query);

        ResultSet rs = stmt.executeQuery(query);
        return rs;

    }
    public void updateTeacher(Connection co, Statement stmt){
        String query = "UPDATE teacher SET firstname = ?, lastname = ?, login = ?, password = ? WHERE id_teacher = ?";
        System.out.print(this.getId());
    }

    public void deleteTeacherById(Connection co, Statement stmt, Integer _id){
        String query = "DELETE From `teacher` Where `id_teacher` = ?";

        try {
            PreparedStatement preparedStmt = co.prepareStatement(query);
            preparedStmt.setInt(1, _id);
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
