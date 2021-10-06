import java.net.*;
import java.util.Scanner;

public class getname {
    public static void main(String[] args) throws Exception {
        InetAddress host = null;
        host = InetAddress.getLocalHost();
        System.out.println(host.getHostName());;
    }    
}
