package com.vivek.myrestapifinal.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class EmployeeController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }
}
