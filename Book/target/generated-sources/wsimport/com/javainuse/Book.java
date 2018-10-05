
package com.javainuse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="editeurs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nbPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dispo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "id",
    "bookName",
    "author",
    "editeurs",
    "nbPage",
    "dispo"
})
public class Book {

    protected int id;
    @XmlElement(required = true)
    protected String bookName;
    @XmlElement(required = true)
    protected String author;
    @XmlElement(required = true)
    protected String editeurs;
    protected int nbPage;
    protected int dispo;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété bookName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Définit la valeur de la propriété bookName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookName(String value) {
        this.bookName = value;
    }

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété editeurs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditeurs() {
        return editeurs;
    }

    /**
     * Définit la valeur de la propriété editeurs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditeurs(String value) {
        this.editeurs = value;
    }

    /**
     * Obtient la valeur de la propriété nbPage.
     * 
     */
    public int getNbPage() {
        return nbPage;
    }

    /**
     * Définit la valeur de la propriété nbPage.
     * 
     */
    public void setNbPage(int value) {
        this.nbPage = value;
    }

    /**
     * Obtient la valeur de la propriété dispo.
     * 
     */
    public int getDispo() {
        return dispo;
    }

    /**
     * Définit la valeur de la propriété dispo.
     * 
     */
    public void setDispo(int value) {
        this.dispo = value;
    }

}
