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

public class SearchANDHistory implements Initializable {

    public static String opsearchusername;
    @FXML
    TextField userinput;
    @FXML
    Button next;
    @FXML
    Text status;
    @FXML
    Button setting;


    public static String username;
    public static String historyusername;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\settings.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            setting.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\next.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            next.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        setting.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Setting.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });







        userinput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if(ke.getCode().equals(KeyCode.ENTER)){

                    try {
                        username =userinput.getText();
                        int boolian=0;
                        PersonDB personDB=new PersonDB();

//
//            for (int i = 0; i <personDB.getPersonsusername().size() ; i++) {
//                System.out.println(personDB.getPersonsusername().get(i));
//            }
//

                        for (int i = 0; i <personDB.getPersonsusername().size() ; i++) {

                            if (username.equals(personDB.getPersonsusername().get(i))) {
                                status.setText("Username  Found !");
                                boolian = 1;
                                // Thread.sleep(1000);
                                //  Server.dataOutput.writeUTF(username);

                                lonDB londb=new lonDB();
                                londb.changess(username);
//                        new Thread(()-> {
//                            try {
                                //   opsearchusername = Server.dataInput.readUTF();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }).start();

                                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chatroom.fxml"))));

                            }
                        }
                        if(boolian==0)
                            status.setText("Username Not Found");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });







        next.setOnAction(event -> {

            try {
                username =userinput.getText();
                int boolian=0;
                PersonDB personDB=new PersonDB();
                //
//            for (int i = 0; i <personDB.getPersonsusername().size() ; i++) {
//                System.out.println(personDB.getPersonsusername().get(i));
//            }
//

                for (int i = 0; i <personDB.getPersonsusername().size() ; i++) {

                    if (username.equals(personDB.getPersonsusername().get(i))) {
                        status.setText("Username  Found !");
                        boolian = 1;

                        lonDB londb=new lonDB();
                        londb.changess(username);

                        //Thread.sleep(1000);

//
//                        new Thread(()-> {
//                            try {
                        //   opsearchusername = Server.dataInput.readUTF();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }).start();



                        // Server.dataOutput.writeUTF(username);
                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chatroom.fxml"))));

                    }
                }
                if(boolian==0)
                    status.setText("Username Not Found");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}