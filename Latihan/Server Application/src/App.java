import java.io.*;
import java.net.*;



public class App {
    private ServerSocket server;
    private int port = 7777;
    public App(){
        try{
            server = new ServerSocket(port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        App example = new App();
        example.handleConnection();
    }
    public void handleConnection(){
        System.out.println("Waiting for client message ...");
        while(true){
            try{
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class ConnectionHandler implements Runnable{
    private Socket Socket;
    private final Socket socket;

    public ConnectionHandler(Socket socket){
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    public void run(){
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String strMessage = (String)ois.readObject();
            System.out.println("Client says : " + strMessage);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hai client, I'm excellent... ");
            ois.close();
            oos.close();
            socket.close();
            System.out.println("Waiting for nexxt client's message ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
