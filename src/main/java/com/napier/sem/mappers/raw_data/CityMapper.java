package com.napier.sem.mappers.raw_data;
import com.napier.sem.models.raw_data.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityMapper {

    public static List<City> GenerateCityFromResultSet(ResultSet rs) throws SQLException {
        List<City> objectList = new ArrayList<City>();

        while(rs.next()) {

            City city = new City();

            city.name = rs.getString("Name");
            city.countrycode = rs.getString("CountryCode");
            city.district = rs.getString("District");
            city.population = rs.getInt("Population");

            objectList.add(city);
        }
        return objectList;
    }
}