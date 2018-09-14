package entity;


import com.javainuse.*;

import java.util.Date;

public class BookAndRent {

    public Book book;

    public Rentbook rentbook;

    public BookAndRent(Book book, Rentbook rentbook) {
        this.bookName=book.getBookName();
        this.author=book.getAuthor();
        this.editeurs=book.getEditeurs();
        this.nbPage=book.getNbPage();
        this.dispo=book.isDispo();
        this.rentid=rentbook.getRentid();
        this.userId=rentbook.getUserId();
        this.bookId=rentbook.getBookId();
        this.reload=rentbook.isReload();
        this.returnbook=rentbook.isReturnbook();
        this.createat=rentbook.getCreateat().toGregorianCalendar().getTime();
        this.endat=rentbook.getEndat().toGregorianCalendar().getTime();

    }

    public String bookName;
    public String author;
    public String editeurs;
    public int nbPage;
    public boolean dispo;
    public int rentid;
    public int userId;
    public int bookId;
    public boolean reload;
    public boolean returnbook;
    public Date createat;
    public Date endat;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditeurs() {
        return editeurs;
    }

    public void setEditeurs(String editeurs) {
        this.editeurs = editeurs;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getEndat() {
        return endat;
    }

    public void setEndat(Date endat) {
        this.endat = endat;
    }
}
