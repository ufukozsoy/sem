package com.napier.sem;

import com.napier.sem.mappers.reports.CapitalCityReportRowMapper;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class CapitalCityReportRowMapperTest {
    @Test
    void getId() {

        CapitalCityReportRowMapper city = new CapitalCityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals(1, city.getId());
    }

    @Test
    void getName() {

        CapitalCityReportRowMapper city = new CapitalCityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("Kabul", city.getName());
    }

    @Test
    void getPopulation() {

        CapitalCityReportRowMapper city = new CapitalCityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals(1780000, city.getPopulation());
    }

    @Test
    void getCountry_code() {

        CapitalCityReportRowMapper city = new CapitalCityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("ABW", city.getCountry_code());
    }

    @Test
    void getDistrict() {

        CapitalCityReportRowMapper city = new CapitalCityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);

        assertEquals("Kabol", city.getDistrict());
    }

    @Test
    void toStringTest() {

        CapitalCityReportRowMapper city = new CapitalCityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("City{" +
                "id=1" +
                ", name='Kabul" + '\'' +
                ", country_code='ABW" + '\'' +
                ", district='Kabol" + '\'' +
                ", population=1780000" +
                '}', city.toString());
    }
}