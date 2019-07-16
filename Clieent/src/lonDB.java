import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class lonDB {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public lonDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:1111/postgres?currentSchema=public", "postgres", "123qwe");
    }

    public void changecl (String cl) throws Exception{
        preparedStatement = connection.prepareStatement("update lon set clientlogin = ? ");
        preparedStatement.setString(1, cl);
        preparedStatement.executeUpdate();
    }

    public void changecs (String cs) throws Exception{
        preparedStatement = connection.prepareStatement("update lon set clientsearch = ? ");
        preparedStatement.setString(1, cs);
        preparedStatement.executeUpdate();
    }

    public void changesl (String sl) throws Exception{
        preparedStatement = connection.prepareStatement("update lon set serverlogin = ? ");
        preparedStatement.setString(1, sl);
        preparedStatement.executeUpdate();
    }

    public void changess (String ss) throws Exception{
        preparedStatement = connection.prepareStatement("update lon set serversearch = ? ");
        preparedStatement.setString(1, ss);
        preparedStatement.executeUpdate();
    }






    public String showcl () throws Exception{
        preparedStatement = connection.prepareStatement("select clientlogin from lon");
        // preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.executeQuery();
        String javab=null;
        if (resultSet.next())
            javab=resultSet.getString("clientlogin");
        return javab;
    }

    public String showcs () throws Exception{
        preparedStatement = connection.prepareStatement("select clientsearch from lon ");
        // preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.executeQuery();
        String javab=null;
        if (resultSet.next())
            javab=resultSet.getString("clientsearch");
        return javab;
    }

    public String showsl () throws Exception{
        preparedStatement = connection.prepareStatement("select serverlogin from lon");
        //  preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.executeQuery();
        String javab=null;
        if (resultSet.next())
            javab=resultSet.getString("serverlogin");
        return javab;
    }

    public String showss () throws Exception{
        preparedStatement = connection.prepareStatement("select serversearch from lon ");
        //  preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.executeQuery();
        String javab=null;
        if (resultSet.next())
            javab=resultSet.getString("serversearch");
        return javab;
    }



}
