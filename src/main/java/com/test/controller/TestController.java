package com.test.controller;

import com.test.object.Admin;
import com.test.object.User;
import com.test.object.UserListForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    //todo http://localhost:8080/springmvc/baseType?age=10
    @RequestMapping(value="baseType")
    @ResponseBody
    public String baseType(int age){
        return "age: " + age;
    }

    //todo http://localhost:8080/springmvc/baseType2?age=10
    @RequestMapping(value="baseType2")
    @ResponseBody
    public String baseType2(Integer age){
        return "age: " + age;
    }

    //todo http://localhost:8080/springmvc/array?name=zhou&name=mei&name=duan
    @RequestMapping(value="array")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sb = new StringBuilder();
        for(String item: name){
            sb.append(item).append(" ");
        }
        return sb.toString();
    }

    //todo http://localhost:8080/springmvc/object?name=zhou&age=11
    //todo http://localhost:8080/springmvc/object?name=zhou&age=11&contactInfo.phone=123456
    @RequestMapping(value="object")
    @ResponseBody
    public String object(User user){
        return user.toString();
    }

    //todo http://localhost:8080/springmvc/object2?name=zhou&age=11
    //todo http://localhost:8080/springmvc/object2?user.name=zhou&age=11&contactInfo.phone=123456&admin.name=hareric
    @RequestMapping(value="object2")
    @ResponseBody
    public String object2(User user, Admin admin){
        return user.toString() + "\n" + admin.toString();
    }

    //没成功，报错java.lang.IllegalArgumentException: Invalid character found in the request target.
    @RequestMapping(value="list")
    @ResponseBody
    public String list(UserListForm userListForm){
        return userListForm.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("admin.");
    }



}