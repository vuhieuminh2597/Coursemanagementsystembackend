package com.example.coursems.entity;

import com.example.coursems.utils.LoggerUtil;
import com.example.coursems.utils.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "regis_record")
public class RegistrationRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regis_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fk_customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fk_course_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    public RegistrationRecord() {
    }

    public RegistrationRecord(Customer customer, Course course, LocalDateTime startDate) {
        this.customer = customer;
        this.course = course;
        setStartDate(startDate);
        setEndDate(startDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        Long days = 90L;
        LocalDateTime date = endDate;
        this.endDate = date.plusDays(days);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
