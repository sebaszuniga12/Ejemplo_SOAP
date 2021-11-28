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
package ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.transform;

import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.ws.CuotaPrestamoRS;
import ec.edu.espe.arqsoftware.prestamo.zamora_zuniga.model.CuotaPrestamo;
import java.time.LocalDateTime;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author valen
 */
public class CuotaPrestamoRSTransform {

    public static CuotaPrestamoRS buildCuotaPrestamoRS(CuotaPrestamo cuotaPrestamo) throws DatatypeConfigurationException {
        LocalDateTime localDatetimeMax = cuotaPrestamo.getFechaMaxPago();
        LocalDateTime localDatetimeFecha = cuotaPrestamo.getFechaPago();
        XMLGregorianCalendar fechaPago = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        if(localDatetimeFecha != null){
        fechaPago = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDatetimeFecha.toString());
        }
        else{
               fechaPago = null;
        }
       XMLGregorianCalendar fechaMaxPago = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDatetimeMax.toString());
        return CuotaPrestamoRS.builder()
                .codigo(cuotaPrestamo.getCodigo())
                .codigoPrestamo(cuotaPrestamo.getCodigoPrestamo())
                .anio(cuotaPrestamo.getAnio())
                .mes(cuotaPrestamo.getMes())
                .cuota(cuotaPrestamo.getCuota())
                .cuotaInteres(cuotaPrestamo.getCuotaInteres())
                .cuotaSeguro(cuotaPrestamo.getCuotaSeguro())
                .capital(cuotaPrestamo.getCapital())
                .saldoAnterior(cuotaPrestamo.getSaldoAnterior())
                .saldoActual(cuotaPrestamo.getSaldoAnterior())
                .estado(cuotaPrestamo.getEstado())
                .fechaMaxPago(fechaMaxPago)
                .fechaPago(fechaPago)
                .valorPago(cuotaPrestamo.getValorPago())
                .build();
    }

}
