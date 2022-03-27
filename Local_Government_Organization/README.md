# DETAILS ABOUT THIS PROJECT
This project is an Information System for the Organization of Local Government in relation to the budget for recycling. Each City has Communities. A more specific category of Community is the Municipal Community, when the number of inhabitants of the community exceeds 300. Each Municipality is characterized by its seat (type String). Each Community is characterized by its population, while the Municipal Community is also characterized by its area in square kilometers (type double). Every Municipal Community has Recycling Centers. Each Recycling Center is characterized by a code (type String) and the tons of recyclable materials it manages per year (type double).

The names of the municipalities are read from the cities.ser file, in the FundingCalculator class and are registered in the list. Clicking the Calculate City Funding button calculates the total subsidy that a municipality must pay to its Communities and Municipal Communities.

The grant for a Community is calculated as: Population * 50 \
The subsidy for a Municipal Community is calculated as: (1000 * each full square kilometer) + (1000 * each full ton of recyclable materials managed by the recycling centers)
