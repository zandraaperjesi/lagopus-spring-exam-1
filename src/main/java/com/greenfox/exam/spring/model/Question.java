package com.greenfox.exam.spring.model;

public class Question {
  private long id;
  private String question;

  public Question(long id, String question) {
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
