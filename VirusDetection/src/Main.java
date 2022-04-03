import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		MolecularTest mTest1 = new MolecularTest("Smith", "May 15, 2020", true, "Nasal", 0.99);
		AntigenTest aTest1 = new AntigenTest("Jones", "October 20, 2020", false, "Throat", 30);
		MolecularTest mTest2 = new MolecularTest("Taylor", "November 29, 2020", true, "Throat", 0.95);
		AntigenTest aTest2 = new AntigenTest("Brown", "June 6, 2020", false, "Throat", 60);
		MolecularTest mTest3 = new MolecularTest("Wilson", "September 19, 2020", false, "Nasal", 0.99);
		AntigenTest aTest3 = new AntigenTest("Johnson", "December 5, 2020", false, "Nasal", 45);
		MolecularTest mTest4 = new MolecularTest("Roberts", "December 17, 2020", false, "Throat", 0.98);
		AntigenTest aTest4 = new AntigenTest("Turner", "April 4, 2020", false, "Throat", 30);
				
		DiagnosticCenter diagnosticCenter = new DiagnosticCenter();
		
		diagnosticCenter.addTest(mTest1);
		diagnosticCenter.addTest(aTest1);
		diagnosticCenter.addTest(mTest2);
		diagnosticCenter.addTest(aTest2);
		diagnosticCenter.addTest(mTest3);
		diagnosticCenter.addTest(aTest3);
		diagnosticCenter.addTest(mTest4);
		diagnosticCenter.addTest(aTest4);
		
		ArrayList<String> testArray = new ArrayList<>();
		testArray.add("Smith");
		testArray.add("Taylor");
		testArray.add("Phillips");
		testArray.add("Turner");
		testArray.add("Wilson");
		
		diagnosticCenter.checkForTest(testArray);
		
		new GUI(diagnosticCenter);
	}

}
