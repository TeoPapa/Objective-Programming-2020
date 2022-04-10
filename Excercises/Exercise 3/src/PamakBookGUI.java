import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PamakBookGUI extends JFrame{
	
	private ArrayList<User> Users = new ArrayList<User>();
	private JTextField name = new JTextField("Please enter your name...");
	private JButton uPage = new JButton("Enter User Page");
	private JButton infections = new JButton("Show Potential Infections");
	private JPanel panel = new JPanel();

	public PamakBookGUI() {
		Users.addAll(PamakBook.getAllTheUsers());
		
		panel.add(name);
		panel.add(uPage);
		panel.add(infections);
		setContentPane(panel);
		
		ButtonListener1 listener1 = new ButtonListener1();
		ButtonListener2 listener2 = new ButtonListener2();
		
		uPage.addActionListener(listener1);
		infections.addActionListener(listener2);
		
		setVisible(true);
		setSize(297, 220);
		setTitle("User Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			for(i = 0; i < Users.size(); i++) {
				if(Users.get(i).getUsername().equals(name.getText()) ) {
					new UserPageGUI(Users.get(i));
					dispose();
					break;
				}
			}
			
			if(i == Users.size())
				JOptionPane.showMessageDialog(null, "User " + name.getText() + " Not Found");
			
		}
		
	}
	
	
	class ButtonListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			int i = 0;
			for(i = 0; i < Users.size(); i++) {
				if(Users.get(i).getUsername().equals(name.getText()) ) {
					new PotentialInfectionsGUI(Users.get(i));
					dispose();
					break;
				}
			}
			
			if(i == Users.size())
				JOptionPane.showMessageDialog(null, "User " + name.getText() + " Not Found");
			
		}
		
	}
}
