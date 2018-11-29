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
package action;

import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import com.library.Book;
import com.library.OutputSOABook;
import com.library.OutputSOABookSearch;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class IndexActionTest {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexActionTest.class);

    private IndexAction action = new IndexAction();

    private List<Book> book=new ArrayList<>();

    @Mock
    private WebServiceTemplate webServiceTemplate;
    @Mock
    private OutputSOABook outputSOABook;
    @Mock
    private OutputSOABookSearch outputSOABookSearch;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void MockTestIndex() throws Exception {
        Book book = new Book();
        book.setId(1);
        outputSOABook.getResult().add(book);
        when(webServiceTemplate.marshalSendAndReceive(any()))
                .thenReturn(outputSOABook);
        when(outputSOABook.getResult()).thenReturn(Collections.singletonList(book));
/*        LOGGER.info(action.execute());
        assertNotNull(action.execute());*/
    }
/*
    @Test
    public void IntégrationTestIndex() throws Exception {
        action.search="Test";
        assertNotNull(action.search());
    }*/
}
