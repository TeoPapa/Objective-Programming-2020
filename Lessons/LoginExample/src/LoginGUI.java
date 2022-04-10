import java.awt.event.*;

import javax.swing.*;

public class LoginGUI extends JFrame{
	private UserList users;
	private JPanel panel = new JPanel();
	private JTextField unameText = new JTextField("", 10);
	private JTextField passText = new JTextField("", 10);
	private JButton loginBtn = new JButton("Login");
	
	
	public LoginGUI(UserList ul) {
		users = ul;
		
		panel.add(unameText);
		panel.add(passText);
		panel.add(loginBtn);
		setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		loginBtn.addActionListener(listener);
		
		setVisible(true);
		setSize(200, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			User currentUser = users.loginAttempt(unameText.getText(), passText.getText());
			if(currentUser == null) {
				JOptionPane.showMessageDialog(null, "Incorrect Login");
			} else {
				currentUser.showForm();
			}
			
		}
		
	}
}
