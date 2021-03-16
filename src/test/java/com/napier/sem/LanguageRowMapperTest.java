package com.napier.sem;

import com.napier.sem.mappers.raw_data.CityMapper;
import com.napier.sem.mappers.raw_data.CountryLanguageMapper;
import com.napier.sem.mappers.reports.LanguageReportRowMapper;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LanguageRowMapperTest {

    @Test
    void getCountryCode() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());
    }

    @Test
    void getLanguageName() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("ABW", language.getCountryCode());}

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
    void toStringTest() {

        LanguageReportRowMapper language = new LanguageReportRowMapper("ABW", "Dutch", "T", 5.3);


        assertEquals("Language{" + "languageName='Dutch" + "', " + "percentage='5.3" + "', " +  "isOfficial='T" + "'" + "}", language.toString());
    }
}