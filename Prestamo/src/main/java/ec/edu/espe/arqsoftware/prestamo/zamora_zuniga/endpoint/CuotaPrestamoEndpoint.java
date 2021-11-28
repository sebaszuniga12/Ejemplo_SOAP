/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.endpoint;

import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.service.CuotaPrestamoService;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws.ObtenerPrestamoIdResponse;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws.ObtenerPrestamoIdRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.model.CuotaPrestamo;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.transform.CuotaPrestamoRSTransform;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws.CuotaPrestamoRS;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws.ObtenerPrestamoIdYEstadoRequest;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws.ObtenerPrestamoIdYEstadoResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author sebas
 */
@Endpoint
@Slf4j
public class CuotaPrestamoEndpoint {

    private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/prestamo/zamora_zuniga/ws";

    private final CuotaPrestamoService cuotaService;

    public CuotaPrestamoEndpoint(CuotaPrestamoService cuotaService) {
        this.cuotaService = cuotaService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerPrestamoIdRequest")
    @ResponsePayload
    public ObtenerPrestamoIdResponse obtenerPrestamoId(@RequestPayload ObtenerPrestamoIdRequest request) throws RuntimeException {
        try {
            List<CuotaPrestamo> cuotaPrestamo = this.cuotaService.listarPorPrestamoId(request.getCodigoPrestamo());
            List<CuotaPrestamoRS> cuotaPrestamoRS = new ArrayList<>();
            log.info("Cuotas obtenidas {} con el codigo: {}",
                    cuotaPrestamo.size(), request.getCodigoPrestamo());
            cuotaPrestamo.forEach(c -> {
                try {
                    cuotaPrestamoRS.add(CuotaPrestamoRSTransform.buildCuotaPrestamoRS(c));
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(CuotaPrestamoEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            ObtenerPrestamoIdResponse response = new ObtenerPrestamoIdResponse();
            response.setCuotaPrestamoRS(cuotaPrestamoRS);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerPrestamoIdYEstadoRequest")
    @ResponsePayload
    public ObtenerPrestamoIdYEstadoResponse obtenerPrestamoIdYEstado(@RequestPayload ObtenerPrestamoIdYEstadoRequest request) throws RuntimeException {
        try {
            List<CuotaPrestamo> cuotaPrestamo = this.cuotaService.listarPorPrestamoIdYEstado(request.getCodigoPrestamo());
            List<CuotaPrestamoRS> cuotaPrestamoRS = new ArrayList<>();
            log.info("Cuotas obtenidas {} con el codigo: {}",
                    cuotaPrestamo.size(), request.getCodigoPrestamo());
            cuotaPrestamo.forEach(c -> {
                try {
                    cuotaPrestamoRS.add(CuotaPrestamoRSTransform.buildCuotaPrestamoRS(c));
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(CuotaPrestamoEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            ObtenerPrestamoIdYEstadoResponse response = new ObtenerPrestamoIdYEstadoResponse();
            response.setCuotaPrestamoRS(cuotaPrestamoRS);
            return response;
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
