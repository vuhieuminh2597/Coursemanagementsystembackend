package com.example.coursems.model;

import com.example.coursems.entity.Course;
import com.example.coursems.entity.Customer;

import java.util.Date;


public class RegisRecordDTO {
    private Long id;
    private String customer;
    private String course;
    private String startDate;
    private String endDate;

    public RegisRecordDTO() {
    }

    public RegisRecordDTO(Long id, String customer, String course, String startDate, String endDate) {
        this.id = id;
        this.customer = customer;
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
