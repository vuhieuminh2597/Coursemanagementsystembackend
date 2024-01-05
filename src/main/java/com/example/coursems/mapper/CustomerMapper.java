package com.example.coursems.mapper;

import com.example.coursems.builder.customer.CustomerBuilder;
import com.example.coursems.builder.customer.CustomerCreateDTOBuilder;
import com.example.coursems.builder.customer.CustomerDTOBuilder;
import com.example.coursems.builder.customer.CustomerUpdateParBuilder;
import com.example.coursems.entity.Customer;
import com.example.coursems.model.customer.CustomerCreateDTO;
import com.example.coursems.model.customer.CustomerDTO;
import com.example.coursems.model.customer.CustomerPartialDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    /**
     * @param customer input
     * @return CustomerDTO
     */
    public CustomerDTO customerMapToCustomerDTO(Customer customer) {
        return new CustomerDTOBuilder()
                .setId(customer.getId())
                .setName(customer.getName())
                .setAddress(customer.getAddress())
                .setBirthDay(customer.getBirthDay())
                .setEmail(customer.getEmail())
                .setGender(customer.getGender())
                .setPhone(customer.getPhone())
                .build();
    }

    public Customer customerDTOMapToCustomer(CustomerDTO customerDTO) {
        return new CustomerBuilder()
                .setId(customerDTO.getId())
                .setName(customerDTO.getName())
                .setAddress(customerDTO.getAddress())
                .setBirthDay(customerDTO.getBirthDay())
                .setGender(customerDTO.getGender())
                .setPhone(customerDTO.getPhone())
                .setEmail(customerDTO.getEmail())
                .build();
    }

    public CustomerCreateDTO customerMapToCustomerCreateDTO(Customer customer) {
        return new CustomerCreateDTOBuilder()
                .setId(customer.getId())
                .setName(customer.getName())
                .setAddress(customer.getAddress())
                .setBirthDay(customer.getBirthDay())
                .setEmail(customer.getEmail())
                .setGender(customer.getGender())
                .setPhone(customer.getPhone())
                .build();
    }

    public Customer customerCreateDTOMapToCustomer(CustomerCreateDTO customerCreateDTO) {
        return new CustomerBuilder()
                .setId(customerCreateDTO.getId())
                .setName(customerCreateDTO.getName())
                .setAddress(customerCreateDTO.getAddress())
                .setBirthDay(customerCreateDTO.getBirthDay())
                .setGender(customerCreateDTO.getGender())
                .setPhone(customerCreateDTO.getPhone())
                .setEmail(customerCreateDTO.getEmail())
                .build();
    }

    public Customer updateCustomerFromCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setGender(customerDTO.getGender());
        customer.setPhone(customerDTO.getPhone());
        customer.setBirthDay(customerDTO.getBirthDay());
        return customer;
    }

    public Customer updateParCustomerFromCustomerPartialDTO(Customer customer, CustomerPartialDTO customerPartialDTO) {
        return new CustomerUpdateParBuilder(customer)
                .setName(customerPartialDTO.getName())
                .setAddress(customerPartialDTO.getAddress())
                .setEmail(customerPartialDTO.getEmail())
                .setGender(customerPartialDTO.getGender())
                .setPhone(customerPartialDTO.getPhone())
                .setBirthDay(customerPartialDTO.getBirthDay())
                .build();
    }
}
