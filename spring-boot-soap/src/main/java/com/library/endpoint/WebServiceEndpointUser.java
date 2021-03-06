package com.library.endpoint;

import com.library.*;
import com.library.config.Authentication;
import com.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class WebServiceEndpointUser {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceEndpointUser.class);

    private static final String NAMESPACE_URI = "http://library.com";

    @Autowired
    UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAUser")
    @ResponsePayload
    public OutputSOAUser getBeer(@RequestPayload InputSOAUser request,
                                 @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);
        OutputSOAUser response = null;
        List<User> output = userService.findAll();
        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOAUser();
        response.getResult().addAll(output);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAUserTest")
    @ResponsePayload
    public OutputSOAUserTest control(@RequestPayload InputSOAUserTest request,
                                     @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);
        OutputSOAUserTest response = null;

        User user = new User();
        user.setPseudo(request.getPseudo());
        User output = userService.control(user);
        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOAUserTest();

        response.setUser(output);

        return response;
    }


    private Authentication getAuthentication(SoapHeaderElement header) {
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAUserById")
    @ResponsePayload
    public OutputSOAUserById hello(@RequestPayload InputSOAUserById request,
                                   @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        User output = userService.findById(request.getId());

        ObjectFactory factory = new ObjectFactory();
        OutputSOAUserById response = factory.createOutputSOAUserById();
        response.setResult(output);

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAUserAdd")
    @ResponsePayload
    public OutputSOAddConfirm Add(@RequestPayload InputSOAUserAdd request,
                                  @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        ObjectFactory factory = new ObjectFactory();
        OutputSOAddConfirm response = factory.createOutputSOAddConfirm();
        String result;

        if (authentication.getUsername().equals("username")) {
            request.getUser().setRole(1);
            response.setResult(userService.add(request.getUser()));
        }
        else if (userService.findById(Integer.parseInt(authentication.getUsername())).getRole()>2){
            response.setResult(userService.add(request.getUser()));
        }
        else{
            response.setResult("Impossible");
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOAUserDel")
    @ResponsePayload
    public OutputSODelConfirm Del(@RequestPayload InputSOAUserDel request,
                                  @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {

        Authentication authentication = getAuthentication(auth);

        ObjectFactory factory = new ObjectFactory();
        OutputSODelConfirm response = factory.createOutputSODelConfirm();
        String result;


        userService.delete(request.getUser());


        response.setResult("Ok");
        return response;
    }
}

