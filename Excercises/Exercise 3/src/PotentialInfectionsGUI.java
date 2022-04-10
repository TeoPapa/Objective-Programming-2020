import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PotentialInfectionsGUI extends JFrame{
	User us;
	JTextArea tArea = new JTextArea(9, 21);
	JButton returnToLog = new JButton("Return to Login Screen");
	JPanel panel = new JPanel();
	
	public PotentialInfectionsGUI(User u) {
		us = u;
		
		panel.add(tArea);
		panel.add(returnToLog);
		
		tArea.setText("***************************************************************************\n");
		tArea.append(us.getUsername() + " has been infected. The following users have to be tested\n");
		tArea.append("****************************************************************************\n");
		
		ArrayList<User> Infected = us.itsCoronaTime();
		
		for( int i = 0; i < Infected.size(); i++) 
			tArea.append(Infected.get(i).getUsername() + "\n");
		
		returnToLog.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PamakBookGUI();
				dispose();
			}
		});
		
		setContentPane(panel);
		
		setVisible(true);
		setSize(400, 300);
		setTitle("Potential Virus Infection");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
