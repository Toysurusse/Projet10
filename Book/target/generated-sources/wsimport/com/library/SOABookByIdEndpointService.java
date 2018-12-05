
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
@WebServiceClient(name = "SOABookByIdEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl")
public class SOABookByIdEndpointService
    extends Service
{

    private final static URL SOABOOKBYIDENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOABOOKBYIDENDPOINTSERVICE_EXCEPTION;
    private final static QName SOABOOKBYIDENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOABookByIdEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOABOOKBYIDENDPOINTSERVICE_WSDL_LOCATION = url;
        SOABOOKBYIDENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOABookByIdEndpointService() {
        super(__getWsdlLocation(), SOABOOKBYIDENDPOINTSERVICE_QNAME);
    }

    public SOABookByIdEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOABOOKBYIDENDPOINTSERVICE_QNAME, features);
    }

    public SOABookByIdEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOABOOKBYIDENDPOINTSERVICE_QNAME);
    }

    public SOABookByIdEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOABOOKBYIDENDPOINTSERVICE_QNAME, features);
    }

    public SOABookByIdEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOABookByIdEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOABookByIdEndpoint
     */
    @WebEndpoint(name = "SOABookByIdEndpoint")
    public SOABookByIdEndpoint getSOABookByIdEndpoint() {
        return super.getPort(new QName("http://library.com", "SOABookByIdEndpoint"), SOABookByIdEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOABookByIdEndpoint
     */
    @WebEndpoint(name = "SOABookByIdEndpoint")
    public SOABookByIdEndpoint getSOABookByIdEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOABookByIdEndpoint"), SOABookByIdEndpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOABOOKBYIDENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOABOOKBYIDENDPOINTSERVICE_EXCEPTION;
        }
        return SOABOOKBYIDENDPOINTSERVICE_WSDL_LOCATION;
    }

}
