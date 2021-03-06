
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
@WebServiceClient(name = "SOARentbookLateEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl")
public class SOARentbookLateEndpointService
    extends Service
{

    private final static URL SOARENTBOOKLATEENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOARENTBOOKLATEENDPOINTSERVICE_EXCEPTION;
    private final static QName SOARENTBOOKLATEENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOARentbookLateEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOARENTBOOKLATEENDPOINTSERVICE_WSDL_LOCATION = url;
        SOARENTBOOKLATEENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOARentbookLateEndpointService() {
        super(__getWsdlLocation(), SOARENTBOOKLATEENDPOINTSERVICE_QNAME);
    }

    public SOARentbookLateEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOARENTBOOKLATEENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookLateEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOARENTBOOKLATEENDPOINTSERVICE_QNAME);
    }

    public SOARentbookLateEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOARENTBOOKLATEENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookLateEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOARentbookLateEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOARentbookLateEndpoint
     */
    @WebEndpoint(name = "SOARentbookLateEndpoint")
    public SOARentbookLateEndpoint getSOARentbookLateEndpoint() {
        return super.getPort(new QName("http://library.com", "SOARentbookLateEndpoint"), SOARentbookLateEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOARentbookLateEndpoint
     */
    @WebEndpoint(name = "SOARentbookLateEndpoint")
    public SOARentbookLateEndpoint getSOARentbookLateEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOARentbookLateEndpoint"), SOARentbookLateEndpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOARENTBOOKLATEENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOARENTBOOKLATEENDPOINTSERVICE_EXCEPTION;
        }
        return SOARENTBOOKLATEENDPOINTSERVICE_WSDL_LOCATION;
    }

}
