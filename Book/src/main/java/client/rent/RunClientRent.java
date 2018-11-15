package client.rent;

import client.Authentication;
import com.library.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RunClientRent {

    public static void main(String[] args) {
       Authentication authentication=new Authentication("username","password");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        Rent client = context.getBean(Rent.class);
        OutputSOARentbook response = client.getRentbook(authentication);

        for (int i=0;i<response.getResult().size();i++){
            System.out.println(response.getResult().get(i).getUserId()+" ; "+response.getResult().get(i).getBookId()+" ; "+response.getResult().get(i).getRentid()+" ; "+response.getResult().get(i).getCreateat()+" ; "+response.getResult().get(i).getEndat()+" ; "+response.getResult().get(i).isReload()+" ; "+response.getResult().get(i).isReturnbook());
        }

        OutputSOARentbookById outputSOARentbookById = client.getRentbookById(authentication,18);
        System.out.println(outputSOARentbookById.getResult().getUserId()+" ; "+outputSOARentbookById.getResult().getBookId()+" ; "+outputSOARentbookById.getResult().getRentid()+" ; "+outputSOARentbookById.getResult().getCreateat()+" ; "+outputSOARentbookById.getResult().getEndat()+" ; "+outputSOARentbookById.getResult().isReload()+" ; "+outputSOARentbookById.getResult().isReturnbook());

        Rentbook rentbook = new Rentbook();
        rentbook.setBookId(0);
        rentbook.setUserId(0);
        /*rentbook.setCreateat();
        rentbook.setEndat();*/
        rentbook.setReload(false);
        rentbook.setReturnbook(false);

        OutputSOARentbookAddConfirm outputSOAddConfirm = client.getRentbookAdd(authentication,rentbook);
        System.out.println(outputSOAddConfirm.getResult());
    }
}
