import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
                        Server.dataOutput.writeUTF(Login.username + ": "+  pm+"\n");
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
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        back.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearhANDHIstory.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        new Thread(()->{
            try {
                while (true) {
                    //   pm=pminput.getText();
//                pms.setText(Server.dataInput.readUTF()+"\n");





                    //logine man va sah un .... sah man ba logine un




                if(SearchANDHistory.username.equals(Login.opusername) && Login.username.equals(SearchANDHistory.opsearchusername))
                    pms.appendText(Server.dataInput.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
