package ie.atu.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client { 

	public static void main(String[] args) throws IOException {

		// access port number and host name from the configuration file
		String configFile = "config.txt";
		BufferedReader br = new BufferedReader(new FileReader(configFile));
		int port = Integer.parseInt(br.readLine());
		String host = br.readLine();

		Scanner s = new Scanner(System.in);

		try (
				Socket socket = new Socket(host, port);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
				) {

			System.out.println("Connected to Echo Server on host " + host); 

			socket.setSoTimeout(15000); // if the above hasn't completed within 15 seconds, stop

			// enter a username, which is sent across to the server
			System.out.print("Enter your name: ");
			String name = s.nextLine();
			out.println(name);

			System.out.println(socketIn.readLine()); // prints "Welcome to the Chat Server " + user's name
			System.out.println(socketIn.readLine() + "\n"); // prints "Currently active: " + currently users connected to the server 

			String userInput;
			while (!(userInput = userIn.readLine()).equals("\\q")) { // entering "\q" allows the user to gracefully exit the server 
				out.println(userInput); // sends the user text to the server
				System.out.println(socketIn.readLine()); // displays text received from the server
			}
			System.out.println(name + " has left the server...");
		} catch (UnknownHostException e) {
			System.out.println("[ERROR] Cannot connect to host");
		} catch (IOException e) {
			System.out.println("[ERROR] No connection to server. Server may not be currently active.");
		}
	}

}
