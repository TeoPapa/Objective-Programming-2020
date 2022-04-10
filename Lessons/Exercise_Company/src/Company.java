import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Company {
	private String cName;
	private ArrayList<Employee> Employed;
	
	
	public Company( String n) {
		cName = n;
		Employed = new ArrayList<Employee>();
	}
	
	public void setEmployee() {
		Employee em;
		String eName;
		String eIncome;
		
		String ans = JOptionPane.showInputDialog("Is the employer a tech employee? (0: No): ");
		
		eName = JOptionPane.showInputDialog("Please enter the Employee's Name: ");
		eIncome = JOptionPane.showInputDialog("Please enter the Employee's Income: ");
		
		if(ans.equals("0")) {
			
			em = new Employee(eName, Double.parseDouble(eIncome)); 
		}
		else {
			String eBonus = JOptionPane.showInputDialog("Please enter the Employee's Bonus: ");
			
			em = new TechEmployee(eName, Double.parseDouble(eIncome), Double.parseDouble(eBonus) );
		}
		
		Employed.add(em);
	}
	
	
	public void printCompany() {
		System.out.println("-----------------------");
		for( int i = 0; i < Employed.size(); i++ ) {
     		}
	}
}
