package com.ev.springMVC.dao;

import com.ev.springMVC.Models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Tomy"));
        people.add(new Person(++PEOPLE_COUNT,"Domy"));
        people.add(new Person(++PEOPLE_COUNT,"Kimmy"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT) ;
        people.add(person);
    }
}
