package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.helpers.QueryHelper;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import com.napier.sem.mappers.reports.CountryReportRowMapper;
import com.napier.sem.mappers.reports.LanguageReportRowMapper;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.reports.CountryReportRow;
import com.napier.sem.models.reports.PopulationReportRow;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

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

    @Test
    void getISO3Code() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba", "North America", "Caribbean", 193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


        assertEquals("ABW", country.getISO3Code());
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
    void getCountryCode() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());
    }

    @Test
    void getLanguageName() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());
    }

    @Test
    void isOfficial() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());
    }

    @Test
    void getPercentage() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());
    }

    @Test
    void WriteReportListToCSV() {

        QueryHelper queryHelper = new QueryHelper();
    }

    @Test
    void GenerateLanguageFromResultSet() {
        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());
    }

    @Test
    void GenerateCountryReportRowsFromResultSet() {
        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

        assertEquals("AW", country.getISO2Code());
    }

    @Test
    void GenerateCityFromResultSet() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


        assertEquals("City{" +
                "id=1" +
                ", name='Kabul" + '\'' +
                ", country_code='ABW" + '\'' +
                ", district='Kabol" + '\'' +
                ", population=1780000" +
                '}', city.toString());
    }

    @Test
    void CountryReports() {

        CountryReportRow country = new CountryReportRow();

    }


    @Test
    void Population() {

        PopulationReportRow populationReportRow = new PopulationReportRow();
    }

    @Test
    void CSVHelper() {

        CSVHelper CSVHelper = new CSVHelper();

    }
    @Test
    void GenerateCountryFromResultSet() {
    Country country = new Country();
}}