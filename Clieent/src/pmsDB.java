import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class pmsDB {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public pmsDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:1111/postgres?currentSchema=public", "postgres", "123qwe");
    }

    public void addpm(String sender,String reciver , String pm,String date) throws Exception{
        preparedStatement = connection.prepareStatement("insert into pms values (default ,?,?,?,?)");
        preparedStatement.setString(1, sender);
        preparedStatement.setString(2,reciver);
        preparedStatement.setString(3,pm);
          preparedStatement.setString(4,date);
        preparedStatement.executeUpdate();
    }

}