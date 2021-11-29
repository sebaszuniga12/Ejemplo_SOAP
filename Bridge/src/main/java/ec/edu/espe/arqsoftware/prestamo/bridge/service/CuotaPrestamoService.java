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
package ec.edu.espe.arqsoftware.prestamo.bridge.service;


import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ec.edu.espe.arqsoftware.prestamo.bridge.soap.CuotaPrestamoRS;
import ec.edu.espe.arqsoftware.prestamo.bridge.soap.ObtenerPrestamoIdRequest;
import ec.edu.espe.arqsoftware.prestamo.bridge.soap.ObtenerPrestamoIdResponse;
import ec.edu.espe.arqsoftware.prestamo.bridge.soap.ObtenerPrestamoIdYEstadoRequest;
import ec.edu.espe.arqsoftware.prestamo.bridge.soap.ObtenerPrestamoIdYEstadoResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;



@Service
@Slf4j
@RequiredArgsConstructor
@Component("Cliente")
public class CuotaPrestamoService extends WebServiceGatewaySupport  {

    public String endpoint = "http://localhost:8090/ws/cuotaPrestamo.wsdl";

    public List<CuotaPrestamoRS> obtenerPorCodigo(Integer codigo) throws DatatypeConfigurationException {
        ObtenerPrestamoIdRequest request = new  ObtenerPrestamoIdRequest();
        request.setCodigoPrestamo(codigo);
        ObtenerPrestamoIdResponse response = (  ObtenerPrestamoIdResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        return response.getCuotaPrestamoRS();
    }

    
    public List<CuotaPrestamoRS> listarPorPrestamoId(Integer codigoPrestamo) throws DatatypeConfigurationException {
        ObtenerPrestamoIdYEstadoRequest request = new  ObtenerPrestamoIdYEstadoRequest();
        request.setCodigoPrestamo(codigoPrestamo);
        ObtenerPrestamoIdYEstadoResponse response = (  ObtenerPrestamoIdYEstadoResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        return response.getCuotaPrestamoRS();
    }
}
