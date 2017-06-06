package com.greenfox.exam.spring;

import com.greenfox.exam.spring.model.QuestionAnswer;
import com.greenfox.exam.spring.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner{

  @Autowired
  QuestionAnswerRepository questionAnswerRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    questionAnswerRepository.save(new QuestionAnswer("When did your course start? (yyyy.mm.dd)", "2017.03.13"));
    questionAnswerRepository.save(new QuestionAnswer("What type of dog Barbi has?", "Whippet"));
    questionAnswerRepository.save(new QuestionAnswer("What is HerrNorbert's favourite color?", "Green"));
    questionAnswerRepository.save(new QuestionAnswer("How many classes are learning at Green Fox Academy at this moment?", "4"));
    questionAnswerRepository.save(new QuestionAnswer("How many mentors teach at Green Fox at this moment?)", "16"));
    questionAnswerRepository.save(new QuestionAnswer("What was the name of the first Green Fox class?", "Vulpes"));
    questionAnswerRepository.save(new QuestionAnswer("How many likes do we have on facebook", "~3300"));
    questionAnswerRepository.save(new QuestionAnswer("What is Tojas's horoscope?", "Libra"));
  }
}
