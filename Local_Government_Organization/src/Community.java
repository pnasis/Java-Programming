import java.io.Serializable;

public class Community implements Serializable{
	
	private String name;
	private int population;
	
	public Community(String name, int population)
	{
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}
	
	public int calculateFunding()
	{
		return population * 50;
	}
}
