package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.ListOfProjects;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetAnsweres {

  public ListOfProjects getAnswerlist() {
    RestTemplate restTemplate = new RestTemplate();
    ListOfProjects answer = new ListOfProjects();
    try {
      answer = restTemplate.postForObject("https://springexamserver.herokuapp.com/projects/sabers", "req", ListOfProjects.class);
    } catch (Exception e) {
      System.out.println(e);
    }
    return answer;
  }
}
