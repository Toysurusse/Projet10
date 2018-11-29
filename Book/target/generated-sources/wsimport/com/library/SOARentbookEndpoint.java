
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
@WebService(name = "SOARentbookEndpoint", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOARentbookEndpoint {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOARentbook
     */
    @WebMethod(operationName = "SOARentbook", action = "http://library.com")
    @WebResult(name = "outputSOARentbook", targetNamespace = "http://library.com", partName = "out")
    public OutputSOARentbook soaRentbook(
        @WebParam(name = "inputSOARentbook", targetNamespace = "http://library.com", partName = "in")
        InputSOARentbook in);

}
