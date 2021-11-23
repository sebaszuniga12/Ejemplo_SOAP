/*
 * Copyright (c) 2021 Sebas.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sebas - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.arquitectura.producto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @Column(name = "COD_PRODUCTO", nullable = false, length = 20)
    private String codigo;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;

    @Column(name = "PRECIO", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "EXISTENCIA", precision = 10, scale = 2)
    private BigDecimal existencia;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    public Producto() {
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

}
