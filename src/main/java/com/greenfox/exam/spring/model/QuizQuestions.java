package com.greenfox.exam.spring.model;

public class QuizQuestions {
  private long id;
  private Question[] questions = new Question[5];

  public QuizQuestions(long id, String[] questions, long[] ids) {
    this.id = id;
    for (int i = 0; i < questions.length; i++) {
      this.questions[i] = new Question(ids[i], questions[i]);
      System.out.println(questions[i]);
    }
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Question[] getQuestions() {
    return questions;
  }

  public void setQuestions(Question[] questions) {
    this.questions = questions;
  }
}
