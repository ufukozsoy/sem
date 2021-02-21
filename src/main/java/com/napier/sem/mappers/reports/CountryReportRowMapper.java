package com.napier.sem.mappers.reports;
import com.napier.sem.models.raw_data.Continent;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.reports.CountryReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryReportRowMapper {

    public static List<CountryReportRow> GenerateCountryReportRowsFromResultSet(ResultSet rs) throws SQLException {
        List<CountryReportRow> objectList = new ArrayList<CountryReportRow>();

        while(rs.next()) {

            try
            {
                CountryReportRow countryReportRow = new CountryReportRow();

                countryReportRow.name = rs.getString("Name");
                countryReportRow.code = rs.getString("Code");
                countryReportRow.continent = Continent.fromString(rs.getString("Continent"));
                countryReportRow.region = rs.getString("Region");
                countryReportRow.population = rs.getInt("Population");
                countryReportRow.capital = rs.getString("Capital");

                objectList.add(countryReportRow);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return objectList;
    }
}