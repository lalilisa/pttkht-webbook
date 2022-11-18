package com.n10.webbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Table(name = "comment")
@Entity
@TypeDefs({
        @TypeDef(
                name = "json",
                typeClass = JsonType.class
        )
})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "BookID")
    private Book book;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    List<Integer> subComment;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<Integer> getSubComment() {
        return subComment;
    }

    public void setSubComment(List<Integer> subComment) {
        this.subComment = subComment;
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
        return "Comment{" +
                "id=" + id +
                ", book=" + book +
                ", customer=" + customer +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                ", subComment=" + subComment +
                ", createdDatetime=" + createdDatetime +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }
}