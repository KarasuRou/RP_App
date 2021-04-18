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
        boolean error = preparedStatement.execute();
        if (error) throw new SQLException("INSERT FAILED! (Update? No ResultSet?)");
        return preparedStatement.getGeneratedKeys();
    }

    public void executeUpdateQuery(String query) throws Exception{
        Statement statement = conn.createStatement();
        int error = statement.executeUpdate(query);
        if (error == 0) throw new SQLException("NO ROW UPDATED");
        statement.close();
    }
}
