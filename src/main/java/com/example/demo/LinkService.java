package com.example.demo;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import static com.example.demo.DatabaseConnection.*;
@Service
public class LinkService {

    public Link selectLink() throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        ResultSet rs = selectAll("student");
        Link l = new Link();

        if(rs.next()){
            l.setText(rs.getString(1));
        }
        return l;
    }
    public void deleteLink(String _table, Integer _id) throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        deleteById(_table, _id);
    }

    public void addLink(String _text) throws SQLException {
        Connection db = DatabaseConnection.getInstance();
        if (db != null) {
            System.out.println("Connection successful !!!");
        }

        addlinkToDb(_text);
    }


}
