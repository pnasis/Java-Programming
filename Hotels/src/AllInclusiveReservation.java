
public class AllInclusiveReservation extends Reservation{
	
	private int meals;
	
	public AllInclusiveReservation(int days, int meals)
	{
		super(days);
		this.meals = meals;
	}

	public int getMeals()
	{
		return meals;
	}
	
	public void setMeals(int meals)
	{
		this.meals = meals;
	}
	
	public int calculateCost()
	{
		return getDays() * (120 + (meals * 30));
	}
}
