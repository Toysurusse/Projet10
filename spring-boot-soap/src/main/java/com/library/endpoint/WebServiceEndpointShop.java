package com.library.endpoint;

import com.library.*;
import com.library.config.Authentication;
import com.library.service.ShopService;
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
public class WebServiceEndpointShop {

	private static final String NAMESPACE_URI = "http://library.com";

    @Autowired
    ShopService shopService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAShop")
    @ResponsePayload
    public OutputSOAShop getBeer(@RequestPayload InputSOAShop request,
                                 @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);
        OutputSOAShop response=null;
        List<Shop> output= shopService.findAll();
        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOAShop();
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAShopById")
    @ResponsePayload
    public OutputSOAShopById hello(@RequestPayload InputSOAShopById request,
                                   @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        Shop output= shopService.findById(request.getId());

        ObjectFactory factory = new ObjectFactory();
        OutputSOAShopById response = factory.createOutputSOAShopById();
        response.setResult(output);

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAShopAdd")
    @ResponsePayload
    public OutputSOAddConfirm Add(@RequestPayload InputSOAShopAdd request,
                                  @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

	    ObjectFactory factory = new ObjectFactory();
        OutputSOAddConfirm response = factory.createOutputSOAddConfirm();
	    String result;

        response.setResult(shopService.add(request.getShop()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAShopDel")
    @ResponsePayload
    public OutputSODelConfirm Del(@RequestPayload InputSOAShopDel request,
                                  @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        ObjectFactory factory = new ObjectFactory();
        OutputSODelConfirm response = factory.createOutputSODelConfirm();
        String result;

        shopService.add(request.getShop());

        response.setResult("Ok");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAShopSearch")
    @ResponsePayload
    public OutputSOAShopSearch getSearch(@RequestPayload InputSOAShopSearch request,
                                         @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        OutputSOAShopSearch response=null;

        List<Shop> output= shopService.findBySearch(request.getTest());

        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOAShopSearch();
        response.getResult().addAll(output);

        return response;
    }
}
