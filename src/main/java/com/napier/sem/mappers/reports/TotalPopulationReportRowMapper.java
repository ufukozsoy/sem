package com.napier.sem.mappers.reports;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.napier.sem.models.reports.PopulationReportRow;
import com.napier.sem.models.reports.TotalPopulationReportRow;

public class TotalPopulationReportRowMapper {

	//Maps a ResultSet object onto a TotalPopulationReportRow object
	public static List<TotalPopulationReportRow> GenerateTotalPopulationReportFromResultSet(ResultSet rs)
			throws SQLException {
		List<TotalPopulationReportRow> objectList = new ArrayList<TotalPopulationReportRow>();

		while (rs.next()) {

			try {
				TotalPopulationReportRow totalPopulationReportRow = new TotalPopulationReportRow();

				totalPopulationReportRow.name = rs.getString("Name");
				totalPopulationReportRow.population = Math.round(rs.getDouble("total_pop"));

				objectList.add(totalPopulationReportRow);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return objectList;
	}
}
