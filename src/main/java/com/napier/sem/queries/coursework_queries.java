package com.napier.sem.queries;

import com.napier.sem.mappers.CityMapper;
import com.napier.sem.models.CityReport;
import com.napier.sem.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class coursework_queries {

    public static List<CityReport> getAllCityReports(Connection con)
    {
        // Create string for SQL statement
        String queryString =
                "SELECT name, country, district, population "
                        + "FROM city";

        return cityReportQuery(con, queryString);
    }

    public static List<CityReport> cityReportQuery(Connection con, String queryString)
    {
        List<CityReport> cityReportsList = null;

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(queryString);

            // Map resultset to objects
            cityReportsList = CityMapper.GenerateCityReportFromResultSet(rset);

            // Print n reports as test
            printCityReport(cityReportsList, 5);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
        return cityReportsList;
    }

    public static void printCityReport(List<CityReport> cityReports, int numberToPrint)
    {
        String printFormat = "%-10s %-15s %-20s %-10s";
        // Print header
        System.out.println(String.format(printFormat, "Name", "Country", "District", "Population"));
        // Loop over all employees in the list

        for(int i = 0; i < numberToPrint; i++) {
            String city_rep_string =
                    String.format(printFormat,
                            cityReports.get(i).name, cityReports.get(i).country, cityReports.get(i).district, cityReports.get(i).population);
            System.out.println(city_rep_string);
        }
    }
}
