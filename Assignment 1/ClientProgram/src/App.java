import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scan = new Scanner(System.in);
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 7777);

            System.out.print("Say something to Server : ");
            String clientMessage = scan.nextLine();

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(clientMessage);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String strMessage = (String)ois.readObject();
            System.out.println("Server says : " + strMessage);
            oos.close();
            ois.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
