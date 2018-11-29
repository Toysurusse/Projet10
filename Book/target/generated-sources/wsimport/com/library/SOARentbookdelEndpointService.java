
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
@WebServiceClient(name = "SOARentbookdelEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://localhost:8085/library/ws/library.wsdl")
public class SOARentbookdelEndpointService
    extends Service
{

    private final static URL SOARENTBOOKDELENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOARENTBOOKDELENDPOINTSERVICE_EXCEPTION;
    private final static QName SOARENTBOOKDELENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOARentbookdelEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8085/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOARENTBOOKDELENDPOINTSERVICE_WSDL_LOCATION = url;
        SOARENTBOOKDELENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOARentbookdelEndpointService() {
        super(__getWsdlLocation(), SOARENTBOOKDELENDPOINTSERVICE_QNAME);
    }

    public SOARentbookdelEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOARENTBOOKDELENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookdelEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOARENTBOOKDELENDPOINTSERVICE_QNAME);
    }

    public SOARentbookdelEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOARENTBOOKDELENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookdelEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOARentbookdelEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOARentbookdel
     */
    @WebEndpoint(name = "SOARentbookdelEndpoint")
    public SOARentbookdel getSOARentbookdelEndpoint() {
        return super.getPort(new QName("http://library.com", "SOARentbookdelEndpoint"), SOARentbookdel.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOARentbookdel
     */
    @WebEndpoint(name = "SOARentbookdelEndpoint")
    public SOARentbookdel getSOARentbookdelEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOARentbookdelEndpoint"), SOARentbookdel.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOARENTBOOKDELENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOARENTBOOKDELENDPOINTSERVICE_EXCEPTION;
        }
        return SOARENTBOOKDELENDPOINTSERVICE_WSDL_LOCATION;
    }

}
