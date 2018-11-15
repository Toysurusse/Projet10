
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
@WebServiceClient(name = "SOARentbookBackEndpointService", targetNamespace = "http://library.com", wsdlLocation = "http://localhost:8085/library/ws/library.wsdl")
public class SOARentbookBackEndpointService
    extends Service
{

    private final static URL SOARENTBOOKBACKENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOARENTBOOKBACKENDPOINTSERVICE_EXCEPTION;
    private final static QName SOARENTBOOKBACKENDPOINTSERVICE_QNAME = new QName("http://library.com", "SOARentbookBackEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8085/library/ws/library.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOARENTBOOKBACKENDPOINTSERVICE_WSDL_LOCATION = url;
        SOARENTBOOKBACKENDPOINTSERVICE_EXCEPTION = e;
    }

    public SOARentbookBackEndpointService() {
        super(__getWsdlLocation(), SOARENTBOOKBACKENDPOINTSERVICE_QNAME);
    }

    public SOARentbookBackEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOARENTBOOKBACKENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookBackEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SOARENTBOOKBACKENDPOINTSERVICE_QNAME);
    }

    public SOARentbookBackEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOARENTBOOKBACKENDPOINTSERVICE_QNAME, features);
    }

    public SOARentbookBackEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOARentbookBackEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOARentbookBack
     */
    @WebEndpoint(name = "SOARentbookBackEndpoint")
    public SOARentbookBack getSOARentbookBackEndpoint() {
        return super.getPort(new QName("http://library.com", "SOARentbookBackEndpoint"), SOARentbookBack.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOARentbookBack
     */
    @WebEndpoint(name = "SOARentbookBackEndpoint")
    public SOARentbookBack getSOARentbookBackEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://library.com", "SOARentbookBackEndpoint"), SOARentbookBack.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOARENTBOOKBACKENDPOINTSERVICE_EXCEPTION!= null) {
            throw SOARENTBOOKBACKENDPOINTSERVICE_EXCEPTION;
        }
        return SOARENTBOOKBACKENDPOINTSERVICE_WSDL_LOCATION;
    }

}
