import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiParser;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.MenuItem;

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
    Button back;
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

    // public static pmsDB

    String ssmile = "\uD83D\uDE02";
    String scry = "\uD83D\uDE2D";
    String sheart = "❤";
    String sfear = "\uD83D\uDE31";
    String sangry = "\uD83D\uDE21";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  pmsDB pmsdb=null;
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


        Date date = new Date();
        String tarikh=date.toString();
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
                    opm.appendText("\n\n");
                }
                if(i<pmsdb.showpm(SearchANDHistory.username,Login.username).size()) {

                    opm.appendText(pmsdb.showpm(SearchANDHistory.username, Login.username).get(i) + "\n");
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
                                pm = pminput.getText();
                                pmsdb.addpm(Login.username,SearchANDHistory.username,pm,tarikh);
                                Client.dataOutput.writeUTF( pm+"\n");
//            mypm.setText(pm);
//            mypm.setText(pm +"\n");
                                mypm.appendText( pm + "\n");
                                opm.appendText("\n\n");
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
                        Client.dataOutput.writeUTF( pm+"\n");
//            mypm.setText(pm);
//            mypm.setText(pm +"\n");
                        mypm.appendText( pm + "\n");
                        opm.appendText("\n\n");
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

        info.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        back.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearhANDHIstory.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        new Thread(()->{
            try {
                lonDB londb=new lonDB();
                while (true) {
//                    opm.appendText("hi");
//                    opm.appendText(Client.dataInput.readUTF());
                    //   pm=pminput.getText();
//                mypm.setText(Client.dataInput.readUTF()+"\n");


                    //logine man va sah un .... sah man ba logine un


                    if (londb.showcl().equals(londb.showss()) && londb.showcs().equals(londb.showsl())) {

//                        if(Client.dataInput.readUTF().equals("\uD83D\uDE02"))
//                            opm.appendText(EmojiParser.parseToUnicode(ssmile));
//
//                         if(Client.dataInput.readUTF().equals("\uD83D\uDE2D"))
//                            opm.appendText(EmojiParser.parseToUnicode(scry));
//
//                         if(Client.dataInput.readUTF().equals("❤"))
//                            opm.appendText(EmojiParser.parseToUnicode(sheart));
//
//                         if(Client.dataInput.readUTF().equals("\uD83D\uDE31"))
//                            opm.appendText(EmojiParser.parseToUnicode(sfear));
//
//
//                         if(Client.dataInput.readUTF().equals("\uD83D\uDE21"))
//                            opm.appendText(EmojiParser.parseToUnicode(sangry));

                     //   if(!(Client.dataInput.readUTF().equals("\uD83D\uDE02")) && !(Client.dataInput.readUTF().equals("\uD83D\uDE2D")) && !(Client.dataInput.readUTF().equals("❤")) && !(Client.dataInput.readUTF().equals("\uD83D\uDE31"))&&  !(Client.dataInput.readUTF().equals("\uD83D\uDE21")))
                        opm.appendText(Client.dataInput.readUTF());

                        mypm.appendText("\n\n");
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
