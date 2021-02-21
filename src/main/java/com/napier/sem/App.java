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

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Application started... (build#: (" + getCurrentTimeStamp() + ")");

        // Create new Application
        App app = new App();
        // Connect to coursework 'world' database
        Connection conn = app.connect("world");

        List<Report> countryReportList = new ArrayList<Report>();
        List<Report> cityReportList = new ArrayList<Report>();
        List<Report> capitalCityReportList = new ArrayList<Report>();
        List<Report> populationReportList = new ArrayList<Report>();

        QueryHelper queryHelper = new QueryHelper();

        // Generate Country reports --- --- ---
        System.out.println("Loading country report queries...");

        for (Query selectQuery : queryHelper.CountryReports) {
            System.out.println("Running query: " + selectQuery.query);
            ResultSet queryResult = DatabaseHelper.RunSelectQuery(conn, selectQuery.query);

            try {
                List<String> queryHeaders = QueryHeaderMapper.GenerateHeadersFromResultSet(queryResult);
                List<CountryReportRow> countryReportRowList = CountryReportRowMapper.GenerateCountryReportRowsFromResultSet(queryResult);
                countryReportList.add(new Report(selectQuery.title, countryReportRowList, queryHeaders, ReportType.Country));
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Query finished: " + selectQuery.query);
        }

        System.out.println("Country report queries finished...");

        // Generate Country reports --- --- ---
        System.out.println("Loading city report queries...");

        for (Query selectQuery : queryHelper.CityReports) {
            System.out.println("Running query: " + selectQuery.query);
            ResultSet queryResult = DatabaseHelper.RunSelectQuery(conn, selectQuery.query);

            try {
                List<String> queryHeaders = QueryHeaderMapper.GenerateHeadersFromResultSet(queryResult);
                List<CityReportRow> cityReportRowList = CityReportRowMapper.GenerateCityFromResultSet(queryResult);
                cityReportList.add(new Report(selectQuery.title, cityReportRowList, queryHeaders, ReportType.City));
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Query finished: " + selectQuery.query);
        }

        System.out.println("City report queries finished...");

        // Generate Country reports --- --- ---
        System.out.println("Loading capital city report queries...");

        for (Query selectQuery : queryHelper.CapitalCityReports) {
            System.out.println("Running query: " + selectQuery.query);
            ResultSet queryResult = DatabaseHelper.RunSelectQuery(conn, selectQuery.query);

            try {
                List<String> queryHeaders = QueryHeaderMapper.GenerateHeadersFromResultSet(queryResult);
                List<CapitalCityReportRow> capitalCityReportRowList = CapitalCityReportRowMapper.GenerateCapitalCityFromResultSet(queryResult);
                capitalCityReportList.add(new Report(selectQuery.title, capitalCityReportRowList, queryHeaders, ReportType.CapitalCity));
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Query finished: " + selectQuery.query);
        }

        System.out.println("Capital city report queries finished...");

        // Generate Country reports --- --- ---
        System.out.println("Loading population report queries...");

        for (Query selectQuery : queryHelper.PopulationReports) {
            System.out.println("Running query: " + selectQuery.query);
            ResultSet queryResult = DatabaseHelper.RunSelectQuery(conn, selectQuery.query);

            try {
                List<String> queryHeaders = QueryHeaderMapper.GenerateHeadersFromResultSet(queryResult);
                List<PopulationReportRow> populationReportRowList = PopulationReportRowMapper.GeneratePopulationReportFromResultSet(queryResult);
                populationReportList.add(new Report(selectQuery.title, populationReportRowList, queryHeaders, ReportType.Population));
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Query finished: " + selectQuery.query);
        }

        System.out.println("Population report queries finished...");

        System.out.println(countryReportList.stream().count() + " country reports collected...");
        System.out.println(cityReportList.stream().count() + " city reports collected...");
        System.out.println(capitalCityReportList.stream().count() + " capital city reports collected...");
        System.out.println(populationReportList.stream().count() + " population reports collected...");

        System.out.println("Generating Country CSV reports...");
        CSVHelper.WriteReportListToCSV(countryReportList, "country_reports");
        System.out.println("Generating City CSV reports...");
        CSVHelper.WriteReportListToCSV(cityReportList, "city_reports");
        System.out.println("Generating Capital City CSV reports...");
        CSVHelper.WriteReportListToCSV(capitalCityReportList, "capital_city_reports");
        System.out.println("Generating Population CSV reports...");
        CSVHelper.WriteReportListToCSV(populationReportList, "population_reports");

        // Disconnect from database
        app.disconnect(conn);
        conn = null;

        System.out.println("Reports saved to 'C:/Users/Public/output_reports'");
        System.out.println("Application closing...");
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

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        java.util.Date now = new java.util.Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}