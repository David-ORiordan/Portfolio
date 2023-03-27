<!doctype html>
<html lang="en">
  <head>
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
		<title>The Whiskey Barrel</title>
	</head>
  
  
	<style>
		/* Background image for body of website which is fixed (i.e., does not scroll) and covers the entirety of the website. Font set to helvetica */
		body {
			background-image: url("images/background-barrels.jpg");
			background-size: cover;
			background-attachment: fixed;
			font-family: Helvetica;
			}
			
		/* Style for text in the header */	
		#headerStyle {
			font-size: 18px;
			margin-left: 46px
			}		
			
		/* Style for Login Button in the modal */
		#submitLoginButton {
			border: none;
			border-radius: 4px;
			padding: 4px 18px;
			color: white;
			background-color: #0066ff;
			font-size: 15px;
			font-family: Helvetica;
		}	
		
		/* Float login button to the right of the header */	
		#loginFunction {
			float: right;
			margin-right: 46px;
			}
			
		/* Style for Login Button in the modal when hovering over button */
		#submitLoginButton:hover {
			background-color: #0060cc;
		}
			
		/* Style for checkout button in the offcanvas sidebar */
		#checkoutButton {
			border: none;
			border-radius: 4px;
			padding: 4px 18px;
			color: white;
			background-color: #0066ff;
			font-size: 18px;
			font-family: Helvetica;
		}
		
		/* Style for checkout button in the offcanvas sidebar when hovering over button */	
		#checkoutButton:hover {
			background-color: #0060cc;
		}
		
		/* Style for Submit Button for mailing list in the footer */
		#submitMailingListButton {
			border: none;
			border-radius: 4px;
			padding: 4px 18px;
			color: white;
			background-color: #0066ff;
			font-size: 15px;
			font-family: Helvetica;
		}
		
		/* Style for Submit Button for mailing list in the footer when hovering over button */
		#submitMailingListButton:hover {
			background-color: #0060cc;
		}
		
		/* Style for Add to Basket Button found in each card component */
		.addToBasketButton {
			border: none;
			border-radius: 4px;
			padding: 4px 18px;
			color: white;
			background-color: #0066ff;
			font-size: 15px;
			font-family: Helvetica;
		}
		
		/* Style for hovering over Add to Basket Button */
		.addToBasketButton:hover {
			background-color: #0060cc;
		}
		
		/* Style for carousel which places the captions below the images */
		.carousel-caption {
			position: relative;
			left: 0;
			top: 0;
		}
	</style>
	

