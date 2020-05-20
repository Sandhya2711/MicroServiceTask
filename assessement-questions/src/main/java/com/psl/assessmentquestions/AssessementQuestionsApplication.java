package com.psl.assessmentquestions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.psl.assessmentquestions.model.Question;

@SpringBootApplication
public class AssessementQuestionsApplication {
	
	@Bean
	public List<Question> getListOfQuestion()
	{
		List<Question> qList=new ArrayList<Question>();
		Question q1=new Question("1","Java","Q1","opt1","opt2","opt3","opt4","a");
		Question q2=new Question("2","Python","Q2","opt1","opt2","opt3","opt4","a");
		Question q3=new Question("3","Java","Q3","opt1","opt2","opt3","opt4","a");
		Question q4=new Question("4","Python","Q4","opt1","opt2","opt3","opt4","a");
		Question q5=new Question("5","Java","Q5","opt1","opt2","opt3","opt4","a");
		qList.add(q1);
		qList.add(q2);
		qList.add(q3);
		qList.add(q4);
		qList.add(q5);
		return qList;
	}
	public static void main(String[] args) {
		SpringApplication.run(AssessementQuestionsApplication.class, args);
	}

}
