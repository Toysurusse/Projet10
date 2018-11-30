package entity;

import com.library.Book;

public class Shopping {

    public int idPannier;
    private String bookName;
    private int nbPage;
    private String editeurs;
    private String author;
    private int dispo;
    private int idBook;

    public Shopping(Book book, int idPannier){
        this.author=book.getAuthor();
        this.idPannier=idPannier;
        this.bookName=book.getBookName();
        this.nbPage=book.getNbPage();
        this.editeurs=book.getAuthor();
        this.dispo=book.getDispo();
        this.idBook=book.getId();
    }

    public int getIdPannier() {
        return idPannier;
    }

    public void setIdPannier(int idPannier) {
        this.idPannier = idPannier;
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

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
}
