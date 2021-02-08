package com.example.demo.Link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/get/link", method = RequestMethod.GET)
    public Link selectAllStudents() throws SQLException {
        return linkService.selectLink();
    }
    @RequestMapping(value = "/remove/link", method = RequestMethod.GET)
    public String removeTeacher(@RequestParam("_table") String _table, @RequestParam("_id") Integer _id) throws SQLException {
        linkService.deleteLink(_table, _id);
        return "Item removed";
    }

    @RequestMapping(value = "/add/link", method = RequestMethod.GET)
    public String removeTeacher(@RequestParam("_text") String _text) throws SQLException {
        linkService.addLink(_text);
        return "Item added";
    }

}
