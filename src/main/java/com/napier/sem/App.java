package com.napier.sem;

import com.napier.sem.models.raw_data.City;
import com.napier.sem.helpers.DatabaseHelper;

import java.sql.*;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Application started... (v.0.1.1)");

        // Create new Application
        App app = new App();
        // Connect to coursework 'world' database
        Connection conn = app.connect("world");

        System.out.println("Running test query...");

        // Create string for SQL statement
        String testQuery =
                "SELECT name, countrycode, district, population "
                        + "FROM city";

        // Query Cities
        List<City> citiesList = DatabaseHelper.runCityQuery(conn, testQuery);

        System.out.println("Test query finished...");

        // Print n reports as test
        DatabaseHelper.printCity(citiesList, 5);

        // Disconnect from database
        app.disconnect(conn);
        conn = null;

        System.out.println("Application finished...");
    }
    /**
     * Connect to the MySQL database.
     */
    public static Connection connect(String databaseName)
    {
        Connection con = null;

        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/" + databaseName + "?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return con;
    }

    /**
     * Disconnect from the MySQL database.
     */
    public static void disconnect(Connection con)
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


}