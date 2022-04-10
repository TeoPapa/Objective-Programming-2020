import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.data.category.*;

public class GUI extends JFrame{

		public GUI() {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			
			dataset.setValue(200, "Classes", "JDK1");
			dataset.setValue(350, "Classes", "JDK2");
			dataset.setValue(420, "Classes", "JDK3");
			dataset.setValue(480, "Classes", "JDK4");
			dataset.setValue(550, "Classes", "JDK5");
			
			JFreeChart chart = ChartFactory.createBarChart3D()
		}
}
