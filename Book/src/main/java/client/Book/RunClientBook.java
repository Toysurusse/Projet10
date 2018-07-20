package client.book;

import client.Authentication;
import com.javainuse.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunClientBook {

    public static void main(String[] args) {
       Authentication authentication=new Authentication("username","password");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        /*OutputSOABook response = client.getBook(authentication);

        for (int i=0;i<response.getResult().size();i++){
            System.out.println(response.getResult().get(i).getId()+" ; "+response.getResult().get(i).getBookName()+" ; "+response.getResult().get(i).getAuthor()+" ; "+response.getResult().get(i).getEditeurs()+" ; "+response.getResult().get(i).getNbPage());
        }
        */
        OutputSOABookById outputSOABookById = client.getBookById(authentication,1);
        System.out.println(outputSOABookById.getResult().getId()+" ; "+outputSOABookById.getResult().getBookName()+" ; "+outputSOABookById.getResult().getAuthor()+" ; "+outputSOABookById.getResult().getEditeurs()+" ; "+outputSOABookById.getResult().getNbPage());

        /*
        Book book = new Book();
        book.setId(10);
        book.setBookName("1984");
        book.setEditeurs("Hachette");
        book.setAuthor("Georges Orwell2");
        book.setNbPage(250);
        book.setDispo(true);
        */
        OutputSOAddConfirm outputSOAddConfirm = client.getBookAdd(authentication,outputSOABookById.getResult());
        System.out.println(outputSOAddConfirm.getResult());

        //OutputSODelConfirm outputSODelConfirm=client.getBookDel(authentication,outputSOABookById.getResult());

    }
}
