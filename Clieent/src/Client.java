import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Application {
    public static DataInputStream dataInput;
    public static DataOutputStream dataOutput;

    static Stage stage;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8081);
       // Socket socket=serversocket.accept();
        dataOutput=new DataOutputStream(socket.getOutputStream());
        dataInput=new DataInputStream(socket.getInputStream());
         launch();
//        while(true) {
//            Scanner scan = new Scanner(System.in);
//            String test = scan.next();
//            dataOutput.writeUTF(test);
//        }
    }

    @Override
    public void start(Stage Stage) throws Exception {
        stage=Stage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage.setScene(new Scene(root,400,600));
        Stage.setTitle("Client");
        stage.alwaysOnTopProperty();
        Stage.show();
    }
}
