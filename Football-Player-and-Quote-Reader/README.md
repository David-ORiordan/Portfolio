# Football-Player-and-Quote-Reader

### Main Feature:  
Ionic mobile application that reads football player data, flag data, and quotes from internet resources.  

### Design rationale:  
The first page of the application has a navigation bar which contains a student number and a link to the Settings Page.  
This page will present a random quote each time the page is loaded, displaying the author of the quote, a tag associated with the quote (e.g., wisom, technology, success), and the quote itself. All quote-related data is retrieved in JSON format from the following source: https://api.quotable.io/random  
This page also has an area for displaying football player data based on their nationality. Until a country ID is entered, no player data will be displayed. Once a country ID has been entered, the related country flag will be displayed, having been retrieved from the following source: https://flagsapi.com/   
The Settings page allows the user to input a country ID. Possible country IDs are viewable in the Country List page. Optionally, the user may also enter a maximum and/or minimum player age. After saving the input details (which are saved in local storage), the user may navigated back to the application home page, which will now display, in addition to a random quote, all the players that fit the input criteria - nationality and, optionally, an age range (e.g., all Irish players over the age of 24). All player data is retrieved in JSON format from the following source: https://app.sportdataapi.com  

### How to run the application:  
• Via the command prompt, navigate to the application src folder and enter the command "ionic serve".  

### Technology used:  
• Ionic v3  
• Angular  
• TypeScript  
• HTML  
• CSS  
• JSON  
• Node.js  
