package com.napier.sem.helpers;

import com.napier.sem.models.raw_data.Query;

import java.util.*;

public class QueryHelper {

    public static List<Query> CountryReports;
    public static List<Query> CityReports;
    public static List<Query> CapitalCityReports;
    public static List<Query> PopulationReports;
    public static List<Query> LanguageReports;

    public QueryHelper()
    {
        CountryReports = new ArrayList<Query>(Arrays.asList(
                new Query("SELECT CO.name,CO.code,CO.continent,CO.region,CO.population,CI.name as capital FROM country CO LEFT JOIN city CI ON CO.capital = CI.id ORDER BY population DESC;",
                        "All the countries in the world organised by largest population to smallest."),

                new Query("SELECT CO.name,CO.code,CO.continent,CO.region,CO.population,CI.name as capital FROM country CO LEFT JOIN city CI ON CO.capital = CI.id WHERE CO.continent = 'Europe' ORDER BY population DESC;",
                        "All the countries in a continent organised by largest population to smallest."),

                new Query("SELECT CO.name,CO.code,CO.continent,CO.region,CO.population,CI.name as capital FROM country CO LEFT JOIN city CI ON CO.capital = CI.id WHERE CO.region = 'Eastern Europe' ORDER BY population DESC;",
                        "All the countries in a region organised by largest population to smallest."),

                // --- --- ---

                new Query("SELECT CO.name,CO.code,CO.continent,CO.region,CO.population,CI.name as capital FROM country CO LEFT JOIN city CI ON CO.capital = CI.id ORDER BY population DESC LIMIT 5;",
                        "The top N populated countries in the world where N is provided by the user."),

                new Query("SELECT CO.name,CO.code,CO.continent,CO.region,CO.population,CI.name as capital FROM country CO LEFT JOIN city CI ON CO.capital = CI.id WHERE CO.continent = 'Europe' ORDER BY population DESC LIMIT 5;",
                        "The top N populated countries in a continent where N is provided by the user."),

                new Query("SELECT CO.name,CO.code,CO.continent,CO.region,CO.population,CI.name as capital FROM country CO LEFT JOIN city CI ON CO.capital = CI.id WHERE CO.region = 'Eastern Europe' ORDER BY population DESC LIMIT 5;",
                        "The top N populated countries in a region where N is provided by the user.")
        ));

        CityReports = new ArrayList<Query>(Arrays.asList(
                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code ORDER BY CI.population DESC;",
                        "All the cities in the world organised by largest population to smallest."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CO.continent = 'Asia' ORDER BY CI.population DESC;",
                        "All the cities in a continent organised by largest population to smallest."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CO.region = 'Western Europe' ORDER BY CI.population DESC;",
                        "All the cities in a region organised by largest population to smallest."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.countrycode = 'NLD' ORDER BY CI.population DESC;",
                        "All the cities in a country organised by largest population to smallest."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.district = 'California' ORDER BY CI.population DESC;",
                        "All the cities in a district organised by largest population to smallest."),

                // --- --- ---


                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code ORDER BY CI.population DESC LIMIT 5",
                        "The top N populated cities in the world where N is provided by the user."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CO.continent = 'Asia' ORDER BY CI.population DESC LIMIT 5",
                        "The top N populated cities in a continent where N is provided by the user."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CO.region = 'Western Europe' ORDER BY CI.population DESC LIMIT 5;",
                        "The top N populated cities in a region where N is provided by the user."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.countrycode = 'NLD' ORDER BY CI.population DESC LIMIT 5;",
                        "The top N populated cities in a country where N is provided by the user."),

                new Query("SELECT CI.Name, CO.Name as country, CI.District, CI.Population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.district = 'California' ORDER BY CI.population DESC LIMIT 5;",
                    "The top N populated cities in a district where N is provided by the user.")
        ));

        CapitalCityReports = new ArrayList<Query>(Arrays.asList(
                new Query("SELECT CI.Name as name, CO.Name as country, CI.Population as population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.id = CO.capital ORDER BY CI.population DESC;",
                        "All the capital cities in the world organised by largest population to smallest."),

                new Query("SELECT CI.Name as name, CO.Name as country, CI.Population as population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.id = CO.capital AND CO.continent = 'Europe' ORDER BY CI.population DESC;",
                        "All the capital cities in a continent organised by largest population to smallest."),

                new Query("SELECT CI.Name as name, CO.Name as country, CI.Population as population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.id = CO.capital AND CO.region = 'South America' ORDER BY CI.population DESC;",
                        "All the capital cities in a region organised by largest to smallest."),

                // --- --- ---

                new Query("SELECT CI.Name as name, CO.Name as country, CI.Population as population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.id = CO.capital ORDER BY CI.population DESC LIMIT 5;",
                        "The top N populated capital cities in the world where N is provided by the user."),

                new Query("SELECT CI.Name as name, CO.Name as country, CI.Population as population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.id = CO.capital AND CO.continent = 'Europe' ORDER BY CI.population DESC LIMIT 5;",
                        "The top N populated capital cities in a continent where N is provided by the user."),

                new Query("SELECT CI.Name as name, CO.Name as country, CI.Population as population FROM city CI LEFT JOIN country CO ON CI.countrycode = CO.code WHERE CI.id = CO.capital AND CO.region = 'South America' ORDER BY CI.population DESC LIMIT 5;",
                        "The top N populated capital cities in a region where N is provided by the user.")
        ));

        PopulationReports = new ArrayList<Query>(Arrays.asList(
                new Query("SELECT CO.continent as name, SUM(distinct CO.Population) AS total_pop, (SUM(distinct CI.Population) / SUM(distinct CO.population)) AS urban_pop_percentage, (1 - SUM(distinct CI.Population) / SUM(distinct CO.Population)) AS rural_pop_percentage FROM country CO LEFT JOIN city CI ON CO.code = CI.countrycode GROUP BY CO.Continent ORDER By SUM(CO.Population) DESC;",
                "The population of people, people living in cities, and people not living in cities in each continent."),

                new Query("SELECT CO.region as name, SUM(distinct CO.Population) AS total_pop, (SUM(distinct CI.Population) / SUM(distinct CO.population)) AS urban_pop_percentage, (1 - SUM(distinct CI.Population) / SUM(distinct CO.Population)) AS rural_pop_percentage FROM country CO LEFT JOIN city CI ON CO.code = CI.countrycode GROUP BY CO.Region ORDER By SUM(CO.Population) DESC;",
                        "The population of people, people living in cities, and people not living in cities in each region."),

                new Query("SELECT CO.name as name, SUM(distinct CO.Population) AS total_pop, (SUM(distinct CI.Population) / SUM(distinct CO.population)) AS urban_pop_percentage, (1- SUM(distinct CI.Population) / SUM(distinct CO.Population)) AS rural_pop_percentage FROM country CO LEFT JOIN city CI ON CO.code = CI.countrycode GROUP BY CO.Code ORDER By SUM(CO.Population) DESC;",
                        "The population of people, people living in cities, and people not living in cities in each country.")
        ));
		//code by viva
        LanguageReports=new ArrayList<Query>(Arrays.asList(
        		new Query("select cl.Language,sum((cl.Percentage/100)*(co.Population)) as speakers,(select sum((cl.Percentage)*(co.Population))/sum(Population) from country) as per_world_population   from countrylanguage cl\n"
        				+ "left join country co\n"
        				+ "on co.code=cl.CountryCode\n"
        				+ "where cl.Language in ('Chinese','English','Hindi','Spanish','Arabic')\n"
        				+ "group by cl.Language\n"
        				+ "order by speakers desc;\n"
        				+ "","The number of people who speak the specified languages from greatest number to smallest, including the percentage of the world population")
        		));
    }
}
