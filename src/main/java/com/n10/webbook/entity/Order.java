package com.n10.webbook.entity;

import com.fasterxml.jackson.annotation.*;
import com.n10.webbook.enums.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "`order`")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "CartID")
    private Cart cart;

    @JsonManagedReference
    @OneToOne(mappedBy = "order")
    private Cash cash;

    @JsonManagedReference
    @OneToOne(mappedBy = "order")
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy = "order")
    private Set<Orderdetail> listOrderDetail;

    @Column(name = "TocalPrice")
    private Double tocalPrice;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "OrderStatus")
    private OrderStatus orderStatus=OrderStatus.SHIPPING;

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
        return "Order{" +
                "id=" + id +
                ", cart=" + cart +
                ", cash=" + cash +
                ", card=" + card +
                ", listOrderDetail=" + listOrderDetail +
                ", tocalPrice=" + tocalPrice +
                ", orderStatus=" + orderStatus +
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Set<Orderdetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(Set<Orderdetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public Double getTocalPrice() {
        return tocalPrice;
    }

    public void setTocalPrice(Double tocalPrice) {
        this.tocalPrice = tocalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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