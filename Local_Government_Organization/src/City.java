import java.io.Serializable;
import java.util.ArrayList;

public class City implements Comparable<City>, Serializable{

	private String base;
	private ArrayList<Community> communities = new ArrayList<>();
	
	public City(String base)
	{
		this.base = base;
	}

	public String getBase() {
		return base;
	}

	public ArrayList<Community> getCommunities() {
		return communities;
	}
	
	public void add(Community c)
	{
		communities.add(c);
	}
	
	public int calculateFunding()
	{
		int totalCost=0;
		for(Community c: communities)
		{
			totalCost = c.calculateFunding();
		}
		return totalCost;
	}

	@Override
	public int compareTo(City city) {
		return this.base.compareTo(city.getBase());
	}
}
