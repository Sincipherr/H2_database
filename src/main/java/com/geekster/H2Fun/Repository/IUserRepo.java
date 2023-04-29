package com.geekster.H2Fun.Repository;

import com.geekster.H2Fun.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends CrudRepository<Users,Integer> {

    List<Users> findByName(String name);
    //findbyname will not work it has to be camel casing
//    I need to give the method name meaning full
//    and with camel casing and the method should contain
//    data member that we are using in the method for example
//    Name is used in User class so I need to use
//    Name in the method name

    //get above certain age
    public List<Users> findByAgeGreaterThan(Integer age);

    public List<Users> findByNameOrAgeGreaterThan(String name,Integer age);
    @Query(value = "select * from Users order by user_age asc",nativeQuery = true)
    public List<Users> findUserOrderByAgeASC();
//query statement
    @Query(value = "select * from Users where  user_age= :age",nativeQuery = true)
    public List<Users> findUserOrderByAgeASCWithWhereever(Integer age);

    //if we are using @Query we can keep method name anything
}
