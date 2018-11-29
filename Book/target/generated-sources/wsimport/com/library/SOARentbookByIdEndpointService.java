
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
@WebServiceClient(name = "SOARentbookByIdEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://192.168.0.17:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl")
public class SOARentbookByIdEndpointService
    extends Service
{

    private final static URL SOARENTBOOKBYIDENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOARENTBOOKBYIDENDPOINTSERVICE_EXCEPTION;
    private final static QName SOARENTBOOKBYIDENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOARentbookByIdEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.17:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOARENTBOOKBYIDENDPOINTSERVICE_WSDL_LOCATION = url;
        SOARENTBOOKBYIDENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOARentbookByIdEndpointService() {
        super(__getWsdlLocation(), SOARENTBOOKBYIDENDPOINTSERVICE_QNAME);
    }

    public SOARentbookByIdEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOARENTBOOKBYIDENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookByIdEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOARENTBOOKBYIDENDPOINTSERVICE_QNAME);
    }

    public SOARentbookByIdEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOARENTBOOKBYIDENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookByIdEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOARentbookByIdEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOARentbookByIdEndpoint
     */
    @WebEndpoint(name = "SOARentbookByIdEndpoint")
    public SOARentbookByIdEndpoint getSOARentbookByIdEndpoint() {
        return super.getPort(new QName("http://library.com", "SOARentbookByIdEndpoint"), SOARentbookByIdEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOARentbookByIdEndpoint
     */
    @WebEndpoint(name = "SOARentbookByIdEndpoint")
    public SOARentbookByIdEndpoint getSOARentbookByIdEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOARentbookByIdEndpoint"), SOARentbookByIdEndpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOARENTBOOKBYIDENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOARENTBOOKBYIDENDPOINTSERVICE_EXCEPTION;
        }
        return SOARENTBOOKBYIDENDPOINTSERVICE_WSDL_LOCATION;
    }

}
