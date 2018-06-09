package com.msita.training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orderproduct",schema ="trainning")
public class OrderProduct {
    @EmbeddedId
    private OrderProductKey key;


    @Column(name="price")
    private Integer price;



    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ido",referencedColumnName="ido", nullable=false, insertable=false, updatable=false)
    private Order order;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idp",referencedColumnName="idp", nullable=false, insertable=false, updatable=false)
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderProductKey getKey() {
        return key;
    }

    public void setKey(OrderProductKey key) {
        this.key = key;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @PrePersist
    public void setCandidateProductId() {
        if (this.getKey().getIdo() == null) {
            this.getKey().setIdo(this.order.getIdo());
        }
        if (this.getKey().getIdp() == null) {
            this.getKey().setIdp(this.getProduct().getIdp());
        }
    }
}
