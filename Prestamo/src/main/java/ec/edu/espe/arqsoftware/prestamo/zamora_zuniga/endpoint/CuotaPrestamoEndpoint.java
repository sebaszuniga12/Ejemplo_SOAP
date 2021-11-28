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
import java.util.ArrayList;

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
    public ObtenerPrestamoIdResponse obtenerPrestamoId(@RequestPayload ObtenerPrestamoIdRequest request) throws RuntimeException{
        try {
            List<CuotaPrestamo> cuotaPrestamo = this.cuotaService.listarPorPrestamoId(request.getCodigoPrestamo());
            List<CuotaPrestamoRS> cuotaPrestamoRS = new ArrayList<>();
            log.info("Cuotas obtenidas {} con el codigo: {}",
            cuotaPrestamo.size(),  request.getCodigoPrestamo());
            cuotaPrestamo.forEach(c -> {
                cuotaPrestamoRS.add(CuotaPrestamoRSTransform.buildCuotaPrestamoRS(c));
            });            
            ObtenerPrestamoIdResponse response = new ObtenerPrestamoIdResponse();
            response.setCuotaPrestamoRS(cuotaPrestamoRS);
            return response;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

   
    /*
    @GetMapping(value = "cuotaPrestamo/{codigoPrestamo}")
    public ResponseEntity obtenerPrestamoIdYEstado(@PathVariable("codigoPrestamo") Integer codigoPrestamo) {
        try {
            List<CuotaPrestamo> cuotaPrestamo = this.cuotaService.listarPorPrestamoIdYEstado(codigoPrestamo);
            List<CuotaPrestamoRS> cuotaPrestamoRS = new ArrayList<>();
            log.info("Cuotas obtenidas {} con el codigo: {}",
                    cuotaPrestamo.size(), codigoPrestamo);
            cuotaPrestamo.forEach(c -> {
                cuotaPrestamoRS.add(CuotaPrestamoRSTransform.buildCuotaPrestamoRS(c));
            });

            return ResponseEntity.ok(cuotaPrestamoRS);
        } catch (Exception e) {
            return Serializador.Error(e, "Error, no se pudieron obtener las cuotas con ese código de préstamo y ese estado");
        }
    }
*/

}
