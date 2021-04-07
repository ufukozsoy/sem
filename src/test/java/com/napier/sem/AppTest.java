package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.helpers.QueryHelper;
import com.napier.sem.mappers.reports.TotalPopulationReportRowMapper;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import com.napier.sem.mappers.reports.CountryReportRowMapper;
import com.napier.sem.mappers.reports.LanguageReportRowMapper;
import com.napier.sem.models.raw_data.Continent;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.reports.CountryReportRow;
import com.napier.sem.models.reports.PopulationReportRow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    static App app;

    static String location = "localhost:33060";

    @BeforeAll
    static void init() {
        app = new App();
        app.connect(location);
    }


    @Test
    void getId() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);

    }


    @Test
    void getName() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);



    }

    @Test
    void getPopulation() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);



    }

    @Test
    void getCountry_code() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);



    }

    @Test
    void getDistrict() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);



    }

    @Test
    void toStringTest() {

        CityReportRowMapper city = new CityReportRowMapper(1, "Kabul", "ABW", "Kabol", 1780000);


    }

    @Test
    void getISO3Code() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba", "North America", "Caribbean", 193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");



    }



    @Test
    void getContinent() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");



    }

    @Test
    void getRegion() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getSurfaceArea() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getIndependenceYear() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }


    @Test
    void getLifeExpectancy() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getGNP() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getGNPOld() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getLocalName() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getGovernmentForm() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getHeadOfState() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }

    @Test
    void getCapital() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");

    }

    @Test
    void getISO2Code() {

        CountryReportRowMapper country = new CountryReportRowMapper("ABW", "Aruba",
                "North America", "Caribbean",
                193.00, 1900, 103000,
                78.4, 828.00, 793.00,
                "Aruba", "Nonmetropolitan Territory of The Netherlands",
                "Beatrix", 129, "AW");


    }
    @Test
    void getCountryCode() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);



    }

    @Test
    void getLanguageName() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


    }

    @Test
    void isOfficial() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);



    }

    @Test
    void getPercentage() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);



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

        City city = new City();


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

        country.code = app.toString();
        country.name = app.toString();;
        country.continent = Continent.fromString(app.toString());
        country.region = app.toString();
        country.localname = app.toString();
        country.governmentform = app.toString();
        country.headofstate = app.toString();

        country.code2 = app.toString();


    }
    @Test
    void TotalPopulationReportRowMapper() {
        TotalPopulationReportRowMapper TotalPopulationReportRowMapper = new TotalPopulationReportRowMapper();

}}


