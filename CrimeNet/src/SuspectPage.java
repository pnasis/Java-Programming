import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SuspectPage extends JFrame implements ActionListener {

	//GUI Items
	private JPanel centralPanel;
	//About Suspect Info Panel
	private JPanel suspInfoPanel;
	private JTextField nameField;
	private JTextField nicknameField;
	private JTextArea numbersArea;
	private ArrayList<String> suspectNumbers = new ArrayList<>();
	//About Communication Info Panel
	private JPanel commInfoPanel;
	private JTextField numberField;
	private JTextArea smsArea;
	private JButton findButton;
	private Registry reg;
	private Suspect susp;
	//About Possible Partners Panel
	private JPanel possiblePartnersPanel;
	private JLabel label;
	private JTextArea partnersArea;
	//About Suggested Partners Panel
	private JPanel suggestedPartnersPanel;
	private JLabel label2;
	private JTextArea suggestedArea;
	//Back to Search Screen
	private JButton backButton;
	
	public SuspectPage(Suspect s, Registry registry)
	{
		//Creating GUI Items
		/*----------------Central Panel----------------*/
		centralPanel= new JPanel();
		
		/*----------------Suspect Info Panel----------------*/
		suspInfoPanel = new JPanel();
		nameField = new JTextField(s.getName());
		nicknameField = new JTextField(s.getCodeName());
		numbersArea = new JTextArea();
		numbersArea.setPreferredSize(new Dimension(95,65));
		suspectNumbers = s.getNumbers();
		
		for(String s1: suspectNumbers)
		{
			numbersArea.append(s1);
			numbersArea.append("\n");
		}
		
		nameField.setEditable(false);
		nicknameField.setEditable(false);
		suspInfoPanel.add(nameField);
		suspInfoPanel.add(nicknameField);
		suspInfoPanel.add(numbersArea);
		suspInfoPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		centralPanel.add(suspInfoPanel);
		
		//Setting the Main Panel
		this.setContentPane(centralPanel);
		
		/*----------------Communication Info Panel----------------*/
		commInfoPanel = new JPanel(new FlowLayout());
		numberField = new JTextField(10);
		smsArea = new JTextArea();
		smsArea.setPreferredSize(new Dimension(220, 150));
		
		findButton = new JButton("Find SMS");
		reg = registry;
		susp = s;
		
		findButton.addActionListener(this);
		commInfoPanel.add(numberField);
		commInfoPanel.add(smsArea);
		commInfoPanel.add(findButton);
		commInfoPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		centralPanel.add(commInfoPanel);
		
		/*----------------Possible Partners Panel----------------*/
		possiblePartnersPanel = new JPanel();
		label = new JLabel("Partners");
		partnersArea = new JTextArea();
		partnersArea.setPreferredSize(new Dimension(210, 150));
		possiblePartnersPanel.add(label);
		possiblePartnersPanel.add(partnersArea);
		possiblePartnersPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		centralPanel.add(possiblePartnersPanel);
		
		ArrayList<Suspect> suspects = susp.getPartners();
		Collections.sort(suspects);
		for(Suspect susp: suspects)
		{
			partnersArea.append(susp.getName());
			partnersArea.append(", ");
			partnersArea.append(susp.getCodeName());
			partnersArea.append("\n");
		}
		
		//Suggested Partners Panel
		suggestedPartnersPanel = new JPanel();
		label2 = new JLabel("Suggested Partners _____>");
		suggestedArea = new JTextArea();
		suggestedArea.setPreferredSize(new Dimension(210, 80));
		suggestedPartnersPanel.add(label2);
		suggestedPartnersPanel.add(suggestedArea);
		suggestedPartnersPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		centralPanel.add(suggestedPartnersPanel);
		
		ArrayList<Suspect> suggested = susp.suggestedSuspects(reg);
		Collections.sort(suggested);
		for(Suspect sg: suggested)
		{
			suggestedArea.append(sg.getName());
			suggestedArea.append(", ");
			suggestedArea.append(sg.getCodeName());
			suggestedArea.append("\n");
		}
		
		//Back to Search Screen
		backButton = new JButton("Back to Search Screen");
		backButton.addActionListener(this);
		centralPanel.add(backButton);
		
		//About Panel
		this.setVisible(true);
		this.setTitle("Suspect Page");
		this.setSize(500, 610);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String num2 = numberField.getText();
		
		if(e.getSource().equals(findButton))
		{
			HashSet<String> messages = new HashSet<>();
			ArrayList<String> nums = susp.getNumbers();
			for(String s: nums)
			{
				for(SMS sm: reg.getMessagesBetween(s, num2))
				{
					messages.add(sm.getMessage());
				}		
			}
			
			for(String str: messages) {
				smsArea.append(str + "\n");
			}
		}
		else
		{
			new FindSuspect(reg);
			this.setVisible(false);
		}
		
	}

}
