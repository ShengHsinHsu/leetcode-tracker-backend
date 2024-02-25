package com.personal.assisent.Hub.controllers;


import com.personal.assisent.Hub.entity.postgres.Question;
import com.personal.assisent.Hub.entity.postgres.Record;
import com.personal.assisent.Hub.entity.postgres.Tag;
import com.personal.assisent.Hub.model.Testing;
import com.personal.assisent.Hub.repository.QuestionRepository;
import com.personal.assisent.Hub.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TestPostgresController {
    private QuestionService questionService;
    @Autowired
    public TestPostgresController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/testing1")
    public Testing testPostgres1() {
        List<Question> questions = questionService.fetchQuestionList();
        System.out.println(questions);

        return new Testing("testingfindAll");
    }
    @GetMapping("/testing2")
    public List<Question> testPostgres2() {
        List<Question> questions = questionService.fetchAll();
        questions.forEach(x -> System.out.println(x.getQuestionId() + ", " + x.getRecord()));
        return questions;
    }

    @GetMapping("/testing3")
    public Question testingPostgres3() {
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
        return questionService.saveQuestion(question);

//        return questionService.findQuestion(questionService.saveQuestion(question));
    }
}
