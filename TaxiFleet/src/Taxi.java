
public abstract class Taxi {

	private String number;
	private String driver;
	
	public Taxi(String number, String driver)
	{
		this.number = number;
		this.driver = driver;
	}
	
	public String getNumber()
	{
		return number;
	}


	public String getDriver()
	{
		return driver;
	}

	public abstract double getAutonomy();
}
