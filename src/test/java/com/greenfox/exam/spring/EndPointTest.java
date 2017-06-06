package com.greenfox.exam.spring;

import com.greenfox.exam.spring.model.QuestionAnswer;
import com.greenfox.exam.spring.repository.QuestionAnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.ArrayList;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EndPointTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private QuestionAnswerRepository questionAnswerRepository;

  @Test
  public void getQuestionAnwseres() throws Exception {
    ArrayList<QuestionAnswer> toReturn = new ArrayList<>();
    toReturn.add(new QuestionAnswer("asd", "asd"));
    toReturn.add(new QuestionAnswer("qwe", "qwe"));
    BDDMockito.given(questionAnswerRepository.findAllByOrderById())
            .willReturn(
                    toReturn
            );
    mockMvc.perform(get("/questions")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$[0].question", is("asd")))
            .andExpect(jsonPath("$[0].answer", is("asd")))
            .andExpect(jsonPath("$[1].question", is("qwe")));
  }

  @Test
  public void getQuestionAnwseresSize() throws Exception {
    ArrayList<QuestionAnswer> toReturn = new ArrayList<>();
    toReturn.add(new QuestionAnswer("asdasd", "asdasd"));
    toReturn.add(new QuestionAnswer("qweqwe", "qweqwe"));
    BDDMockito.given(questionAnswerRepository.findAllByOrderById())
            .willReturn(
                    toReturn
            );
    mockMvc.perform(get("/questions")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.*", hasSize(2)));
  }

}