<body>

	<!-- Div container for header of website, which contains the name of the business, a modal (for a user login option), and a offcanvas sidebar (for a view basket option) -->
	<!-- Code block for modal taken from: https://getbootstrap.com/docs/5.1/components/modal/ -->
	<!-- Code block for offcanvas sidebar taken from: https://getbootstrap.com/docs/5.1/components/offcanvas/#live-demo-->
	
	<!-- class adds padding, background colour, text colour to div as well as making the div span the width of the page -->
	<div class="p-3 bg-black text-white container-fluid">
		<!-- loginFunction id allows for style to float the buttons to the right -->
		<div id="loginFunction">
			<!-- Button to trigger login modal -->
			<button id="modalLogin" type="button" class="btn btn-primary left" data-bs-toggle="modal" data-bs-target="#exampleModal">Login</button>
			<!-- Button to open the offcanvas sidebar -->
			<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
			View Basket</button>
		</div>	
		<!-- headerStyle id provides font size for the text and places it to the left of the div -->
		<!-- headerStyle id tag is also called upon by the loginCheck() function to alter the text by adding textual confirmation that the user is logged in -->
		<p id="headerStyle"><b>Welcome to The Whiskey Barrel</b></p>
	</div>

		<!-- Modal code block -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<!-- modal-dialog-centered added to class to place the modal in the center of the page -->
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modalLabel">Please enter your login details.</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
				<div class="modal-body">
					<div class="container"> 
						<!-- onsubmit calls loginCheck() function to verfiy user's input details with hardcoded login details. Return false prevents page from refreshing after the function is called-->
						<form  onsubmit="loginCheck(); return false"> <!-- FORM TAGS MIGHT NOT BE NEEDED -->
							<!-- usernameLabel id is called upon by the loginCheck() function, which hides the label upon login -->
							<label id="usernameLabel" for="uname"><b>Username:</b></label>
							<br>
							<!-- usernameInput id is called upon by the loginCheck() function, which hides the input box upon login -->
							<!-- usernameInput input value is also used by the loginCheck() function to determine if the username is valid or not  -->
							<input id="usernameInput" type="text" placeholder="Enter Username" name="uname" required>
							<br><br>
							<!-- closeWindow id is called upon by the loginCheck() function when login is successful. In this case, it adds text to the modal informing the user to close the window to continue shopping -->
							<!-- style color: red makes the text in closeWindow to red -->
							<label id="closeWindow" style="color:red"></label>
							<!-- passwordLabel id is called upon by the loginCheck() function, which hides the label upon login -->
							<label id="passwordLabel" for="psw"><b>Password:</b></label>
							<br>
							<!-- passwordInput id is called upon by the loginCheck() function, which hides the input box upon login -->
							<!-- passwordInput input value is also used by the loginCheck() function to determine if the password is valid or not  -->
							<input id="passwordInput" type="password" placeholder="Enter Password" name="psw" required>
							<br><br>
							<!-- submitLoginButton id is called upon by the loginCheck() function, which hides the button upon login -->
							<input id="submitLoginButton" type="submit" value="Submit">
						</form>
					</div>
				</div>
			</div>
		  </div>
		</div>
		<!-- End of modal code block -->
		
		<!-- Script for login capability within the modal -->
		<script>
			// user login status default setting is false (not logged in). User cannot make purchases without loggin in
			loggedIn = false; 
			
			// This function performs the login feature by checking user's input username and password 
			function loginCheck() {
				
				// Hardcoded user details. username = david, password = pass
				var loginArray = ["david", "pass"];
				
				// If statement compares user input details with expected hardcoded user details
				// If input details match hardcoded details, the modal alters appearance and informs the user they have logged in, and the "Welcome to the Whiskey Barrel" text in the header is amended, adding that the user is logged in
				if (usernameInput.value == loginArray[0] && passwordInput.value == loginArray[1]) {
					document.getElementById("headerStyle").innerHTML = "<b>Welcome to The Whiskey Barrel, " + loginArray[0] + " is logged in.</b>"; 
					document.getElementById("modalLabel").innerHTML = "<b>You are now logged in.</b>";
					document.getElementById("usernameInput").style.visibility = "hidden";
					document.getElementById("usernameLabel").style.visibility = "hidden";
					document.getElementById("passwordInput").style.visibility = "hidden";
					// display:none rather than visibility=hidden as it helps the modal retain it's shape after login causes elements to be hidden, no other reason 
					document.getElementById("passwordLabel").style.display = "none"; 
					document.getElementById("submitLoginButton").style.visibility = "hidden";
					document.getElementById("modalLogin").style.visibility = "hidden";
					document.getElementById("closeWindow").innerHTML = "<b><i>Please close this window to continue shopping.</i></b>"
					// user can now make purchases
					loggedIn = true; 
					// removes "You must log in to make a purchase", if an attempt to make a purchase was made before being logged in
					document.getElementById("checkoutMessage").innerHTML = "";
				} 
				// If input username does not match hardcoded username, an alert appears telling the user they have entered an invalid username
				else if (usernameInput.value != loginArray[0]) {
					alert("Invalid username. Please try again.")
				} 
				// If input username matchs hardcoded username but wrong password used, an alert appears telling the user their password is wrong
				else if (usernameInput.value == loginArray[0] && passwordInput.value != loginArray[1]) {
					alert("Incorrect password. Please try again.")
				} 
			}
		</script> 	
		<!-- End of script for login capability within the modal -->
  
		<!-- Offcanvas Sidebar code block -->
		<!-- offcanvas-end added to class to place the offcanvase sidebar in the right of the page -->
		<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="offcanvasExampleLabel">Basket Contents</h5>
				<button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<div>
					<!-- Items added to basket appear here in the following slots (item1 to item8) with a running total at the bottom -->
					<p id="item1"></p>
					<p id="item2"></p>
					<p id="item3"></p>
					<p id="item4"></p>
					<p id="item5"></p>
					<p id="item6"></p>
					<p id="item7"></p>
					<p id="item8"></p>
					<!-- class makes the text red, the span is where the running total cost is entered, with total initially set to €0.00 -->
					<p class="text-danger"><b>Total Price:</b> €<span id="basketTotal">0.00</span></p>
					<!-- checkoutButton id creates styling for the checkout button -->
					<!-- checkout() function is called when button is clicked -->
					<button id="checkoutButton" onclick="checkout()" type="button">Checkout</button>
					<!-- checkout() function inserts a message here -->
					<p id="checkoutMessage"></p>
				</div>
			</div>
		</div>
		<!-- End of offcanvas Sidebar code block -->
		
		<!-- Script for checkout capability within the offcanvas sidebar -->
		<script>
			// This function determines what happens when the user attempts to checkout and alters its response based on whether the user is logged out, the basket is empty, or if a valid purchase is being made by a logged in user
			function checkout() {
				// if statement checks if the user is logged in or not and displays a message if they are not logged in
				if (loggedIn == false) {
					document.getElementById("checkoutMessage").innerHTML = "<i>You must log in to make a purchase.</i>";
				}
				// else if statement checks if the basket is empty (which it will be if total price is equal to zero) and displays a message if so
				else if (totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7] == 0) {
					document.getElementById("checkoutMessage").innerHTML = "<i>Cannot checkout while basket is empty!</i>";
				}
				// else statement runs if user is logged in and there are items in the basket. A thank you message is displayed, the basket is emptied, the basketTotal price is reset to 0.00, and the totalPriceArray is also reset 
				else {
					document.getElementById("checkoutMessage").innerHTML = "<i>Thank you for your purchase!</i>";
					document.getElementById("item1").style.display = "none";
					document.getElementById("item2").style.display = "none";
					document.getElementById("item3").style.display = "none";
					document.getElementById("item4").style.display = "none";
					document.getElementById("item5").style.display = "none";
					document.getElementById("item6").style.display = "none";
					document.getElementById("item7").style.display = "none";
					document.getElementById("item8").style.display = "none";
					document.getElementById("basketTotal").innerHTML = "0.00";
					totalPriceArray = [0, 0, 0, 0, 0, 0, 0, 0];
				}
			}
		</script>
		<!-- End of script for checkout capability within the offcanvas sidebar -->
	<!-- End of div container for header of website -->
	

	<!-- Div container for carousel code block --> 
	
	<!-- class adds margin spacing on the top and bottom, padding, background colour, text colour to div as well as centering the text within the div -->
	<div class="mt-4 mb-5 p-2 bg-black text-white container text-center">
		<h5>The Whiskey Barrel Staff Recommends...</h5>
   
		<!-- Bootstrap "carousel" component with controls, indicators and captions to display staff recommendations -->   
		<!-- Code block taken from: https://getbootstrap.com/docs/5.1/components/carousel/#with-captions -->  
		<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" ></button>
				<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" ></button>
				<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" ></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
				<!-- mx-auto added to class to center images in the carousel, w-25 for width of the images -->
				<img src="images/StaffPick1-Jameson-Black-Barrel.jpg" class="mx-auto d-block w-25" alt="Jameson Black Barrel Whiskey">
				<div class="carousel-caption d-none d-md-block">
					<p>Jameson Black Barrel Whiskey</p>
				</div>
			</div>
			<div class="carousel-item">
			<!-- mx-auto added to class to center images in the carousel, w-25 for width of the images -->
				<img src="images/StaffPick2-Redbreast-12-Year-Old.jpg" class="mx-auto d-block w-25" alt="Redbreast 12 Year Old Whiskey">
				<div class="carousel-caption d-none d-md-block">
					<p>Redbreast 12 Year Old Whiskey</p>
				</div>
			</div>
			<div class="carousel-item">
			<!-- mx-auto added to class to center images in the carousel, w-25 for width of the images -->
				<img src="images/StaffPick3-Yellow-Spot-12-Year-Old.jpg" class="mx-auto d-block w-25" alt="Yellow Spot 12 Year Old Whiskey">
				<div class="carousel-caption d-none d-md-block">
					<p>Yellow Spot 12 Year Old Whiskey</p>
				</div>
			</div>
			</div>
				<!-- adds capability to scroll back through carousel images -->
				<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
				</button>
				<!-- adds capability to scroll forward through carousel images -->
				<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
				</button>
		</div>	
		<!-- End carousel code block --> 
		
	</div>	
	<!-- End of div container for carousel code block --> 
	
	
	<!-- Connection to a database which contains product information --> 
	<!-- Product information inserted into card components in the next code block --> 
	<!-- Code block derived from course lecture video (Week 11, Retrieving values from Database using PHP and Javascript) from: https://web.microsoftstream.com/video/d9e13d6c-b256-4f59-8ca8-9630fdd81b63 -->  
	<?php
	
		// Step 1:  Create a database connection
			$dbhost = "localhost";
			$dbuser = "root";
			$dbpassword = "";
			$dbname = "g00258621";

			$connection = mysqli_connect($dbhost,$dbuser,$dbpassword,$dbname);
			
			// Test if connection occoured
			if(mysqli_connect_errno()){
				die("DB connection failed: " .
					mysqli_connect_error() .
						" (" . mysqli_connect_errno() . ")"
						);
			}

			if (!$connection)
				{
					die('Could not connect: ' . mysqli_error());
				}
		
		// Step 2: Perform Database Query
		
			// Retrieve database information related to Redbreast 12 Year Old (ID=1)
			$sql1 = ("SELECT * FROM products WHERE ID = '1';");
			$result = mysqli_query($connection, $sql1);
			$row1 = mysqli_fetch_assoc($result);
		
			// Retrieve database information related to Teeling Small Batch Whiskey (ID=2)
			$sql2 = ("SELECT * FROM products WHERE id = '2';");
			$result = mysqli_query($connection, $sql2);
			$row2 = mysqli_fetch_assoc($result);
			
			// Retrieve database information related to Green Spot Single Pot Still (ID=3)
			$sql3 = ("SELECT * FROM products WHERE id = '3';");
			$result = mysqli_query($connection, $sql3);
			$row3 = mysqli_fetch_assoc($result);
			
			// Retrieve database information related to Yellow Spot 12 Year Old (ID=4)
			$sql4 = ("SELECT * FROM products WHERE id = '4';");
			$result = mysqli_query($connection, $sql4);
			$row4 = mysqli_fetch_assoc($result);
			
			// Retrieve database information related to Jameson Black Barrel (ID=5)
			$sql5 = ("SELECT * FROM products WHERE id = '5';");
			$result = mysqli_query($connection, $sql5);
			$row5 = mysqli_fetch_assoc($result);
			
			// Retrieve database information related to Jameson (ID=6)
			$sql6 = ("SELECT * FROM products WHERE id = '6';");
			$result = mysqli_query($connection, $sql6);
			$row6 = mysqli_fetch_assoc($result);
			
			// Retrieve database information related to Tullamore Dew 12 Year Old (ID=7)
			$sql7 = ("SELECT * FROM products WHERE id = '7';");
			$result = mysqli_query($connection, $sql7);
			$row7 = mysqli_fetch_assoc($result);
			
			// Retrieve database information related to Tullamore Dew (ID=8)
			$sql8 = ("SELECT * FROM products WHERE id = '8';");
			$result = mysqli_query($connection, $sql8);
			$row8 = mysqli_fetch_assoc($result);
			
		// Step 3:  Close database connection
		mysqli_close($connection);
			
	?>
	<!-- End database connection code block --> 
	
 
	<!-- Bootstrap "card" component to display the website's stock items --> 
	<!-- Product information used within each card is derived from the database connection code block above --> 
	<!-- Code block derived from: https://getbootstrap.com/docs/5.1/components/card/#horizontal -->
	<!-- Card Group 1 houses cards 1 and 2 --> 
	<div class="card-group">
		<!-- Card 1 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row1['imageURL'] ?>" class="img-fluid" alt="<?php echo $row1['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row1['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row1['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row1['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems1 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems1(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityA" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 1 -->
		
		<!-- Script for adding card 1's item details into the offcanvas sidebar -->
		<script>	
			// array keeps track of the total cost of the user's purchase. All items initially set to zero and then each individual item's array index is updated each time an item is added to the basket
			var totalPriceArray = [0, 0, 0, 0, 0, 0, 0, 0];
			
			// This function allows the user to add the item to their basket
			function addingItems1() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity1 = quantityA.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice1 = quantityA.value * <?php echo $row1['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item1").innerHTML = "<b><?php echo $row1['Product_name'] ?></b><br> - Quanity: " + quantity1 + ", Price: €" + quantityAndPrice1;
					
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[0] = quantityAndPrice1;
				// this adds the cost to the running total price	
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item1").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 1's item details into the offcanvas sidebar -->
		
		<!-- Card 2 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row2['imageURL'] ?>" class="img-fluid" alt="<?php echo $row2['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row2['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row2['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row2['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems2 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems2(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityB" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 2 -->
		
		<!-- Script for adding card 2's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems2() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity2 = quantityB.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice2 = quantityB.value * <?php echo $row2['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item2").innerHTML = "<b><?php echo $row2['Product_name'] ?></b><br> - Quanity: " + quantity2 + ", Price: €" + quantityAndPrice2;
					
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[1] = quantityAndPrice2;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item2").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 2's item details into the offcanvas sidebar -->
	</div>
	<!-- End of Card Group 1 -->
	
	<!-- Card Group 2 houses cards 3 and 4  -->
	<div class="card-group">
		<!-- Card 3 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row3['imageURL'] ?>" class="img-fluid rounded-start" alt="<?php echo $row3['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row3['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row3['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row3['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems3 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems3(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityC" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 3 -->
		
		<!-- Script for adding card 3's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems3() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity3 = quantityC.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice3 = quantityC.value * <?php echo $row3['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item3").innerHTML = "<b><?php echo $row3['Product_name'] ?></b><br> - Quanity: " + quantity3 + ", Price: €" + quantityAndPrice3;
				
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[2] = quantityAndPrice3;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item3").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 3's item details into the offcanvas sidebar -->
		
		<!-- Card 4 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row4['imageURL'] ?>" class="img-fluid rounded-start" alt="<?php echo $row4['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row4['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row4['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row4['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems4 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems4(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityD" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 4 -->
		
		<!-- Script for adding card 4's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems4() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity4 = quantityD.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice4 = quantityD.value * <?php echo $row4['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item4").innerHTML = "<b><?php echo $row4['Product_name'] ?></b><br> - Quanity: " + quantity4 + ", Price: €" + quantityAndPrice4;
				
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[3] = quantityAndPrice4;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item4").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 4's item details into the offcanvas sidebar -->
	</div>
	<!-- End of Card Group 2 -->
	
	<!-- Card Group 3 houses cards 5 and 6 -->
	<div class="card-group">
		<!-- Card 5 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row5['imageURL'] ?>" class="img-fluid rounded-start" alt="<?php echo $row5['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row5['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row5['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row5['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems5 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems5(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityE" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 5 -->
		
		<!-- Script for adding card 5's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems5() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity5 = quantityE.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice5 = quantityE.value * <?php echo $row5['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item5").innerHTML = "<b><?php echo $row5['Product_name'] ?></b><br> - Quanity: " + quantity5 + ", Price: €" + quantityAndPrice5;
				
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[4] = quantityAndPrice5;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item5").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 5's item details into the offcanvas sidebar -->
		
		<!-- Card 6 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row6['imageURL'] ?>" class="img-fluid rounded-start" alt="<?php echo $row6['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row6['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row6['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row6['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems6 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems6(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityF" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 6 -->
		
		<!-- Script for adding card 6's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems6() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity6 = quantityF.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice6 = quantityF.value * <?php echo $row6['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item6").innerHTML = "<b><?php echo $row6['Product_name'] ?></b><br> - Quanity: " + quantity6 + ", Price: €" + quantityAndPrice6;
					
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[5] = quantityAndPrice6;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item6").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 6's item details into the offcanvas sidebar -->
	</div>
	<!-- End of Card Group 3 -->
	
	<!-- Card Group 4 houses cards 7 and 8 -->
	<div class="card-group">
		<!-- Card 7 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->
					<img src="<?php echo $row7['imageURL'] ?>" class="img-fluid rounded-start" alt="<?php echo $row7['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row7['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row7['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row7['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems7 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems7(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityG" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 7 -->
		
		<!-- Script for adding card 7's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems7() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity7 = quantityG.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice7 = quantityG.value * <?php echo $row7['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item7").innerHTML = "<b><?php echo $row7['Product_name'] ?></b><br> - Quanity: " + quantity7 + ", Price: €" + quantityAndPrice7;
				
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[6] = quantityAndPrice7;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item7").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 7's item details into the offcanvas sidebar -->
		
		<!-- Card 8 -->
		<!-- margin and padding added to card -->
		<div class="card m-4 p-2">
			<div class="row g-5">
				<div class="col-md-4">
					<!-- class contains img-fluid to alter the fit of the image inside of card -->
					<!-- image and product name displayed in the card are acquired through the connection to the "products" database -->	
					<img src="<?php echo $row8['imageURL'] ?>" class="img-fluid rounded-start" alt="<?php echo $row8['Product_name'] ?>">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<!-- product name displayed in the card is acquired through the connection to the "products" database -->
						<h5 class="card-title"><?php echo $row8['Product_name'] ?></h5>
						<!-- description displayed in the card is acquired through the connection to the "products" database -->
						<p class="card-text"><?php echo $row8['Description'] ?></p>
						<!-- price displayed in the card is acquired through the connection to the "products" database -->
						<!-- text-danger class displays the price in red -->
						<p class="card-text"><small class="text-danger">Price: €<?php echo $row8['Price'] ?></small></p>
						<!-- Form for adding purchases to basket -->
						<!-- onsubmit calls the addingItems8 function, which adds the product name, quantity and price to the order. Return false prevents page from reloading -->
						<form onsubmit="addingItems8(); return false">
							<label>Quantity:</label>
							<!-- "quantity" id allows the function to access the input quantity amount. The min amount ensures only amounts of 1 or more are valid. A step of 1 ensures only whole numbers are valid. Value is set to an initial 0. Style allows the width of the input box to be set -->
							<input type="number" id="quantityH" min="1" step="1" value="0" style="width: 50px">
							<!-- class style alters the appearance of the button-->
							<input class="addToBasketButton" type="submit" value="Add to Basket">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End of card 8 -->
		
		<!-- Script for adding card 8's item details into the offcanvas sidebar -->
		<script>
			// This function allows the user to add the item to their basket
			function addingItems8() {
				
				// variable for the quantity amount, derived from the quantity input box
				var quantity8 = quantityH.value;
				// variable for the price multiplied by the quantity
				var quantityAndPrice8 = quantityH.value * <?php echo $row8['Price'] ?>;
				// this adds the item name, quantity and total price to the offcanvas sidebar
				document.getElementById("item8").innerHTML = "<b><?php echo $row8['Product_name'] ?></b><br> - Quanity: " + quantity8 + ", Price: €" + quantityAndPrice8;
					
				// this adds the cost to the specific array index reserved for this item in the running total price	
				totalPriceArray[7] = quantityAndPrice8;
				// this adds the cost to the running total price
				document.getElementById("basketTotal").innerHTML = totalPriceArray[0] + totalPriceArray[1] + totalPriceArray[2] + totalPriceArray[3] +totalPriceArray[4] + totalPriceArray[5] + totalPriceArray[6] + totalPriceArray[7];
				
				// this makes item visible again in the basket if it was hidden due to a puchase having already been made
				document.getElementById("item8").style.display = "block";
				
				// removes "Cannot checkout while basket is empty!", if user is adding items to basket again after having made a purchase
				document.getElementById("checkoutMessage").innerHTML = "";
			}
		</script>
		<!-- End of script for adding card 8's item details into the offcanvas sidebar -->
	</div>
	<!-- End of Card Group 4 -->
	<!-- End card code block -->
	
	
	<!-- Div container for footer of website -->
	<!-- Footer contains an option for users to enter their email address to sign up for the business' mailing list -->
	
	<!-- class adds margin spacing on the top, padding, background colour, text colour to div as well as making the div span the width of the page -->
	<div class="mt-5 p-3 bg-black text-white container-fluid">
		<p>Why not get in touch?
		<br>
		You can email us at: thewhiskeybarrel@gmail.com
		<br>
		You can also join our mailing list to receive weekly news and updates from your favourite whiskey vendor:
			<!-- mailingListConfirmation() function is called once email address is submitted -->
			<form onsubmit="mailingListConfirmation(); return false"> 
				<input type="email" placeholder="Enter Email Address" name="uname" required>
				<!-- id styles the submit button -->
				<input id="submitMailingListButton" type="submit" value="Submit">
			</form>
		</p>
		<p><i>Please drink alcohol responsibly.</i></p>
	</div>
	<!-- End of div container for footer of website -->
	
	<!-- Script for displaying an alert upon successful email submission -->
	<script>
		// This function displays an alert informing the user that they have signed up to the mailing list.
		// Function will only be called after email input validation criteria is met
		function mailingListConfirmation() {
			
			// the content of the alert informing the user that they have signed up to the mailing list.
			var mailingList = "Thank you for signing up to our mailing list!";
			alert(mailingList);	
		}
	</script> 
	<!-- End of script for displaying an alert upon successful email submission -->
	

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
	
	
</body>

  
</html>