package OneClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class implements java socket client
 *
 * @author pankaj
 */
public class TCPClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        socket = new Socket(host.getHostName(), 1234);
        for (int i = 0; i < 5; i++) {
            //establish socket connection to server
//            if (socket == null)
//            socket = new Socket(host.getHostName(), 1234);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket TCPServer");
            if (i == 4) {
                oos.writeObject("exit");
            } else {
                oos.writeObject("" + i);
            }
            //read the server response message
//            ois = new ObjectInputStream(socket.getInputStream());
//            String message = (String) ois.readObject();
//            System.out.println("Message: " + message);
//            close resources
//            ois.close();
//            oos.close();
            Thread.sleep(2000);
        }
        oos.close();
    }
}
