package com.napier.sem.mappers.reports;
import com.napier.sem.models.raw_data.Continent;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.reports.CountryReportRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryReportRowMapper {

    public static List<CountryReportRow> GenerateCountryReportRowsFromResultSet(ResultSet rs) throws SQLException {
        List<CountryReportRow> objectList = new ArrayList<CountryReportRow>();

        while(rs.next()) {

            try
            {
                CountryReportRow countryReportRow = new CountryReportRow();

                countryReportRow.name = rs.getString("Name");
                countryReportRow.ISO3code = rs.getString("ISO3Code");
                countryReportRow.continent = rs.getString("continent");
                countryReportRow.region = rs.getString("Region");
                countryReportRow.population = rs.getInt("Population");
                countryReportRow.headofstate = rs.getString("headOfstate");

                objectList.add(countryReportRow);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return objectList;
    }



    private final String ISO3Code;
    private final String name;
    private final String continent;
    private final String region;
    private final Double surfaceArea;
    private final int independenceYear;
    private final int population;
    private final double lifeExpectancy;
    private final double GNP;
    private final double GNPOld;
    private final String localName;
    private final String governmentForm;
    private final String headOfState;
    private final int capital;
    private final String ISO2Code;



    public CountryReportRowMapper(String ISO3Code, String name, String continent, String region,
                                  Double surfaceArea, int indepYear, int population, double lifeExpectancy,
                                  double GNP, double GNPOld, String localName, String governmentForm, String headOfState,
                                  int capital, String ISO2Code){
        this.ISO3Code = ISO3Code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.independenceYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.ISO2Code = ISO2Code;
    }


    public String getISO3Code () {
        return ISO3Code;
    }

  
    public String getName () {
        return name;
    }


    public String getContinent () {
        return continent;
    }


    public String getRegion () {
        return region;
    }

    /**

     */
    public double getSurfaceArea () {
        return surfaceArea;
    }

    /**

     */
    public int getIndependenceYear () {
        return independenceYear;
    }


    public int getPopulation () {
        return population;
    }


    public double getLifeExpectancy () {
        return lifeExpectancy;
    }


    public double getGNP () {
        return GNP;
    }


    public double getGNPOld () {
        return GNPOld;
    }


    public String getLocalName () {
        return localName;
    }


    public String getGovernmentForm () {
        return governmentForm;
    }


    public String getHeadOfState () {
        return headOfState;
    }


    public int getCapital () {
        return capital;
    }


    public String getISO2Code () {
        return ISO2Code;
    }


    @Override
    public String toString() {
        return "Country{" +
                "ISO3Code='" + ISO3Code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", independenceYear=" + independenceYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", GNP=" + GNP +
                ", GNPOld=" + GNPOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + capital +
                ", ISO2Code='" + ISO2Code + '\'' +
                '}';
    }
}