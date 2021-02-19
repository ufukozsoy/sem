package com.napier.sem;

import com.napier.sem.models.Employee;
import com.napier.sem.queries.coursework_queries;
import com.napier.sem.queries.lab_queries;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application

        //LABS --- --- ---
        App app = new App();
        // Connect to labs 'employees' database
        Connection labs_conn = app.connect("employees");
        // Extract employee salary information
        ArrayList<Employee> employeesList = lab_queries.getAllSalaries(labs_conn);
        // Print salaries
        lab_queries.printSalaries(employeesList);
        // Disconnect from database
        app.disconnect(labs_conn);
        labs_conn = null;

        //COURSEWORK --- --- ---

        // Connect to coursework 'world' database
        Connection coursew_conn = app.connect("world");

        coursework_queries.getAllCityReports(coursew_conn);

        // Disconnect from database
        app.disconnect(coursew_conn);
        coursew_conn = null;
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