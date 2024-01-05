package com.example.coursems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "custumers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_dob")
    private String birthDay;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "customer_phone")
    private String phone;
    @Column(name = "customer_gender")
    private String gender;
    @Column(name = "status_is_delete")
    private boolean isDelete;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_customer_id", referencedColumnName = "customer_id")
    @JsonIgnore
    private List<RegistrationRecord> customerRecord;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_course",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnore
    private Set<Course> courses;

    public Customer() {
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<RegistrationRecord> getCustomerRecord() {
        return customerRecord;
    }

    public void setCustomerRecord(List<RegistrationRecord> customerRecord) {
        this.customerRecord = customerRecord;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }


    public void setCourses(Course courses) {
        this.courses.add(courses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return isDelete == customer.isDelete && Objects.equals(id, customer.id) && Objects.equals(name, customer.name)
                && Objects.equals(birthDay, customer.birthDay) && Objects.equals(address, customer.address)
                && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone)
                && Objects.equals(gender, customer.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDay, address, email, phone, gender, isDelete);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
