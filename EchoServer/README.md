# EchoServer

### Description of project design/implementation:  
EchoServer:
-	The EchoServer program is designed to start off by reading the port number found in the configuration file and opening a server socket on that port. The server socket blocks and waits until a client connection is accepted. 
-	A pool of 50 ServerThreads are created to handle any connections, thereby allowing multiple clients to connect to the EchoServer simultaneously.  After a client connection is accepted by the server socket, a ServerThread equipped with the connection is submitted to the thread pool. 
-	Each ServerThread declares a BufferedReader object and a PrintWriter object in a try-with-resources statement to handle input and output, respectively. The PrintWriter object is configured to auto-flush, and the try-with-resources statement ensures that the BufferedReader and PrintWriter objects are closed at the end of the statement. The client’s username is read and added to a list of client usernames, which is then used to display to the client the names of those who are currently connected to the EchoServer. 
-	Input messages from the client are read and then echoed back to the client alongside their username. 
-	After the client has closed the socket connection, their name is removed from the list of usernames. 

Client:
-	The Client program is designed to start off by reading the port number and host name from the configuration file.
-	In a try-with-resources statement, the program attempts to create a socket connection at the specified host and port, which is only possible if the EchoServer is already up and running. Additionally, two BufferedReader objects and a PrintWriter object are created to handle the EchoServer input, the user input, and the output. The try-with-resources statement ensures that the socket connection, BufferedReader objects, and the PrintWriter object all close automatically at the end of the statement.
-	If the socket connection is successfully made, a message is displayed on the client’s command prompt. If the connection is not made within 15 seconds, the program stops.  
-	Assuming the socket connection is established, the client is prompted to enter a username, which will then be sent over to the EchoServer. The client then receives a welcome message and is shown a list of clients currently connected to the EchoServer. The client may now input messages which, when sent, will be sent to the EchoServer and echoed back to them. If the client enters “\q”, they will disconnect from the EchoServer. 
-	If the client attempts to connect to the server through the wrong port number, the client will throw an I/O Exception. This exception is not expected to be thrown unless there is an error in reading the port number from the configuration file. 
-	If the client attempts to connect to the wrong host name, the client may throw Unknown Host Exception. This exception is not expected to be thrown unless there is an error in reading the host name from the configuration file.
-	If the client attempts to connect to the server when the server is not actively listening for connections, the client will throw an I/O Exception.
-	If the client and server connect initially but the connection is lost during the chat session, the client will throw an I/O Exception if the connection is lost on the server-side and the client then attempts to communication with the server. Alternatively, if the connection is lost on the client-side, the server will throw a Socket Exception.

It is worth noting that the configuration file is located in the src directory alongside the source code.  

### Instructions for running the application:  
-	Enter the src directory via the command prompt. Compile the EchoServer.java file and then run the file. 
-	Enter the src directory via a separate command prompt. Compile the Client.java file and then run the file. 
-	The Client program will attempt to create a socket connection with the EchoServer. If successful, the client is prompted to enter a username. 
-	The client may type in and send their messages through the command prompt. These messages should be received by the EchoServer and echoed back to the client. 
-	Multiple clients may connect to the EchoServer using their own command prompt, each able to have their messages echoed back to them.
-	The client may close the socket connection by entering “\q”.  


### Technology used:
- Java 19
