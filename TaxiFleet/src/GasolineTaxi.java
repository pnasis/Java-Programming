
public class GasolineTaxi extends Taxi{

	private int gasAmount;
	private double consumption;
	
	public GasolineTaxi(String number, String driver, int gasAmount, double consumption)
	{
		super(number, driver);
		this.gasAmount = gasAmount;
		this.consumption = consumption;
	}
	
	public double getAutonomy()
	{
		return 90 * (gasAmount/consumption);
	}
}
