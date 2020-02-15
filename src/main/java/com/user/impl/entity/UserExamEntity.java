package com.user.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userexam")
public class UserExamEntity {
	
	@Column(name = "userexamid")
	@Id
	int userExamID;
	
	@Column(name = "userid")
	int userID;
	
	@Column(name = "examid")
	int examID;
	
	@Column(name = "score")
	int score;
	
	@Column(name = "grade")
	String grade;
	
	public UserExamEntity() {
		super();
	}
	
	public UserExamEntity(int userExamID, int userID, int examID, int score, String grade) {
		super();
		this.userExamID = userExamID;
		this.userID = userID;
		this.examID = examID;
		this.score = score;
		this.grade = grade;
	}
	
	
	public int getUserExamID() {
		return userExamID;
	}
	public void setUserExamID(int userExamID) {
		this.userExamID = userExamID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
		this.examID = examID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
