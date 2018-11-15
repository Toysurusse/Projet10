
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
@WebServiceClient(name = "SOAShopaddEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://localhost:8085/library/ws/library.wsdl")
public class SOAShopaddEndpointService
    extends Service
{

    private final static URL SOASHOPADDENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOASHOPADDENDPOINTSERVICE_EXCEPTION;
    private final static QName SOASHOPADDENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOAShopaddEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8085/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOASHOPADDENDPOINTSERVICE_WSDL_LOCATION = url;
        SOASHOPADDENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOAShopaddEndpointService() {
        super(__getWsdlLocation(), SOASHOPADDENDPOINTSERVICE_QNAME);
    }

    public SOAShopaddEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOASHOPADDENDPOINTSERVICE_QNAME, features);
    }

    public SOAShopaddEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOASHOPADDENDPOINTSERVICE_QNAME);
    }

    public SOAShopaddEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOASHOPADDENDPOINTSERVICE_QNAME, features);
    }

    public SOAShopaddEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAShopaddEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOAShopadd
     */
    @WebEndpoint(name = "SOAShopaddEndpoint")
    public SOAShopadd getSOAShopaddEndpoint() {
        return super.getPort(new QName("http://library.com", "SOAShopaddEndpoint"), SOAShopadd.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOAShopadd
     */
    @WebEndpoint(name = "SOAShopaddEndpoint")
    public SOAShopadd getSOAShopaddEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOAShopaddEndpoint"), SOAShopadd.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOASHOPADDENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOASHOPADDENDPOINTSERVICE_EXCEPTION;
        }
        return SOASHOPADDENDPOINTSERVICE_WSDL_LOCATION;
    }

}
