package hello.tasklet;

import client.Authentication;
import client.rent.SoapClientRentConfig;
import com.library.Latebook;
import com.library.OutputSOARentbookLate;
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
		List<Latebook> bookList=new ArrayList<>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
		client.rent.RentClient client = context.getBean(client.rent.RentClient.class);
		OutputSOARentbookLate response = client.getRentbookLate();
		bookList=response.getResult();
		for (Latebook b:bookList
				) {
			emailExampleController.sendHtmlEmail(b.getMail(),b.getPseudo(),b.getBookname());
			log.info("Mail sent to : " + b.getMail() + ")");
		}
		return null;
	}
}