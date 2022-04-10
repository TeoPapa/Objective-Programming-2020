import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class UserPageGUI extends JFrame{
		
		private User cUser;
		private JTextField TName;
		private JTextField TMail;
		private JButton backtL = new JButton("Back to Login Screen");
		private JTextField fName = new JTextField("Send Friend Request...");
		private JButton fBut = new JButton("Add Friend");
		private JTextArea TPost = new JTextArea(9, 20);
		private JButton BPost = new JButton("Post");
		private JLabel postOFriends = new JLabel("Recent Posts by Friends");
		private JTextArea poFriends= new JTextArea(9, 20);
		private JLabel glLabel = new JLabel("Groups");
		private JList groupList;
		private DefaultListModel<String> model;
		private JButton adtGr = new JButton("Join Group");
		private JLabel sugFriends = new JLabel("Suggested Friends");
		private JList suggesFriends;
		private JPanel panel = new JPanel();
		
		
		public UserPageGUI(User u) {
			cUser = u;
			
			TName = new JTextField( cUser.getUsername() );
			TMail = new JTextField( cUser.getEmail() );
			
			panel.add(TName);
			panel.add(TMail);
			panel.add(backtL);
			panel.add(fName);
			panel.add(fBut);
			panel.add(TPost);
			panel.add(BPost);
			panel.add(postOFriends);
			panel.add(poFriends);
			
			backtL.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new PamakBookGUI();
					dispose();
				}
			});
			
			fBut.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<User> temp = PamakBook.getAllTheUsers();
					Boolean x = true;
					
					for(int i = 0; i < temp.size(); i++) {
						if( temp.get(i).getUsername().equals( fName.getText()) && !(temp.get(i).isFriends(u))) {
							u.addFriend(temp.get(i));
							JOptionPane.showMessageDialog(null, fName.getText() + " added succesfuly to the friend list!");
							x = false;
							
							System.out.println("The max diameter of the PamakBook graph is: " + PamakBook.graphLength());
							
							break;
						} else if ( temp.get(i).getUsername().equals(fName.getText()) && temp.get(i).isFriends(u) ) {
							JOptionPane.showMessageDialog(null, "Sorry, you are already friends with " + fName.getText());
							x = false;
							break;
						}
					}
					
					if(x) {
						JOptionPane.showMessageDialog(null, "User did not found with this Username! Please try again!");
					}
				}
				
			});
			
			BPost.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Date t = new Date();
					cUser.addPost( new Post( t, TPost.getText(), cUser));
					
					TPost.setText("");
					JOptionPane.showMessageDialog(null, "Post posted succesfully!");
					
					ArrayList<Post> temp = cUser.returnAllPosts();
					
					poFriends.setText(temp.get(0).getThePost() + "\n");
					
					if(temp.size() > 1) {
						for(int i = 1; i < temp.size(); i++) {
							poFriends.append(temp.get(i).getThePost() + "\n");
						}
					}
				}
			});
			
			
			ArrayList<Post> temp = cUser.returnAllPosts();
			
			if(temp.size() == 0) {
				poFriends.setText(" ");
			}
			else if (temp.size() == 1){
				poFriends.setText(temp.get(0).getThePost() + "\n");
			}
			else {
				for(int i = 0; i < temp.size(); i++) {
					poFriends.append(temp.get(i).getThePost() + "\n");
				}
			}
			
			ArrayList<Group> groups = PamakBook.getAllTheGroups();
			
			groupList = new JList<String>();
			model = new DefaultListModel<String>();
			
			for(int i = 0; i < groups.size(); i++) {
				model.addElement(groups.get(i).getName());
			}
			
			groupList.setModel(model);
			
			panel.add(glLabel);
			panel.add(groupList);
			panel.add(adtGr);
			
			adtGr.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String gName = (String) groupList.getSelectedValue();
					boolean temp = false;
					
					for(int i = 0; i < groups.size(); i++) {
						if(groups.get(i).equals(new Group(gName, ""))) {
							temp = groups.get(i).addMember(u);
							break;
						}
					}
					
					if(temp) {
						JOptionPane.showMessageDialog(null, "User Succesfully Registered To " + gName);
					} else{
						JOptionPane.showMessageDialog(null, "User Could Not Register To The Group!");
					}
				}
				
			});
			
			
			
			ArrayList <String> temp1 = new ArrayList<String>();
			ArrayList<User> temp2 = cUser.suggestedFriends();
			for(int i = 0; i < temp2.size(); i++) {
				temp1.add(temp2.get(i).getUsername());
			}
			
			suggesFriends = new JList(temp1.toArray());
			
			panel.add(sugFriends);
			panel.add(suggesFriends);
			
			setContentPane(panel);
			
			setVisible(true);
			setSize(400, 600);
			setTitle("User Page");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
