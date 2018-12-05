
package com.library;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour shop complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="shop">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idusershop" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idbookshop" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idpannier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dispo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="createat" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endat" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shop", propOrder = {
    "id",
    "idusershop",
    "idbookshop",
    "idpannier",
    "dispo",
    "createat",
    "endat"
})
public class Shop {

    protected int id;
    protected int idusershop;
    protected int idbookshop;
    @XmlElement(required = true)
    protected String idpannier;
    protected boolean dispo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createat;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endat;

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
     * Obtient la valeur de la propriété idusershop.
     * 
     */
    public int getIdusershop() {
        return idusershop;
    }

    /**
     * Définit la valeur de la propriété idusershop.
     * 
     */
    public void setIdusershop(int value) {
        this.idusershop = value;
    }

    /**
     * Obtient la valeur de la propriété idbookshop.
     * 
     */
    public int getIdbookshop() {
        return idbookshop;
    }

    /**
     * Définit la valeur de la propriété idbookshop.
     * 
     */
    public void setIdbookshop(int value) {
        this.idbookshop = value;
    }

    /**
     * Obtient la valeur de la propriété idpannier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdpannier() {
        return idpannier;
    }

    /**
     * Définit la valeur de la propriété idpannier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdpannier(String value) {
        this.idpannier = value;
    }

    /**
     * Obtient la valeur de la propriété dispo.
     * 
     */
    public boolean isDispo() {
        return dispo;
    }

    /**
     * Définit la valeur de la propriété dispo.
     * 
     */
    public void setDispo(boolean value) {
        this.dispo = value;
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
