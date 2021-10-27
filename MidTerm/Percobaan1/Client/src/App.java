import java.net.*;
import java.io.*;

public class App{
    
	public static void main(String[] args) throws Exception{
        /* 
        take ip of localhost, using localhost because the client and server still in one computer 
        so we don't need to transmite by network.
        */
        InetAddress host = InetAddress.getLocalHost();
		Socket socket = new Socket(host, 1234);
        // tell client connect to server
        System.out.println("--- Client is connected to server ---");
        System.out.print("Input Message: ");
        
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //Send data to server
            
        BufferedReader strMessage = new BufferedReader(new InputStreamReader(socket.getInputStream())); // read data coming to server
                    
        BufferedReader message = new BufferedReader(new InputStreamReader(System.in)); // read data from the keyboard
        String str, str1; // str for input keyboard and str1 for message from server 
                        
        // repeat as long as not type "Exit"
        while (!(str = message.readLine()).equals("Exit")) {                    
            // send data to the server
            dos.writeBytes(str + "\n");
            // receive data or the message from the server
            str1 = strMessage.readLine();
            // if message from server Exit so the will break from while
            if (str1.equals("Exit"))
                break;
            // showing the reply from server
            System.out.println("Server reply: "+str1);
            // for showing input message for client
            System.out.print("Input Message: ");
        }
        // since already comeout from while will showing "Connection is closed"
        System.out.println("Connection is closed");
        // close connection.
        dos.close();
        strMessage.close();
        message.close();
        socket.close();
    }
}
