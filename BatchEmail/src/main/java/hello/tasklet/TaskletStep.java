package hello.tasklet;

import client.Authentication;
import client.rent.SoapClientRentConfig;
import com.javainuse.Latebook;
import com.javainuse.OutputSOARentbookLate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class TaskletStep implements Tasklet{

	@Autowired
	HtmlEmailExampleController emailExampleController;

	private static final Logger log = LoggerFactory.getLogger(TaskletStep.class);
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("test");
	    TimeUnit.SECONDS.sleep(3);

		List<Latebook> bookList=new ArrayList<>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
		client.rent.Rent client = context.getBean(client.rent.Rent.class);
        System.out.println("test");
        TimeUnit.SECONDS.sleep(3);
		OutputSOARentbookLate response = client.getRentbookLate(new Authentication("username","password"));
		bookList=response.getResult();
        System.out.println("test");
        TimeUnit.SECONDS.sleep(3);
		for (Latebook b:bookList
				) {
            System.out.println("test");
            TimeUnit.SECONDS.sleep(3);
			emailExampleController.sendHtmlEmail(b.getMail(),b.getPseudo(),b.getBookname());
			log.info("Mail sent to : " + b.getMail() + ")");
		}
		return null;
	}
}