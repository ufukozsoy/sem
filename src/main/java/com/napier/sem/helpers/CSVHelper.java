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
                        csvWriter.append(countryReportRow.code);
                        csvWriter.append(",");
                        csvWriter.append(countryReportRow.continent.label);
                        csvWriter.append(",");
                        csvWriter.append(countryReportRow.region);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", countryReportRow.population));
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", countryReportRow.capital));
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
                        csvWriter.append(populationReportRow.name);
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", populationReportRow.population));
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", populationReportRow.urban_pop_percentage));
                        csvWriter.append(",");
                        csvWriter.append(String.format("%d", populationReportRow.rural_pop_percentage));
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
