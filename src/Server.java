/*
 * @(#)Server.java	1.0 10/12/09
 *
 * Psuedocode
 *   Start server socket on port 5000
 *   Listen for incoming connections
 *   Create new ClientHandler to manage each new connection
 *   Shutdown the server when done
 *   
 * UML Diagram
 * --------------------------------------------------
 *                     Server
 * --------------------------------------------------
 *  -server: ServerSocket
 *  -c: ClientHandler
 * --------------------------------------------------
 *  +main(String[]): void
 * --------------------------------------------------
 * 
 * Change Log
 * v1.0
 *  -initial release
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket server = new ServerSocket(5000);

		while (true)
		{
			// wait for new client to connect
			Socket client = server.accept();
			System.out.println ("Accepted connection from: " + client.getInetAddress ());
			// create clienthandler to manage new incoming connection
			ClientHandler c = new ClientHandler(client);
			c.start ();
		}
	}
}