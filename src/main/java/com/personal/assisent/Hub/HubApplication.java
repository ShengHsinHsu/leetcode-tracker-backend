package com.personal.assisent.Hub;

import com.personal.assisent.Hub.entity.postgres.Question;
import com.personal.assisent.Hub.entity.postgres.Record;
import com.personal.assisent.Hub.entity.postgres.Tag;
import com.personal.assisent.Hub.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HubApplication {


	public static void main(String[] args) {
		SpringApplication.run(HubApplication.class, args);
	}

	@Bean
	public CommandLineRunner startUp(QuestionService questionService) {
		return args -> {
			System.out.println("\n:: Pre-setup :: \n");
			System.out.println("Delete All Data in Question");
			questionService.deleteAll();

			System.out.println("::Adding Testing Data::");
			addTestingData(questionService);
			System.out.println("\n:: Pre-setup End :: \n");
		};
	}

	void addTestingData(QuestionService questionService) {
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag("tag1"));
		tags.add(new Tag("tag2"));

		List<Record> records = new ArrayList<>();
		records.add(new Record(LocalDateTime.now(), false));
		records.add(new Record(LocalDateTime.now(), true));

		Question question = new Question();
		question.setTitle("testing insert");
		question.setTopic("insert Topic");
		question.setIsImportant(false);
		question.setNoteLink("https://google.aexp.com");
		question.setTag(tags);
		question.setRecord(records);
		questionService.saveQuestion(question);
		System.out.println("\nPlease go to the page: /api/v1/questions/search To see all the data\n");
	}


}
