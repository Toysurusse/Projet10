
package com.library;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SOAShopSearchEndpoint", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAShopSearchEndpoint {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOAShopSearch
     */
    @WebMethod(operationName = "SOAShopSearch", action = "http://library.com")
    @WebResult(name = "outputSOAShopSearch", targetNamespace = "http://library.com", partName = "out")
    public OutputSOAShopSearch soaShopSearch(
        @WebParam(name = "inputSOAShopSearch", targetNamespace = "http://library.com", partName = "in")
        InputSOAShopSearch in);

}