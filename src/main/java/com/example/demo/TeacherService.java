package com.example.demo;
import org.springframework.stereotype.Service;

import com.example.demo.Teacher;
import com.example.demo.TeacherService;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.demo.DatabaseConnection.selectAllTeacher;

@Service
public class TeacherService {

    public Teacher selectTeachers() throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        ResultSet rs = selectAllTeacher("teacher");
        Teacher t = new Teacher();

        System.out.print("22222222");
        if(rs.next()){
            t.setFirstname(rs.getString(1));
            t.setName(rs.getString(2));
            t.setLogin(rs.getString(3));
            t.setPassword(rs.getString(4));
        }
        return t;
    }

    public void deleteTeacher(String empId) {

    }
}
