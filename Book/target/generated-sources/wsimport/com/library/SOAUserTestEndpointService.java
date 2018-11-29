
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
@WebServiceClient(name = "SOAUserTestEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://localhost:8085/library/ws/library.wsdl")
public class SOAUserTestEndpointService
    extends Service
{

    private final static URL SOAUSERTESTENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAUSERTESTENDPOINTSERVICE_EXCEPTION;
    private final static QName SOAUSERTESTENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOAUserTestEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8085/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAUSERTESTENDPOINTSERVICE_WSDL_LOCATION = url;
        SOAUSERTESTENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOAUserTestEndpointService() {
        super(__getWsdlLocation(), SOAUSERTESTENDPOINTSERVICE_QNAME);
    }

    public SOAUserTestEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAUSERTESTENDPOINTSERVICE_QNAME, features);
    }

    public SOAUserTestEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOAUSERTESTENDPOINTSERVICE_QNAME);
    }

    public SOAUserTestEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAUSERTESTENDPOINTSERVICE_QNAME, features);
    }

    public SOAUserTestEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAUserTestEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOAUserTest
     */
    @WebEndpoint(name = "SOAUserTestEndpoint")
    public SOAUserTest getSOAUserTestEndpoint() {
        return super.getPort(new QName("http://library.com", "SOAUserTestEndpoint"), SOAUserTest.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOAUserTest
     */
    @WebEndpoint(name = "SOAUserTestEndpoint")
    public SOAUserTest getSOAUserTestEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOAUserTestEndpoint"), SOAUserTest.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAUSERTESTENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOAUSERTESTENDPOINTSERVICE_EXCEPTION;
        }
        return SOAUSERTESTENDPOINTSERVICE_WSDL_LOCATION;
    }

}
