package client.rent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientRentConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.library");
        return marshaller;
    }

    @Bean
    public RentClient weatherClient(Jaxb2Marshaller marshaller) {
        RentClient client = new RentClient();
        client.setDefaultUri("http://localhost:8085/library/ws/rentbook");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
