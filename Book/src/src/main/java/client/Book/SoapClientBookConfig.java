package client.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientBookConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.javainuse");
        return marshaller;
    }

    @Bean
    public BookClient weatherClient(Jaxb2Marshaller marshaller) {
        BookClient client = new BookClient();
        client.setDefaultUri("http://localhost:8085/javainuse/ws/book");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }



}
