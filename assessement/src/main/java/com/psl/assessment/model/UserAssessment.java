package com.psl.assessment.model;

import java.util.List;

public class UserAssessment {

	String assessmentId;
	List<Answer> ansList;
	
	public UserAssessment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAssessment(String assessmentid,List<Answer> ansList) {
		super();
		this.ansList = ansList;
		this.assessmentId = assessmentid;
	}

	public List<Answer> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	
		
}
