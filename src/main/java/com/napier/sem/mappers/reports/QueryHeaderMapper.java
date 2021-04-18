package com.napier.sem.mappers.reports;
import com.napier.sem.models.reports.CapitalCityReportRow;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryHeaderMapper {

    //Maps a ResultSet object into a string representing a header row for a generated CSV
    public static List<String> GenerateHeadersFromResultSet(ResultSet rs) throws SQLException {
        List<String> objectList = new ArrayList<String>();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        System.out.println("Getting resultset metadata. Number of columns: " + columnCount);

        // The column count starts from 1
        for (int i = 1; i <= columnCount; i++ ) {
            String columnName = rsmd.getColumnName(i);
            objectList.add(columnName);
            System.out.println("Adding column to columns list: " + columnName);
        }
        System.out.println("total number of columns in list: " + objectList.stream().count());

        return objectList;
    }
}