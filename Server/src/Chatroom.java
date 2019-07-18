import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiParser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import sun.rmi.runtime.Log;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class Chatroom implements Initializable {
    public static String pm;
    @FXML
    TextField pminput;
    @FXML
    TextArea mypm;
    @FXML
    Button send;
    @FXML
    Button info;
    @FXML
    TextArea opm;
    @FXML
    MenuItem smile;
    @FXML
    MenuItem cry;
    @FXML
    MenuItem heart;
    @FXML
    MenuItem angry;
    @FXML
    MenuItem fear;
    @FXML
    Button file;
    @FXML
    ListView filetable;
    @FXML
    ListView filetable1;


    public static void openfile(String directory){

        File file = new File(directory);
        Desktop desktop = Desktop.getDesktop();

        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    // public static pmsDB



    String ssmile = "\uD83D\uDE02";
    String scry = "\uD83D\uDE2D";
    String sheart = "❤";
    String sfear = "\uD83D\uDE31";
    String sangry = "\uD83D\uDE21";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date date = new Date();
        String tarikh=date.toString();
        String time[]=tarikh.split(" ");

        filetable.getSelectionModel().getSelectedItem();
        filetable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                openfile(newValue);
//                System.out.println("ListView selection changed from oldValue = "
//                        + oldValue + " to newValue = " + newValue);
            }
        });


        filetable1.getSelectionModel().getSelectedItem();
        filetable1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                openfile(newValue);
//                System.out.println("ListView selection changed from oldValue = "
//                        + oldValue + " to newValue = " + newValue);
            }
        });

