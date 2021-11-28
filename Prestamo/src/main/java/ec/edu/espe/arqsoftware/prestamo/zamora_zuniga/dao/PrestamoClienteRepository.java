/*
 * Copyright (c) 2021 mafer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    mafer - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.dao;

import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.model.PrestamoCliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoClienteRepository extends JpaRepository<PrestamoCliente, Integer>{
    List<PrestamoCliente> findByCodigoPrestamoAndCodigoClienteAndEstado(String codPrestamo, String codCliente, String estado);
    List<PrestamoCliente> findByEstado(String estado);
    List<PrestamoCliente> findByCodigoCliente(String codigoCliente);
}
