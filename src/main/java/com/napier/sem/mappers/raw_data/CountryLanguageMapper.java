package com.napier.sem.mappers.raw_data;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.raw_data.CountryLanguage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryLanguageMapper {

    public static List<CountryLanguage> GenerateCityFromResultSet(ResultSet rs) throws SQLException {
        List<CountryLanguage> objectList = new ArrayList<CountryLanguage>();

        while(rs.next()) {

            CountryLanguage countryLanguage = new CountryLanguage();

            countryLanguage.countrycode = rs.getString("CountryCode");
            countryLanguage.language = rs.getString("Language");
            countryLanguage.isofficial = rs.getBoolean("IsOfficial");
            countryLanguage.percentage = rs.getDouble("Percentage");

            objectList.add(countryLanguage);
        }
        return objectList;
    }
}