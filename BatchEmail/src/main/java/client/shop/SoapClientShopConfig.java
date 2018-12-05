package client.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientShopConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.library");
        return marshaller;
    }

    @Bean
    public ShopClient weatherClient(Jaxb2Marshaller marshaller) {
        ShopClient client = new ShopClient();
        client.setDefaultUri("http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/Shop");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
