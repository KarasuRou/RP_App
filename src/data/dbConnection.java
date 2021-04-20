package data;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class dbConnection {

    private Connection conn;

    public dbConnection(){
        try {
            String[] strings = getConnectionStrings();
            conn = DriverManager.getConnection(strings[0],strings[1],strings[2]);
            conn.setClientInfo("autoReconnect","true");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String[] getConnectionStrings() throws Exception{
        String[] strings = new String[3];
        File file = new File("application.conf");
        System.out.println(file.getAbsolutePath());
        Scanner input = new Scanner(file);
        int i = 0;
        while (input.hasNext() && i != 3) {
            String string = input.nextLine();
            if (string.contains("database.url:")) {
                string = string.replaceAll("\\s","").replace("database.url:", "");
                strings[i++] = string;
            } else if (string.contains("database.username:")) {
                string = string.replaceAll("\\s","").replace("database.username:", "");
                strings[i++] = string;
            } else if (string.contains("database.password:")) {
                string = string.replaceAll("\\s","").replace("database.password:", "");
                strings[i++] = string;
            }
        }
        return strings;
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

    public ResultSet executeUpdateSelectQuery(String query) throws Exception{
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return statement.executeQuery(query);
    }
}
