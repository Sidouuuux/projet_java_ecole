package com.example.demo.Student;

import com.example.demo.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Student extends Person {

    public Student(Integer  id, String name, String firstname, String login, String password){
        super(id, name, firstname, login, password);
    }

    public Student(String name, String firstname, String login, String password){
        super(name, firstname, login, password);
    }

    public Student(){
        super();
    }

    public void addStudent(Connection co, Statement stmt){
        String query = "INSERT INTO `student`(`id_student`, `firstname`, `lastname`, `login`, `password`) VALUES (null, ?, ?,?,?) ";

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
    public void updateStudent(Connection co, Statement stmt){
        String query = "UPDATE student SET firstname = ?, lastname = ?, login = ?, password = ? WHERE id_student = ?";
        System.out.print(this.getId());
        try {
            PreparedStatement preparedStmt = co.prepareStatement(query);
            preparedStmt.setString(1, this.getFirstname());
            preparedStmt.setString(2, this.getName());
            preparedStmt.setString(3, this.getLogin());
            preparedStmt.setString(4, this.getPassword());
            preparedStmt.setInt(5, this.getId());
            preparedStmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudentById(Connection co, Statement stmt, Integer _id){
        String query = "DELETE From `student` Where `id_student` = ?";

        try {
            PreparedStatement preparedStmt = co.prepareStatement(query);
            preparedStmt.setInt(1, _id);
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
