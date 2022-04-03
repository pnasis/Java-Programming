
public abstract class DiagnosticTest extends Test {

	private boolean result;
	private String type;
	
	public DiagnosticTest(String lastname, String date, boolean result, String type)
	{
		super(lastname, date);
		this.result = result;
		this.type = type;
	}

	public boolean getResult()
	{
		return result;
	}

	public String getType()
	{
		return type;
	}
	
	
}
