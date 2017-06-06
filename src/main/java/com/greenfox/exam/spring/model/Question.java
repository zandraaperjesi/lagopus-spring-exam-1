package com.greenfox.exam.spring.model;

public class Question {
  private String question;
  private long id;

  public Question(String question, long id) {
    this.question = question;
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }
}
