import java.net.*;
import java.io.*;

public class App{
	public static void main(String[] args)throws Exception{
		ServerSocket server = new ServerSocket(1234);
        // tell server is running now
        System.out.println("--- Server is run ---");
  
        Socket socket = server.accept(); // waiting client to connect server

        PrintStream ps = new PrintStream(socket.getOutputStream()); // send data to client

        BufferedReader strMessage = new BufferedReader(new InputStreamReader(socket.getInputStream())); // read data from client

        BufferedReader message = new BufferedReader(new InputStreamReader(System.in)); // read data from keyboard
  
        // server executes continuously
        while (true) {
  
            String str, str1; // str for message from client and str1 for to reply the message
  
            // as long as not null the program will not end
            while ((str = strMessage.readLine()) != null) {
                // showing message got from client
                System.out.println("Client message: "+str);
                System.out.print("Type reply: ");
                // reply to client
                str1 = message.readLine();  
                // send to client
                ps.println(str1);
                // if server type Exit so server will be closed
                if (str1.equals("Exit"))
                    break;
            }
            // showing connection of server closed
            System.out.println("Connection closed");
            // close connection
            ps.close();
            strMessage.close();
            message.close();
            server.close();
            socket.close();
  
            // terminate application
            System.exit(0);
        }
    }
}
