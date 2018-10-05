
package com.javainuse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rentbook" type="{http://javainuse.com}rentbook"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rentbook"
})
@XmlRootElement(name = "inputSOARentbookBack")
public class InputSOARentbookBack {

    @XmlElement(required = true)
    protected Rentbook rentbook;

    /**
     * Obtient la valeur de la propriété rentbook.
     * 
     * @return
     *     possible object is
     *     {@link Rentbook }
     *     
     */
    public Rentbook getRentbook() {
        return rentbook;
    }

    /**
     * Définit la valeur de la propriété rentbook.
     * 
     * @param value
     *     allowed object is
     *     {@link Rentbook }
     *     
     */
    public void setRentbook(Rentbook value) {
        this.rentbook = value;
    }

}
