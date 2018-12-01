
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
@WebService(name = "SOABookdel", targetNamespace = "http://javainuse.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOABookdel {


    /**
     * 
     * @param in
     * @return
     *     returns com.javainuse.OutputSOAddConfirm
     */
    @WebMethod(operationName = "SOABookdel", action = "http://javainuse.com")
    @WebResult(name = "outputSOAddConfirm", targetNamespace = "http://javainuse.com", partName = "out")
    public OutputSOAddConfirm soaBookdel(
        @WebParam(name = "inputSOABookDel", targetNamespace = "http://javainuse.com", partName = "in")
        InputSOABookDel in);

}
