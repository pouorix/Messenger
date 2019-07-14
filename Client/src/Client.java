import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {


        Socket socket = new Socket("localhost",8081);
        DataOutputStream dataOutput=new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInput=new DataInputStream(socket.getInputStream());

        while(true)
            System.out.println(dataInput.readUTF());
    }
}