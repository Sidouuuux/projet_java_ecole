package com.example.demo;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        // ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("src/main/java/com.example.xml/applicationContext.xml");
        try {
            //ApplicationContext appCtx = new ClassPathXmlApplicationContext("src/main/java/com/example/demo/applicationContext.xml");
            Resource r = new ClassPathResource("applicationContext.xml");
            BeanFactory fac = new XmlBeanFactory(r);

            Person person = (Person) fac.getBean("person");
            Parent parent = (Parent) fac.getBean("parent");
            Student student = (Student) fac.getBean("student");
            Teacher teacher = (Teacher) fac.getBean("teacher");

            Chat chat = (Chat) fac.getBean("chat");
            Link link = (Link) fac.getBean("link");

            Document document = (Document) fac.getBean("document");
            //Homework homework = (Homework) fac.getBean("homework");

            /*Connection co = DatabaseConnection.getInstance();
            if (co != null) {
                System.out.println("Connection successful !!!");
            }
            Statement stmt = co.createStatement();

            //Teacher t = new Teacher("5448545lsvkoij","Helder","Heldou77", "Lebgdu77RPZ!!");*/

            SpringApplication.run(Main.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
