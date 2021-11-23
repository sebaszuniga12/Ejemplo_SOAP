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
package ec.edu.espe.arquitectura.producto.service;

import ec.edu.espe.arquitectura.producto.dao.ProductoRepository;
import ec.edu.espe.arquitectura.producto.exception.CreateException;
import ec.edu.espe.arquitectura.producto.exception.UpdateException;
import ec.edu.espe.arquitectura.producto.model.Producto;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Optional<Producto> obtainByCodigo(String codigo) {
        return this.productoRepository.findById(codigo);
    }

    @Transactional
    public Producto createProducto(Producto producto) {
        Optional<Producto> productoOpt = this.obtainByCodigo(producto.getCodigo());
        if (!productoOpt.isPresent()) {
            return this.productoRepository.save(producto);
        } else {
            StringBuilder sbMsg = new StringBuilder("The PRODUCTO with code: ");
            sbMsg.append(producto.getCodigo());
            sbMsg.append(" is already in the database");
            throw new CreateException(sbMsg.toString());
        }
    }

    @Transactional
    public void updateProducto(Producto producto) {
        Optional<Producto> productoOpt = this.obtainByCodigo(producto.getCodigo());
        if (productoOpt.isPresent()) {
            this.productoRepository.save(producto);
        } else {
            StringBuilder sbMsg = new StringBuilder("The PRODUCTO  with code: ");
            sbMsg.append(producto.getCodigo());
            sbMsg.append(" is not in the database");
            throw new UpdateException(sbMsg.toString());
        }
    }
    
    @Transactional
    public void deleteByCodigo(String codigo) {
        Optional<Producto> productoOpt = this.obtainByCodigo(codigo);
        if (productoOpt.isPresent()) {
             this.productoRepository.deleteById(codigo);
        } else {
            StringBuilder sbMsg = new StringBuilder("The PRODUCTO  with code: ");
            sbMsg.append(codigo);
            sbMsg.append(" is not in the database");
            throw new UpdateException(sbMsg.toString());
        }
    }
}
