import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    public static String pm;
    @FXML
    TextField pminput;
    @FXML
    TextArea pms;
    @FXML
    Button send;
    @FXML
    Button info;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        info.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

send.setOnAction(event -> {


    new Thread(()->{

        try {
            pm=pminput.getText();
            Client.dataOutput.writeUTF(Login.username +": "+ pm+"\n");

//            pms.setText("You : " + pm +"\n");
            pms.appendText("You : " + pm + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();




});

        new Thread(()->{
            try {
                pm=pminput.getText();
//                pms.setText(Client.dataInput.readUTF()+"\n");
                pms.appendText(Client.dataInput.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
