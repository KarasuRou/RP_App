package data;

import java.sql.*;

public class dbConnection {

    private Connection conn;

    public dbConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql:", "", "");
            conn.setClientInfo("autoReconnect","true");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public ResultSet executeSelectQuery(String query) throws Exception{
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    public ResultSet executeInsertQuery(String query) throws Exception{
        PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.execute();
        return preparedStatement.getGeneratedKeys();
    }

    public void executeUpdateQuery(String query) throws Exception{
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
}
