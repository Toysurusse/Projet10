package com.javainuse.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "rentbook")
public class Rent implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rentid")
    private int id;

    @Column(name = "book_id")
    private int book_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "create_at")
    private Date create_at;

    @Column(name = "end_at")
    private Date end_at;

    @Column(name = "reload")
    private boolean reload;

    @Column(name = "returnbook")
    private boolean returnbook;

    protected Rent(){
    }

    public Rent(int book_id, int user_id, Date create_at, Date end_at, boolean reload, boolean returnbook){
        this.book_id=book_id;
        this.user_id=user_id;
        this.create_at=create_at;
        this.end_at=end_at;
        this.reload=reload;
        this.returnbook=returnbook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Date end_at) {
        this.end_at = end_at;
    }

    public boolean isReload() {
        return reload;
    }

    public void setReload(boolean reload) {
        this.reload = reload;
    }

    public boolean isReturnbook() {
        return returnbook;
    }

    public void setReturnbook(boolean returnbook) {
        this.returnbook = returnbook;
    }
}
