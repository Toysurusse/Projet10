package client.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientBookConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.library");
        return marshaller;
    }

    @Bean
    public BookClient weatherClient(Jaxb2Marshaller marshaller) {
        BookClient client = new BookClient();
        client.setDefaultUri("http://192.168.0.17:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/book");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }



}
