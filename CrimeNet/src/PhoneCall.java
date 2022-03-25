
public class PhoneCall extends Communication{

	private int duration;
	
	public PhoneCall(String num1, String num2, int date, int month, int year, int duration)
	{
		super(num1, num2, date, month, year);
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}

	public void printInfo()
	{
		System.out.println("This phone call has the following info");
		System.out.println("Between " + getNum1() + " --- " + getNum2());
		System.out.println("on " + getYear() + "/" + getMonth() + "/" + getDate());
		System.out.println("Duration: " + duration);
	}
}
