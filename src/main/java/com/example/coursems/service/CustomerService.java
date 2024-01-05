package com.example.coursems.service;

import com.example.coursems.model.customer.CustomerCreateDTO;
import com.example.coursems.model.customer.CustomerDTO;
import com.example.coursems.model.customer.CustomerPage;
import com.example.coursems.model.customer.CustomerPartialDTO;


public interface CustomerService {
    CustomerPage getAllCustomerService(Integer page, Integer size);
    CustomerDTO findByIdCustomer (String id);
    CustomerDTO createNewCustomer (CustomerCreateDTO customerDTO);
    CustomerDTO updateCustomer (CustomerDTO customerDTO);
    void deleteCustomer (String id);
    CustomerDTO updatePartial(CustomerPartialDTO customerPartialDTO);
    CustomerDTO registrationCourse(String idCustomer, String idCourse);
}
