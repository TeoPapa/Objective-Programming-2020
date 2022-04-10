import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;


public class PamakBookSaveGUI extends JFrame{

	private JLabel message = new JLabel("Are you sure you want overide the current PamakBook. The saved data is:");
	private JLabel users = new JLabel("Users:");
	private JList<String> usersList;
	private DefaultListModel<String> model1;
	private JLabel groups = new JLabel("Groups:");
	private JList groupList;
	private DefaultListModel<String> model2;
	private JLabel wrugd = new JLabel("Do you want to save the PamakBook?");
	private JButton yes = new JButton("Yes");
	private JButton no = new JButton("No");
	private JButton reset = new JButton("Reset PamakBook");
	private JPanel panel = new JPanel();
	
	
	public PamakBookSaveGUI() {
		ArrayList<User> savUsers = new ArrayList<User>();
		ArrayList<Group> savGroups = new ArrayList<Group>();
		
		panel.add(message);
		panel.add(users);
		
		usersList = new JList<String>();
		model1 = new DefaultListModel<String>();
		
		File fUser = new File("Users.ser");
		File fGroup = new File("Groups.ser");
		
		try {
			FileInputStream fins = new FileInputStream(fUser);
			ObjectInputStream dins = new ObjectInputStream(fins);
		
			savUsers.addAll( (ArrayList<User>) dins.readObject() );
		
			dins.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream finss = new FileInputStream(fGroup);
			ObjectInputStream dinss = new ObjectInputStream(finss);
			
			savGroups.addAll( (ArrayList<Group>) dinss.readObject() );
		
			dinss.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < savUsers.size(); i ++) {
			model1.addElement(savUsers.get(i).getUsername());
		}
		
		usersList.setModel(model1);
		panel.add(usersList);
		
		groupList = new JList<String>();
		model2 = new DefaultListModel<String>();
		
		for(int i = 0; i < savGroups.size(); i++) {
			model2.addElement(savGroups.get(i).getName());
		}
		
		groupList.setModel(model2);
		
		panel.add(groups);
		panel.add(groupList);
		
		panel.add(wrugd);
		panel.add(yes);
		panel.add(no);
		panel.add(reset);
		
		yes.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PamakBook.saveFiles();
				JOptionPane.showMessageDialog(null, "PamakBook Saved Succesfully!");
				dispose();
			}
			
		});
		
		no.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PamakBook Did Not Saved!");
				dispose();
			}
			
		});
		
		reset.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<User> tmp1 = new ArrayList<User>();
				ArrayList<Group> tmp2 = new ArrayList<Group>();
				
				File fUsers = new File("Users.ser");
				File fGroups = new File("Groups.ser");
				
				
					FileOutputStream fouts;
					try {
						fouts = new FileOutputStream(fUsers);
						ObjectOutputStream douts = new ObjectOutputStream(fouts);
						
						douts.writeObject(tmp1);
					
						douts.close();
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
							
					FileOutputStream foutss;
					try {
						foutss = new FileOutputStream(fGroups);
						ObjectOutputStream doutss = new ObjectOutputStream(foutss);
						
						doutss.writeObject(tmp2);
					
						doutss.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
					JOptionPane.showMessageDialog(null, "PamakBook Reseted Succesfully! Close the program and reopen it to rewrite it!");
					dispose();
			}
			
		});
	
		setContentPane(panel);
		
		setVisible(true);
		setSize(450, 150);
		setTitle("Save");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
