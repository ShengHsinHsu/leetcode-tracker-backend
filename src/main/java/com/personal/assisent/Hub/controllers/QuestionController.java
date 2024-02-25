package com.personal.assisent.Hub.controllers;


import com.personal.assisent.Hub.entity.postgres.Question;
import com.personal.assisent.Hub.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

// UNLOGGED table for cache: https://martinheinz.dev/blog/105

@RestController
@RequestMapping("/api/v1/questions/search")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.fetchAll();
    }

    @GetMapping("{questionId}")
    public Question getQuestion(@PathVariable UUID questionId) {
        return questionService.getQuestion(questionId);
    }
}
