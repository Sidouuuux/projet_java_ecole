package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/get/student", method = RequestMethod.GET)
    public Student selectAllStudents() throws SQLException {
        return studentService.selectStudents();
    }
    @RequestMapping(value = "/remove/student", method = RequestMethod.GET)
    public String removeTeacher(@RequestParam("_table") String _table, @RequestParam("_id") Integer _id) throws SQLException {
        studentService.deleteStudent(_table, _id);
        return "Item removed";
    }

    @RequestMapping(value = "/add/student", method = RequestMethod.GET)
    public String removeTeacher(
            @RequestParam("_firstname") String _firstname,
            @RequestParam("_lastname") String _lastname,
            @RequestParam("_login") String _login,
            @RequestParam("_password") String _password) throws SQLException {
        studentService.addStudent(_firstname, _lastname, _login, _password);
        return "Item added";
    }

}
