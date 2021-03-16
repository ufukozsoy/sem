package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.mappers.raw_data.CityMapper;
import com.napier.sem.models.reports.CityReportRow;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import com.napier.sem.mappers.reports.CapitalCityReportRowMapper;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class CapitalCityReportRowMapperTest {
    @Test
    void getId() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals(1, city.getId());
    }

    @Test
    void getName() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("Kabul", city.getName());
    }

    @Test
    void getPopulation() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals(1780000, city.getPopulation());
    }

    @Test
    void getCountry_code() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("ABW", city.getCountry_code());
    }

    @Test
    void getDistrict() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("Kabol", city.getDistrict());
    }

    @Test
    void toStringTest() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("City{" +
                "id=1" +
                ", name='Kabul" + '\'' +
                ", country_code='ABW" + '\'' +
                ", district='Kabol" + '\'' +
                ", population=1780000" +
                '}', city.toString());
    }
}