package com.napier.sem.mappers.reports;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.napier.sem.models.reports.LanguageReportRow;


public class LanguageReportRowMapper {


    public static List<LanguageReportRow> GenerateLanguageReportFromResultSet(ResultSet rs) throws SQLException {
        List<LanguageReportRow> objectList = new ArrayList<LanguageReportRow>();

        while (rs.next()) {

            try {
                LanguageReportRow languageReportRow = new LanguageReportRow();
                languageReportRow.language = rs.getString("Language");
                languageReportRow.speakers = Math.round(rs.getDouble("speakers"));
                languageReportRow.percentage_of_world_population = rs.getDouble("per_world_population");

                objectList.add(languageReportRow);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return objectList;
    }

    private String countryCode;
    private String languageName;
    private String isOfficial;
    private Double percentage;



    public LanguageReportRowMapper(String countryCode, String languageName, String isOfficial, double percentage) {
        this.countryCode = countryCode;
        this.languageName = languageName;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }


    public String getCountryCode() {return countryCode; }


    public String getLanguageName() {
        return languageName;
    }


    public String isOfficial() {
        return isOfficial;
    }


    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Language{" + "languageName='" + languageName + "', " + "percentage='" + percentage + "', " +  "isOfficial='" + isOfficial + "'" + "}";
    }
}
