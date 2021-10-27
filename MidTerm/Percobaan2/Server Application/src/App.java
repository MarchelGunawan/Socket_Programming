import java.io.*;
import java.net.*;
import java.util.*;

public class App {
    private ServerSocket server;
    private int port = 7777;
    public static boolean condition = true;
    static volatile boolean finished = false;
    public static final String TERMINATE = "Exit";
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
        System.out.println("--- Server is run ---");
        while(condition){
            try{
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            }catch (Exception e){
                System.out.println("Connection closed");
                // e.printStackTrace();
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
        Scanner scan = new Scanner(System.in);
        String message;
        try {
            while (!App.finished) {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String strMessage = (String)ois.readObject();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                if (strMessage.equalsIgnoreCase(App.TERMINATE)) {
                    scan.close();
                    System.out.println("Connection closed");
                    App.condition = false;
                    App.finished = true;
                    oos.close();
                    ois.close();
                    socket.close();
                    break;
                }else{
                    System.out.println("Client says : " + strMessage);
                    System.out.print("Type reply: ");
                    message = scan.nextLine();
                    oos.writeObject(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
