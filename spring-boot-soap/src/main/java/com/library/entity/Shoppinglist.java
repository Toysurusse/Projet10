package com.library.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "shoppinglist")
public class Shoppinglist implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(generator = "SEC_ODON", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_ODON", sequenceName = "SO.SEC_ODON",allocationSize=1)
    @Column(name = "id")
    private int id;

    @Column(name = "idusershop")
    private int idusershop;

    @Column(name = "idbookshop")
    private int idbookshop;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "end_at")
    private Timestamp end_at;

    @Column(name = "dispo")
    private boolean dispo;

    @Column(name = "idpannier")
    private String idpannier;

    public Shoppinglist(int idusershop, int idbookshop, Timestamp create_at, Timestamp end_at, boolean dispo, String idpannier){
        this.idbookshop=idbookshop;
        this.idusershop=idusershop;
        this.create_at=create_at;
        this.end_at=end_at;
        this.dispo=dispo;
        this.idpannier=idpannier;
    }

    public Shoppinglist() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdusershop() {
        return idusershop;
    }

    public void setIdusershop(int idusershop) {
        this.idusershop = idusershop;
    }

    public int getIdbookshop() {
        return idbookshop;
    }

    public void setIdbookshop(int idbookshop) {
        this.idbookshop = idbookshop;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Timestamp end_at) {
        this.end_at = end_at;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public String getIdpannier() {
        return idpannier;
    }

    public void setIdpannier(String idpannier) {
        this.idpannier = idpannier;
    }


}
