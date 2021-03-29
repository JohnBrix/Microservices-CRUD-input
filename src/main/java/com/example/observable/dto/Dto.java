package com.example.observable.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Dto  {

    private Integer id;
    @NotBlank(message = "Firstname cannot be blank!")
    private String firstName;
    @NotBlank(message = "Lastname cannot be blank!")
    private String lastName;
    @NotNull(message = "BirthDate cannot be blank!")
    private Date birthDate;
    @NotNull(message = "Age cannot be null")
    private Integer age;
    @NotBlank(message = "Address cannot be blank!")
    private String address;
    private Date dateCreated;

    public Dto(Integer id, @NotBlank(message = "Firstname cannot be blank!") String firstName, @NotBlank(message = "Lastname cannot be blank!") String lastName, @NotNull(message = "BirthDate cannot be blank!") Date birthDate, @NotNull(message = "Age cannot be null") Integer age, @NotBlank(message = "Address cannot be blank!") String address, Date dateCreated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.address = address;
        this.dateCreated = dateCreated;
    }

    public Dto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
