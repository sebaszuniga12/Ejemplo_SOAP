package ec.edu.espe.arqsoftware.prestamo.bridge.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import ec.edu.espe.arqsoftware.prestamo.bridge.service.CuotaPrestamoService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {

    @Autowired
    private CuotaPrestamoService client;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ec.edu.espe.arqsoftware.prestamo.bridge.soap");
        return marshaller;
    }

    @Bean
    @Primary
    public CuotaPrestamoService cuotaPrestamo(Jaxb2Marshaller marshaller) {
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}