/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Book;

import client.Authentication;
import com.javainuse.OutputSOABook;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 */
@Conversion()
public class IndexAction extends ActionSupport {
    
    private Date now = new Date(System.currentTimeMillis());
    @TypeConversion(converter = "book.DateConverter")
    public Date getDateNow() { return now; }
    
    public String execute() throws Exception {

        /*SOABookEndpointService test = new SOABookEndpointService();
        InputSOABook testin=new InputSOABook();
        testin.setTest("Test");
        OutputSOABook test2=new OutputSOABook();
        test2=test.getSOABookEndpoint().soaBook(testin);
        System.out.println(test2.getResult().get(0).getBookName());*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));

        System.out.println(response.getResult().get(0).getId()+" "+response.getResult().get(0).getAuthor() );

        now = new Date(System.currentTimeMillis());
        return SUCCESS;
    }
}
