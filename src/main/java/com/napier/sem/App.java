package com.napier.sem;

import com.napier.sem.helpers.DatabaseHelper;
import com.napier.sem.helpers.QueryHelper;
import com.napier.sem.mappers.CountryMapper;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.raw_data.Query;
import com.napier.sem.models.reports.CountryReportRow;
import com.napier.sem.models.reports.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Application started... (build#: 2021-02-20T23:19)");

        // Create new Application
        App app = new App();
        // Connect to coursework 'world' database
        Connection conn = app.connect("world");

        List<Report> countryReportList = new ArrayList<Report>();
        List<Report> cityReportList = new ArrayList<Report>();
        List<Report> capitalCityReportList = new ArrayList<Report>();
        List<Report> populationReportList = new ArrayList<Report>();

        System.out.println("Loading country queries...");

        QueryHelper queryHelper = new QueryHelper();

        for (Query selectQuery : queryHelper.CountryReports) {
            System.out.println("Running query: " + selectQuery.query);
            ResultSet queryResult = DatabaseHelper.RunSelectQuery(conn, selectQuery.query);

            try {
                List<CountryReportRow> countryReportRowList = CountryMapper.GenerateCountryReportRowsFromResultSet(queryResult);

                Report newReport = new Report();

                newReport.title = selectQuery.title;
                newReport.rows = countryReportRowList;

                System.out.println("TEST PRINT START...");
                System.out.println(newReport.title);
                System.out.println("TEST PRINT END...");

                countryReportList.add(newReport);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Queries finished...");
        }

        System.out.println("Queries finished...");
        System.out.println(countryReportList.stream().count() + " reports collected...");

        System.out.println("(PLACEHOLDER) Generating CSV reports...");

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