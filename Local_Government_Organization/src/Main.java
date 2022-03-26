import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//---------City and its communities-------------
		City sithonia = new City("Sithonia");
		Community vourvourou = new Community("Vourvourou", 140);
		MunicipalCommunity nikiti = new MunicipalCommunity("Nikiti", 2769, 2.3);
		
		//---------City and its communities-------------
		City kassandra = new City("Kassandra");
		Community poseidi = new Community("Poseidi", 76);
		MunicipalCommunity kassandreia = new MunicipalCommunity("Kassandreia", 2801, 2.7);
		
		//---------City and its communities-------------
		City ioannina = new City("Ioannina");
		Community nisos = new Community("Nisos", 219); 
		MunicipalCommunity anatoli = new MunicipalCommunity("Anatoli", 11555, 1.8);
		
		//---------City and its communities-------------
		City artaiwn = new City("Artaiwn");
		Community apomero = new Community("Apomero", 142); 
		MunicipalCommunity arta = new MunicipalCommunity("Arta", 42985, 3.1);
		
		//---------Recycling centers----------
		RecyclingCenter rec112 = new RecyclingCenter("rec112", 55.7);
		RecyclingCenter rec115 = new RecyclingCenter("rec115", 23.8);
		RecyclingCenter rec117 = new RecyclingCenter("rec117", 95.7);
		RecyclingCenter rec122 = new RecyclingCenter("rec122", 140.8);
		RecyclingCenter rec123 = new RecyclingCenter("rec123", 77.5);
		
		//---------Adding recycling centers to municipal communities----------
		nikiti.add(rec112);
		kassandreia.add(rec115);
		anatoli.add(rec117);
		arta.add(rec122);
		arta.add(rec123);
		
		//---------Adding communities to cities---------
		sithonia.add(vourvourou);
		sithonia.add(nikiti);
		
		kassandra.add(poseidi);
		kassandra.add(kassandreia);
		 
		ioannina.add(anatoli);
		ioannina.add(nisos);
				
		artaiwn.add(arta);
		artaiwn.add(apomero);
		
		ArrayList<City> cities = new ArrayList<>();
		cities.add(sithonia);
		cities.add(kassandra);
		cities.add(ioannina);
		cities.add(artaiwn);
		
		File file = new File("Cities.ser");
		try {
			FileOutputStream outStream = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(cities);
			out.close();
			outStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		FundingCalculator frame = new FundingCalculator();
	}

}
