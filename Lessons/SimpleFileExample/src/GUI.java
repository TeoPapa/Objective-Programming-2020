import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame{
	private JFileChooser fc = new JFileChooser();
	private JPanel panel = new JPanel();
	private JButton btn = new JButton("Open File");
	
	public GUI() {
		panel.add(btn);
		this.setContentPane(panel);
		
		
		btn.addActionListener( new ButtonListener());
		
		
		
	}
	
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int returnVal = fc.showOpenDialog(panel);
			if(returnVal == JFileChooser.OPEN_DIALOG) {
					File file = fc.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file));
						String line = reader.readLine();
						while(line != null) {
							System.out.println(line);
							line = reader.readLine();
						}
						reader.close();
						
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				
				
				}
			
		}
		
	}

}
