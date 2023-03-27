package ie.atu.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

	public static List<String> names = new ArrayList<String>(); 

	public static void main(String[] args) throws IOException {
		
		// access port number from the configuration file
		String configFile = "config.txt";
		BufferedReader br = new BufferedReader(new FileReader(configFile));
		int port = Integer.parseInt(br.readLine());

		ExecutorService pool = Executors.newFixedThreadPool(50); 

		try (ServerSocket server = new ServerSocket(port)) {
			while (true) { // keeps server socket open and listening out for connections
				System.out.println("Listening for connection on port " + port + "..."); 
				try { 
					Socket connection = server.accept(); // blocks and waits until a connection is set up
					System.out.println("Client connected from " + connection.getInetAddress() + ":" + connection.getPort()); // print client's IP Address and Port number
					Callable<Void> task = new ServerThread(connection); 
					pool.submit(task); 
				} catch (IOException ex) {
				}
			}
		} catch (IOException ex) {
			System.err.println("[ERROR] Couldn't start server");
		}
	}

	private static class ServerThread implements Callable<Void> { 

		private Socket connection;
		private String name;

		ServerThread(Socket connection) {
			this.connection = connection;
		}

		@Override
		public Void call() {
			try (
					PrintWriter out = new PrintWriter(connection.getOutputStream(), true); // auto-flush set to true
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					) {

				// read in client's username and add it to the list
				name = in.readLine();
				names.add(name);

				out.println("Welcome to the Echo Server " + name + "!\nCurrently active: " + names);
				
				// echo client's messages
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					out.println("[" + name + "]: " + inputLine); 
				}
				names.remove(name);
			} catch (IOException ex) {
				System.err.println(ex);
			} 
			finally {
				try {
					connection.close();
				} catch (IOException e) {
				}
			}
			return null;
		}
	}

}
