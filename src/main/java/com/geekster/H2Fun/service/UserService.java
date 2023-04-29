package com.geekster.H2Fun.service;

import com.geekster.H2Fun.Repository.IUserRepo;
import com.geekster.H2Fun.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo ur;
    public Iterable<Users> getusers() {
        Iterable<Users> allusers=ur.findAll();
        return allusers;
    }


    public String addusers(List<Users> userList) {
        Iterable<Users> addedusers=ur.saveAll(userList);
        if(addedusers!=null){
            return "Yes";
        }else{
            return "NO";
        }
    }

    public void deleteuser(Integer id) {
        ur.deleteById(id);
    }

    public List<Users> getuserbyname(String name) {
        return ur.findByName(name);
    }

    public List<Users> getuserbyage(String age) {
        Integer userage=Integer.parseInt(age);
        return ur.findByAgeGreaterThan(userage);
    }
    public List<Users> getuserbynameage(String name,String age){
        Integer userage=Integer.parseInt(age);
        return ur.findByNameOrAgeGreaterThan(name,userage);
    }
    public List<Users> sortasc(){
        return ur.findUserOrderByAgeASC();
    }

    public List<Users> queryuser(String age) {
        Integer userage=Integer.parseInt(age);
        return ur.findUserOrderByAgeASCWithWhereever(userage);
    }
}