//       //. int i = 1;
//            filebtn.setOnAction(event -> {
//
//              //  filetxt.setText(String.valueOf(i++));
//
//            });
//
//        open.setOnAction(event -> {
//            fileDB filedb= null;
//            try {
//                filedb = new fileDB();
//                System.out.println(filedb.showfile(SearchANDHistory.username, Login.username).get(filedb.showfile(SearchANDHistory.username, Login.username).size()-1));
//                openfile(filedb.showfile(SearchANDHistory.username, Login.username).get(filedb.showfile(SearchANDHistory.username, Login.username).size()-1));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        });
//        System.out.println(filetable.getSelectionModel().getSelectedItems().toString());
//        openfile(filetable.getSelectionModel().getSelectedItems().toString());


        //fileDB filedb= null;


        new Thread(()-> {
            try {
                fileDB filedb = new fileDB();

                for (int i = 0; i < filedb.showfile(SearchANDHistory.username, Login.username).size(); i++)
                    filetable.getItems().add(filedb.showfile(SearchANDHistory.username, Login.username).get(i));

                //   fileDB filedb = new fileDB();
                int filetablesize=filedb.showfile(SearchANDHistory.username, Login.username).size();
                //  filetablesize=filedb.showfile(SearchANDHistory.username, Login.username).size();
                while (true) {
                    // for (int i = 0; i < filedb.showfile(SearchANDHistory.username, Login.username).size(); i++)
                    if (filedb.showfile(SearchANDHistory.username, Login.username).size() != filetablesize) {
                        filetable.getItems().clear();
                        for (int j = 0; j < filedb.showfile(SearchANDHistory.username, Login.username).size(); j++)
                            filetable.getItems().add(filedb.showfile(SearchANDHistory.username, Login.username).get(j));
                        //  filetable.getItems().add(filedb.showfile(SearchANDHistory.username, Login.username).get(i));
                        filetablesize++;
                    }
                }
            } catch (Exception e) {


            }
        }).start();


        new Thread(()-> {
            try {
                fileDB filedb = new fileDB();

                for (int i = 0; i < filedb.showfile( Login.username,SearchANDHistory.username).size(); i++)
                    filetable1.getItems().add(filedb.showfile(Login.username,SearchANDHistory.username).get(i));

                //   fileDB filedb = new fileDB();
                int filetablesize=filedb.showfile(Login.username,SearchANDHistory.username).size();
                //  filetablesize=filedb.showfile(SearchANDHistory.username, Login.username).size();
                while (true) {
                    // for (int i = 0; i < filedb.showfile(SearchANDHistory.username, Login.username).size(); i++)
                    if (filedb.showfile(Login.username,SearchANDHistory.username).size() != filetablesize) {
                        filetable1.getItems().clear();
                        for (int j = 0; j < filedb.showfile(Login.username,SearchANDHistory.username).size(); j++)
                            filetable1.getItems().add(filedb.showfile(Login.username,SearchANDHistory.username).get(j));
                        //  filetable.getItems().add(filedb.showfile(SearchANDHistory.username, Login.username).get(i));
                        filetablesize++;
                    }
                }
            } catch (Exception e) {


            }
        }).start();



        //  fileDB finalFiledb = filedb;
        file.setOnAction(event -> {
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);
            if (selectedFile != null) {
                String filee = selectedFile.getPath();
                //  System.out.println(filee);
                try {
                    fileDB filedb = new fileDB();
                    filedb.add(Login.username,SearchANDHistory.username,filee,tarikh);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //   System.out.println(photo);

            }
        });


        smile.setOnAction(event -> {
            pminput.appendText( EmojiParser.parseToUnicode(ssmile));
        });

        cry.setOnAction(event -> {
            pminput.appendText( EmojiParser.parseToUnicode(scry));
        });

        angry.setOnAction(event -> {
            pminput.appendText( EmojiParser.parseToUnicode(sangry));
        });

        fear.setOnAction(event -> {
            pminput.appendText( EmojiParser.parseToUnicode(sfear));
        });

        heart.setOnAction(event -> {
            pminput.appendText( EmojiParser.parseToUnicode(sheart));
        });
        System.out.println();



        // smile.setOnAction();

        try {
            pmsDB pmsdb=new pmsDB();

//            if(pmsdb.getsender(pmsdb.showpm( Login.username,SearchANDHistory.username).get(0)).equals(Login.username))
//                opm.appendText("\n\n");
//
//            if(pmsdb.getsender(pmsdb.showpm(SearchANDHistory.username, Login.username).get(0)).equals(SearchANDHistory.username))
//                mypm.appendText("\n\n");


            for (int i = 0; i <Integer.max(pmsdb.showpm(Login.username,SearchANDHistory.username).size(),pmsdb.showpm(SearchANDHistory.username,Login.username).size()); i++) {
                if(i<pmsdb.showpm(Login.username,SearchANDHistory.username).size()) {

                    mypm.appendText(pmsdb.showpm(Login.username, SearchANDHistory.username).get(i) + "\n");
                    String zaman[]=pmsdb.showdate(Login.username, SearchANDHistory.username).get(i).split(" ");
                    mypm.appendText(zaman[3]+"\n\n");
                    opm.appendText("\n\n");
                }
                if(i<pmsdb.showpm(SearchANDHistory.username,Login.username).size()) {

                    opm.appendText(pmsdb.showpm(SearchANDHistory.username, Login.username).get(i) + "\n");
                    String zaman[]=pmsdb.showdate(SearchANDHistory.username,Login.username).get(i).split(" ");
                    opm.appendText(zaman[3]+"\n\n");
                    mypm.appendText("\n\n");
                }
//                System.out.println("Login username : "+ Login.username);
//                System.out.println("Search and History username :" + SearchANDHistory.username);
//                System.out.println(pmsdb.showpm(Login.username,SearchANDHistory.username).get(i));
            }
//            for (int i = 0; i <pmsdb.showpm(SearchANDHistory.username,Login.username).size() ; i++) {
//
//
////                System.out.println(pmsdb.showpm(Login.username,SearchANDHistory.username).get(i));
//            }


            pminput.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent ke) {
                    if(ke.getCode().equals(KeyCode.ENTER)){
                        new Thread(()->{

                            try {
                                Date date = new Date();
                                String tarikh=date.toString();
                                String time[]=tarikh.split(" ");

                                pm = pminput.getText();
                                pmsdb.addpm(Login.username,SearchANDHistory.username,pm,tarikh);
                                Server.dataOutput.writeUTF( pm);
//            mypm.setText(pm);
//            mypm.setText(pm +"\n");
                                mypm.appendText( pm + "\n");
                                mypm.appendText("("+ time[3]+")" + "\n\n");

                                opm.appendText("\n\n\n");
                                pminput.setText("");
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }).start();


                    }

                }
            });



            send.setOnAction(event -> {


                new Thread(()->{

                    try {

                        pm = pminput.getText();
                        pmsdb.addpm(Login.username,SearchANDHistory.username,pm,tarikh);
                        Server.dataOutput.writeUTF( pm);
//            mypm.setText(pm);
//            mypm.setText(pm +"\n");
                        mypm.appendText( pm + "\n");
                        mypm.appendText("("+ time[3]+")" + "\n\n");
                        opm.appendText("\n\n\n");
                        pminput.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();



            });




        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Image  image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\send.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            send.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            Image  image = new Image(new FileInputStream("C:\\Users\\Acer\\Desktop\\AP Messengers - Copy - Copy\\icons\\icons\\file.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            file.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            PersonDB persondb=new PersonDB();
            Image  image = new Image(new FileInputStream(persondb.getPerson(SearchANDHistory.username).get(6)));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            info.setGraphic(imageView);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }


        info.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });







        new Thread(()->{
            try {
                lonDB londb=new lonDB();
                while (true) {
                    // opm.appendText("hi");
                    // opm.appendText(Server.dataInput.readUTF());
                    //   pm=pminput.getText();
//                mypm.setText(Server.dataInput.readUTF()+"\n");


                    //logine man va sah un .... sah man ba logine un



                    if (londb.showcl().equals(londb.showss()) && londb.showcs().equals(londb.showsl())) {

                        opm.appendText(Server.dataInput.readUTF()+"\n");
                        Date date1 = new Date();
                        String tarikh1=date1.toString();
                        String time1[]=tarikh1.split(" ");

                        opm.appendText("("+ time1[3]+")" + "\n\n");

                        mypm.appendText("\n\n\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}