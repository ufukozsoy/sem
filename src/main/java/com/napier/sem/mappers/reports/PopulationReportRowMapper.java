package com.napier.sem.mappers.reports;
import com.napier.sem.models.reports.CityReportRow;
import com.napier.sem.models.reports.PopulationReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PopulationReportRowMapper {

    public static List<PopulationReportRow> GeneratePopulationReportFromResultSet(ResultSet rs) throws SQLException {
        List<PopulationReportRow> objectList = new ArrayList<PopulationReportRow>();

        while(rs.next()) {

            try
            {
                PopulationReportRow populationReportRow = new PopulationReportRow();

                populationReportRow.name = rs.getString("Name");
                populationReportRow.population = rs.getInt("total_pop");
                populationReportRow.urban_pop_percentage = rs.getDouble("urban_pop_percentage");
                populationReportRow.rural_pop_percentage = rs.getDouble("rural_pop_percentage");

                objectList.add(populationReportRow);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return objectList;
    }
}