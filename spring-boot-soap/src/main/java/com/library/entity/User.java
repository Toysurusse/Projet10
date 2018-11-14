package com.library.entity;

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

    @Column(name = "salt")
    private String salt;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "delete")
    private boolean delete;

    @Column(name = "mail")
    private String mail;

    @Column(name = "role")
    private int role;

    protected User(){
    }

    public User(String pseudo, String password, String salt, String mail, int role, boolean delete){
        this.password=password;
        this.salt=salt;
        this.pseudo=pseudo;
        this.mail=mail;
        this.role=role;
        this.delete=delete;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
