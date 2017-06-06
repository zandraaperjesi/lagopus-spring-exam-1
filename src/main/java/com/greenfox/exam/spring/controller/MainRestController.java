package com.greenfox.exam.spring.controller;


import com.greenfox.exam.spring.model.QuizQuestions;
import com.greenfox.exam.spring.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

  @Autowired
  QuestionAnswerRepository questionAnswerRepository;

  @GetMapping("/questions")
  public QuizQuestions getQuestions() {

    String[] questions = new String[5];
    long[] ids = new long[5];
    for (int i = 1; i < 6; i++) {
      questions[i - 1] = questionAnswerRepository.findOne((long)i).getQuestion();
      ids[i - 1] = questionAnswerRepository.findOne((long)i).getId();
    }
    return new QuizQuestions(1, questions);
  }
}
