
package com.javainuse;

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
@WebService(name = "SOARentbookByIdEndpoint", targetNamespace = "http://javainuse.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOARentbookByIdEndpoint {


    /**
     * 
     * @param in
     * @return
     *     returns com.javainuse.OutputSOARentbookById
     */
    @WebMethod(operationName = "SOARentbookById", action = "http://javainuse.com")
    @WebResult(name = "outputSOARentbookById", targetNamespace = "http://javainuse.com", partName = "out")
    public OutputSOARentbookById soaRentbookById(
        @WebParam(name = "inputSOARentbookById", targetNamespace = "http://javainuse.com", partName = "in")
        InputSOARentbookById in);

}
