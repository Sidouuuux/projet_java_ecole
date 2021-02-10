package com.example.handlingformsubmission.Chat;

import com.example.handlingformsubmission.DatabaseConnection;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ChatController {


    //teacherChat
    @GetMapping("/chat")
    public String ChatForm(Model model) {
        model.addAttribute("Chat", new Chat());
        return "chatForm";
    }

    @PostMapping("/chat")
    public String ChatSubmit(@ModelAttribute Chat chat, Model model) throws SQLException {
        Connection co = DatabaseConnection.getInstance();
        if (co != null) {
            System.out.println("Connection successful !!!");
        }
        Statement stmt = co.createStatement();
        chat.addChat(co,stmt);
        model.addAttribute("Chat", chat);
        return "chatSend";
    }
}
