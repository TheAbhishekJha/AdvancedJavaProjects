package com.anurag.test.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 55, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 123, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		txtName = new JTextField();
		txtName.setText("Enter Name");
		txtName.setBounds(101, 42, 189, 42);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Enter Password");
		txtPassword.setBounds(100, 110, 189, 42);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(54, 206, 117, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		btnRegister.setBounds(242, 206, 117, 25);
		frame.getContentPane().add(btnRegister);
	}

	protected void login() {
		// TODO Auto-generated method stub
		String name = txtName.getText();
		String password = txtPassword.getText();
		UserOperations userOperations = UserOperations.getInstance();
		int result =userOperations.searchUser(name);
		if(result==-1) {
			JOptionPane.showInputDialog( this,"USER DONT EXIS");
			//System.out.println("loggedin");


		}else if(userOperations.checkUser(result,password)) {
			//System.out.println("loggedin");
			JOptionPane.showInputDialog( this,"loggedin");

		}
		
	}

	protected void addUser() {
		// TODO Auto-generated method stub
		String name = txtName.getText();
		String password = txtPassword.getText();
		User user = new User(name, password);
		UserOperations userOperations = UserOperations.getInstance();
		String result = userOperations.addUser(user);
		JOptionPane.showMessageDialog(frame, this,result, 0);


	}
}
