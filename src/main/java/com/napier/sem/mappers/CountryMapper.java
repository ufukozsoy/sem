package com.napier.sem.mappers;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.raw_data.Continent;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.reports.CountryReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryMapper {

    public static List<Country> GenerateCountryFromResultSet(ResultSet rs) throws SQLException {
        List<Country> objectList = new ArrayList<Country>();

        while(rs.next()) {

            Country country = new Country();

            country.code = rs.getString("Code");
            country.name = rs.getString("Name");
            country.continent = Continent.fromString(rs.getString("Continent"));
            country.region = rs.getString("Region");
            country.surfacearea = rs.getDouble("SurfaceArea");
            country.indepyear = rs.getInt("IndepYear");
            country.population = rs.getInt("Population");
            country.lifeexpectancy = rs.getDouble("LifeExpectancy");
            country.gnp = rs.getDouble("GNP");
            country.gnpold = rs.getDouble("GNPOld");
            country.localname = rs.getString("LocalName");
            country.governmentform = rs.getString("GovernmentForm");
            country.headofstate = rs.getString("HeadOfState");
            country.capital = rs.getInt("Capital");
            country.code2 = rs.getString("Code2");

            objectList.add(country);
        }
        return objectList;
    }

    public static List<CountryReportRow> GenerateCountryReportRowsFromResultSet(ResultSet rs) throws SQLException {
        List<CountryReportRow> objectList = new ArrayList<CountryReportRow>();

        while(rs.next()) {

            CountryReportRow countryReportRow = new CountryReportRow();

            countryReportRow.name = rs.getString("Name");
            countryReportRow.code = rs.getString("Code");
            countryReportRow.continent = Continent.fromString(rs.getString("Continent"));
            countryReportRow.region = rs.getString("Region");
            countryReportRow.population = rs.getInt("Population");
            countryReportRow.capital = rs.getInt("Capital");

            objectList.add(countryReportRow);
        }
        return objectList;
    }
}