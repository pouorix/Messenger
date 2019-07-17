import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\sign-in.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Loginbtn.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\sign-up.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Signupbtn.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        Signupbtn.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signup.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        Loginbtn.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}