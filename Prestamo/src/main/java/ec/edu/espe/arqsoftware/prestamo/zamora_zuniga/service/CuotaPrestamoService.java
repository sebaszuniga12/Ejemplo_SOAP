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
package ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.service;

import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.dao.CuotaPrestamoRepository;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.model.CuotaPrestamo;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CuotaPrestamoService {

    private final CuotaPrestamoRepository cuotaRepo;

    public CuotaPrestamoService(CuotaPrestamoRepository cuotaRepo) {
        this.cuotaRepo = cuotaRepo;
    }


    public List<CuotaPrestamo> listarPorPrestamoId(Integer codigoPrestamo) {
        return this.cuotaRepo.findByCodigoPrestamo(codigoPrestamo);
    }

    public List<CuotaPrestamo> listarPorPrestamoIdYEstado(Integer codigo) {
        List<CuotaPrestamo> cuotaPendiente = this.cuotaRepo.findByCodigoPrestamoAndEstadoOrderByFechaMaxPagoAsc(codigo, "PEN");
        List<CuotaPrestamo> cuotaMora = this.cuotaRepo.findByCodigoPrestamoAndEstadoOrderByFechaMaxPagoAsc(codigo, "MOR");
        List<CuotaPrestamo> cuotasEstado = new ArrayList<>();
        cuotasEstado.addAll(cuotaPendiente);
        cuotasEstado.addAll(cuotaMora);

        return cuotasEstado;
    }
}
