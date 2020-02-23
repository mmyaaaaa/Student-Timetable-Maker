// Assignment: Summative Login class
// Names: Mya, Preesha & Eraj 
// Date: 2020-01-09
// Description: Runs The login window then prompts the GUI window after successful login

package summative;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

	// hard coded valid passwords and usernames 
	public String[] usernames =  {"bob", "joe", "otherbob"};
	public String[] passwords = {"123", "mama", "banana"};
	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window1 = new login();
					window1.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	 public boolean checkPasswordAndUsername (String user, String pass) {
		
		 boolean valid = false;
		 
		 // check to see if the username is valid
		 for (int i = 0 ; i < usernames.length; i++) {
			 
			 if (user.equals(usernames[i])) {
				 // valid username found 
				 // check corresponding password 
				 if (pass.equals(passwords[i])) {
					 // password is valid 
					 valid = true;
					 break;
				 }
			 }
			 
		 }
		 
		 return valid; 
		 
	 }
	
	
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("LOGIN");
		frame.setBounds(500, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel loginpanel = new JPanel();
		loginpanel.setBorder(new LineBorder(new Color(0, 100, 0), 5));
		loginpanel.setBackground(new Color(46, 139, 87));
		frame.getContentPane().add(loginpanel, "name_1443003813464700");
		
		JLabel lblWelcome = new JLabel("Welcome to APPNAME ");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 30));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setBackground(new Color(255, 255, 255));
		
		JLabel lblPleaseTypeIn = new JLabel("Please type in your username and password ");
		lblPleaseTypeIn.setForeground(new Color(255, 255, 255));
		lblPleaseTypeIn.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JLabel lblInTheCorrosponding = new JLabel("in the corrosponding fields to get started!");
		lblInTheCorrosponding.setForeground(new Color(255, 255, 255));
		lblInTheCorrosponding.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JLabel lblNewLabel = new JLabel("────────────────────────────────────────────");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// if pass and user is true close login window and open gui 
			if (checkPasswordAndUsername(textField.getText(), String.valueOf(passwordField.getPassword()))) {
				
					// show application
					GUI window = new GUI();
					window.frmStudentSchedulingSystem.setVisible(true);
		
					// delete login window
					frame.setVisible(false);
			}
			
			else {
			// show error 	
				JOptionPane.showMessageDialog(frame, "Incorrect Password and/or Username, Please Try Again");
			}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(255, 69, 0));
		
		passwordField = new JPasswordField();
		GroupLayout gl_loginpanel = new GroupLayout(loginpanel);
		gl_loginpanel.setHorizontalGroup(
			gl_loginpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loginpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInTheCorrosponding, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPleaseTypeIn, GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_loginpanel.createSequentialGroup()
							.addGroup(gl_loginpanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_loginpanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(passwordField, Alignment.TRAILING))
							.addGap(76)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_loginpanel.setVerticalGroup(
			gl_loginpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginpanel.createSequentialGroup()
					.addGap(14)
					.addComponent(lblWelcome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(lblPleaseTypeIn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInTheCorrosponding)
					.addGap(18)
					.addGroup(gl_loginpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_loginpanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_loginpanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		loginpanel.setLayout(gl_loginpanel);
	}
}
