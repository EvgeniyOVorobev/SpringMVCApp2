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
        people.add(new Person(++PEOPLE_COUNT,"Tom",24,"Tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Tommy",45,"Tomy@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Dommy",18,"Dommy@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Kimmy",58,"Kimmy@mail.ru"));
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

    public void update(int id, Person person) {
        Person personToBeUpdated=show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p->p.getId()==id);
    }
}
