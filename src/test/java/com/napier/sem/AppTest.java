package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    @Test
    void printCitiesTestNull() {
        app.printCityReport(null);
    }

    @Test
    void printCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCityReport(cities);
    }

    @Test
    void printCitiesTestNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCityReport(cities);
    }

    @Test
    void printCountriesTestNull() {
        app.printCountryReport(null);
    }

    @Test
    void printCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountryReport(countries);
    }

    @Test
    void printCountriesTestNormal() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("AGO","Angola","Africa","Central Africa",
                1246700,1975,12878000,38,6648,
                7984,"Angola","Republic","José Eduardo dos Santos","56","AO");
        countries.add(country);
        country = new Country("GBR","United Kingdom","Europe","British Islands",
                242900,1066,59623400,77.7,1378330,
                1296830,"United Kingdom","Constitutional Monarchy","Elisabeth II","456","GB");
        countries.add(country);
        country = new Country("GHA","Ghana","Africa","Western Africa",
                238533.00,1957,20212000,57.4,7137.00,
                6884.00,"Ghana","Republic","John Kufuor","910","GH"
        );
        countries.add(country);
        app.printCountryReport(countries);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNull() {
        app.printCountriesLargestToSmallest(null);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesLargestToSmallest(countries);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNormal() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("AGO","Angola","Africa","Central Africa",
                1246700,1975,12878000,38,6648,
                7984,"Angola","Republic","José Eduardo dos Santos","56","AO");
        countries.add(country);
        country = new Country("GBR","United Kingdom","Europe","British Islands",
                242900,1066,59623400,77.7,1378330,
                1296830,"United Kingdom","Constitutional Monarchy","Elisabeth II","456","GB");
        countries.add(country);
        country = new Country("GHA","Ghana","Africa","Western Africa",
                238533.00,1957,20212000,57.4,7137.00,
                6884.00,"Ghana","Republic","John Kufuor","910","GH"
        );
        countries.add(country);
        app.printCountriesLargestToSmallest(countries);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestNullNoContinent() {
        app.printCountriesByContinentLargestToSmallest(null,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestNullWithContinent() {
        app.printCountriesByContinentLargestToSmallest(null,"Europe");
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestEmptyNoContinent() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesByContinentLargestToSmallest(countries,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestEmptyWithContinent() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesByContinentLargestToSmallest(countries,"Europe");
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestNormalNoContinent() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("AGO","Angola","Africa","Central Africa",
                1246700,1975,12878000,38,6648,
                7984,"Angola","Republic","José Eduardo dos Santos","56","AO");
        countries.add(country);
        country = new Country("GBR","United Kingdom","Europe","British Islands",
                242900,1066,59623400,77.7,1378330,
                1296830,"United Kingdom","Constitutional Monarchy","Elisabeth II","456","GB");
        countries.add(country);
        country = new Country("GHA","Ghana","Africa","Western Africa",
                238533.00,1957,20212000,57.4,7137.00,
                6884.00,"Ghana","Republic","John Kufuor","910","GH"
        );
        countries.add(country);
        app.printCountriesByContinentLargestToSmallest(countries,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestNormalWithContinent() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("AGO","Angola","Africa","Central Africa",
                1246700,1975,12878000,38,6648,
                7984,"Angola","Republic","José Eduardo dos Santos","56","AO");
        countries.add(country);
        country = new Country("GBR","United Kingdom","Europe","British Islands",
                242900,1066,59623400,77.7,1378330,
                1296830,"United Kingdom","Constitutional Monarchy","Elisabeth II","456","GB");
        countries.add(country);
        country = new Country("GHA","Ghana","Africa","Western Africa",
                238533.00,1957,20212000,57.4,7137.00,
                6884.00,"Ghana","Republic","John Kufuor","910","GH"
        );
        countries.add(country);
        app.printCountriesByContinentLargestToSmallest(countries,"Europe");
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestNullNoRegion() {
        app.printCountriesByRegionLargestToSmallest(null,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestNullWithRegion() {
        app.printCountriesByRegionLargestToSmallest(null,"Caribbean");
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestEmptyNoRegion() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesByRegionLargestToSmallest(countries,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestEmptyWithRegion() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesByRegionLargestToSmallest(countries,"Caribbean");
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestNormalNoRegion() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("AGO","Angola","Africa","Central Africa",
                1246700,1975,12878000,38,6648,
                7984,"Angola","Republic","José Eduardo dos Santos","56","AO");
        countries.add(country);
        country = new Country("GBR","United Kingdom","Europe","British Islands",
                242900,1066,59623400,77.7,1378330,
                1296830,"United Kingdom","Constitutional Monarchy","Elisabeth II","456","GB");
        countries.add(country);
        country = new Country("GHA","Ghana","Africa","Western Africa",
                238533.00,1957,20212000,57.4,7137.00,
                6884.00,"Ghana","Republic","John Kufuor","910","GH"
        );
        countries.add(country);
        app.printCountriesByRegionLargestToSmallest(countries,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestNormalWithRegion() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("AGO","Angola","Africa","Central Africa",
                1246700,1975,12878000,38,6648,
                7984,"Angola","Republic","José Eduardo dos Santos","56","AO");
        countries.add(country);
        country = new Country("GBR","United Kingdom","Europe","British Islands",
                242900,1066,59623400,77.7,1378330,
                1296830,"United Kingdom","Constitutional Monarchy","Elisabeth II","456","GB");
        countries.add(country);
        country = new Country("GHA","Ghana","Africa","Western Africa",
                238533.00,1957,20212000,57.4,7137.00,
                6884.00,"Ghana","Republic","John Kufuor","910","GH"
        );
        countries.add(country);
        app.printCountriesByRegionLargestToSmallest(countries,"Western Africa");
    }
}