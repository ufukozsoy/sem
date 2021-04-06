package com.napier.sem;

import com.napier.sem.mappers.reports.PopulationReportRowMapper;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class PopulationReportRowMapperTest {
    @Test
    void getId() {

        PopulationReportRowMapper city = new PopulationReportRowMapper(1,"Kabul", "ABW", "Kabol", 1780000);


        assertEquals(1, city.getId());
    }

    @Test
    void getName() {

        PopulationReportRowMapper city = new PopulationReportRowMapper(1,"Kabul", "ABW", "Kabol", 1780000);


        assertEquals("Kabul", city.getName());
    }

    @Test
    void getPopulation() {

        PopulationReportRowMapper city = new PopulationReportRowMapper(1,"Kabul", "ABW", "Kabol", 1780000);


        assertEquals(1780000, city.getPopulation());
    }

    @Test
    void getCountry_code() {

        PopulationReportRowMapper city = new PopulationReportRowMapper(1,"Kabul", "ABW", "Kabol", 1780000);


        assertEquals("ABW", city.getCountry_code());
    }

    @Test
    void getDistrict() {

        PopulationReportRowMapper city = new PopulationReportRowMapper(1,"Kabul", "ABW", "Kabol", 1780000);


        assertEquals("Kabol", city.getDistrict());
    }

    @Test
    void toStringTest() {

        PopulationReportRowMapper city = new PopulationReportRowMapper(1,"Kabul", "ABW", "Kabol", 1780000);


        assertEquals("City{" +
                "id=1" +
                ", name='Kabul" + '\'' +
                ", country_code='ABW" + '\'' +
                ", district='Kabol" + '\'' +
                ", population=1780000" +
                '}', city.toString());
    }
}