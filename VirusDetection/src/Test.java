
public abstract class Test {

	private String lastname;
	private String date;
	
	public Test(String lastname, String date)
	{
		this.lastname = lastname;
		this.date = date;
	}

	public String getLastname()
	{
		return lastname;
	}

	public String getDate()
	{
		return date;
	}
}
