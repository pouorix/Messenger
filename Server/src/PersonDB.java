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
        preparedStatement = connection.prepareStatement("insert into persons values (default ,?,?,?,?,?,?)");
        preparedStatement.setString(3, person.getUsername());
        preparedStatement.setString(4,person.getPassword());
        preparedStatement.setString(1,person.getFirstname());
        preparedStatement.setString(2,person.getLastname());
        preparedStatement.setString(5,person.getEmail());
        preparedStatement.setString(6,person.getPhonenumber());
        preparedStatement.executeUpdate();
    }
//
//    public  void getPersons() throws Exception{
//        preparedStatement = connection.prepareStatement("select * from person");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("username"));
//        }
//    }

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
        }
    return info;
    }

//    public void changePass(Person person, String newPass) throws Exception{
//        preparedStatement = connection.prepareStatement("update person set pass = ? where username = ?");
//        preparedStatement.setString(1, newPass);
//        preparedStatement.setString(2,person.getUsername());
//        preparedStatement.executeUpdate();
//    }
//
//    public void deletePerson(String username) throws Exception{
//        preparedStatement = connection.prepareStatement("delete from person where username = ?");
//        preparedStatement.setString(1, username);
//        preparedStatement.executeUpdate();
//    }
//
    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }

}
