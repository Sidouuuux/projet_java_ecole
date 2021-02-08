package com.example.demo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.DatabaseConnection;

import java.sql.SQLException;

@RestController
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/get/teacher", method = RequestMethod.GET)
    public Teacher selectAllTeachers() throws SQLException {
        return teacherService.selectTeachers();
    }

    @RequestMapping(value = "/remove/teacher", method = RequestMethod.GET)
    public String removeTeacher( @RequestParam("_table") String _table, @RequestParam("_id") Integer _id) throws SQLException {
        teacherService.deleteTeacher(_table, _id);
        return "Item removed";
    }

    @RequestMapping(value = "/add/teacher", method = RequestMethod.GET)
    public String removeTeacher(
            @RequestParam("_firstname") String _firstname,
            @RequestParam("_lastname") String _lastname,
            @RequestParam("_login") String _login,
            @RequestParam("_password") String _password) throws SQLException {
        teacherService.addTeacher(_firstname, _lastname, _login, _password);
        return "Item added";
    }
}
