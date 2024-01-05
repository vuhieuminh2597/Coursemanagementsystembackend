package com.example.coursems.builder.customer;

import com.example.coursems.entity.Customer;


public class CustomerUpdateParBuilder {
    private Customer customer;

    public CustomerUpdateParBuilder(Customer customer) {
        this.customer = customer;
    }

    public CustomerUpdateParBuilder setId(String id) {
        if (id != null) {
            this.customer.setId(id);
        }
        return this;
    }

    public CustomerUpdateParBuilder setName(String name) {
        if (name != null) {
            this.customer.setName(name);
        }
        return this;
    }

    public CustomerUpdateParBuilder setBirthDay(String birthDay) {
        if(birthDay != null){
            this.customer.setBirthDay(birthDay);
        }
        return this;
    }

    public CustomerUpdateParBuilder setAddress(String address) {
        if(address != null){
            this.customer.setAddress(address);
        }
        return this;
    }

    public CustomerUpdateParBuilder setEmail(String email) {
        if(email != null){
            this.customer.setEmail(email);
        }

        return this;
    }

    public CustomerUpdateParBuilder setPhone(String phone) {
        if(phone != null){
            this.customer.setPhone(phone);
        }
        return this;
    }

    public CustomerUpdateParBuilder setGender(String gender) {
        if (gender != null){
            this.customer.setGender(gender);
        }
        return this;
    }

//    public CustomerUpdateParBuilder setCustomerRecord(Set<RegistrationRecord> customerRecord) {
//        this.customer.setCustomerRecord(customerRecord);
//        return this;
//    }

//    public CustomerUpdateParBuilder setCourse(Set<Course> courses) {
//        this.customer.setCourses(courses);
//        return this;
//    }

    public Customer build() {
        return this.customer;
    }

}
