package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.AnswerDTO;
import com.greenfox.exam.spring.model.ListOfProjects;
import com.greenfox.exam.spring.model.ProjectToDecode;
import com.greenfox.exam.spring.model.QuizQuestions;
import com.greenfox.exam.spring.repository.ProjectRepository;
import com.greenfox.exam.spring.repository.QuestionAnswerRepository;
import com.greenfox.exam.spring.service.RandomNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainRestController {

  int quizId = 0;

  long idsToGet[] = {1, 2, 3, 4, 5};

  @Autowired
  ProjectRepository projectRepository;

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
    quizId += 1;
    idsToGet = ids;
    return new QuizQuestions(quizId, questions, ids);
  }

  @PostMapping("/answers")
  public ListOfProjects QuizAnsweres(@RequestBody AnswerDTO answerDTO) {
    List<ProjectToDecode> emptyProjects = new ArrayList<>();
    int correctAnswers = 0;
    for (int i = 0; i < 5; i++) {
      if (answerDTO.getAnswers().get(i).getAnswer().equals(questionAnswerRepository.findOne(idsToGet[i]).getAnswer())) {
        correctAnswers += 1;
      }
    }
    if (correctAnswers == 5) {
      return new ListOfProjects(projectRepository.findAllByOrderById());
    }
    return new ListOfProjects(emptyProjects);
  }
}
