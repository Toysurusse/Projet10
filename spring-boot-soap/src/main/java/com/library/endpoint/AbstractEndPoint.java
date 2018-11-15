package com.library.endpoint;

import com.library.SpringBootLibraryApplication;
import com.library.config.Authentication;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.soap.SoapHeaderElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class AbstractEndPoint {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractEndPoint.class);

    protected Authentication getAuthentication(SoapHeaderElement header){
        Authentication authentication = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Authentication.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            authentication = (Authentication) unmarshaller.unmarshal(header.getSource());
        } catch (JAXBException e) {
            LOGGER.error("Error In AbstractEndPoint",e);
        }
        return authentication;
    }
}
