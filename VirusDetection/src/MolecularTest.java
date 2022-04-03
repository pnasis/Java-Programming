
public class MolecularTest extends DiagnosticTest {

	private double accuracy;
	
	public MolecularTest(String lastname, String date, boolean result, String type, double accuracy)
	{
		super(lastname, date, result, type);
		this.accuracy = accuracy;
	}

	public double getAccuracy()
	{
		return accuracy;
	}
}
