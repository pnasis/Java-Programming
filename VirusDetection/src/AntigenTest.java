
public class AntigenTest extends DiagnosticTest {

	private int seconds;
	
	public AntigenTest(String lastname, String date, boolean result, String type, int seconds)
	{
		super(lastname, date, result, type);
		this.seconds = seconds;
	}

	public int getSeconds()
	{
		return seconds;
	}
}
