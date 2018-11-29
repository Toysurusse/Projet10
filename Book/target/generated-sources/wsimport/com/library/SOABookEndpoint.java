
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
@WebService(name = "SOABookEndpoint", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOABookEndpoint {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOABook
     */
    @WebMethod(operationName = "SOABook", action = "http://library.com")
    @WebResult(name = "outputSOABook", targetNamespace = "http://library.com", partName = "out")
    public OutputSOABook soaBook(
        @WebParam(name = "inputSOABook", targetNamespace = "http://library.com", partName = "in")
        InputSOABook in);

}
