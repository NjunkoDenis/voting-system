package by.njunko.voting.db;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DENIS on 16.12.2016.
 */
public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/db";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBWorker() {

        try {

            DriverManager.registerDriver(new FabricMySQLDriver());

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Connection getConnection() {

        if(connection != null){

            return connection;
        }

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance ();

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("CONNECTION SUCCESSFUL");

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {

            e.printStackTrace();
        }

        return  connection;
    }

}
