import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//Fleets
		Fleet fleet1 = new Fleet("Athens");
		Fleet fleet2 = new Fleet("Thessaloniki");
		ArrayList<Fleet> allFleets = new ArrayList<>();

		//Gasoline Taxis
		GasolineTaxi gasTaxi1 = new GasolineTaxi("AVG25467", "George", 1600, 3.4);
		GasolineTaxi gasTaxi2 = new GasolineTaxi("ADG39475", "Peter", 1800, 4.8);
		
		//Electrical Taxis
		ElectricalTaxi electricTaxi1 = new ElectricalTaxi("AVG29345", "John", 10000);
		ElectricalTaxi electricTaxi2 = new ElectricalTaxi("ADG29345", "Nick", 15000);
		
		//Adding Taxis to Fleet
		fleet1.storeTaxi(gasTaxi1);
		fleet1.storeTaxi(electricTaxi1);
		fleet2.storeTaxi(gasTaxi2);
		fleet2.storeTaxi(electricTaxi2);
		
		//Adding Fleets into the ArrayList
		allFleets.add(fleet1);
		allFleets.add(fleet2);
		
		GUI myGUI = new GUI(allFleets);
	}

}
