import java.net.*;
import java.util.Scanner;

public class IPtoName2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert IP Number : ");
        String host = scan.next();
            InetAddress address = null;
            address = InetAddress.getByName(host);
            System.out.println(address.getHostName());
    }
}
