package com.ev.springMVC.Models;

import jakarta.persistence.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min=2,max = 30,message = "Name should be between 2 an 30 character")
    @Column
    private String name;
    @Column
    @Min(value = 0,message = "Age should be grater than 0")
    private int age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    @Email
    @Column
    private String email;

    public Person( String name, int age,String email ) {
        this.name = name;
        this.age = age;
        this.email=email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public Person() {
    }
}
