package com.example.handlingformsubmission.Teacher;

import com.example.handlingformsubmission.Chat.Chat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.handlingformsubmission.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class TeacherController {

    //teacherRegister
    @GetMapping("/teacherRegister")
    public String teacherForm(Model model) {
        model.addAttribute("Teacher", new Teacher());
        return "teacherRegister";
    }

    @PostMapping("/teacherRegister")
    public String TeacherSubmit(@ModelAttribute Teacher teacher, Model model) throws SQLException {
        Connection co = DatabaseConnection.getInstance();
        if (co != null) {
            System.out.println("Connection successful !!!");
        }
        Statement stmt = co.createStatement();
        teacher.addTeacher(co,stmt);
        model.addAttribute("Teacher", teacher);
        return "teacherRegisterSuccess";
    }

    //teacherConnexion
    @GetMapping("/teacherLogin")
    public String teacherLoginForm(Model model) {
        model.addAttribute("Teacher", new Teacher());
        return "teacherLogin";
    }

    @PostMapping("/teacherLogin")
    public String teacherLoginSubmit(@ModelAttribute Teacher teacher, Model model) throws SQLException {
        Connection co = DatabaseConnection.getInstance();
        if (co != null) {
            System.out.println("Connection successful !!!");
        }
        Statement stmt = co.createStatement();
        ResultSet connected = teacher.getTeacher(co,stmt);
        if(connected.next()){
            teacher.setFirstname(connected.getString(2));
            teacher.setName(connected.getString(3));
            model.addAttribute("Teacher", teacher);
            return "loggedTeacher";
        }else{
            return "teacherLoginFailed";
        }
    }
}