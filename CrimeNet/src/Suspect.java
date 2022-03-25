import java.util.ArrayList;

public class Suspect implements Comparable<Suspect>{
	
	//Fields
	private String name;
	private String codeName;
	
	private String currloc;
	private ArrayList<String> numbers = new ArrayList<>();
	private ArrayList<Suspect> partners = new ArrayList<>();
	
	//Methods
	public Suspect(String name, String codename, String currloc)
	{
		this.name = name;
		this.codeName = codename;
		this.currloc = currloc;
	}
	
	public String getName() {
		return name;
	}

	public String getCodeName() {
		return codeName;
	}

	public String getCurrloc() {
		return currloc;
	}

	public ArrayList<String> getNumbers() {
		return numbers;
	}

	public ArrayList<Suspect> getPartners() {
		return partners;
	}

	public void setPartners(ArrayList<Suspect> partners) {
		this.partners = partners;
	}

	public void addNumber(String number)
	{
		numbers.add(number);
	}
	
	public void addToPartners(Suspect s)
	{
		boolean isThere=partners.contains(s);
		if(!isThere)
			partners.add(s);
	}
	
	public boolean isConnectedTo(Suspect aSuspect)
	{
		return partners.contains(aSuspect);
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect s)
	{
		ArrayList<Suspect> same = new ArrayList<>();
		ArrayList<Suspect> temp = s.getPartners();
		
		for(Suspect curr : partners)
		{
			if(temp.contains(curr))
				same.add(curr);
		}
		return same;
	}
	
	public void printPartners()
	{
		for(Suspect s: partners)
		{
			System.out.println("Name: " + s.getName() + ", " + s.getCodeName());
		}
	}
	
	public boolean isNumInList(String num)
	{
		return (numbers.contains(num));
	}
	
	public ArrayList<Suspect> suggestedSuspects(Registry registry)
	{
		ArrayList<Suspect> suggestedPartners = new ArrayList<>();
		ArrayList<Suspect> suspects = registry.getSuspects();
		Suspect temp = null;
		
		//Searching the specific suspect in the registry
		for(Suspect s: suspects)
		{
			if(s.getName().equals(this.getName()))
				temp = s;
		}
		
		ArrayList<Suspect> partners = temp.getPartners(); //getting the partners of the suspect.
		ArrayList<Suspect> temp1 = new ArrayList<>(); //for holding the partners of each partner.
		//checking all the partners
		for(Suspect s1: partners)
		{
			temp1 = s1.getPartners();
			//checking all the partners of the each partner
			for(Suspect s2: temp1)
			{
				if(!temp.getPartners().contains(s2) && !suggestedPartners.contains(s2) && !s2.equals(temp))
					suggestedPartners.add(s2);
			}
		}
		return suggestedPartners;
	}

	@Override
	//For comparing suspect objects
	public int compareTo(Suspect s) {
		return this.name.compareTo(s.getName());
	}	
	
}
