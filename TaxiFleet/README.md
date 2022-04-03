# DETAILS ABOUT THIS PROJECT
The following project is an application that allows the registration of data related to taxi fleets (Fleet) that a company has in various cities. Taxis are divided into ElectricalTaxi marked with registration number (String), driver's name (String) and the number of batteries (int) and GasolineTaxi marked with registration number (String), the name of the driver (String), petrol tank in liters (int) and average petrol consumption in liters / 100km (double). The taxi fleet of a city (Fleet) is characterized by the name of the city-fleet (String) and consists of different taxis of both categories. \
In a petrol taxi the autonomy (the kilometers it can travel utilizing all the fuel in the tank) is calculated as: **autonomy = 90 x (tank size / average consumption)** \
In an electric taxi the autonomy (the kilometers it can travel using all the energy of the batteries) is calculated as: **autonomy = 70 x number of batteries** \
In taxi classes there are methods that calculate and return its autonomy. In the taxi fleet class there is a method (storeTaxi) for adding a new taxi to the fleet. \
Finally there is a graphical user interface with a text field (TextField) and two keys named "Show Autonomy" and "Save to File". By entering (typing) the name of a city-fleet in the text field and \
- selecting the "Show Autonomy" button displayed on the console:
-the name of the city-fleet
-the number of taxis
-the total autonomy of all taxis that are registered for the given city-fleet \
- selecting the "Save to File" button creates a text file with a file name "Fleets.txt", which will include as content:
-the name of the city-fleet (on the 1st line)
-the driver 's name, registration number and autonomy of each taxi in
different line
-the total autonomy of all taxis
