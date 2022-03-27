# DETAILS ABOUT THIS PROJECT
The following application allows the registration of hotel room bookings (some bookings are AllInclusive and in addition to accommodation include from 1 to 3 meals per day).
The cost of a simple reservation is calculated as: 
# Accommodation Days × 120
The cost of an AllInclusive booking is calculated as:
# Days of Stay × (120 + number of Meals Per Day × 30)
The hotels built in the main method are read from the hotels.ser file and their names are displayed on the Input screen. After the user enters values in the appropriate fields, by selecting the "Save Reservation" button an object of the appropriate class is created and registered in the selected hotel (the application understands the type of reservation based on whether there is a completed number in the field "Number of Meals" ). By selecting the "Cost Calculation" button, the cost field of all bookings registered in the selected hotel is displayed in the text field "Total Cost".
