package com.ev.springMVC.dao;

import com.ev.springMVC.Models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Person p", Person.class).getResultList();

    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session=sessionFactory.getCurrentSession();
        Person person=session.get(Person.class,id);
        return person;
    }
    @Transactional
    public void save(Person person) {
    Session session= sessionFactory.getCurrentSession();
    session.save(person);
    }
    @Transactional
    public void update(int id, Person person) {
        Session session=sessionFactory.getCurrentSession();
        Person person1=session.get(Person.class,id);
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        person1.setEmail(person.getEmail());

    }
    @Transactional
    public void delete(int id) {
    Session session=sessionFactory.getCurrentSession();
    session.remove(session.get(Person.class,id));
    }
}
