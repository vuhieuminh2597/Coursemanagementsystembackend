package com.example.coursems.builder.customer;

import com.example.coursems.entity.Course;
import com.example.coursems.entity.Customer;
import com.example.coursems.entity.RegistrationRecord;

import java.util.Set;

public class CustomerBuilder {
    private Customer customer = new Customer();

    public CustomerBuilder setId (String id){
        this.customer.setId(id);
        return this;
    }

    public CustomerBuilder setName (String name){
        this.customer.setName(name);
        return this;
    }

    public CustomerBuilder setBirthDay (String birthDay){
        this.customer.setBirthDay(birthDay);
        return this;
    }

    public CustomerBuilder setAddress (String address){
        this.customer.setAddress(address);
        return this;
    }

    public CustomerBuilder setEmail (String email){
        this.customer.setEmail(email);
        return this;
    }

    public CustomerBuilder setPhone (String phone){
        this.customer.setPhone(phone);
        return this;
    }

    public CustomerBuilder setGender (String gender){
        this.customer.setGender(gender);
        return this;
    }

    public CustomerBuilder setCustomerRecord (Set<RegistrationRecord> customerRecord){
        this.customer.setCustomerRecord(customerRecord);
        return this;
    }

    public CustomerBuilder customerBuilder (boolean isDelete){
        this.customer.setDelete(isDelete);
        return this;
    }

//    public CustomerBuilder setCourse (Set<Course> courses){
//        this.customer.setCourses(courses);
//        return this;
//    }

    public Customer build (){
        return this.customer;
    }
}
