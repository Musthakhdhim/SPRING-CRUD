//package com.crudoperation.Crud.profilemanager;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//@Component
//@Profile("dev")
//public class DataSecond {
//    @Value("${usernames}")
//    String user_name;
//    @Value("${password}")
//    String password;
//
//    @PostConstruct
//    public void Test(){
//        System.out.println("from second-dev");
//        System.out.println("Username: "+user_name+", Password: "+password);
//    }
//}
