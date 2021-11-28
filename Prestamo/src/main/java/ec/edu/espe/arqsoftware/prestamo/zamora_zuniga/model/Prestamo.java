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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "prestamo")

public class Prestamo implements Serializable {

    @Id
    @Column(name = "cod_prestamo", nullable = false)
    private String codigo;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "monto_min", nullable = false)
    private BigDecimal montoMin;
    
    @Column(name = "monto_max", nullable = false)
    private BigDecimal montoMax;
    
    @Column(name = "plazo_max", nullable = false)
    private Integer plazoMax;
    
    @Column(name = "plazo_min", nullable = false)
    private Integer plazoMin;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamos", fetch = FetchType.LAZY)
    private List<PrestamoTasa> prestamosTasa;
    

    
}
