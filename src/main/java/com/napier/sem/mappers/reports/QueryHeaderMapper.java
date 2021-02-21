package com.napier.sem.mappers.reports;
import com.napier.sem.models.reports.CapitalCityReportRow;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryHeaderMapper {

    public static List<String> GenerateHeadersFromResultSet(ResultSet rs) throws SQLException {
        List<String> objectList = new ArrayList<String>();

        while(rs.next()) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // The column count starts from 1
            for (int i = 1; i <= columnCount; i++ ) {
                String columnName = rsmd.getColumnName(i);
                objectList.add(columnName);
            }
        }
        return objectList;
    }
}