package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Teacher;
import com.example.demo.TeacherService;
//import com.example.demo.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.demo.DatabaseConnection.*;

@RestController
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "//teacher", method = RequestMethod.GET)
    public Teacher selectAllTeachers() throws SQLException {

        System.out.print("3333333");
        return teacherService.selectTeachers();

    }

    @RequestMapping(value = "/remove/teacher", method = RequestMethod.GET)
    public String removeEmployee( @RequestParam("empId") String empId) {

        teacherService.deleteTeacher(empId);

        return "Teacher removed";
    }
}
