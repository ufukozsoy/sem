package com.napier.sem.mappers;
import com.napier.sem.models.CityReport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityMapper {

    public static List<CityReport> GenerateCityReportFromResultSet(ResultSet rs) throws SQLException {
        List<CityReport> objectList = new ArrayList<>();

        while(rs.next()) {

            CityReport cityReport = new CityReport();

            cityReport.name = rs.getString("Name");
            cityReport.country = rs.getString("Country");
            cityReport.district = rs.getString("District");
            cityReport.population = rs.getInt("Population");

            objectList.add(cityReport);
        }
        return objectList;
    }
}