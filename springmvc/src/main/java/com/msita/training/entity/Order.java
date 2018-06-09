package com.msita.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="order", schema="trainning")
public class Order implements Serializable {

    @Id
    @Column( name = "ido")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer ido;

    @Column( name = "sum")
    private Integer sum;

    @Column(name="username")
    private String username;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username",referencedColumnName = "username", nullable = false,insertable = false,updatable = false)
    private User user;

    @JsonIgnoreProperties("order")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="order", fetch=FetchType.LAZY)
    private List<OrderProduct> lstOrderProduct;

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProduct> getLstOrderProduct() {
        return lstOrderProduct;
    }

    public void setLstOrderProduct(List<OrderProduct> lstOrderProduct) {
        this.lstOrderProduct = lstOrderProduct;
    }
}
