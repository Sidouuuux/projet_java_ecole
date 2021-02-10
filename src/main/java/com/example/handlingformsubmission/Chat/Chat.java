package com.example.handlingformsubmission.Chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Chat {

    private Integer id;
    private String content;

    public Chat(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Chat(String content) {
        this.content = content;
    }

    public Chat(){
        this.id = new Integer(null);
        this.content = new String();
    }

    public void addChat(Connection co, Statement stmt){
        String query = "INSERT INTO `Chat`(`id_chat`, `content`) VALUES (?) ";

        try {
            PreparedStatement preparedStmt = co.prepareStatement(query);
            preparedStmt.setString(1, this.getContent());
            preparedStmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
