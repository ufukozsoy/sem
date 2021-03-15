package com.napier.sem.helpers;


import com.napier.sem.models.enums.ReportType;
import com.napier.sem.models.reports.*;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class CSVHelper {

    public static void WriteReportListToCSV(List<Report> reportList, String outputFolderName) {
        for (Report report : reportList) {
            WriteReportToCSV(report, outputFolderName);
        }
    }

    public static void WriteReportToCSV(Report report, String outputFolderName)
    {
        try
        {
            String directoryPath = "/tmp/output_reports/" + outputFolderName;
            String filePath = directoryPath + "/" + report.getSlug() + ".csv";

            File directory = new File(directoryPath);
            if (! directory.exists()){
                directory.mkdirs();
            }

            System.out.println("Saving report to: " + filePath);

            FileWriter csvWriter = new FileWriter(filePath);

            // Print header
            csvWriter.append(String.join(",", report.columns));
            csvWriter.append("\n");

            switch (report.reportType)
            {
                case Country:

                    for (CountryReportRow countryReportRow : (List<CountryReportRow>)report.rows) {
                        csvWriter.append(countryReportRow.name);
                        csvWriter.append(",");
                        csvWriter.append(countryReportRow.ISO3code);
                        csvWriter.append(",");
                        csvWriter.append(countryReportRow.continent);
                        csvWriter.append(",");
                        csvWriter.append(countryReportRow.region);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", countryReportRow.population));
                        csvWriter.append(",");
                        csvWriter.append(countryReportRow.headofstate);
                        csvWriter.append("\n");
                    }
                    break;

                case City:
                    for (CityReportRow cityReportRow : (List<CityReportRow>)report.rows) {
                        csvWriter.append(cityReportRow.name);
                        csvWriter.append(",");
                        csvWriter.append(cityReportRow.country);
                        csvWriter.append(",");
                        csvWriter.append(cityReportRow.district);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", cityReportRow.population));
                        csvWriter.append("\n");
                    }
                    break;

                case CapitalCity:
                    for (CapitalCityReportRow capitalCityReportRow : (List<CapitalCityReportRow>)report.rows) {
                        csvWriter.append(capitalCityReportRow.name);
                        csvWriter.append(",");
                        csvWriter.append(capitalCityReportRow.country);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", capitalCityReportRow.population));
                        csvWriter.append("\n");
                    }
                    break;

                case Population:
                    for (PopulationReportRow populationReportRow : (List<PopulationReportRow>)report.rows) {

                        System.out.println("Writing row to CSV: " + populationReportRow.name);

                        csvWriter.append(populationReportRow.name);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", populationReportRow.population));
                        csvWriter.append(",");
                        csvWriter.append(String.format("%.2f", populationReportRow.urban_pop_percentage));
                        csvWriter.append(",");
                        csvWriter.append(String.format("%.2f", populationReportRow.rural_pop_percentage));
                        csvWriter.append("\n");
                    }
                    break;
                             
                case Language:
                	for (LanguageReportRow languageReportRow : (List<LanguageReportRow>)report.rows) {

                        System.out.println("Writing row to CSV: " + languageReportRow.language);
						                       
                        csvWriter.append(languageReportRow.language);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", languageReportRow.speakers));
                        csvWriter.append(",");
                        csvWriter.append(String.format("%.2f", languageReportRow.percentage_of_world_population));
                        csvWriter.append("\n");
            }
                	break;
                    
            }

            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to write report to CSV");
        }
    }
}
