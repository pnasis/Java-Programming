
public abstract class Communication {

	private String num1;
	private String num2;
	private int date;
	private int month;
	private int year;
	
	public Communication(String num1, String num2, int date, int month, int year)
	{
		this.num1 = num1;
		this.num2 = num2;
		this.date = date;
		this.month = month;
		this.year = year;
		
	}
	
	public String getNum1()
	{
		return num1;
	}
	
	public String getNum2()
	{
		return num2;
	}
	
	public int getDate()
	{
		return date;
	}
	
	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}
	
	//Abstract method.
	public abstract void printInfo();
	
}
