package com.javainuse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usertable")
public class User implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid")
    private int id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "mail")
    private String mail;

    protected User(){
    }

    public User(String pseudo, String password, String mail){
        this.password=password;
        this.pseudo=pseudo;
        this.mail=mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
