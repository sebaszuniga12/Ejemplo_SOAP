package ec.edu.espe.arqsoftware.springsoapcf.endpoint;

import ec.edu.espe.arqsoftware.springsoapcf.exception.CreateException;
import ec.edu.espe.arqsoftware.springsoapcf.exception.UpdateException;
import ec.edu.espe.arqsoftware.springsoapcf.service.ProductoService;
import ec.edu.espe.arqsoftware.springsoapcf.ws.ActualizarProductoRequest;
import ec.edu.espe.arqsoftware.springsoapcf.ws.ActualizarProductoResponse;
import ec.edu.espe.arqsoftware.springsoapcf.ws.CrearProductoRequest;
import ec.edu.espe.arqsoftware.springsoapcf.ws.CrearProductoResponse;
import ec.edu.espe.arqsoftware.springsoapcf.ws.EliminarProductoPorCodigoRequest;
import ec.edu.espe.arqsoftware.springsoapcf.ws.EliminarProductoPorCodigoResponse;
import ec.edu.espe.arqsoftware.springsoapcf.ws.ObtenerProductoPorCodigoRequest;
import ec.edu.espe.arqsoftware.springsoapcf.ws.ObtenerProductoPorCodigoResponse;
import ec.edu.espe.arqsoftware.springsoapcf.ws.Producto;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class ProductoEndpoint {
    private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/SpringSOAPCF/ws";

    private final ProductoService service;

    @Autowired
    public ProductoEndpoint(ProductoService service){
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerProductoPorCodigoRequest")
    @ResponsePayload
    public ObtenerProductoPorCodigoResponse obtenerProductoPorCodigo(@RequestPayload ObtenerProductoPorCodigoRequest request) throws CreateException{
        Optional<Producto> productoOpt = this.service.obtainByCodigo(request.getCodigo());
        if (productoOpt.isPresent()) {
            ObtenerProductoPorCodigoResponse response = new ObtenerProductoPorCodigoResponse();
            response.setProducto(productoOpt.get());
            return response;
        } else {
            log.error("The PRODUCTO with code: {} does not exists in the database", request.getCodigo());
            throw new CreateException("Message: "+"The PRODUCTO with code"+request.getCodigo()+" does not exists in the database");
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "crearProductoRequest")
    @ResponsePayload
    public CrearProductoResponse crearProducto(@RequestPayload CrearProductoRequest request) throws CreateException{
        try {
            log.info("The PRODUCTO with this information: {} will be inserted in the database", request.getProducto());
            Producto productoTmp = this.service.createProducto(request.getProducto());
            CrearProductoResponse response = new CrearProductoResponse();
            response.setProducto(productoTmp);
            return response;
        } catch (Exception e) {
            String exceptionMessage = e.getMessage();
            log.error("An error occurred while creating the PRODUCTO {} - Returning a Bad Request - Caused by: {}",
                    request.getProducto(),
                    exceptionMessage);
            throw new CreateException("Error: "+exceptionMessage);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "actualizarProductoRequest")
    @ResponsePayload
    public ActualizarProductoResponse actualizarProducto(@RequestPayload ActualizarProductoRequest request) throws UpdateException {
        try {
            log.info("The PRODUCTO with this information: {} will be updated in the database", request.getProducto());
            this.service.updateProducto(request.getProducto());
            ActualizarProductoResponse response = new ActualizarProductoResponse();
            response.setProducto(request.getProducto());
            return response;
        } catch (Exception e) {
            String exceptionMessage = e.getMessage();
            log.error("An error occurred while updating the PRODUCTO {} - Returning a Bad Request - Caused by: {}",
                    request.getProducto(),
                    exceptionMessage);
            throw new UpdateException("Error: "+exceptionMessage);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "eliminarProductoPorCodigoRequest")
    @ResponsePayload
    public EliminarProductoPorCodigoResponse actualizarProducto(@RequestPayload EliminarProductoPorCodigoRequest request) throws UpdateException {
        Optional<Producto> productoOpt = this.service.obtainByCodigo(request.getCodigo());
        if (productoOpt.isPresent()) {
            log.info("The PRODUCTO with this code: {} will be deleted", request.getCodigo());
            this.service.deleteByCodigo(request.getCodigo());
            EliminarProductoPorCodigoResponse response = new EliminarProductoPorCodigoResponse();
            response.setProducto(productoOpt.get());
            return response;
        } else {
            log.error("The PRODUCTO with code: {} does not exists in the database", request.getCodigo());
            throw new UpdateException("Error: The PRODUCTO with code: "+request.getCodigo()+" does not exists in the database");
        }
    }
}
