import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PersonDB {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:1111/postgres?currentSchema=public", "postgres", "123qwe");
    }

    public void addPerson(Person person) throws Exception{
        preparedStatement = connection.prepareStatement("insert into persons values (default ,?,?,?,?,?,?,?)");
        preparedStatement.setString(3, person.getUsername());
        //security

        final String secretKey = "elmoskey";

        String originalString = person.getPassword();
        String encryptedString = AES.encrypt(originalString, secretKey) ;


        //security
        preparedStatement.setString(4,encryptedString);
        preparedStatement.setString(1,person.getFirstname());
        preparedStatement.setString(2,person.getLastname());
        preparedStatement.setString(5,person.getEmail());
        preparedStatement.setString(6,person.getPhonenumber());
        preparedStatement.setString(7,person.getPhoto());
        preparedStatement.executeUpdate();
    }
    //
    public  ArrayList<String> getPersonsusername() throws Exception{
        preparedStatement = connection.prepareStatement("select username from persons");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> usernames=new ArrayList<>();
        while (resultSet.next()){
            usernames.add(resultSet.getString("username"));
        }
        return usernames;
    }

    public ArrayList<String>getPerson(String username) throws Exception{
        preparedStatement = connection.prepareStatement("select * from persons where username = ?");
        preparedStatement.setString(1,username);
        ArrayList<String >info=new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            info.add(resultSet.getString("firstname"));
            info.add(resultSet.getString("lastname"));
            info.add(resultSet.getString("username"));
            info.add(resultSet.getString("password"));
            info.add(resultSet.getString("email"));
            info.add(resultSet.getString("phonenumber"));
            info.add(resultSet.getString("picturedirectory"));
        }
        return info;
    }

    public void changePass(String username, String newPass) throws Exception{
        preparedStatement = connection.prepareStatement("update persons set password = ? where username = ?");

//        final String secretKey = "elmoskey";
//        String originalString = newPass;
//        String encryptedString = AES.encrypt(originalString, secretKey) ;
//

        preparedStatement.setString(1, AES.encrypt(newPass,"elmoskey"));
        //System.out.println(AES.decrypt(AES.encrypt(newPass,"emoskey"),""));
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }


    public void changeFirstname(String username, String newFirstname) throws Exception{
        preparedStatement = connection.prepareStatement("update persons set firstname = ? where username = ?");
        preparedStatement.setString(1, newFirstname);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changeLastname(String username, String newLastname) throws Exception{
        preparedStatement = connection.prepareStatement("update persons set lastname = ? where username = ?");
        preparedStatement.setString(1, newLastname);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();

    }

    public void changeUsername(String username, String newUsername) throws Exception{
        preparedStatement = connection.prepareStatement("update persons set username = ? where username = ?");
        preparedStatement.setString(1, newUsername);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }


    public void changeEmail(String username, String newEmail) throws Exception{
        preparedStatement = connection.prepareStatement("update persons set email = ? where username = ?");
        preparedStatement.setString(1, newEmail);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }


    public void changePhonenumber(String username, String newpn) throws Exception{
        preparedStatement = connection.prepareStatement("update persons set phonenumber = ? where username = ?");
        preparedStatement.setString(1, newpn);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }



    //
    public void deletePerson(String username) throws Exception{
        preparedStatement = connection.prepareStatement("delete from persons where username = ?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }
    //
    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }

}
