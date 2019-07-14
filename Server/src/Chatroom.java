import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
   // public static pmsDB

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  pmsDB pmsdb=null;
        Date date = new Date();
        String tarikh=date.toString();


        try {
            pmsDB pmsdb=new pmsDB();

            if(pmsdb.getsender(pmsdb.showpm( Login.username,SearchANDHistory.username).get(0)).equals(Login.username))
                opm.appendText("\n\n");

            if(pmsdb.getsender(pmsdb.showpm(SearchANDHistory.username, Login.username).get(0)).equals(SearchANDHistory.username))
                mypm.appendText("\n\n");


            for (int i = 0; i <Integer.max(pmsdb.showpm(Login.username,SearchANDHistory.username).size(),pmsdb.showpm(SearchANDHistory.username,Login.username).size()); i++) {
                if(i<=pmsdb.showpm(Login.username,SearchANDHistory.username).size()) {

                    mypm.appendText(pmsdb.showpm(Login.username, SearchANDHistory.username).get(i) + "\n");
                    opm.appendText("\n\n");
                }
                if(i<=pmsdb.showpm(SearchANDHistory.username,Login.username).size()) {

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
                                Server.dataOutput.writeUTF( pm+"\n");
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
                        Server.dataOutput.writeUTF( pm+"\n");
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
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        back.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearhANDHIstory.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        new Thread(()->{
            try {
                while (true) {
                    //   pm=pminput.getText();
//                mypm.setText(Server.dataInput.readUTF()+"\n");


                    //logine man va sah un .... sah man ba logine un


                    if (SearchANDHistory.username.equals(Login.opusername) && Login.username.equals(SearchANDHistory.opsearchusername)) {
                        opm.appendText(Server.dataInput.readUTF());
                        mypm.appendText("\n\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
