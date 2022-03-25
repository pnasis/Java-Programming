
public class SMS extends Communication{

	private String message;
	
	public SMS(String num1, String num2, int date, int month, int year, String message)
	{
		super(num1, num2, date, month, year);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void printInfo()
	{
		System.out.println("This SMS has the following info");
		System.out.println("Between " + getNum1() + " --- " + getNum2());
		System.out.println("on " + getYear() + "/" + getMonth() + "/" + getDate());
		System.out.println("Text: " + message);
	}
}
