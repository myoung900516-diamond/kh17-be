package com.kh.spring12.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.quiz.Choice;
import com.kh.spring12.entity.quiz.Question;
import com.kh.spring12.repo.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QuestionInsertTest01 {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	public void test() {
		//문항과 보기4개를 합쳐서 등록
		Question question = Question.builder()
							.questionContent("선호하는 블라우저 색은?")
						.build();
		
		question.getChoices().add(Choice.builder().choiceContent("검정색").answer(false).question(question).build());
		question.getChoices().add(Choice.builder().choiceContent("아이보리색").answer(true).question(question).build());
		question.getChoices().add(Choice.builder().choiceContent("남색").answer(false).question(question).build());
		question.getChoices().add(Choice.builder().choiceContent("보라색").answer(false).question(question).build());
		
		questionRepository.save(question);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
