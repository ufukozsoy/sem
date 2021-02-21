package com.napier.sem.mappers.reports;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.reports.CityReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityReportRowMapper {

    public static List<CityReportRow> GenerateCityFromResultSet(ResultSet rs) throws SQLException {
        List<CityReportRow> objectList = new ArrayList<CityReportRow>();

        while(rs.next()) {

            CityReportRow cityReportRow = new CityReportRow();

            cityReportRow.name = rs.getString("Name");
            cityReportRow.country = rs.getString("Country");
            cityReportRow.district = rs.getString("District");
            cityReportRow.population = rs.getInt("Population");

            objectList.add(cityReportRow);
        }
        return objectList;
    }
}