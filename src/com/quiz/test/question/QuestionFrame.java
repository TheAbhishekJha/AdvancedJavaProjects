package com.anurag.test.question;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;


import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class QuestionFrame extends JPanel implements QuestionConstants{
	private int index=DEFAULT_INDEX;
	QuestionOperations questionOperations=QuestionOperations.getInstance();

	JLabel lblQuestionNumber = new JLabel("Question number");
	JLabel lblQuestion = new JLabel("Question");
	
	JRadioButton [] rdbtn=new JRadioButton[] {
	 new JRadioButton("Option1"),
	 new JRadioButton("option2"),
	 new JRadioButton("option3")
	};
	



	private JFrame frame;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionFrame window = new QuestionFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuestionFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		for(int i=0;i<=NO_OF_QUESTIONS;i++) {
			
		}
		
		JLabel lblTest = new JLabel("TEST");
		lblTest.setVerticalAlignment(SwingConstants.TOP);
		lblTest.setFont(new Font("DejaVu Serif", Font.BOLD, 30));
		lblTest.setBounds(241, 30, 104, 49);
		frame.getContentPane().add(lblTest);
		
		lblQuestion.setVerticalTextPosition(SwingConstants.TOP);
		lblQuestion.setVerticalAlignment(SwingConstants.TOP);
		lblQuestion.setBounds(45, 150, 414, 56);
		frame.getContentPane().add(lblQuestion);
		
		lblQuestionNumber.setVerticalTextPosition(SwingConstants.TOP);
		lblQuestionNumber.setVerticalAlignment(SwingConstants.TOP);
		lblQuestionNumber.setBounds(12, 150, 28, 23);
		frame.getContentPane().add(lblQuestionNumber);
		buttonGroup_1.add(rdbtn[0]);
		
		rdbtn[0].setVerticalAlignment(SwingConstants.TOP);
		rdbtn[0].setBounds(45, 220, 414, 23);
		frame.getContentPane().add(rdbtn[0]);
		
		buttonGroup_1.add(rdbtn[1]);
		
		rdbtn[1].setVerticalAlignment(SwingConstants.TOP);
		rdbtn[1].setBounds(45, 246, 414, 23);
		frame.getContentPane().add(rdbtn[1]);
		buttonGroup_1.add(rdbtn[2]);
		
		rdbtn[2].setVerticalTextPosition(SwingConstants.TOP);
		rdbtn[2].setVerticalAlignment(SwingConstants.TOP);
		rdbtn[2].setBounds(45, 273, 414, 23);
		frame.getContentPane().add(rdbtn[2]);
		JButton btnPrevious = new JButton("previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAnswer();
				buttonGroup_1.clearSelection();
				
				if(index==0) 
					index=2;
				else
					index--;
				show();
			}
		});
		btnPrevious.setBounds(12, 374, 117, 25);
		frame.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAnswer();
				if(index==2) 
					index=0;
				else
					index++;
				show();
			}
		});
		btnNext.setBounds(267, 374, 117, 25);
		frame.getContentPane().add(btnNext);
		
		JButton btnSkip = new JButton("skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAnswer();
				if(index==2) 
					index=0;
				else
					index++;
				show();
			}
		});
		btnSkip.setBounds(141, 374, 117, 25);
		frame.getContentPane().add(btnSkip);
		
		JButton btnEndTest = new JButton("end test");
		btnEndTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEndTest.setBounds(363, 42, 117, 25);
		frame.getContentPane().add(btnEndTest);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionOperations.intitializeQuestionList();
				show();
			}
		});
		btnStart.setBounds(52, 43, 117, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnClearSelction = new JButton("Clear Selction");
		btnClearSelction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroup_1.clearSelection();
			}
		});
		btnClearSelction.setBounds(141, 337, 204, 25);
		frame.getContentPane().add(btnClearSelction);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBalls(g);
		
		
		
}
	
	
	private void drawBalls(Graphics g) {
		// TODO Auto-generated method stub
		questionOperations.drawBalls(g);
		
	}

	
	protected void saveAnswer() {
		for(int i=0;i<NO_OF_QUESTIONS;i++) {
			if(rdbtn[i].isSelected()==true) {
				questionOperations.setAnswer(rdbtn[i].getText(),index);
				setStatus(ATTEMPTED,i);
				break;
			}
			else 
				questionOperations.setAnswer(null,index);
		}
		buttonGroup_1.clearSelection();
	}

	
		
		

	private void setStatus(int status, int i) {
		// TODO Auto-generated method stub
		questionOperations.setStatus(status,i);
		
	}

	public void show() {
		// TODO Auto-generated method stub
		String[] a=questionOperations.getOption(index);
		lblQuestion.setText(questionOperations.getQuestion(index));
		lblQuestionNumber.setText(((Integer)(index+1)).toString());
		rdbtn[0].setText(a[0]);
		rdbtn[1].setText(a[1]);
		rdbtn[2].setText(a[2]);
		setRadioButton();
	}

	private void setRadioButton() {
		for(int i=0;i<NO_OF_QUESTIONS;i++) 
			rdbtn[i].setSelected(questionOperations.getAnswer(rdbtn[i].getText(),index));
	}
	
}
