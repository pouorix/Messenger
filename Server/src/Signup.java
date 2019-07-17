import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.xml.soap.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

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
    Button picture;
    @FXML
    Button back;

    public static String email;
    public static String fisrtname ;
    public static String lastname ;
    public static String username ;
    public static String password;
    public static String phonenumber ;
    public static String photo ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\back.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            back.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\sign-in.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            register.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        register.setOnAction(event -> {
            fisrtname = txtffirstname.getText();
            lastname = txtflastname.getText();
            username = txtfusername.getText();
            password = txtfpassword.getText();
            email = txtfemail.getText();
            phonenumber = txtfphonenumber.getText();
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Email.fxml"))));

            } catch (Exception e) {
                e.printStackTrace();
            }

        });





        txtfemail.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if(ke.getCode().equals(KeyCode.ENTER)){
                    fisrtname = txtffirstname.getText();
                    lastname = txtflastname.getText();
                    username = txtfusername.getText();
                    password = txtfpassword.getText();
                    email = txtfemail.getText();
                    phonenumber = txtfphonenumber.getText();
                    try {
                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Email.fxml"))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        picture.setOnAction(event -> {
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);
            if (selectedFile != null)
                photo = selectedFile.getPath();

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
