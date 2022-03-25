
public class Reservation {

	private int days;
	
	public Reservation(int days)
	{
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	public int calculateCost()
	{
		return days*120;
	}
}
