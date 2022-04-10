import javax.swing.*;

public class ProfessorMainGUI extends JFrame{
private JPanel panel = new JPanel();
	
	
	public ProfessorMainGUI() {
		setContentPane(panel);
		
		
		setVisible(true);
		setSize(200, 250);
		setTitle("Welcome Student");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
