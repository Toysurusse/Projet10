
package com.library;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour rentbook complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="rentbook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rentid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="book_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reload" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="returnbook" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="createat" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="endat" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rentbook", propOrder = {
    "rentid",
    "userId",
    "bookId",
    "reload",
    "returnbook",
    "createat",
    "endat"
})
public class Rentbook {

    protected int rentid;
    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "book_id")
    protected int bookId;
    protected boolean reload;
    protected boolean returnbook;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createat;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endat;

    /**
     * Obtient la valeur de la propriété rentid.
     * 
     */
    public int getRentid() {
        return rentid;
    }

    /**
     * Définit la valeur de la propriété rentid.
     * 
     */
    public void setRentid(int value) {
        this.rentid = value;
    }

    /**
     * Obtient la valeur de la propriété userId.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Obtient la valeur de la propriété bookId.
     * 
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Définit la valeur de la propriété bookId.
     * 
     */
    public void setBookId(int value) {
        this.bookId = value;
    }

    /**
     * Obtient la valeur de la propriété reload.
     * 
     */
    public boolean isReload() {
        return reload;
    }

    /**
     * Définit la valeur de la propriété reload.
     * 
     */
    public void setReload(boolean value) {
        this.reload = value;
    }

    /**
     * Obtient la valeur de la propriété returnbook.
     * 
     */
    public boolean isReturnbook() {
        return returnbook;
    }

    /**
     * Définit la valeur de la propriété returnbook.
     * 
     */
    public void setReturnbook(boolean value) {
        this.returnbook = value;
    }

    /**
     * Obtient la valeur de la propriété createat.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateat() {
        return createat;
    }

    /**
     * Définit la valeur de la propriété createat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateat(XMLGregorianCalendar value) {
        this.createat = value;
    }

    /**
     * Obtient la valeur de la propriété endat.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndat() {
        return endat;
    }

    /**
     * Définit la valeur de la propriété endat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndat(XMLGregorianCalendar value) {
        this.endat = value;
    }

}
