package com.napier.sem.mappers.reports;
import com.napier.sem.models.reports.CapitalCityReportRow;
import com.napier.sem.models.reports.CityReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CapitalCityReportRowMapper {

    public static List<CapitalCityReportRow> GenerateCapitalCityFromResultSet(ResultSet rs) throws SQLException {
        List<CapitalCityReportRow> objectList = new ArrayList<CapitalCityReportRow>();

        while(rs.next()) {

            CapitalCityReportRow capitalCityReportRow = new CapitalCityReportRow();

            capitalCityReportRow.name = rs.getString("Name");
            capitalCityReportRow.country = rs.getString("Country");
            capitalCityReportRow.population = rs.getInt("Population");

            objectList.add(capitalCityReportRow);
        }
        return objectList;
    }
}