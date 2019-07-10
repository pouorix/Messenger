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
        String pm=pminput.getText();
        info.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
