
package com.javainuse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour shoppingCart complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="shoppingCart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cartid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statut" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shoppingCart", propOrder = {
    "cartid",
    "userId",
    "duration",
    "statut"
})
public class ShoppingCart {

    protected int cartid;
    @XmlElement(name = "user_id")
    protected int userId;
    protected int duration;
    protected boolean statut;

    /**
     * Obtient la valeur de la propriété cartid.
     * 
     */
    public int getCartid() {
        return cartid;
    }

    /**
     * Définit la valeur de la propriété cartid.
     * 
     */
    public void setCartid(int value) {
        this.cartid = value;
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
     * Obtient la valeur de la propriété duration.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Définit la valeur de la propriété duration.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * Obtient la valeur de la propriété statut.
     * 
     */
    public boolean isStatut() {
        return statut;
    }

    /**
     * Définit la valeur de la propriété statut.
     * 
     */
    public void setStatut(boolean value) {
        this.statut = value;
    }

}
