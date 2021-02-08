package com.example.demo.Teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class TeacherView {
    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello I am the test, now you have hope understanding how front works **********</div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }
}
