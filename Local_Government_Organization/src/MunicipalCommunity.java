import java.util.ArrayList;
import java.io.Serializable;

public class MunicipalCommunity extends Community implements Serializable{

	private double area;  	//in square kilometers
	private ArrayList<RecyclingCenter> recyclingCenters = new ArrayList<>();

	public MunicipalCommunity(String name, int population, double area) {
		super(name, population);
		this.area = area;
	}
	
	public void add(RecyclingCenter rc)
	{
		recyclingCenters.add(rc);
	}
	
	public int calculateFunding()
	{
		int totalTones=0;
		for(RecyclingCenter rc: recyclingCenters)
		{
			totalTones += rc.getTones();
		}
		return ((int)area * 1000) + (1000)* totalTones;
	}
}
