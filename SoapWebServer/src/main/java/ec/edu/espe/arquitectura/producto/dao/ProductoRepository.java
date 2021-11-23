/*
 * Copyright (c) 2021 sebas.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    sebas - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.arquitectura.producto.dao;

import ec.edu.espe.arquitectura.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface ProductoRepository extends JpaRepository<Producto, String>{
    
}
