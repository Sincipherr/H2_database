package com.geekster.H2Fun.controller;

import com.geekster.H2Fun.model.Users;
import com.geekster.H2Fun.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @GetMapping(value = "/users")
    public Iterable<Users> getusers(){
        return us.getusers();
    }

    @GetMapping(value = "/home")
    public String home(){
        System.out.println("Hello world");
        return "Hello world";
    }

    @GetMapping(value = "/users/{name}")
    public List<Users> getuserbyname(@PathVariable String name){
        return us.getuserbyname(name);
    }

    @GetMapping(value = "/userage/{age}")
    public List<Users> getuserbyage(@PathVariable String age){
        return us.getuserbyage(age);
    }

    @GetMapping(value = "/usernameage/{name}/{age}")
    public List<Users> getuserbynameage(@PathVariable String name,@PathVariable String age){
        return us.getuserbynameage(name,age);
    }
    @GetMapping(value = "/usersort")
    public List<Users> sortuser(){
        return us.sortasc();
    }

    @GetMapping(value = "/userquery/{age}")
    public List<Users> query(@PathVariable String age){
        return us.queryuser(age);
    }

    @PostMapping(value = "/addusers")
    public String adduser(@RequestBody List<Users> userList){
        return us.addusers(userList);
    }


    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        us.deleteuser(id);
    }
}
