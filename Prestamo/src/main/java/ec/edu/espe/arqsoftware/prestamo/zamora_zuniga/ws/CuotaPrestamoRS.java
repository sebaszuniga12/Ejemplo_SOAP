//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.27 at 10:10:35 PM COT 
//


package ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * <p>Java class for cuotaPrestamoRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cuotaPrestamoRS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codigoPrestamo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cuota" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="cuotaInteres" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="cuotaSeguro" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="capital" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="saldoAnterior" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="saldoActual" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaMaxPago" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="fechaPago" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="valorPago" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuotaPrestamoRS", propOrder = {
    "codigo",
    "codigoPrestamo",
    "anio",
    "mes",
    "cuota",
    "cuotaInteres",
    "cuotaSeguro",
    "capital",
    "saldoAnterior",
    "saldoActual",
    "estado",
    "fechaMaxPago",
    "fechaPago",
    "valorPago"
})

    @Builder(toBuilder = true)
    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @Setter(value = AccessLevel.PACKAGE)
    @Getter
public class CuotaPrestamoRS {

    protected int codigo;
    protected int codigoPrestamo;
    protected int anio;
    protected int mes;
    @XmlElement(required = true)
    protected BigDecimal cuota;
    @XmlElement(required = true)
    protected BigDecimal cuotaInteres;
    @XmlElement(required = true)
    protected BigDecimal cuotaSeguro;
    @XmlElement(required = true)
    protected BigDecimal capital;
    @XmlElement(required = true)
    protected BigDecimal saldoAnterior;
    @XmlElement(required = true)
    protected BigDecimal saldoActual;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaMaxPago;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPago;
    @XmlElement(required = true)
    protected BigDecimal valorPago;

 

    /**
     * Gets the value of the codigo property.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

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

    /**
     * Gets the value of the anio property.
     * 
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Sets the value of the anio property.
     * 
     */
    public void setAnio(int value) {
        this.anio = value;
    }

    /**
     * Gets the value of the mes property.
     * 
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sets the value of the mes property.
     * 
     */
    public void setMes(int value) {
        this.mes = value;
    }

    /**
     * Gets the value of the cuota property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCuota() {
        return cuota;
    }

    /**
     * Sets the value of the cuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCuota(BigDecimal value) {
        this.cuota = value;
    }

    /**
     * Gets the value of the cuotaInteres property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCuotaInteres() {
        return cuotaInteres;
    }

    /**
     * Sets the value of the cuotaInteres property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCuotaInteres(BigDecimal value) {
        this.cuotaInteres = value;
    }

    /**
     * Gets the value of the cuotaSeguro property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCuotaSeguro() {
        return cuotaSeguro;
    }

    /**
     * Sets the value of the cuotaSeguro property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCuotaSeguro(BigDecimal value) {
        this.cuotaSeguro = value;
    }

    /**
     * Gets the value of the capital property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCapital() {
        return capital;
    }

    /**
     * Sets the value of the capital property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCapital(BigDecimal value) {
        this.capital = value;
    }

    /**
     * Gets the value of the saldoAnterior property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    /**
     * Sets the value of the saldoAnterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaldoAnterior(BigDecimal value) {
        this.saldoAnterior = value;
    }

    /**
     * Gets the value of the saldoActual property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    /**
     * Sets the value of the saldoActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaldoActual(BigDecimal value) {
        this.saldoActual = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the fechaMaxPago property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaMaxPago() {
        return fechaMaxPago;
    }

    /**
     * Sets the value of the fechaMaxPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaMaxPago(XMLGregorianCalendar value) {
        this.fechaMaxPago = value;
    }

    /**
     * Gets the value of the fechaPago property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPago() {
        return fechaPago;
    }

    /**
     * Sets the value of the fechaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPago(XMLGregorianCalendar value) {
        this.fechaPago = value;
    }

    /**
     * Gets the value of the valorPago property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPago() {
        return valorPago;
    }

    /**
     * Sets the value of the valorPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPago(BigDecimal value) {
        this.valorPago = value;
    }

}
