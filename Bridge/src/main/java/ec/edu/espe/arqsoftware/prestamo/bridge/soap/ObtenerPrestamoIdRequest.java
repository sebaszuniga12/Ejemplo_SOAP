//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.28 at 08:03:50 PM ECT 
//


package ec.edu.espe.arqsoftware.prestamo.bridge.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoPrestamo" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "codigoPrestamo"
})
@XmlRootElement(name = "obtenerPrestamoIdRequest")
public class ObtenerPrestamoIdRequest {

    protected int codigoPrestamo;

    /**
     * Gets the value of the codigoPrestamo property.
     * 
     */
    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    /**
     * Sets the value of the codigoPrestamo property.
     * 
     */
    public void setCodigoPrestamo(int value) {
        this.codigoPrestamo = value;
    }

}
