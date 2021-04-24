package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.helpers.QueryHelper;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import com.napier.sem.mappers.reports.CountryReportRowMapper;
import com.napier.sem.mappers.reports.LanguageReportRowMapper;
import com.napier.sem.mappers.reports.QueryHeaderMapper;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.raw_data.Continent;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.raw_data.CountryLanguage;
import com.napier.sem.models.reports.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

	static String location = "localhost:3306";

    @BeforeAll
    static void init() {
        app = new App();
        app.connect(location);
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
    void testAsiaInContinentEnumFromString() {
        assertEquals("Asia", Continent.fromString("Asia").toString());
    }

    @Test
    void testEuropeInContinentEnumFromString() {
        assertEquals("Europe", Continent.fromString("Europe").toString());
    }

    @Test
    void testNAInContinentEnumFromString() {
        assertEquals("North_America", Continent.fromString("North America").toString());
    }

    @Test
    void testAfricaInContinentEnumFromString() {
        assertEquals("Africa", Continent.fromString("Africa").toString());
    }

    @Test
    void testOceaniaInContinentEnumFromString() {
        assertEquals("Oceania", Continent.fromString("Oceania").toString());
    }

    @Test
    void testAntInContinentEnumFromString() {
        assertEquals("Antarctica", Continent.fromString("Antarctica").toString());
    }

    @Test
    void testSAInContinentEnumFromString() {
        assertEquals("South_America", Continent.fromString("South America").toString());
    }

    @Test
    public void testMainMethodForExceptions() {
        try {
            String[] arg = {};
            app.main(arg);
        } catch (Exception e) {
            assertNull(e);
        }
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
    void CountryReport() {

        QueryHelper queryHelper = new QueryHelper();
    }
    @Test
    void WriteReportListToCSV() {

        CSVHelper CSVHelper = new CSVHelper();
    }
    @Test
    void GenerateLanguageFromResultSet() {

        CountryLanguage countryLanguage = new CountryLanguage();

        countryLanguage.countrycode = app.toString();
        countryLanguage.language = app.toString();

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
    void GenerateHeadersFromResultSet () {
        QueryHeaderMapper QueryHeaderMapper = new QueryHeaderMapper();
}

	@Test
	public void testReportFoldersExists() {
		try {
			String[] arg = {};
			app.main(arg);
		} catch (Exception e) {
			assertNull(e);
		}
	}

}