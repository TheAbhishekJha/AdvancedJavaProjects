package com.anurag.test.question;

public class Question {
	private	String question;
	private	String[] option= new String[3];
	private	String rightAnswer;
	private	String userAnswer;
	private int status;
	
	
	public Question(String string, String[] optionList_1, int notVisited) {
		// TODO Auto-generated constructor stub
		this.question=string;
		this.option=optionList_1;
		this.status=notVisited;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOption() {
		return option;
	}
	public void setOption(String[] option) {
		this.option = option;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
