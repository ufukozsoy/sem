package com.napier.sem.mappers.reports;
import com.napier.sem.models.reports.CapitalCityReportRow;
import com.napier.sem.models.reports.CityReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CapitalCityReportRowMapper {

    //Maps a ResultSet object onto a CapitalCityReportRow object
    public static List<CapitalCityReportRow> GenerateCapitalCityFromResultSet(ResultSet rs) throws SQLException {
        List<CapitalCityReportRow> objectList = new ArrayList<CapitalCityReportRow>();

        while(rs.next()) {

            try
            {
                CapitalCityReportRow capitalCityReportRow = new CapitalCityReportRow();

                capitalCityReportRow.name = rs.getString("Name");
                capitalCityReportRow.country = rs.getString("Country");
                capitalCityReportRow.population = rs.getInt("Population");

                objectList.add(capitalCityReportRow);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return objectList;
    }
    private final int id;
    private final String name;
    private final String country_code;
    private final String district;
    private final int population;

    public CapitalCityReportRowMapper(int id, String name, String country_code, String district, int population) {
        this.id = id;
        this.name = name;
        this.country_code = country_code;
        this.district = district;
        this.population = population;
    }

    /**
     *
     * @return The unique identifier number of this city
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return The name of this city
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The country code of this city
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     *
     * @return The district of this city
     */
    public String getDistrict() {
        return district;
    }

    /**
     *
     * @return The population of this city
     */
    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", country_code='" + this.country_code + '\'' +
                ", district='" + this.district + '\'' +
                ", population=" + this.population +
                '}';
    }
}
