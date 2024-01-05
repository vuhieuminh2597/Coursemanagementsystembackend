package com.example.coursems.builder.customer;

import com.example.coursems.model.customer.CustomerDTO;

public class CustomerDTOBuilder {
    private CustomerDTO customerDTO = new CustomerDTO();

    public CustomerDTOBuilder setId (String id){
        this.customerDTO.setId(id);
        return this;
    }

    public CustomerDTOBuilder setName (String name){
        this.customerDTO.setName(name);
        return this;
    }

    public CustomerDTOBuilder setBirthDay (String birthDay){
        this.customerDTO.setBirthDay(birthDay);
        return this;
    }

    public CustomerDTOBuilder setAddress (String address){
        this.customerDTO.setAddress(address);
        return this;
    }

    public CustomerDTOBuilder setEmail (String email){
        this.customerDTO.setEmail(email);
        return this;
    }

    public CustomerDTOBuilder setPhone (String phone){
        this.customerDTO.setPhone(phone);
        return this;
    }

    public CustomerDTOBuilder setGender (String gender){
        this.customerDTO.setGender(gender);
        return this;
    }

//    public CustomerDTOBuilder setcustomerDTORecord (Set<RegistrationRecord> customerDTORecord){
//        this.customerDTO.setcustomerDTORecord(customerDTORecord);
//        return this;
//    }
//
//    public CustomerDTOBuilder setCourse (Set<Course> courses){
//        this.customerDTO.setCourses(courses);
//        return this;
//    }

    public CustomerDTO build (){
        return this.customerDTO;
    }
}
