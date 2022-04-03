import java.util.ArrayList;

public class Fleet {

	private String name;
	private ArrayList<Taxi> taxi = new ArrayList<>();
	
	public Fleet(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	
	public ArrayList<Taxi> getTaxi()
	{
		return taxi;
	}

	public void storeTaxi(Taxi car)
	{
		taxi.add(car);
	}
	
	public double getTotalAutonomy()
	{
		double total = 0;
		for(Taxi t: taxi)
		{
			total += t.getAutonomy();
		}
		return total;
	}
}
