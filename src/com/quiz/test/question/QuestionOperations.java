package com.anurag.test.question;

import java.awt.Graphics;
import java.util.ArrayList;


public class QuestionOperations implements QuestionConstants{
	private ArrayList<Question> questionList=new ArrayList<>();
	private static QuestionOperations questionOperations =null;
	
	public void intitializeQuestionList() {
		
		String[] optionList_1= {"coffee","programing language","spoken language"};
		String[] optionList_2= {"adt","variable","function"};
		String[] optionList_3= {"set of variables","condition","index"};

		questionList.add(new Question("what is JAVA",optionList_1,NOT_VISITED));
		questionList.add(new Question("what is class",optionList_2,NOT_VISITED));
		questionList.add(new Question("what is array",optionList_3,NOT_VISITED));
		
		randomizeList();
	}
	private void randomizeList() {
		// TODO Auto-generated method stub
		int[] a=new int[NO_OF_QUESTIONS];
		
		for(int i=0;i<NO_OF_QUESTIONS;i++) {
			do {
			a[i]=(int)(Math.random()*NO_OF_QUESTIONS)+1;
			System.out.print(a[i]);
			}while(isDuplicate(a[i],a,i));
		}
		ArrayList<Question> newArrayList=new ArrayList<>();
		for(int i = 0;i<NO_OF_QUESTIONS;i++) {
			newArrayList.add(questionList.get(a[i]-1));
		}
		questionList=newArrayList;
		
		
	}
	private boolean isDuplicate(int a, int[] b, int i2) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<i2;i++) {
			if(a==b[i]) 
				return true;
			
			
		}
		return false;
		
	}
	
	
	
	
	
	public  static QuestionOperations getInstance(){
		synchronized(QuestionOperations.class){
			if(questionOperations==null){
				questionOperations = new QuestionOperations();
			}
		}
		return questionOperations;
	}
	public String getQuestion(int index) {
		// TODO Auto-generated method stub
		
		return questionList.get(index).getQuestion();
	}
	public String[] getOption(int index) {
		// TODO Auto-generated method stub
		return questionList.get(index).getOption();
	}
	public void setAnswer(String text, int i) {
		// TODO Auto-generated method stub
		questionList.get(i).setUserAnswer(text);
	}
	public void setStatus(int status, int i) {
		// TODO Auto-generated method stub
		questionList.get(i).setStatus(status);
		
	}
	public void drawBalls(Graphics g) {
		// TODO Auto-generated method stub
		for(int i=0;i<NO_OF_QUESTIONS;i++) {
			
			g.fillOval(200+i*20, 200, 20, 20);
		}
	}
	
	public boolean getAnswer(String text, int i) {
		// TODO Auto-generated method stub
		if(questionList.get(i).getUserAnswer()==text)
			return true;
		else
			return false;
	}

}
