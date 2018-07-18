
package com.javainuse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour shoppingBook complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="shoppingBook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="book_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="create_at" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="end_at" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="reload" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="returnbook" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shoppingBook", propOrder = {
    "id",
    "bookId",
    "userId",
    "createAt",
    "endAt",
    "reload",
    "returnbook"
})
public class ShoppingBook {

    protected int id;
    @XmlElement(name = "book_id")
    protected int bookId;
    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "create_at", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createAt;
    @XmlElement(name = "end_at", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endAt;
    protected boolean reload;
    protected boolean returnbook;

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
     * Obtient la valeur de la propriété createAt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateAt() {
        return createAt;
    }

    /**
     * Définit la valeur de la propriété createAt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateAt(XMLGregorianCalendar value) {
        this.createAt = value;
    }

    /**
     * Obtient la valeur de la propriété endAt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndAt() {
        return endAt;
    }

    /**
     * Définit la valeur de la propriété endAt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndAt(XMLGregorianCalendar value) {
        this.endAt = value;
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

}
