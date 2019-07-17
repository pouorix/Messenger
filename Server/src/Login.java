import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
public static String username;
public static String opusername;
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
    @FXML
    Button back;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final String secretKey = "elmoskey";

        login.setOnAction(event -> {
            username=txtfusername.getText();
            String password=txtfpassword.getText();
            usernameisincorrect.setText("");
            passwordisincorrect.setText("");
            try {
                PersonDB personDB=new PersonDB();

                if(personDB.getPerson(username).isEmpty())
                    usernameisincorrect.setText("Username is incorrect");
                else {
                    if (!(personDB.getPerson(username).get(3) .equals(AES.encrypt(password, secretKey) ) ) ) {
                        passwordisincorrect.setText("Password is incorrect");
                    }
                    else {
                       // Client.dataOutput.writeUTF(username);
                        lonDB londb=new lonDB();
                        londb.changecl(username);
                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchANDHistory.fxml"))));

//                        new Thread(() -> {
//                            try {
                                //opusername = Client.dataInput.readUTF();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }).start();

                        //System.out.println(opusername);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });





        txtfpassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                usernameisincorrect.setText("");
                passwordisincorrect.setText("");
                final String secretKey = "elmoskey";
                if(ke.getCode().equals(KeyCode.ENTER)){
                    username=txtfusername.getText();
                    String password=txtfpassword.getText();
                    try {
                        PersonDB personDB=new PersonDB();

                        if(personDB.getPerson(username).isEmpty())
                            usernameisincorrect.setText("Username is incorrect");
                        else {
                            if (!(personDB.getPerson(username).get(3) .equals(AES.encrypt(password, secretKey) ))) {
                                passwordisincorrect.setText("Password is incorrect");
                            }
                            else {
                                // Client.dataOutput.writeUTF(username);
                                lonDB londb=new lonDB();

                                londb.changesl(username);
                                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchANDHistory.fxml"))));

                                londb.changecl(username);
                                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchANDHistory.fxml"))));


//                        new Thread(() -> {
//                            try {
                                //opusername = Client.dataInput.readUTF();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }).start();

                                //System.out.println(opusername);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });






        back.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }
}
