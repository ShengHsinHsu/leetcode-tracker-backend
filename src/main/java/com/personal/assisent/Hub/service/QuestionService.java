package com.personal.assisent.Hub.service;

import com.personal.assisent.Hub.entity.postgres.Question;
import com.personal.assisent.Hub.entity.postgres.Record;
import com.personal.assisent.Hub.entity.postgres.Tag;
import com.personal.assisent.Hub.repository.QuestionRepository;
import com.personal.assisent.Hub.repository.RecordRepository;
import com.personal.assisent.Hub.repository.TagRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @PersistenceContext
    private EntityManager entityManager;

    private QuestionRepository questionRepository;
    private RecordRepository recordRepository;
    private TagRepository tagRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, RecordRepository recordRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.recordRepository = recordRepository;
        this.tagRepository = tagRepository;
    }

    public List<Question> fetchQuestionList() {
        return questionRepository.findAll();
    }

    public List<Question> fetchAll() {
        return questionRepository.findAll();
    }

    @Transactional
    public Question saveQuestion(Question newQuestion) {
        newQuestion = questionRepository.saveAndFlush(newQuestion);
        entityManager.refresh(newQuestion);
        return newQuestion;
    }

    @Transactional
    public Question findQuestion(Question question) {
        Question new_question = questionRepository.findById(question.getQuestionId()).orElse(new Question());
        entityManager.refresh(new_question);
        return new_question;
    }

    @Transactional
    public void deleteAll() {
        questionRepository.deleteAll();
    }

    public Question getQuestion(UUID uuid) {
        return questionRepository.findById(uuid).orElse(new Question());
    }

}
