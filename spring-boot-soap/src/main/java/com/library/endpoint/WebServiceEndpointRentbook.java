package com.library.endpoint;

import com.library.*;
import com.library.config.Authentication;
import com.library.mail.HtmlEmailExampleController;
import com.library.service.RentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;

@Endpoint
public class WebServiceEndpointRentbook {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceEndpointRentbook.class);

    private static final String NAMESPACE_URI = "http://library.com";

        @Autowired
        RentService rentService;

        @Autowired
        HtmlEmailExampleController mailer;

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

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbookLate")
        @ResponsePayload
        public OutputSOARentbookLate getRentbookLate(@RequestPayload InputSOARentbookLate request,
                                                     @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {


            Authentication authentication = getAuthentication(auth);
            OutputSOARentbookLate response=null;

            if(request.getTest().equals("Test")){
                List<Latebook> output= rentService.findByLate();
                ObjectFactory factory = new ObjectFactory();
                response = factory.createOutputSOARentbookLate();
                response.getResult().addAll(output);
            }
            if(request.getTest().equals("48h")){
                List<Latebook> output= rentService.findByEnd();
                ObjectFactory factory = new ObjectFactory();
                response = factory.createOutputSOARentbookLate();
                response.getResult().addAll(output);
            }

            return response;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbookByUser")
        @ResponsePayload
        public OutputSOARentbookByUser getRentbookByUser(@RequestPayload InputSOARentbookByUser request,
                                                         @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {
            Authentication authentication = getAuthentication(auth);
            OutputSOARentbookByUser response=null;
            List<Rentbook> output= rentService.findByUserId(request.getId());
            ObjectFactory factory = new ObjectFactory();
            response = factory.createOutputSOARentbookByUser();
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
        public OutputSOARentbookAddConfirm Add(@RequestPayload InputSOARentbookAdd request,
                                               @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

            Authentication authentication = getAuthentication(auth);

            ObjectFactory factory = new ObjectFactory();
            OutputSOARentbookAddConfirm response = factory.createOutputSOARentbookAddConfirm();

            String result = "Test";

            for (Rentbook r:request.getResult()
                 ) {
                result = rentService.add(r);
            }
            if (request.getResult().get(0).getRentid()==0) {
                try {
                    mailer.sendHtmlEmail(rentService.extractForMail(request.getResult()));
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            response.setResult(result);
            return response;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOARentbookBack")
        @ResponsePayload
        public OutputSOARentbookBackConfirm Back(@RequestPayload InputSOARentbookBack request,
                                                 @SoapHeader("{" + Authentication.AUTH_NS +"}authentication") SoapHeaderElement auth) {

            Authentication authentication = getAuthentication(auth);

            ObjectFactory factory = new ObjectFactory();
            OutputSOARentbookBackConfirm response = factory.createOutputSOARentbookBackConfirm();
            String result = rentService.back(request.getRentbook());

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

            rentService.add(request.getRentbook());

            response.setResult("Ok");
            return response;
        }
    }
