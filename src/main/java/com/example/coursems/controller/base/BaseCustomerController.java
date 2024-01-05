package com.example.coursems.controller.base;

import com.example.coursems.model.customer.CustomerCreateDTO;
import com.example.coursems.model.customer.CustomerDTO;
import com.example.coursems.model.customer.CustomerPage;
import com.example.coursems.model.customer.CustomerPartialDTO;
import org.springframework.http.ResponseEntity;

public interface BaseCustomerController{
    ResponseEntity<CustomerPage> getPage(Integer page,Integer size);
    ResponseEntity<CustomerDTO> getById (String id);
    ResponseEntity<CustomerDTO> create (CustomerCreateDTO newObject);
    ResponseEntity<CustomerDTO> update (CustomerDTO object);
    void delete (String id);
    ResponseEntity<CustomerDTO> updatePartial (CustomerPartialDTO object);
    ResponseEntity<CustomerDTO> regisCourse (String idCustomer,String idCourse);
}
