package com.example.demo;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import static com.example.demo.DatabaseConnection.*;
@Service
public class StudentService {

    public Student selectStudents() throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        ResultSet rs = selectAll("student");
        Student s = new Student();

        if(rs.next()){
            s.setFirstname(rs.getString(1));
            s.setName(rs.getString(2));
            s.setLogin(rs.getString(3));
            s.setPassword(rs.getString(4));
        }
        return s;
    }
    public void deleteStudent(String _table, Integer _id) throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        deleteById(_table, _id);
    }

    public void addStudent(String _firstname, String _lastname, String _login, String _password) throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

    addStudentToDb(_firstname, _lastname, _login, _password);
    }


}
