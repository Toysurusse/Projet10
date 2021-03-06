
package com.library;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SOARentbookByUserEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl")
public class SOARentbookByUserEndpointService
    extends Service
{

    private final static URL SOARENTBOOKBYUSERENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOARENTBOOKBYUSERENDPOINTSERVICE_EXCEPTION;
    private final static QName SOARENTBOOKBYUSERENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOARentbookByUserEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOARENTBOOKBYUSERENDPOINTSERVICE_WSDL_LOCATION = url;
        SOARENTBOOKBYUSERENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOARentbookByUserEndpointService() {
        super(__getWsdlLocation(), SOARENTBOOKBYUSERENDPOINTSERVICE_QNAME);
    }

    public SOARentbookByUserEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOARENTBOOKBYUSERENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookByUserEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOARENTBOOKBYUSERENDPOINTSERVICE_QNAME);
    }

    public SOARentbookByUserEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOARENTBOOKBYUSERENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookByUserEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOARentbookByUserEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOARentbookByUser
     */
    @WebEndpoint(name = "SOARentbookByUserEndpoint")
    public SOARentbookByUser getSOARentbookByUserEndpoint() {
        return super.getPort(new QName("http://library.com", "SOARentbookByUserEndpoint"), SOARentbookByUser.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOARentbookByUser
     */
    @WebEndpoint(name = "SOARentbookByUserEndpoint")
    public SOARentbookByUser getSOARentbookByUserEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOARentbookByUserEndpoint"), SOARentbookByUser.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOARENTBOOKBYUSERENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOARENTBOOKBYUSERENDPOINTSERVICE_EXCEPTION;
        }
        return SOARENTBOOKBYUSERENDPOINTSERVICE_WSDL_LOCATION;
    }

}
