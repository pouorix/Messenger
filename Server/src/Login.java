import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\sign-in.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            login.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\back.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            back.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        usernameisincorrect.setText("");
        passwordisincorrect.setText("");
        final String secretKey = "elmoskey";

        login.setOnAction(event -> {
            usernameisincorrect.setText("");
            passwordisincorrect.setText("");
            username=txtfusername.getText();
            String password=txtfpassword.getText();
            try {
                PersonDB personDB=new PersonDB();

                if(personDB.getPerson(username).isEmpty())
                    usernameisincorrect.setText("Username is incorrect");
                else {
                    if (!(personDB.getPerson(username).get(3) .equals(AES.encrypt(password, secretKey) ) ) ) {
                        passwordisincorrect.setText("Password is incorrect");
                    }
                    else {
                        // Server.dataOutput.writeUTF(username);
                        lonDB londb=new lonDB();
                        londb.changesl(username);
                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchANDHistory.fxml"))));

//                        new Thread(() -> {
//                            try {
                        //opusername = Server.dataInput.readUTF();
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
                                // Server.dataOutput.writeUTF(username);
                                lonDB londb=new lonDB();
                                londb.changesl(username);
                                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchANDHistory.fxml"))));

//                        new Thread(() -> {
//                            try {
                                //opusername = Server.dataInput.readUTF();
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