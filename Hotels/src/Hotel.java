import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable, Comparable<Hotel> {
	
	private String name;
	private ArrayList<Reservation> reserv;
	
	public Hotel(String name) {
		this.name = name;
		reserv = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addReservation(Reservation res)
	{
		reserv.add(res);
	}

	@Override
	public int compareTo(Hotel o) {
		return this.name.compareTo(o.name);
	}
	
	public int calculateTotalCost()
	{
		int total = 0;
		for(Reservation r: reserv)
		{
			total += r.calculateCost();
		}
		return total;
	}
}
