package com.example.coursems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    private String id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_des")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_course_id", referencedColumnName = "course_id")
    @JsonIgnore
    private Set<RegistrationRecord> courseRecord;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Customer> customers;

    public Course() {
    }

    public Course(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RegistrationRecord> getCourseRecord() {
        return courseRecord;
    }

    public void setCourseRecord(Set<RegistrationRecord> customerRecord) {
        this.courseRecord = customerRecord;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
