package com.psl.assessmentquestions.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.assessmentquestions.model.Question;
import com.psl.assessmentquestions.model.QuestionList;

@RestController
@RequestMapping("/questions")
public class QuestionResource {
	
	@Autowired
	public List<Question> questionList;
	
	@RequestMapping("/getquestion")
	public QuestionList getQuestions()
	{
		return new QuestionList(questionList); 
	}
	
	@RequestMapping("/getquestion/{questionType}")
	public QuestionList getQuestionsByType(@PathVariable("questionType") String questionType)
	{
		List<Question> questionListByType = new ArrayList<Question>();
		for(Question ques : questionList)
		{
			if(ques.getQuestionType().equals(questionType))
				questionListByType.add(ques);
		}
		return new QuestionList(questionListByType); 
	}
	
}
