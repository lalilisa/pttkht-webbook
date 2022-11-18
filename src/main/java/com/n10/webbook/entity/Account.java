package com.n10.webbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.n10.webbook.enums.AccountStatus;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "account")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "State")
    private String state;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "AccountStatus")
    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus=AccountStatus.INACTIVE;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_datetime")
    @CreationTimestamp
    private Date createdDatetime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_datetime")
    @UpdateTimestamp
    private Date updatedDatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public Date getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Date updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", createdDate=" + createdDate +
                ", accountStatus=" + accountStatus +
                ", createdDatetime=" + createdDatetime +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }
}