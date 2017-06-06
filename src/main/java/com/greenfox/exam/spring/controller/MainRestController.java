package com.greenfox.exam.spring.controller;


import com.greenfox.exam.spring.model.QuizQuestions;
import com.greenfox.exam.spring.repository.QuestionAnswerRepository;
import com.greenfox.exam.spring.service.RandomNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

  @Autowired
  RandomNumService randomNumService;

  @Autowired
  QuestionAnswerRepository questionAnswerRepository;

  @GetMapping("/questions")
  public QuizQuestions getQuestions() {
    List<Integer> questionsToGet = randomNumService.questionsToPick(questionAnswerRepository.findAllByOrderById().size());
    String[] questions = new String[5];
    long[] ids = new long[5];
    for (int i = 1; i < 6; i++) {
      questions[i - 1] = questionAnswerRepository.findOne((long)questionsToGet.get(i - 1)).getQuestion();
      ids[i - 1] = questionAnswerRepository.findOne((long)questionsToGet.get(i - 1)).getId();
    }
    return new QuizQuestions(1, questions, ids);
  }
}
