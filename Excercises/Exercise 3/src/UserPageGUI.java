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
		private JTextArea TPost = new JTextArea(9, 20);
		private JButton BPost = new JButton("Post");
		private JLabel postOFriends = new JLabel("Recent Posts by Friends");
		private JTextArea poFriends= new JTextArea(9, 20);
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
			panel.add(TPost);
			panel.add(BPost);
			panel.add(postOFriends);
			panel.add(poFriends);
			panel.add(sugFriends);
			
			backtL.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new PamakBookGUI();
					dispose();
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
			
			
			
			
			ArrayList <String> temp1 = new ArrayList<String>();
			ArrayList<User> temp2 = cUser.suggestedFriends();
			for(int i = 0; i < temp2.size(); i++) {
				temp1.add(temp2.get(i).getUsername());
			}
			
			suggesFriends = new JList(temp1.toArray());
			
			panel.add(suggesFriends);
			setContentPane(panel);
			
			setVisible(true);
			setSize(400, 600);
			setTitle("User Page");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
