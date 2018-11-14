package com.library.endpoint;

import com.library.SpringBootLibraryApplication;
import com.library.config.Authentication;
import org.apache.log4j.LogManager;
import org.springframework.ws.soap.SoapHeaderElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class AbstractEndPoint {

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(SpringBootLibraryApplication.class);

    protected Authentication getAuthentication(SoapHeaderElement header){
        Authentication authentication = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Authentication.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            authentication = (Authentication) unmarshaller.unmarshal(header.getSource());
        } catch (JAXBException e) {
            logger.trace(e);
        }
        return authentication;
    }
}
