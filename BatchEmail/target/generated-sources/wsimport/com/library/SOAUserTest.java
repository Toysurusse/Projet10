
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
@WebService(name = "SOAUserTest", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAUserTest {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOAUserTest
     */
    @WebMethod(operationName = "SOAUserTest", action = "http://library.com")
    @WebResult(name = "outputSOAUserTest", targetNamespace = "http://library.com", partName = "out")
    public OutputSOAUserTest soaUserTest(
        @WebParam(name = "inputSOAUserTest", targetNamespace = "http://library.com", partName = "in")
        InputSOAUserTest in);

}
