package com.fsd.entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "userservice")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private String email;
    //private String role;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String mobileNo;
    
    @ElementCollection
    private List<Long> registrationIds;

    public User(Long id, String username, String password, String email,  String firstName, String lastName, Date dateOfBirth, String mobileNo, List<Long> registrationIds) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
        this.registrationIds = registrationIds;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public List<Long> getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(List<Long> registrationIds) {
        this.registrationIds = registrationIds;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
                 + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
                + dateOfBirth + ", mobileNo=" + mobileNo + ", registrationIds=" + registrationIds + "]";
    }
}
