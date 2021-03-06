
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
@WebService(name = "SOAShopByIdEndpoint", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAShopByIdEndpoint {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOAShopById
     */
    @WebMethod(operationName = "SOAShopById", action = "http://library.com")
    @WebResult(name = "outputSOAShopById", targetNamespace = "http://library.com", partName = "out")
    public OutputSOAShopById soaShopById(
        @WebParam(name = "inputSOAShopById", targetNamespace = "http://library.com", partName = "in")
        InputSOAShopById in);

}
