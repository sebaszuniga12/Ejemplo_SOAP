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
package ec.edu.espe.arqsoftware.prestamo.bridge.controller;


import ec.edu.espe.arqsoftware.prestamo.bridge.soap.CuotaPrestamoRS;
import ec.edu.espe.arqsoftware.prestamo.bridge.service.CuotaPrestamoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valen
 */
@Slf4j
@RestController
@RequestMapping("/api/cuota")
public class CuotaPrestamoController {

    private final CuotaPrestamoService cuotaService;

    public CuotaPrestamoController(CuotaPrestamoService cuotaService) {
        this.cuotaService = cuotaService;
    }

    @GetMapping(value = "codigoPrestamo/{codigoPrestamo}")
    public ResponseEntity obtenerPrestamoId(@PathVariable("codigoPrestamo") Integer codigoPrestamo) {
        try {
            List<CuotaPrestamoRS> response = this.cuotaService.obtenerPorCodigo(codigoPrestamo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @GetMapping(value = "cuotaPrestamo/{codigoPrestamo}")
    public ResponseEntity obtenerPrestamoIdYEstado(@PathVariable("codigoPrestamo") Integer codigoPrestamo){
        try {
            List<CuotaPrestamoRS> response = this.cuotaService.listarPorPrestamoId(codigoPrestamo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

  
}
