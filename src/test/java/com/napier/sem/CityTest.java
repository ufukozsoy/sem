package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.mappers.raw_data.CityMapper;
import com.napier.sem.models.reports.CityReportRow;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Class Tests for the City Data Model to verify that the correct data is
 * stored in the structs correctly.
 */

class CityTest {
    @Test
    void getId() {
        //Arrange
        CityReportRowMapper city = new CityReportRowMapper(1,"Varna", "169", "Varna", 100000);

        //Assert
        assertEquals(1, city.getId());
    }

    @Test
    void getName() {
        //Arrange
        CityReportRowMapper city = new CityReportRowMapper(1,"Varna", "169", "Varna", 100000);

        //Assert
        assertEquals("Varna", city.getName());
    }

    @Test
    void getPopulation() {
        //Arrange
        CityReportRowMapper city = new CityReportRowMapper(1,"Varna", "169", "Varna", 100000);

        //Assert
        assertEquals(100000, city.getPopulation());
    }

    @Test
    void getCountry_code() {
        //Arrange
        CityReportRowMapper city = new CityReportRowMapper(1,"Varna", "169", "Varna", 100000);

        //Assert
        assertEquals("169", city.getCountry_code());
    }

    @Test
    void getDistrict() {
        //Arrange
        CityReportRowMapper city = new CityReportRowMapper(1,"Varna", "169", "Varna", 100000);

        //Assert
        assertEquals("Varna", city.getDistrict());
    }

    @Test
    void toStringTest() {
        //Arrange
        CityReportRowMapper city = new CityReportRowMapper(1,"Varna", "169", "Varna", 100000);

        //Assert
        assertEquals("City{" +
                "id=1" +
                ", name='Varna" + '\'' +
                ", country_code='169" + '\'' +
                ", district='Varna" + '\'' +
                ", population=100000" +
                '}', city.toString());
    }
}