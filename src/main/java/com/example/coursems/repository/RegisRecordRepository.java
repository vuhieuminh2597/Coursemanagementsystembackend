package com.example.coursems.repository;

import com.example.coursems.entity.Customer;
import com.example.coursems.entity.RegistrationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisRecordRepository extends JpaRepository<RegistrationRecord,Long> {
    @Query("SELECT r.customer FROM RegistrationRecord r where r.customer.id =:id")
    Optional<Customer> findCustomerById(String id);
}
