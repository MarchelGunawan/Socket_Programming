import java.io.*;
import java.net.*;
import java.rmi.server.SocketSecurityException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 7777);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hello server, how are you?");

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
