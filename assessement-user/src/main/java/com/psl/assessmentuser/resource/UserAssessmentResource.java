package com.psl.assessmentuser.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.psl.assessmentuser.model.Answer;
import com.psl.assessmentuser.model.Question;
import com.psl.assessmentuser.model.QuestionList;
import com.psl.assessmentuser.model.UserAssessment;

@RestController
@RequestMapping("/userassessment")
public class UserAssessmentResource {

	@Autowired
	RestTemplate restTemplate;
	
	UserAssessment userAssessment;
	
	@PostMapping("/{userId}")
	public UserAssessment getUserResponse(@RequestBody UserAssessment userAssessment)
	{
		this.userAssessment = userAssessment;
		return this.userAssessment;
	}
	
	@GetMapping("/result")
	public String getUserResult()
	{
		int marks=0;
		List<Answer> userAnswer = this.userAssessment.getAnsList();
		QuestionList queList = restTemplate.getForObject("http://localhost:8085/questions/getquestion",QuestionList.class);
		for(Answer ans : userAnswer)
		{	
			for(Question ques : queList.getQuestionList())
			{
				if(ques.getQuestionId().equals(ans.getQid())&&ques.getRightOption().equals(ans.getAns()))
					marks+=1;
			}
		}
		return "Your current marks are :- "+marks;
	}
}
