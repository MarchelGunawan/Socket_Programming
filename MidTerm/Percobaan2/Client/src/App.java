import java.io.*;
import java.net.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 7777);
            System.out.println("--- Client is connected to server ---");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                System.out.print("Input message: ");
                String message = scan.nextLine();
                oos.writeObject(message);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String strMessage = (String)ois.readObject();
                if (strMessage.equalsIgnoreCase("Exit")) {
                    System.out.println();
                    scan.close();
                    oos.close();
                    ois.close();
                    break;
                } else {
                    System.out.println("Server reply : " + strMessage);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
