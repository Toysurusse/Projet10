
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
@WebServiceClient(name = "SOABookdelEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl")
public class SOABookdelEndpointService
    extends Service
{

    private final static URL SOABOOKDELENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOABOOKDELENDPOINTSERVICE_EXCEPTION;
    private final static QName SOABOOKDELENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOABookdelEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.14:8082/spring-boot-soap-0.0.1-SNAPSHOT/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOABOOKDELENDPOINTSERVICE_WSDL_LOCATION = url;
        SOABOOKDELENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOABookdelEndpointService() {
        super(__getWsdlLocation(), SOABOOKDELENDPOINTSERVICE_QNAME);
    }

    public SOABookdelEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOABOOKDELENDPOINTSERVICE_QNAME, features);
    }

    public SOABookdelEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOABOOKDELENDPOINTSERVICE_QNAME);
    }

    public SOABookdelEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOABOOKDELENDPOINTSERVICE_QNAME, features);
    }

    public SOABookdelEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOABookdelEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOABookdel
     */
    @WebEndpoint(name = "SOABookdelEndpoint")
    public SOABookdel getSOABookdelEndpoint() {
        return super.getPort(new QName("http://library.com", "SOABookdelEndpoint"), SOABookdel.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOABookdel
     */
    @WebEndpoint(name = "SOABookdelEndpoint")
    public SOABookdel getSOABookdelEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOABookdelEndpoint"), SOABookdel.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOABOOKDELENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOABOOKDELENDPOINTSERVICE_EXCEPTION;
        }
        return SOABOOKDELENDPOINTSERVICE_WSDL_LOCATION;
    }

}
