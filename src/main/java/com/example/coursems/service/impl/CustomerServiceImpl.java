package com.example.coursems.service.impl;

import com.example.coursems.builder.customer.CustomerPageBuild;
import com.example.coursems.cmd.ConstException;
import com.example.coursems.entity.Course;
import com.example.coursems.entity.Customer;
import com.example.coursems.entity.RegistrationRecord;
import com.example.coursems.exception.*;
import com.example.coursems.mapper.CustomerMapper;
import com.example.coursems.model.customer.CustomerCreateDTO;
import com.example.coursems.model.customer.CustomerDTO;
import com.example.coursems.model.customer.CustomerPage;
import com.example.coursems.model.customer.CustomerPartialDTO;
import com.example.coursems.repository.CourseRepository;
import com.example.coursems.repository.CustomerRepository;
import com.example.coursems.repository.RegisRecordRepository;
import com.example.coursems.service.CustomerService;
import com.example.coursems.utils.LoggerUtil;
import com.example.coursems.utils.TimeUtil;
import com.example.coursems.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    private CourseRepository courseRepository;
    private RegisRecordRepository recordRepository;

    /**
     * Service layer
     * Constructor injection
     *
     * @param customerRepository Dependency injection
     * @param customerMapper     Dependency injection
     */
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper,
                               CourseRepository courseRepository,
                               RegisRecordRepository recordRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.courseRepository = courseRepository;
        this.recordRepository = recordRepository;
    }

    /**
     * Service layer
     * Method get list use customize page
     *
     * @param page input
     * @param size input
     * @return CustomerPage
     */
    @Override
    public CustomerPage getAllCustomerService(Integer page, Integer size) {
        if (page < 0 || size <= 0) {
            throw new InvalidPageParamException(ConstException.INVALID_PAGE_PARAMETER, String.valueOf(page), String.valueOf(size));
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> result = customerRepository.findAllCustomer(pageable);
        return new CustomerPageBuild()
                .setPage(page + 1)
                .setData(result.getContent())
                .setNext(page, size, result.getTotalElements(), result.getTotalPages())
                .setPrevious(page + 1, size, result.getTotalElements())
                .setSize(size)
                .setTotalPages(result.getTotalPages())
                .setTotalElement(result.getTotalElements())
                .build();
    }

    /**
     * Service layer
     * Method find customer by id
     *
     * @param id input
     * @return CustomerDTO
     */
    @Override
    public CustomerDTO findByIdCustomer(String id) {
        UUIDUtil.validateUUID(id);//Check id có đúng định dạng
        //Check customer theo mã id,không tìm thấy throw exception
        Customer customer = customerRepository.findByIdCustomer(id).orElseThrow(() ->
                new NotFoundException(ConstException.CUSTOMER_NOT_FOUND, id)
        );
        return customerMapper.customerMapToCustomerDTO(customer);
    }

    /**
     * Service layer
     * Method create new a customer
     *
     * @param customerCreateDTO input
     * @return CustomerCreateDTO
     */
    @Override
    public CustomerDTO createNewCustomer(CustomerCreateDTO customerCreateDTO) {
        UUIDUtil.validateUUID(customerCreateDTO.getId());//Check id có đúng định dạng
        //Check id có tồn tại
        Optional<String> customerId = customerRepository.findByIdCustomerDuplicate(customerCreateDTO.getId());
        //Throw exception
        if (customerId.isPresent()) {
            throw new DuplicateIdException(ConstException.CUSTOMER_ID_IS_DUPLICATE, customerCreateDTO.getId());
        }
        //Save vào DataBase
        Customer customer = customerRepository.save(customerMapper.customerCreateDTOMapToCustomer(customerCreateDTO));
        return customerMapper.customerMapToCustomerDTO(customer);
    }

    /**
     * Service layer
     * Method update customer
     *
     * @param customerDTO input
     * @return CustomerDTO
     */
    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        UUIDUtil.validateUUID(customerDTO.getId());//Check id có đúng định dạng
        //Check customer có tồn tại
        Customer customer = customerRepository.findByIdCustomer(customerDTO.getId()).orElseThrow(() ->
                new NotFoundException(ConstException.CUSTOMER_NOT_FOUND, customerDTO.getId())
        );
        //Tiến hành mapping dữ liệu và lưu vào database
        customerRepository.save(customerMapper.updateCustomerFromCustomerDTO(customer, customerDTO));
        return customerMapper.customerMapToCustomerDTO(customer);
    }

    /**
     * Service layer
     * Method delete a customer
     *
     * @param id input
     */
    @Override
    public void deleteCustomer(String id) {
        UUIDUtil.validateUUID(id);//Check id có đúng định dạng
        //Check customer có tồn tại
        Customer customer = customerRepository.findByIdCustomer(id).orElseThrow(() ->
                new NotFoundException(ConstException.CUSTOMER_NOT_FOUND, id)
        );
        //Set status delete là true
        customer.setDelete(true);
        customerRepository.save(customer);
    }

    /**
     * Service layer
     * Method update partial a customer
     *
     * @param customerPartialDTO input
     * @return CustomerDTO
     */
    @Override
    public CustomerDTO updatePartial(CustomerPartialDTO customerPartialDTO) {
        UUIDUtil.validateUUID(customerPartialDTO.getId());//Check id có đúng định dạng
        //Check customer có tồn tại
        Customer customer = customerRepository.findByIdCustomer(customerPartialDTO.getId()).orElseThrow(() ->
                new NotFoundException(ConstException.CUSTOMER_NOT_FOUND, customerPartialDTO.getId())
        );
        //Tiến hành mapping dữ liệu và lưu vào database
        customerRepository.save(customerMapper.updateParCustomerFromCustomerPartialDTO(customer, customerPartialDTO));
        return customerMapper.customerMapToCustomerDTO(customer);
    }

    /**
     * Service layer
     * Method register for a course
     *
     * @param idCustomer input
     * @param idCourse   input
     * @return CustomerDTO
     */
    @Override
    public CustomerDTO registrationCourse(String idCustomer, String idCourse) {
        UUIDUtil.validateUUID(idCustomer);//check định dạng id
        UUIDUtil.validateUUID(idCourse);//check định dạng id
        //Check customer có tồn tại
        Customer customer = customerRepository.findByIdCustomer(idCustomer).orElseThrow(() ->
                new NotFoundException(ConstException.CUSTOMER_NOT_FOUND, idCustomer)
        );
        ////Check course có tồn tại
        Course course = courseRepository.findById(idCourse).orElseThrow(() ->
                new NotFoundException(ConstException.COURSE_NOT_FOUND, idCourse)
        );
        LocalDateTime date = LocalDateTime.now();//Lấy time  hiện tại
        //Lưu thông tin record
        recordRepository.save(new RegistrationRecord(customer, course, date));
        return customerMapper.customerMapToCustomerDTO(customer);
    }
}
