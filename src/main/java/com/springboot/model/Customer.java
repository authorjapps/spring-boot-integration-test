package com.springboot.model;

import java.util.Objects;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * Customer class is the representation of a online customer
 */
public class Customer {

    private String id;
    private String name;
    private Integer age;
    private String emailId;

    public Customer() {
    }

    public Customer(String id, String name, Integer age, String emailId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmailId() {
        return emailId;
    }

//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(age, customer.age) &&
                Objects.equals(emailId, customer.emailId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, emailId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
