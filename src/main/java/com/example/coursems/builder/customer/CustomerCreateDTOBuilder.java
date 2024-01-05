package com.example.coursems.builder.customer;

import com.example.coursems.model.customer.CustomerCreateDTO;

public class CustomerCreateDTOBuilder {
    private CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO();

    public CustomerCreateDTOBuilder setId (String id){
        this.customerCreateDTO.setId(id);
        return this;
    }

    public CustomerCreateDTOBuilder setName (String name){
        this.customerCreateDTO.setName(name);
        return this;
    }

    public CustomerCreateDTOBuilder setBirthDay (String birthDay){
        this.customerCreateDTO.setBirthDay(birthDay);
        return this;
    }

    public CustomerCreateDTOBuilder setAddress (String address){
        this.customerCreateDTO.setAddress(address);
        return this;
    }

    public CustomerCreateDTOBuilder setEmail (String email){
        this.customerCreateDTO.setEmail(email);
        return this;
    }

    public CustomerCreateDTOBuilder setPhone (String phone){
        this.customerCreateDTO.setPhone(phone);
        return this;
    }

    public CustomerCreateDTOBuilder setGender (String gender){
        this.customerCreateDTO.setGender(gender);
        return this;
    }

//    public CustomerCreateDTOBuilder setcustomerCreateDTORecord (Set<RegistrationRecord> customerCreateDTORecord){
//        this.customerCreateDTO.setcustomerCreateDTORecord(customerCreateDTORecord);
//        return this;
//    }
//
//    public CustomerCreateDTOBuilder setCourse (Set<Course> courses){
//        this.customerCreateDTO.setCourses(courses);
//        return this;
//    }

    public CustomerCreateDTO build (){
        return this.customerCreateDTO;
    }
}
