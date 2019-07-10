import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
        @FXML
        Button Loginbtn;
        @FXML
        Button Signupbtn;
        @FXML Text txt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Signupbtn.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signup.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

   Loginbtn.setOnAction(event -> {
       try {
           Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));

       } catch (IOException e) {
           e.printStackTrace();
       }
   });

    }
}
