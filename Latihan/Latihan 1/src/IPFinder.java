import java.net.*;
import java.io.*;

public class IPFinder {
    public static void main(String[] args) throws IOException {
        String host;
        BufferedReader input= new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Host Name: ");
        host= input.readLine();

        try {
            InetAddress address = InetAddress.getByName(host);
            System.out.println("IP Address: "+ address);
        }
        catch(UnknownHostException e){
            System.out.println("Could not find" + host);
        }

    }
}