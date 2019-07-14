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
    @FXML
    Button back;
    // public static pmsDB

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  pmsDB pmsdb=null;
        try {
            pmsDB pmsdb=new pmsDB();

            send.setOnAction(event -> {


                new Thread(()->{

                    try {
                        pm=pminput.getText();
                        pmsdb.addpm(Login.username,SearchANDHistory.username,pm);
                        Client.dataOutput.writeUTF(Login.username + ": "+  pm+"\n");
//            pms.setText(pm);
//            pms.setText(pm +"\n");
                        pms.appendText("You : " + pm + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();



            });




        } catch (Exception e) {
            e.printStackTrace();
        }

        info.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        info.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        new Thread(()->{
            try {
                while (true) {
                    //   pm=pminput.getText();
//                pms.setText(Client.dataInput.readUTF()+"\n");
                    if(Login.opusername.equals(SearchANDHistory.username) && Login.username.equals(SearchANDHistory.opsearchusername))
                         pms.appendText(Client.dataInput.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
