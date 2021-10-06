import java.net.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert IP Number: ");
            String host = scan.next();
            InetAddress address = null;
            try{
                address = InetAddress.getByName(host);
            }catch(UnknownHostException e){
                System.out.println("Invalid IP");
                System.exit(0);
            }
            System.out.println(address.getHostName());
            scan.close();
    }
}
