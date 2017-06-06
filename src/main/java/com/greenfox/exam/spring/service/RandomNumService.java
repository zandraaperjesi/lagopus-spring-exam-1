package com.greenfox.exam.spring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomNumService {

  public List<Integer> questionsToPick(int size) {
    int counter = 0;
    List<Integer> toReturn = new ArrayList<>();
    while(toReturn.size() < 5) {
      int buffer = (int) (Math.random() * size + 1);
      if(!toReturn.contains(buffer)) {
        toReturn.add(buffer);
      }
    }
    return toReturn;
  }
}