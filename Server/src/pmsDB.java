import java.sql.*;
import java.util.ArrayList;

public class pmsDB {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public pmsDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:1111/postgres?currentSchema=public", "postgres", "123qwe");
    }

    public void addpm(String sender, String reciver, String pm, String date) throws Exception {
        preparedStatement = connection.prepareStatement("insert into pms values (default ,?,?,?,?)");
        preparedStatement.setString(1, sender);
        preparedStatement.setString(2, reciver);
        preparedStatement.setString(3, pm);
        preparedStatement.setString(4, date);
        preparedStatement.executeUpdate();
    }

    public ArrayList<String> showpm(String username1, String username2) throws SQLException {
        preparedStatement = connection.prepareStatement("select text from pms where sender = ? AND reciver = ?   ");
        preparedStatement.setString(1, username1);
        preparedStatement.setString(2, username2);
        ArrayList<String> info = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            info.add(resultSet.getString("text"));
        }
        return info;
    }


    public ArrayList<String> showdate(String username1, String username2) throws SQLException {
        preparedStatement = connection.prepareStatement("select text from pms where sender = ? AND reciver = ?   ");
        preparedStatement.setString(1, username1);
        preparedStatement.setString(2, username2);
        ArrayList<String> info = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            info.add(resultSet.getString("text"));
        }
        return info;
    }

    public String getsender(String text) throws SQLException {
        preparedStatement = connection.prepareStatement("select sender from pms where text = ?   ");
        preparedStatement.setString(1, text);
        ArrayList<String> info = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        String sender=null;
        while (resultSet.next()) {
            sender =  resultSet.getString("sender");
        }
        return sender;
    }
}
