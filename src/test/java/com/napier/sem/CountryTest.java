package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.mappers.raw_data.CountryMapper;
import com.napier.sem.mappers.reports.CountryReportRowMapper;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CountryTest {
    @Test
    void getISO3Code() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba", "North America", "Caribbean", 193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


        assertEquals("ABW", country.getISO3Code());
    }

    @Test
    void getName() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("Aruba", country.getName());
    }

    @Test
    void getContinent() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


        assertEquals("North America", country.getContinent());
    }

    @Test
    void getRegion() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("Caribbean", country.getRegion());
    }

    @Test
    void getSurfaceArea() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(193.0, country.getSurfaceArea());
    }

    @Test
    void getIndependenceYear() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(1900, country.getIndependenceYear());
    }

    @Test
    void getPopulation() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(103000, country.getPopulation());
    }

    @Test
    void getLifeExpectancy() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(78.4, country.getLifeExpectancy());
    }

    @Test
    void getGNP() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(828.0, country.getGNP());
    }

    @Test
    void getGNPOld() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(793.0, country.getGNPOld());
    }

    @Test
    void getLocalName() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("Aruba", country.getLocalName());
    }

    @Test
    void getGovernmentForm() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("Nonmetropolitan Territory of The Netherlands", country.getGovernmentForm());
    }

    @Test
    void getHeadOfState() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("Beatrix", country.getHeadOfState());
    }

    @Test
    void getCapital() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals(129, country.getCapital());
    }

    @Test
    void getISO2Code() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("AW", country.getISO2Code());
    }

    @Test
    void toStringTest() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("Country{" +
                "ISO3Code='ABW"  + '\'' +
                ", name='Aruba" + '\'' +
                ", continent='North America" + '\'' +
                ", region='Caribbean" + '\'' +
                ", surfaceArea=193.0" +
                ", independenceYear=1900" +
                ", population=103000" +
                ", lifeExpectancy=78.4" +
                ", GNP=828.0" +
                ", GNPOld=793.0" +
                ", localName='Aruba" + '\'' +
                ", governmentForm='Nonmetropolitan Territory of The Netherlands" + '\'' +
                ", headOfState='Beatrix" + '\'' +
                ", capital=129"  +
                ", ISO2Code='AW" + '\'' +
                '}', country.toString());

    }
}