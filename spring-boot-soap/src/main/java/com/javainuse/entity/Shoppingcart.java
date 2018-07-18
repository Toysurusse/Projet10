package com.javainuse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shoppingcart")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "duration")
    private int duration;

    @Column(name = "statut")
    private boolean statut;

    public Shoppingcart(int user_id, int duration, boolean statut) {
        this.user_id = user_id;
        this.duration = duration;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

}
