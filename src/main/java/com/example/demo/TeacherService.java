package com.example.demo;
import org.springframework.stereotype.Service;

import com.example.demo.Teacher;
import com.example.demo.TeacherService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.demo.DatabaseConnection.*;

@Service
public class TeacherService {

    public Teacher selectTeachers() throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        ResultSet rs = selectAll("teacher");
        Teacher t = new Teacher();

        if(rs.next()){
            t.setFirstname(rs.getString(1));
            t.setName(rs.getString(2));
            t.setLogin(rs.getString(3));
            t.setPassword(rs.getString(4));
        }
        return t;
    }

    public void deleteTeacher(String _table, Integer _id) throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        deleteById(_table, _id);
    }

    public void addTeacher(String _firstname, String _lastname, String _login, String _password) throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        addTeacherToDB(_firstname, _lastname, _login, _password);
    }
}
