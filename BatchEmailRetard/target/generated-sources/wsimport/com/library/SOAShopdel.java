
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
@WebService(name = "SOAShopdel", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAShopdel {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOAShopDelConfirm
     */
    @WebMethod(operationName = "SOAShopdel", action = "http://library.com")
    @WebResult(name = "outputSOAShopDelConfirm", targetNamespace = "http://library.com", partName = "out")
    public OutputSOAShopDelConfirm soaShopdel(
        @WebParam(name = "inputSOAShopDel", targetNamespace = "http://library.com", partName = "in")
        InputSOAShopDel in);

}
