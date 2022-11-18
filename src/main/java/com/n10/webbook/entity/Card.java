package com.n10.webbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "card")
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @Column(name = "NumberAccount")
    private String numberAccount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_datetime")
    @CreationTimestamp
    private Date createdDatetime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_datetime")
    @UpdateTimestamp
    private Date updatedDatetime;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", order=" + order +
                ", numberAccount='" + numberAccount + '\'' +
                ", createdDatetime=" + createdDatetime +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
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
}