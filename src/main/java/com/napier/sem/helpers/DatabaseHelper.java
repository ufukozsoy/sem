package com.napier.sem.helpers;

import com.napier.sem.mappers.CityMapper;
import com.napier.sem.models.raw_data.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DatabaseHelper {

    public static List<City> runCityQuery(Connection con, String queryString)
    {
        List<City> citiesList = null;

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(queryString);

            // Map resultset to objects
            citiesList = CityMapper.GenerateCityFromResultSet(rset);

            System.out.println("Retrieved " + citiesList.stream().count() + " cities from database.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
        return citiesList;
    }

    public static void printCity(List<City> citiesList, int numberToPrint)
    {
        String printFormat = "%-10s %-15s %-20s %-10s";
        // Print header
        System.out.println(String.format(printFormat, "Name", "CountryCode", "District", "Population"));
        // Loop over all employees in the list

        for(int i = 0; i < numberToPrint; i++) {
            String city_rep_string =
                    String.format(printFormat,
                            citiesList.get(i).name, citiesList.get(i).countrycode, citiesList.get(i).district, citiesList.get(i).population);
            System.out.println(city_rep_string);
        }
    }
}
