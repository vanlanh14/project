package com.msita.training.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class OrderProductKey implements Serializable {

    @Column(name = "Ido")
    private Integer ido;

    @Column(name = "IdP")
    private Integer idp;

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    public Integer getIdp() {
        return idp;
    }

    public void setIdp(Integer idp) {
        this.idp = idp;
    }
}
