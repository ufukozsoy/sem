package com.napier.sem;

import com.napier.sem.helpers.CSVHelper;
import com.napier.sem.helpers.QueryHelper;
import com.napier.sem.mappers.reports.TotalPopulationReportRowMapper;
import com.napier.sem.mappers.reports.CityReportRowMapper;
import com.napier.sem.mappers.reports.CountryReportRowMapper;
import com.napier.sem.mappers.reports.LanguageReportRowMapper;
import com.napier.sem.models.raw_data.Continent;
import com.napier.sem.models.raw_data.Country;
import com.napier.sem.models.raw_data.CountryLanguage;
import com.napier.sem.models.enums.ReportType;
import com.napier.sem.models.raw_data.City;
import com.napier.sem.models.reports.CapitalCityReportRow;
import com.napier.sem.models.reports.CityReportRow;
import com.napier.sem.models.reports.CountryReportRow;
import com.napier.sem.models.reports.LanguageReportRow;
import com.napier.sem.models.reports.PopulationReportRow;
import com.napier.sem.models.reports.TotalPopulationReportRow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

public class AppTest {

    static App app;

	static String location = "localhost:3306";

    @BeforeAll
    static void init() {
        app = new App();
        app.connect(location);
    }

	@Test
	void testDisconnectConnection() {
		try {
			app.disconnect(app.connect(location));
		} catch (Exception e) {
			assertNull(e);
		}
	}

	@Test
	void testCurrentTimeStampInApp() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		assertEquals(date.format(new java.util.Date()), app.getCurrentTimeStamp());
	}

	@Test
	void testCountryInEnum() {
		assertEquals("Country", ReportType.values()[0].toString());
	}

	@Test
	void testCityInEnum() {
		assertEquals("City", ReportType.values()[1].toString());
	}

	@Test
	void testCapitalCityInEnum() {
		assertEquals("CapitalCity", ReportType.values()[2].toString());
	}

	@Test
	void testPopulationInEnum() {
		assertEquals("Population", ReportType.values()[3].toString());
	}

	@Test
	void testLanguageInEnum() {
		assertEquals("Language", ReportType.values()[4].toString());
	}

	@Test
	void testTotalPopulationInEnum() {
		assertEquals("TotalPopulation", ReportType.values()[5].toString());
	}

	@Test
	void testCountryLanguageObjectIsNotNull() {
		CountryLanguage cl = new CountryLanguage();
		assertNull(cl.countrycode);
	}
	
	@Test
	void testCapitalCityReportRowObjectIsNotNull() {
		CapitalCityReportRow cl = new CapitalCityReportRow();
		assertNull(cl.country);
	}
	
	@Test
	void testCityReportRowObjectIsNotNull() {
		CityReportRow cl = new CityReportRow();
		assertNull(cl.country);
	}
	
	@Test
	void testLanguageReportRowObjectIsNotNull() {
		LanguageReportRow cl = new LanguageReportRow();
		assertNull(cl.countryCode);
	}
	
	@Test
	void testTotalPopulationReportRowRowObjectIsNotNull() {
		TotalPopulationReportRow cl = new TotalPopulationReportRow();
		assertNull(cl.name);
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


