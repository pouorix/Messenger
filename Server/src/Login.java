import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    TextField txtfusername;
    @FXML
    TextField txtfpassword;
    @FXML
    Button login;
    @FXML
    Text passwordisincorrect;
    @FXML
    Text usernameisincorrect;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        login.setOnAction(event -> {
            String username=txtfusername.getText();
            String password=txtfpassword.getText();
            try {
                PersonDB personDB=new PersonDB();
                if(personDB.getPerson(username).isEmpty())
                    usernameisincorrect.setText("Username is incorrect");
                else {
                    if (personDB.getPerson(username).get(3) != password) {
                        passwordisincorrect.setText("Password is incorrect");
                    }
                    else
                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });



    }
}
