import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FindSuspect extends JFrame implements ActionListener{

	//GUI Items
	private JPanel panel;
	private JButton findButton;
	private JButton networkButton;
	private JTextField suspectField;
	private Registry reg;
	
	public FindSuspect(Registry registry)
	{
	//Creating GUI Items
	panel = new JPanel();
	findButton = new JButton("Find");
	networkButton = new JButton("Visualize Network");
	suspectField = new JTextField("Please enter suspect's name");
	
	reg = registry;
	
	findButton.addActionListener(this);
	networkButton.addActionListener(this);
	
	//Adding items to the panel
	panel.add(suspectField);
	panel.add(findButton);
	panel.add(networkButton);
	
	this.setContentPane(panel);
	
	//About Panel
	this.setVisible(true);
	this.setTitle("Find Suspect");
	this.setLocationRelativeTo(null);
	this.setSize(300, 150);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = suspectField.getText();
		boolean exists = false;
		
		if(e.getSource().equals(findButton))
		{
			ArrayList<Suspect> susp = reg.getSuspects();
			for(Suspect s: susp)
			{
				if(s.getName().equals(name))
				{
					new SuspectPage(s, reg);
					exists = true;
					this.setVisible(false);
				}
			}
			if(!exists)
				JOptionPane.showMessageDialog(null, "Suspect " + name + " Not Found");
		}
		if(e.getSource().equals(networkButton))
			new SuspectsNetwork(reg);
		
	}
}
