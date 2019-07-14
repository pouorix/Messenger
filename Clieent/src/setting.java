import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class setting implements Initializable {
    @FXML
    TextField changefirstname;
    @FXML
    TextField changelastname;
    @FXML
    TextField changeusername;
    @FXML
    TextField changepassword;
    @FXML
    TextField changeemail;
    @FXML
    TextField changephonenumber;
    @FXML
    Button cfnb;
    @FXML
    Button clnb;
    @FXML
    Button cunb;
    @FXML
    Button cpb;
    @FXML
    Button ceb;
    @FXML
    Button cpnb;
    @FXML
    Button deleteaccount;
    @FXML
    Button exit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cpb.setOnAction(event -> {
            String test=changepassword.getText();
            try {
                PersonDB personDB=new PersonDB();
                personDB.changePass(Login.username,test);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        cfnb.setOnAction(event -> {
            String test=changefirstname.getText();
            try {
                PersonDB personDB=new PersonDB();
                personDB.changeFirstname(Login.username,test);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        clnb.setOnAction(event -> {
            String test=changelastname.getText();
            try {
                PersonDB personDB=new PersonDB();
                personDB.changeLastname(Login.username,test);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        cunb.setOnAction(event -> {
            String test=changeusername.getText();
            try {
                PersonDB personDB=new PersonDB();
                personDB.changeUsername(Login.username,test);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });




        ceb.setOnAction(event -> {
            String test=changeemail.getText();
            try {
                PersonDB personDB=new PersonDB();
                personDB.changeEmail(Login.username,test);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        cpnb.setOnAction(event -> {
            String test=changephonenumber.getText();
            try {
                PersonDB personDB=new PersonDB();
                personDB.changePhonenumber(Login.username,test);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        deleteaccount.setOnAction(event -> {

            try {
                PersonDB personDB=new PersonDB();
                personDB.deletePerson(Login.username);
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        exit.setOnAction(event -> {

            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
