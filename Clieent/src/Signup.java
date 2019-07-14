import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;

public class Signup implements Initializable {
    @FXML
    TextField txtffirstname;
    @FXML
    TextField txtflastname;
    @FXML
    TextField txtfusername;
    @FXML
    TextField txtfpassword;
    @FXML
    TextField txtfemail;
    @FXML
    TextField txtfphonenumber;
    @FXML
    Button register;
    @FXML
    Text status;
    @FXML
    Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register.setOnAction(event -> {
            String fisrtname = txtffirstname.getText();
            String lastname = txtflastname.getText();
            String username = txtfusername.getText();
            String password = txtfpassword.getText();
            String email = txtfemail.getText();
            String phonenumber = txtfphonenumber.getText();
            Person person = new Person(fisrtname, lastname, username, password, email, phonenumber);
            try {
                PersonDB personDB = new PersonDB();
                personDB.addPerson(person);
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));


            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        back.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
}
