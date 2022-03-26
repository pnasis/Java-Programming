import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FundingCalculator extends JFrame {
	
	private JPanel panel = new JPanel();
	private JList<String> citiesList = new JList<>();
	private DefaultListModel<String> citiesModel = new DefaultListModel<>();
	private ArrayList<City> cities = new ArrayList<>();
	private JButton cityFundingButton = new JButton("Calculate City Funding");
	private JTextField fundingTextField = new JTextField("calculated funding");
	
	
	public FundingCalculator() {
		
		//Getting the city names from the file and saving them into an ArrayList.
		File file = new File("Cities.ser");
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cities	= (ArrayList<City>)in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Adding the city names to the List.
		Collections.sort(cities);
		for(City c: cities)
			citiesModel.addElement(c.getBase());
		
		citiesList.setModel(citiesModel);
		
		//Creating and setting the ActionListener
		ButtonListener listener = new ButtonListener();
		cityFundingButton.addActionListener(listener);
		
		panel.add(citiesList);
		panel.add(cityFundingButton);
		panel.add(fundingTextField);
		
		//About Panel
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Funding Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String selectedCityName = citiesList.getSelectedValue();
			City selectedCity = null;
			
			//We check which city the user selected.
			for(City c : cities)
			{
				if(c.getBase().equals(selectedCityName)){
					selectedCity = c;
					break;
				}
			}
			
			//If user has selected a city:
			if(selectedCity!=null)
			{
				int funding = selectedCity.calculateFunding();
				fundingTextField.setText(Integer.toString(funding) + "€");
			}
			else{ //If user has not selected a city:
				JOptionPane.showMessageDialog(null, "No hotel selected!");
				System.out.println("No hotel selected");
			}
		}
	}
}
