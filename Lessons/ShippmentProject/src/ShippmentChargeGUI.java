import java.awt.event.*;

import javax.swing.*;

public class ShippmentChargeGUI extends JFrame {
	private Ship sh;
	private JPanel panel = new JPanel();
	private JButton cChargeBtn = new JButton("Calculate Charge");
	private JTextField tChargeTxt = new JTextField("Total charge for all containers");
	
	public ShippmentChargeGUI(Ship shh) {
		sh = shh;
		panel.add(cChargeBtn);
		panel.add(tChargeTxt);
		setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		cChargeBtn.addActionListener(listener);
		
		setVisible(true);
		setSize(800, 800);
		setTitle("Shippment Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tChargeTxt.setText(Double.toString(sh.TotalCharge()));
		}
		
	}

}
