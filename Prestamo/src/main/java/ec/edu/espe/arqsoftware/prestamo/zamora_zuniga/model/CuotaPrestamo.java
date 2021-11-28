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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cuota_prestamo")

public class CuotaPrestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cuota", nullable = false)
    private Integer codigo;
    
    @Column(name = "prestamo_id", nullable = false)
    private Integer codigoPrestamo;
    
    @Column(name = "anio", nullable = false)
    private Integer anio;
    
    @Column(name = "mes", nullable = false)
    private Integer mes;
    
    @Column(name = "cuota", nullable = false)
    private BigDecimal cuota;
    
    @Column(name = "cuota_interes", nullable = false)
    private BigDecimal cuotaInteres;
    
    @Column(name = "cuota_seguro", nullable = false)
    private BigDecimal cuotaSeguro;
    
    @Column(name = "capital")
    private BigDecimal capital;
    
    @Column(name = "saldo_anterior")
    private BigDecimal saldoAnterior;
    
    @Column(name = "saldo_actual")
    private BigDecimal saldoActual;
    
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @Column(name = "fecha_max_pago", nullable = false)
    private LocalDateTime fechaMaxPago;
    
    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;
    
    @Column(name = "valor_pago")
    private BigDecimal valorPago;
    
    @JoinColumn(name = "prestamo_id", referencedColumnName = "prestamo_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private PrestamoCliente prestamoCliente;

    

    
    
}
