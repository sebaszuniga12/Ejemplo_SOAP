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
package ec.edu.espe.arquitectura.producto.controller;

import ec.edu.espe.arquitectura.producto.model.Producto;
import ec.edu.espe.arquitectura.producto.response.BadRequestRS;
import ec.edu.espe.arquitectura.producto.response.NotFoundRS;
import ec.edu.espe.arquitectura.producto.service.ProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@RequestMapping("/v1/producto")
@Slf4j
public class ProductoController {
    
     private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }
    
    @GetMapping(value = "{codigo}")
      @ApiOperation(value = "Obtener un producto",
            notes = "Obtiene un producto de acuerdo a su código",
            response = Producto.class, hidden = false)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Cuando se encuentra un producto de acuerdo al código enviado",
                    response = Producto.class),
            @ApiResponse(code = 404,
                    message = "Cuando no existe un producto con el código enviado",
                    response = NotFoundRS.class)
    })
    
    public ResponseEntity obtenerProductoPorCodigo(@PathVariable("codigo") String codigo) {
        Optional<Producto> productoOpt = this.service.obtainByCodigo(codigo);
        if (productoOpt.isPresent()) {
            return ResponseEntity.ok(productoOpt.get());
        } else {
            log.error("The PRODUCTO with code: {} does not exists in the database", codigo);
            NotFoundRS<String> response = new NotFoundRS<>();
            response.setSearchParameters(codigo);
            response.setPath("v1/producto/{codigo}");
            response.setMessage("El producto con el codigo enviado no existe en la base de datos");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
    }
    
    @PostMapping
     @ApiOperation(value = "Crear un producto",
            notes = "Crea un producto de acuerdo a los datos enviados",
            response = Producto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Cuando se crea un producto de acuerdo a los datos enviados",
                    response = Producto.class),
            @ApiResponse(code = 400,
                    message = "Cuando no se puede crear prodcuto con los datos enviados",
                    response = BadRequestRS.class)
    })
    public ResponseEntity crearProducto(@RequestBody Producto producto) {
        try {
            log.info("The PRODUCTO with this information: {} will be inserted in the database", producto);
            Producto response = this.service.createProducto(producto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            String exceptionMessage = e.getMessage();
            log.error("An error occurred while creating the PRODUCTO {} - Returning a Bad Request - Caused by: {}",
                    producto,
                    exceptionMessage);
            BadRequestRS<Producto> response = new BadRequestRS<>();
            response.setMessage("No fue posible crear el producto con la información dada");
            response.setPath("/v1/producto");
            response.setExceptionMessage(exceptionMessage);
            response.setObject(producto);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
    }
    
    @PutMapping
    @ApiOperation(value = "Actualizar un producto",
            notes = "Actualiza un producto de acuerdo a los datos enviados",
            response = Producto.class, hidden = false)
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Cuando se actualiza un producto de acuerdo a los datos enviados",
                    response = Producto.class),
            @ApiResponse(code = 400,
                    message = "Cuando no se puede actualizar un producto con los datos enviados",
                    response = BadRequestRS.class)
    })
    public ResponseEntity actualizarProducto(@RequestBody Producto producto) {
        try {
            log.info("The PRODUCTO with this information: {} will be updated in the database", producto);
            this.service.updateProducto(producto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("An error occurred while updating the PRODUCTO {} - Returning a Bad Request - Caused by: {}",
                    producto,
                    e.getMessage());
            BadRequestRS<Producto> response = new BadRequestRS<>();
            response.setMessage("No fue posible modificar el producto con la información dada");
            response.setPath("/v1/producto");
            response.setExceptionMessage(e.getMessage());
            response.setObject(producto);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
    }
    

     @GetMapping(value = "eliminar/{codigo}")
      @ApiOperation(value = "Eliminar un producto",
            notes = "Eliminar un producto de acuerdo a su código",
            response = Producto.class, hidden = false)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Cuando se encuentra un producto de acuerdo al código enviado",
                    response = Producto.class),
            @ApiResponse(code = 404,
                    message = "Cuando no existe un producto con el código enviado",
                    response = NotFoundRS.class)
    })
    
    public ResponseEntity eliminarProductoPorCodigo(@PathVariable("codigo") String codigo) {
        Optional<Producto> productoOpt = this.service.obtainByCodigo(codigo);
        if (productoOpt.isPresent()) {
            this.service.deleteByCodigo(codigo);
            return ResponseEntity.ok(productoOpt.get());
        } else {
            log.error("The PRODUCTO with code: {} does not exists in the database", codigo);
            NotFoundRS<String> response = new NotFoundRS<>();
            response.setSearchParameters(codigo);
            response.setPath("v1/producto/{codigo}");
            response.setMessage("El producto con el codigo enviado no existe en la base de datos");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
    }

}
