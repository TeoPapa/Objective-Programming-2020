import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class PamakBookGUI extends JFrame{

	private JButton add = new JButton("New User");
	private JTextField name = new JTextField("User Name");
	private JTextField mail = new JTextField("User Email");
	private JButton uPage = new JButton("Enter User Page");
	private JButton infections = new JButton("Show Potential Infections");
	private JButton fSave = new JButton("Save PamakBook");
	private JPanel panel = new JPanel();

	public PamakBookGUI() {
		
		PamakBook pbk = new PamakBook();
		
		panel.add(add);
		panel.add(name);
		panel.add(mail);
		panel.add(uPage);
		panel.add(infections);
		panel.add(fSave);
		panel.add(fSave);
		setContentPane(panel);
		
		ButtonListener1 listener1 = new ButtonListener1();
		ButtonListener2 listener2 = new ButtonListener2();
		
		add.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<User> Users = PamakBook.getAllTheUsers();
				Boolean x = true;
				User temp = new User( name.getText(), mail.getText());
				
				for(int i = 0; i < Users.size(); i++) {
					if(Users.get(i).equals(temp)) {
						x = false;
						JOptionPane.showMessageDialog(null, "User Already Exists! Please try again!");
						break;
					}
				}
				
				if(x) {
					if(temp.userCreated()) {
						PamakBook.addUserToPB(temp);
						JOptionPane.showMessageDialog(null, "User Created Succesfully!");
					} else {
						JOptionPane.showMessageDialog(null, "User could not be created: Invalid email format");
					}
				}
			}
			
		});
		
		uPage.addActionListener(listener1);
		infections.addActionListener(listener2);
		
		fSave.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(PamakBook.hasFileStart()) {
					new PamakBookSaveGUI();
				} else {
					PamakBook.saveFiles();
					JOptionPane.showMessageDialog(null, "PamakBook Saved Succesfully!");
				}
			}
			
		});
		
		setVisible(true);
		setSize(297, 220);
		setTitle("User Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<User> Users = PamakBook.getAllTheUsers();
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
			ArrayList<User> Users = PamakBook.getAllTheUsers();
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
