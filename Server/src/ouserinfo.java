import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ouserinfo implements Initializable {
    @FXML
    Text username;
    @FXML
    Text firstname;
    @FXML
    Text lastname;
    @FXML
    Text email;

    @FXML
    Text phonenumber;

    @FXML
    Button back;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PersonDB personDB=null;
        try {
            personDB=new PersonDB();
        } catch (Exception e) {
            e.printStackTrace();
        }

        username.setText(SearchANDHistory.username);
        try {
            firstname.setText(personDB.getPerson(SearchANDHistory.username).get(0));
            lastname.setText(personDB.getPerson(SearchANDHistory.username).get(1));
            email.setText(personDB.getPerson(SearchANDHistory.username).get(4)); firstname.setText(personDB.getPerson(SearchANDHistory.username).get(0));
            phonenumber.setText(personDB.getPerson(SearchANDHistory.username).get(5));

        } catch (Exception e) {
            e.printStackTrace();
        }
        back.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chatroom.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
