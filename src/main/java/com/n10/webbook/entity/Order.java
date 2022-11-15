package com.n10.webbook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.n10.webbook.enums.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "`order`")
@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CartID")
    private Cart cart;

    @OneToOne(mappedBy = "order")
    private Cash cash;

    @OneToOne(mappedBy = "order")
    private Card card;

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

}