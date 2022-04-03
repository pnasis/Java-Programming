import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiagnosticCenter {

	private ArrayList<DiagnosticTest> tests = new ArrayList<>();
	
	public void addTest(DiagnosticTest test)
	{
		tests.add(test);
	}
	
	public ArrayList<DiagnosticTest> getTests()
	{
		return tests;
	}

	public void checkForTest(ArrayList<String> test)
	{
		
		Collections.sort(test);
		File f = new File("TestedPeople.txt");
		try {
			FileWriter writer = new FileWriter(f);

			for(String s: test)
			{
				boolean found = false;
				
				for(DiagnosticTest dt: tests)
				{
					if(s.equals(dt.getLastname()))
					{
						DiagnosticTest d = dt;
						found = true;
						writer.write(s + " has performed a test with the following information:");
						writer.write(System.lineSeparator());
						
						if(d instanceof MolecularTest)
						{
							writer.write("Molecular Test, Date: " + d.getLastname() + ", Result: " + d.getResult() + ", Type: " + d.getType() + ", " + ((MolecularTest)d).getAccuracy());
							writer.write(System.lineSeparator());
							writer.write("----------");
							writer.write(System.lineSeparator());
						}
						
						if(d instanceof AntigenTest)
						{
							writer.write("Antigen Test, Date: " + d.getLastname() + ", Result: " + d.getResult() + ", Type: " + d.getType() + ", " + ((AntigenTest)d).getSeconds());
							writer.write(System.lineSeparator());
							writer.write("----------");
							writer.write(System.lineSeparator());
						}
						
						break;
					}
				}
				if(!found)
				{
					writer.write(s + " has not performed any test.");
					writer.write(System.lineSeparator());
					writer.write("----------");
					writer.write(System.lineSeparator());
				}
			}	
			writer.close();			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
