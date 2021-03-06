
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
@WebService(name = "SOAUserdel", targetNamespace = "http://library.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAUserdel {


    /**
     * 
     * @param in
     * @return
     *     returns com.library.OutputSOAUserDelConfirm
     */
    @WebMethod(operationName = "SOAUserdel", action = "http://library.com")
    @WebResult(name = "outputSOAUserDelConfirm", targetNamespace = "http://library.com", partName = "out")
    public OutputSOAUserDelConfirm soaUserdel(
        @WebParam(name = "inputSOAUserDel", targetNamespace = "http://library.com", partName = "in")
        InputSOAUserDel in);

}
