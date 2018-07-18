package com.javainuse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shoppingbook")
public class Shoppingbook implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cartid")
    private int cartid;

    @Column(name = "bookid")
    private int bookid;

    @Column(name = "userid")
    private int userid;

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int id) {
        this.cartid = cartid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Shoppingbook(int bookid, int userid) {
        this.bookid = bookid;
        this.userid = userid;
    }
}
