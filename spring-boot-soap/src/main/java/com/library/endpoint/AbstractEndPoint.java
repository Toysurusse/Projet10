package com.library.endpoint;

import com.library.config.Authentication;
import org.springframework.ws.soap.SoapHeaderElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class AbstractEndPoint {


    protected Authentication getAuthentication(SoapHeaderElement header){
        Authentication authentication = null;
        try {

            JAXBContext context = JAXBContext.newInstance(Authentication.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            authentication = (Authentication) unmarshaller.unmarshal(header.getSource());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return authentication;
    }
}
