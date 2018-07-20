package com.javainuse.endpoint;

import com.javainuse.*;
import com.javainuse.config.Authentication;
import com.javainuse.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;

@Endpoint
public class WebServiceEndpointRentbook {

    private static final String NAMESPACE_URI = "http://javainuse.com";

    @Autowired
    RentService rentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbook")
    @ResponsePayload
    public OutputSOARentbook getRentbook(@RequestPayload InputSOARentbook request,
                                 @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);
        OutputSOARentbook response=null;
        List<Rentbook> output= rentService.findAll();
        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOARentbook();
        response.getResult().addAll(output);

        return response;
    }

    private Authentication getAuthentication(SoapHeaderElement header){
        Authentication authentication = null;
        try {

            JAXBContext context = JAXBContext.newInstance(Authentication.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            authentication = (Authentication) unmarshaller.unmarshal(header.getSource());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return authentication;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbookById")
    @ResponsePayload
    public OutputSOARentbookById hello(@RequestPayload InputSOARentbookById request,
                                   @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        Rentbook output= rentService.findById(request.getId());

        ObjectFactory factory = new ObjectFactory();
        OutputSOARentbookById response = factory.createOutputSOARentbookById();
        response.setResult(output);

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbookAdd")
    @ResponsePayload
    public OutputSOAddConfirm Add(@RequestPayload InputSOARentbookAdd request,
                                  @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        ObjectFactory factory = new ObjectFactory();
        OutputSOAddConfirm response = factory.createOutputSOAddConfirm();
        String result = rentService.add(request.getRentbook());

        response.setResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbookDel")
    @ResponsePayload
    public OutputSODelConfirm Del(@RequestPayload InputSOARentbookDel request,
                                  @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        ObjectFactory factory = new ObjectFactory();
        OutputSODelConfirm response = factory.createOutputSODelConfirm();
        String result;

        rentService.delete(request.getRentbook());

        response.setResult("Ok");
        return response;
    }
}
