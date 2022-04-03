import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	private JPanel panel;
	private JTextField nameField;
	private JButton autonomyButton;
	private JButton saveButton;
	ArrayList<Fleet> allFleets = new ArrayList<>();
	
	public GUI(ArrayList<Fleet> allFleets)
	{
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		nameField = new JTextField("Fleet name");
		nameField.setPreferredSize(new Dimension(70, 20));
		autonomyButton = new JButton("Show Autonomy");
		autonomyButton.setBackground(new Color(0, 204, 204));
		saveButton = new JButton("Save to File");
		saveButton.setBackground(new Color(0, 204, 204));
		
		this.allFleets = allFleets;
		
		ButtonListener listener = new ButtonListener();
		autonomyButton.addActionListener(listener);
		saveButton.addActionListener(listener);
		
		panel.add(nameField);
		panel.add(autonomyButton);
		panel.add(saveButton);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(370, 100);
		this.setTitle("Fleets Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nameFleet = nameField.getText();
			Fleet selectedFleet = null;
			
			for(Fleet f: allFleets)
			{
				if(f.getName().equals(nameFleet))
				{
					selectedFleet = f;
					break;
				}
			}
			
			if(e.getSource().equals(autonomyButton))
			{
				
				if(selectedFleet!=null)
					System.out.println("Name: " + selectedFleet.getName() + ", Amount of Taxi: " + allFleets.size() + ", Total Autonomy: " + String.format("%.2f", selectedFleet.getTotalAutonomy()) + ".");
				else
					JOptionPane.showMessageDialog(null, "No fleet selected");
			}
			
			if(e.getSource().equals(saveButton))
			{
				File f = new File("Fleets.txt");
				try {
					FileWriter writer = new FileWriter(f);
					
					writer.write("Fleet Name: " + selectedFleet.getName());
					writer.write(System.lineSeparator());
					writer.write("--------------------------------------------------------------");
					writer.write(System.lineSeparator());
					
					for(Taxi t: selectedFleet.getTaxi())
					{
						writer.write("Name: " + t.getDriver());
						writer.write(System.lineSeparator());
						writer.write("Licence Plate: " + t.getNumber());
						writer.write(System.lineSeparator());
						writer.write("Autonomy: " + String.format("%.2f", t.getAutonomy()));
						writer.write(System.lineSeparator());
						writer.write("--------------------------");
						writer.write(System.lineSeparator());
					}
					
					writer.write(System.lineSeparator());
					writer.write("Total Aytonomy: " + String.format("%.2f", selectedFleet.getTotalAutonomy()));
					writer.write(System.lineSeparator());
					writer.close();			
				}
				catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
}
