package org.example.app.model;


import org.example.dao.ORM.ModelMapper;

public class User extends ModelMapper<User> {

    private int id;
    private String name;
    private int age;
    private double salary;
    private boolean isMarried;


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
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean isMarried() {
        return isMarried;
    }
    public void setMarried(boolean married) {
        isMarried = married;
    }





    public User(String name, int age, double salary, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;

    }

    public  User(){

    }

    @Override
    public User createInstance() {
        return new User();
    }


}

