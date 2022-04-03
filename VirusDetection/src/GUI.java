import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	
	private JPanel panel = new JPanel();
	private JButton button = new JButton("PrintResults");
	private ArrayList<DiagnosticTest> tests;
	
	public GUI(DiagnosticCenter diagnosticCenter) {
		
		tests = diagnosticCenter.getTests();
		
		panel.add(button);
		this.setContentPane(panel);		
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(200, 200);
		this.setTitle("Test Statistics");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			int positive = 0;
			int negative = 0;
			
			for(DiagnosticTest dt: tests)
			{
				if(dt.getResult())
				{
					positive++;
				}
				else
					negative++;
				
			}
			
			System.out.println("Positive Tests: " + positive + " (" + String.format("%.2f", (double)(positive*100)/(positive+negative)) +"%), Negative Tests: " + negative + " (" + String.format("%.2f", (double)(negative*100/(positive+negative))) +"%)");
		}
		
	}

}
