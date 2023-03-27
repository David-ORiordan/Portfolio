# The-Whiskey-Barrel-Business-Website
Website developed for a fictional business called The Whiskey Barrel

### Description:  
A business e-commerce website that employs the principles of HTML5, CSS and JavaScript. For the purposes of the project, I created a fictional whiskey seller business called The Whiskey Barrel. 

### Features: 
- The website displays a range of product details (name, image, description, and price). The use may add products (at a quantity of their choosing) to the basket.  
- The website connects to a database that contains product information (i.e., product ID, name, price, description, and image URL). This information is accessible via PHP and used to display product information throughout the website.  
- Users may login to their account (entering the hardcoded username and password of "david" and "pass", respectively, allows the user to login) to make purchases. Note that "purchase" here are purely theoretical, with the basket's contents being emptied and a thank you message being displayed upon checkout.  
- Form validation is used throughout the website. Attempting to submit details while the username and/or password input boxes are empty results in a message being displayed. Signing up to a fictional mailing list requires a valid email address to be input before submission. When engaging with the quantity input boxes accompanying each product, and attempts to enter a quantity of zero to the basket will be rejected. All form validation is achieved through HTML.  
- A carousel displaying a revolving selection of images highlighting staff picked whiskies. 

### How to run:  
Start Apache and MySQL in the XAMPP Control Panel.  
Through your web browser, go to http://localhost/phpmyadmin/. Upload the SQL file to the database.    
Store the PHP and images directory pertaining to the website in the \xampp\htdocs directory on your local drive.  
Open the website on your web browser via Localhost by entering http://localhost/The%20Whiskey%20Barrel.php  

### Technology used:  
- HTML  
- CSS  
- JavaScript
- BootStrap 5
- PHP
- XAMPP Server
