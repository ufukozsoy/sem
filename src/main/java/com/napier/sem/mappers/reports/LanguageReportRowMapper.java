//code by viva
package com.napier.sem.mappers.reports;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.napier.sem.models.reports.LanguageReportRow;


public class LanguageReportRowMapper {
	
	public static List<LanguageReportRow> GenerateLanguageReportFromResultSet(ResultSet rs) throws SQLException {
        List<LanguageReportRow> objectList = new ArrayList<LanguageReportRow>();

        while(rs.next()) {

            try
            {
            	LanguageReportRow languageReportRow = new LanguageReportRow();
                languageReportRow.language = rs.getString("Language");
                languageReportRow.speakers = rs.getDouble("speakers");
                languageReportRow.percentage_of_world_population = rs.getDouble("per_world_population");

                objectList.add(languageReportRow);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return objectList;
    }
}
