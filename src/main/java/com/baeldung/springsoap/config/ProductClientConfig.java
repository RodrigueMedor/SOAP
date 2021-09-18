package com.baeldung.springsoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductClientConfig {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.baeldung.springsoap.gen");
        return marshaller;
    }

    @Bean
    public ProductClient productClient(Jaxb2Marshaller jaxb2Marshaller){
        ProductClient client = new ProductClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);
        return client;
    }
}
