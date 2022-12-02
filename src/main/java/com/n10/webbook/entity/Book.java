package com.n10.webbook.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Table(name = "book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "PublishYear")
    private String publishYear;

    @Column(name = "NumberOfPages", nullable = false)
    private Integer numberOfPages;

    @Column(name = "Language")
    private String language;

    @Column(name = "Price")
    private double price;

    @JsonBackReference
    @OneToMany(mappedBy = "book")
    private Set<Item> items;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private Set<Image> images;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Author author;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "PublisherID")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "bookcategory",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", language='" + language + '\'' +
                ", createdDatetime=" + createdDatetime +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }
}