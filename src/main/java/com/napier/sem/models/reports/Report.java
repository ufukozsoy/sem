package com.napier.sem.models.reports;

import com.napier.sem.models.enums.ReportType;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class Report {
    public String title;
    public List rows;
    public List<String> columns;
    public ReportType reportType;

    public String getSlug() {
        Pattern NONLATIN = Pattern.compile("[^\\w-]");
        Pattern WHITESPACE = Pattern.compile("[\\s]");
        String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public Report(String title, List rows, List columns, ReportType reportType) {
        this.title = title;
        this.rows = rows;
        this.columns = columns;
        this.reportType = reportType;
    }
}
