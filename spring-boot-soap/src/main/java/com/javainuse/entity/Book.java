package com.javainuse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookid")
    private int id;

    @Column(name = "bookname")
    private String bookName;

    @Column(name = "nbpage")
    private int nbPage;

    @Column(name = "editeurs")
    private String editeurs;

    @Column(name = "author")
    private String author;

    @Column(name = "dispo")
    private Boolean dispo;

    public Boolean getDispo() {
        return dispo;
    }

    public void setDispo(Boolean dispo) {
        this.dispo = dispo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEditeurs() {
        return editeurs;
    }

    public void setEditeurs(String editeurs) {
        this.editeurs = editeurs;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    protected Book(){

    }

    public Book(String bookName, int nbPage, String editeurs, String author) {
        this.bookName = bookName;
        this.nbPage = nbPage;
        this.editeurs = editeurs;
        this.author = author;
    }
}
