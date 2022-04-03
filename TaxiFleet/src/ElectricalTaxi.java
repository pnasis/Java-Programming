
public class ElectricalTaxi extends Taxi{

	private int batteryAmount;
	
	public ElectricalTaxi(String number, String driver, int batteryAmount)
	{
		super(number, driver);
		this.batteryAmount = batteryAmount;
	}
	
	public double getAutonomy()
	{
		return 70 * batteryAmount;
	}
}
