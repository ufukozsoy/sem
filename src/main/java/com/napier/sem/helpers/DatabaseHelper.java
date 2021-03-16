package com.napier.sem.helpers;

import com.napier.sem.models.raw_data.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
}
