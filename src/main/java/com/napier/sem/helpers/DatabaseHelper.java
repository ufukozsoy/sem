package com.napier.sem.helpers;

import com.napier.sem.mappers.reports.*;
import com.napier.sem.models.enums.ReportType;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.raw_data.Query;
import com.napier.sem.models.reports.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    public static ResultSet RunSelectQuery(Connection con, String queryString)
    {
        ResultSet rset = null;
        try
        {
            Statement stmt = con.createStatement();
            rset = stmt.executeQuery(queryString);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get result set");
        }
        return rset;
    }

    public static List<Report> GenerateReportsForQueryArray(Connection conn, List<Query> queryArray, ReportType reportType) {

        List<Report> generatedReports = new ArrayList<Report>();

        for (Query selectQuery : queryArray) {
            System.out.println("Running query: " + selectQuery.query);
            ResultSet queryResult = DatabaseHelper.RunSelectQuery(conn, selectQuery.query);

            try {
                List<String> queryHeaders = QueryHeaderMapper.GenerateHeadersFromResultSet(queryResult);

                List reportRowList = new ArrayList();

                switch (reportType) {
                    case Country:
                        reportRowList = CountryReportRowMapper.GenerateCountryReportRowsFromResultSet(queryResult);
                        break;
                    case City:
                        reportRowList = CityReportRowMapper.GenerateCityFromResultSet(queryResult);
                        break;
                    case CapitalCity:
                        reportRowList = CapitalCityReportRowMapper.GenerateCapitalCityFromResultSet(queryResult);
                        break;
                    case Population:
                        reportRowList = PopulationReportRowMapper.GeneratePopulationReportFromResultSet(queryResult);
                        break;
                    case Language:
                        reportRowList = LanguageReportRowMapper.GenerateLanguageReportFromResultSet(queryResult);
                        break;
                }
                generatedReports.add(new Report(selectQuery.title, reportRowList, queryHeaders, reportType));
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Query finished: " + selectQuery.query);
        }

        return generatedReports;
    }
}
