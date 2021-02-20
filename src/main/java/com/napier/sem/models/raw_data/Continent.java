package com.napier.sem.models.raw_data;

public enum Continent {
    Asia("Asia"),
    Europe("Europe"),
    North_America("North America"),
    Africa("Africa"),
    Oceania("Oceania"),
    Antarctica("Antarctica"),
    South_America("South America");

    public final String label;

    private Continent(String label) {
        this.label = label;
    }
}