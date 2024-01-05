package com.example.coursems.controller;

import com.example.coursems.controller.base.BaseCustomerController;
import com.example.coursems.model.customer.CustomerCreateDTO;
import com.example.coursems.model.customer.CustomerDTO;
import com.example.coursems.model.customer.CustomerPage;
import com.example.coursems.model.customer.CustomerPartialDTO;
import com.example.coursems.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin(origins = "http://localhost:8080")//Spring security
public class CustomerController implements BaseCustomerController {
    private CustomerService customerService;

    /**
     * Controller layer
     * Constructor injection
     *
     * @param customerService Dependency injection
     */
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Controller layer
     * Method get list use pagination
     *
     * @param page input
     * @param size input
     * @return ResponseEntity<CustomerPage>
     */
    @GetMapping
    @Override
    public ResponseEntity<CustomerPage> getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        CustomerPage customerPage = customerService.getAllCustomerService(page - 1, size);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * Controller layer
     * Method get by id
     *
     * @param id input from client
     * @return ResponseEntity<CustomerDTO>
     */
    @GetMapping("/getId/{customerId}")
    @Override
    public ResponseEntity<CustomerDTO> getById(@PathVariable("customerId") String id) {
        return ResponseEntity.ok(customerService.findByIdCustomer(id));
    }

    /**
     * Controller layer
     * Method create new a customer
     *
     * @param newCustomer input from client
     * @return ResponseEntity<CustomerDTO>
     */
    @PostMapping("/create")
    @Override
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerCreateDTO newCustomer) {
        return new ResponseEntity<>(customerService.createNewCustomer(newCustomer), HttpStatus.CREATED);
    }

    /**
     * Controller layer
     * Method update a customer
     *
     * @param customerDTO input
     * @return ResponseEntity<CustomerDTO>
     */
    @PutMapping("/update")
    @Override
    public ResponseEntity<CustomerDTO> update(
            @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(customerDTO));
    }

    /**
     * Controller layer
     * Method delete a customer
     *
     * @param id input
     */
    @DeleteMapping("/delete/{customerId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)//Response status code = 204
    @Override
    public void delete(@PathVariable("customerId") String id) {
        customerService.deleteCustomer(id);
    }

    /**
     * Controller layer
     * Method update partial a customer
     *
     * @param customerPartialDTO input
     * @return ResponseEntity<CustomerDTO>
     */
    @PatchMapping("/updatePartial")
    @Override
    public ResponseEntity<CustomerDTO> updatePartial(@RequestBody CustomerPartialDTO customerPartialDTO) {
        return ResponseEntity.ok(customerService.updatePartial(customerPartialDTO));
    }

    /**
     * Controller layer
     * Method register for a course
     *
     * @param idCustomer input
     * @param idCourse   input
     * @return ResponseEntity<CustomerDTO>
     */
    @PutMapping("/{customerId}/course/{courseId}")
    @Override
    public ResponseEntity<CustomerDTO> regisCourse(@PathVariable("customerId") String idCustomer,
                                                   @PathVariable("courseId") String idCourse) {
        return new ResponseEntity<>(customerService.registrationCourse(idCustomer, idCourse), HttpStatus.OK);
    }
}
