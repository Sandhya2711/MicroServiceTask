package com.psl.assessment.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.psl.assessment.model.Question;
import com.psl.assessment.model.QuestionForm;
import com.psl.assessment.model.QuestionList;
import com.psl.assessment.model.UserAssessment;

@RestController
@RequestMapping("/assessment")
public class AssessmentResource {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/form")
	public List<QuestionForm> getQuestionForm()
	{
		List<QuestionForm> formList = new ArrayList<QuestionForm>();
		
		QuestionList queList = restTemplate.getForObject("http://localhost:8085/questions/getquestion",QuestionList.class);
		for(Question ques : queList.getQuestionList())
		{
			QuestionForm form = new QuestionForm(ques.getQuestionId(), ques.getQuestionType(), ques.getQuestionType(), ques.getOption1(),ques.getOption2(),ques.getOption3(),ques.getOption4());
			formList.add(form);
		}
		
		return formList;
	}
	
	@GetMapping("/form/{type}")
	public List<QuestionForm> getQuestionFormByType(@PathVariable("type") String type)
	{
		List<QuestionForm> formList = new ArrayList<QuestionForm>();
		
		QuestionList queList = restTemplate.getForObject("http://localhost:8085/questions/getquestion/"+type,QuestionList.class);
		for(Question ques : queList.getQuestionList())
		{
			QuestionForm form = new QuestionForm(ques.getQuestionId(), ques.getQuestionType(), ques.getQuestionType(), ques.getOption1(),ques.getOption2(),ques.getOption3(),ques.getOption4());
			formList.add(form);
		}
		
		return formList;
	}
	
	@PostMapping("/submitform/{userId}")
	public UserAssessment getUserResponse(@RequestBody UserAssessment userAssessment)
	{
		UserAssessment userAssessmentResponse = restTemplate.postForObject("http://localhost:8089/userassessment/"+userAssessment.getAssessmentId(),userAssessment, UserAssessment.class);
		return userAssessmentResponse;
	}
	
	@GetMapping("/result")
	public String getResult()
	{
		String result = restTemplate.getForObject("http://localhost:8089/userassessment/result", String.class);
		return result;
	}
}
