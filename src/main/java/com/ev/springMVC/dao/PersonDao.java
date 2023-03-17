package com.ev.springMVC.dao;

import com.ev.springMVC.Models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private List<Person> people;

    {
        people=new ArrayList<>();
        people.add(new Person(1,"Tom"));
        people.add(new Person(2,"Tomy"));
        people.add(new Person(3,"Domy"));
        people.add(new Person(4,"Kimmy"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}
