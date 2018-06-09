package com.msita.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name="product", schema="trainning")
public class Product {

    @Id
    @Column(name="idp")
    private Integer idp;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    @Column(name="price")
    private int price;

    @Column(name="brand")
    private String brand;

    @Transient
    private int quantity=1;

    @JsonIgnoreProperties("product")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="product", fetch=FetchType.LAZY)
    private List<OrderProduct> lstOrderProduct;

    public List<OrderProduct> getLstOrderProduct() {
        return lstOrderProduct;
    }

    public void setLstOrderProduct(List<OrderProduct> lstOrderProduct) {
        this.lstOrderProduct = lstOrderProduct;
    }

    public Integer getIdp() {
        return idp;
    }

    public void setIdp(Integer idp) {
        this.idp = idp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
