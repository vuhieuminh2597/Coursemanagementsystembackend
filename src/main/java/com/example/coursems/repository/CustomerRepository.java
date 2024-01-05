package com.example.coursems.repository;

import com.example.coursems.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("SELECT c FROM Customer c WHERE c.isDelete != TRUE ORDER BY c.name")
    Page<Customer> findAllCustomer(Pageable pageable);

    /**
     * Repository layer
     * Abstract method find customer by id
     *
     * @param id input
     * @return Optional<Customer>
     */
    @Query("SELECT c FROM Customer c WHERE c.id = :id AND c.isDelete != TRUE")
    Optional<Customer> findByIdCustomer(String id);

    /**
     * Repository layer
     * Abstract method find customer name by name
     *
     * @param name input
     * @return Optional<String>
     */
    @Query("SELECT c.name FROM Customer c WHERE c.name = :name AND c.isDelete != TRUE ")
    Optional<String> findByNameCustomerDuplicate(String name);

    /**
     * Repository layer
     * Abstract method find customer id by id
     *
     * @param id input
     * @return Optional<String>
     */
    @Query("SELECT c.id FROM  Customer c WHERE c.id = :id")
    Optional<String> findByIdCustomerDuplicate(String id);
}
