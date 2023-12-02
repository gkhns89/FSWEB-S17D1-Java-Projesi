package com.s171.spring1start.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Value("${instructor.name}")
    private String name;

    @Value("${instructor.surname}")
    private String surname;

    @Value("${program.version}")
    private String version;

    @Value("1989")
    private int birthYear;

    @GetMapping("/test")
    public String test (){

        name = "Mahmut";

        return "Hi! "+ name+" "+surname + ". Doğum Yılı: "+ birthYear + " Version: "+version;

    }


}
