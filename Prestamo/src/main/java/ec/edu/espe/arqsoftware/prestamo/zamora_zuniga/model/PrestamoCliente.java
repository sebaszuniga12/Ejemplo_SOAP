/*
 * Copyright (c) 2021 valen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    valen - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "prestamo_cliente")

public class PrestamoCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestamo_id", nullable = false)
    private Integer codigo;
    
    @Column(name = "cod_prestamo", nullable = false)
    private String codigoPrestamo;
    
    @Column(name = "cod_cliente", nullable = false)
    private String codigoCliente;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "plazo", nullable = false)
    private Integer plazo;
    
    @Column(name = "seg_desgravamen")
    private String segDesgravamen;
    
    @Column(name = "monto_seguro")
    private BigDecimal montoSeguro;
    
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;
    
    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;
    
    @Column(name = "valor_total_interes", nullable = false)
    private BigDecimal valorTotalInteres;
    
    @Column(name = "monto_total_pago", nullable = false)
    private BigDecimal montoTotalPago;
    
    @Column(name = "saldo_capital")
    private BigDecimal saldoCapital;
    
    @Column(name = "estado")
    private String estado;  
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamoCliente")
    private List<CuotaPrestamo> cuotasPrestamo;
    
    @JoinColumn(name = "cod_prestamo", referencedColumnName = "cod_prestamo",nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prestamo prestamo;

}
