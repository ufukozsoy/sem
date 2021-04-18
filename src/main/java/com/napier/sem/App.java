package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.helpers.DatabaseHelper;
import com.napier.sem.helpers.QueryHelper;
import com.napier.sem.mappers.raw_data.CountryMapper;
import com.napier.sem.mappers.reports.*;
import com.napier.sem.models.enums.ReportType;
import com.napier.sem.models.raw_data.Query;
import com.napier.sem.models.reports.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Application started... (build#: (" + getCurrentTimeStamp() + ")");

        // Create new Application
        App app = new App();
        // Connect to coursework 'world' database
        Connection conn = null;

        // Connect to database
        if (args.length < 1)
        {
            conn = app.connect("localhost:3306");
        }
        else
        {
            conn = app.connect(args[0]);
        }

        List<Report> countryReportList = new ArrayList<Report>();
        List<Report> cityReportList = new ArrayList<Report>();
        List<Report> capitalCityReportList = new ArrayList<Report>();
        List<Report> populationReportList = new ArrayList<Report>();
        List<Report> languageReportList = new ArrayList<Report>();
        List<Report> totalPopulationReportList = new ArrayList<Report>();

        QueryHelper queryHelper = new QueryHelper();

        // Generate Country reports --- --- ---
        System.out.println("Loading country report queries...");
        countryReportList = DatabaseHelper.GenerateReportsForQueryArray(conn, queryHelper.CountryReports, ReportType.Country);
        System.out.println("Country report queries finished...");

        // Generate Country reports --- --- ---
        System.out.println("Loading city report queries...");
        cityReportList = DatabaseHelper.GenerateReportsForQueryArray(conn, queryHelper.CityReports, ReportType.City);
        System.out.println("City report queries finished...");

        // Generate Country reports --- --- ---
        System.out.println("Loading capital city report queries...");
        capitalCityReportList = DatabaseHelper.GenerateReportsForQueryArray(conn, queryHelper.CapitalCityReports, ReportType.CapitalCity);
        System.out.println("Capital city report queries finished...");

        // Generate Country reports --- --- ---
        System.out.println("Loading population report queries...");
        populationReportList = DatabaseHelper.GenerateReportsForQueryArray(conn, queryHelper.PopulationReports, ReportType.Population);
        System.out.println("Population report queries finished...");

        // Generate Language reports --- --- ---
        System.out.println("Loading language population report queries...");
        languageReportList = DatabaseHelper.GenerateReportsForQueryArray(conn, queryHelper.LanguageReports, ReportType.Language);
        System.out.println("Language population report queries finished...");

        // Generate Total population reports --- --- ---
        System.out.println("Loading total population report queries...");
        totalPopulationReportList = DatabaseHelper.GenerateReportsForQueryArray(conn, queryHelper.TotalLanguageReports, ReportType.TotalPopulation);
        System.out.println("Total population report queries finished...");

        System.out.println(countryReportList.stream().count() + " country reports collected...");
        System.out.println(cityReportList.stream().count() + " city reports collected...");
        System.out.println(capitalCityReportList.stream().count() + " capital city reports collected...");
        System.out.println(populationReportList.stream().count() + " population reports collected...");
        System.out.println(languageReportList.stream().count() + " language reports collected...");
        System.out.println(totalPopulationReportList.stream().count() + " total population reports collected...");

        System.out.println("Generating Country CSV reports...");
        CSVHelper.WriteReportListToCSV(countryReportList, "country_reports");
        System.out.println("Generating City CSV reports...");
        CSVHelper.WriteReportListToCSV(cityReportList, "city_reports");
        System.out.println("Generating Capital City CSV reports...");
        CSVHelper.WriteReportListToCSV(capitalCityReportList, "capital_city_reports");
        System.out.println("Generating Population CSV reports...");
        CSVHelper.WriteReportListToCSV(populationReportList, "population_reports");
        System.out.println("Generating Language CSV reports...");
        CSVHelper.WriteReportListToCSV(languageReportList, "language_reports");
        System.out.println("Generating Total Population CSV reports...");
        CSVHelper.WriteReportListToCSV(totalPopulationReportList, "total_population_reports");
        // Disconnect from database
        app.disconnect(conn);
        conn = null;

        System.out.println("Reports saved to 'C:/Users/Public/output_reports'");
        System.out.println("Application closing...");
    }
    /**
     * Connect to the MySQL database.
     */
    public static Connection connect(String location)
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

        int retries = 20;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(20000);
                // Connect to database

                String connectionString = "jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false";
                System.out.println("Using connection string: " + connectionString);

                con = DriverManager.getConnection(connectionString, "root", "example");
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

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        java.util.Date now = new java.util.Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}