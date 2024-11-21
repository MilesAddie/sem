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
    void printCapitalCitiesTestNull() {
        app.printCapitalCityReport(null);
    }

    @Test
    void printCapitalCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCityReport(cities);
    }

    @Test
    void printCapitalCitiesTestNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(456, "London", "GBR", "England", 7285000);
        cities.add(city);
        city = new City(1532, "Japan", "JPN", "Tokyo-to", 7980230);
        cities.add(city);
        city = new City(3068, "Berlin", "DEU", "Berliini", 3386667);
        cities.add(city);
        app.printCapitalCityReport(cities);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNull() {
        app.printCountriesPopulationLargestToSmallest(null);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationLargestToSmallest(countries);
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
        app.printCountriesPopulationLargestToSmallest(countries);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestNullNoContinent() {
        app.printCountriesPopulationByContinentLargestToSmallest(null,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestNullWithContinent() {
        app.printCountriesPopulationByContinentLargestToSmallest(null,"Europe");
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestEmptyNoContinent() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallest(countries,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByContinentTestEmptyWithContinent() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallest(countries,"Europe");
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
        app.printCountriesPopulationByContinentLargestToSmallest(countries,null);
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
        app.printCountriesPopulationByContinentLargestToSmallest(countries,"Europe");
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestNullNoRegion() {
        app.printCountriesPopulationByRegionLargestToSmallest(null,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestNullWithRegion() {
        app.printCountriesPopulationByRegionLargestToSmallest(null,"Caribbean");
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestEmptyNoRegion() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallest(countries,null);
    }

    @Test
    void printCountriesPopulationHighestToLowestByRegionTestEmptyWithRegion() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallest(countries,"Caribbean");
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
        app.printCountriesPopulationByRegionLargestToSmallest(countries,null);
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
        app.printCountriesPopulationByRegionLargestToSmallest(countries,"Western Africa");
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNull() {
        app.printCitiesPopulationLargestToSmallest(null);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationLargestToSmallest(cities);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationLargestToSmallest(cities);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullNoContinent() {
        app.printCitiesPopulationByContinentLargestToSmallest(null, null);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithContinent() {
        app.printCitiesPopulationByContinentLargestToSmallest(null, "Europe");
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyNoContinent() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithContinent() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallest(cities, "Europe");
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalNoContinent() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithContinent() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallest(cities, "Europe");
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullNoRegion() {
        app.printCitiesPopulationByRegionLargestToSmallest(null, null);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithRegion() {
        app.printCitiesPopulationByRegionLargestToSmallest(null, "Caribean");
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyNoRegion() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithRegion() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallest(cities, "Caribbean");
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalNoRegion() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithRegion() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallest(cities, "Caribbean");
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullNoCountry() {
        app.printCitiesPopulationByCountryLargestToSmallest(null, null);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithCountry() {
        app.printCitiesPopulationByCountryLargestToSmallest(null, "United Kingdom");
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyNoCountry() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithCountry() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallest(cities, "United Kingdom");
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalNoCountry() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithCountry() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallest(cities, "United Kingdom");
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullNoDistrict() {
        app.printCitiesPopulationByDistrictLargestToSmallest(null, null);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithDistrict() {
        app.printCitiesPopulationByDistrictLargestToSmallest(null, "England");
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyNoDistrict() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithDistrict() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallest(cities, "England");
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalNoDistrict() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallest(cities, null);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithDistrict() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallest(cities, "England");
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNull() {
        app.printCapitalCitiesPopulationLargestToSmallest(null);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationLargestToSmallest(cities);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationLargestToSmallest(cities);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullNoContinent() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallest(null, null);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithContinent() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallest(null, "Europe");
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyNoContinent() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallest(cities, null);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithContinent() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallest(cities, "Europe");
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalNoContinent() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallest(cities, null);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithContinent() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallest(cities, "Europe");
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullNoRegion() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallest(null, null);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithRegion() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallest(null, "Caribean");
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyNoRegion() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallest(cities, null);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithRegion() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallest(cities, "Caribbean");
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalNoRegion() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallest(cities, null);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithRegion() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallest(cities, "Caribbean");
    }

    @Test
    void printPopulationContinentTestNull(){
        app.printPopulationsContinent(null);
    }

    @Test
    void printPopulationContinentTestNormal(){
        app.printPopulationsContinent("Europe");
    }

    @Test
    void printPopulationRegionTestNull(){
        app.printPopulationsRegion(null);
    }

    @Test
    void printPopulationRegionTestNormal(){
        app.printPopulationsRegion("Caribbean");
    }

    @Test
    void printPopulationCountryTestNull(){
        app.printPopulationsCountry(null);
    }

    @Test
    void printPopulationCountryTestNormal(){
        app.printPopulationsCountry("United Kingdom");

    @Test
    void printCountriesPopulationHighestToLowestTestNullWithNAsNegative() {
        app.printCountriesPopulationLargestToSmallestWithN(null, -5);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNullWithNAsZero() {
        app.printCountriesPopulationLargestToSmallestWithN(null, -5);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNullWithNAsNoremal() {
        app.printCountriesPopulationLargestToSmallestWithN(null, 5);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationLargestToSmallestWithN(countries, -5);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationLargestToSmallestWithN(countries, 0);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationLargestToSmallestWithN(countries, 5);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNormalWithNAsNegative() {
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
        app.printCountriesPopulationLargestToSmallestWithN(countries, 0);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNormalWithNAsZero() {
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
        app.printCountriesPopulationLargestToSmallestWithN(countries, -5);
    }

    @Test
    void printCountriesPopulationHighestToLowestTestNormalWithNAsNormal() {
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
        app.printCountriesPopulationLargestToSmallestWithN(countries, 5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNullWithNAsNegative() {
        app.printCountriesPopulationByContinentLargestToSmallestWithN(null, "Europe", -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNullWithNAsZero() {
        app.printCountriesPopulationByContinentLargestToSmallestWithN(null, "Europe", -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNullWithNAsNoremal() {
        app.printCountriesPopulationByContinentLargestToSmallestWithN(null, "Europe", 5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCountriesPopulationByContinentLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCountriesPopulationByContinentLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNullWithNAsNoremalContinentAsNull() {
        app.printCountriesPopulationByContinentLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, "Europe", -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, "Europe", 0);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, "Europe", 5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, null, -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, null, 0);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, null, 5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNormalWithNAsNegative() {
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
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, "Europe", 0);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNormalWithNAsZero() {
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
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, "Europe", -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNormalWithNAsNormal() {
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
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, "Europe", 5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
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
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, null, 0);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
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
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, null, -5);
    }

    @Test
    void printCountriesPopulationByContinentHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
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
        app.printCountriesPopulationByContinentLargestToSmallestWithN(countries, null, 5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNullWithNAsNegative() {
        app.printCountriesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNullWithNAsZero() {
        app.printCountriesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNullWithNAsNoremal() {
        app.printCountriesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", 5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNullWithNAsNegativeRegionAsNull() {
        app.printCountriesPopulationByRegionLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNullWithNAsZeroRegionAsNull() {
        app.printCountriesPopulationByRegionLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNullWithNAsNoremalRegionAsNull() {
        app.printCountriesPopulationByRegionLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, "Caribbean", -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, "Caribbean", 0);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, "Caribbean", 5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestEmptyWithNAsNegativeRegionAsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, null, -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestEmptyWithNAsZeroRegionAsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, null, 0);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestEmptyWithNAsNormalRegionAsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, null, 5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNormalWithNAsNegative() {
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
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, "Caribbean", 0);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNormalWithNAsZero() {
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
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, "Caribbean", -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNormalWithNAsNormal() {
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
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, "Caribbean", 5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNormalWithNAsNegativeRegionAsNull() {
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
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, null, 0);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNormalWithNAsZeroRegionAsNull() {
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
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, null, -5);
    }

    @Test
    void printCountriesPopulationByRegionHighestToLowestTestNormalWithNAsNormalRegionAsNull() {
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
        app.printCountriesPopulationByRegionLargestToSmallestWithN(countries, null, 5);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNullWithNAsNegative() {
        app.printCitiesPopulationLargestToSmallestWithN(null, -5);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNullWithNAsZero() {
        app.printCitiesPopulationLargestToSmallestWithN(null, 0);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNullWithNAsNormal() {
        app.printCitiesPopulationLargestToSmallestWithN(null, 5);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationLargestToSmallestWithN(cities, -5);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationLargestToSmallestWithN(cities, 0);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationLargestToSmallestWithN(cities, 5);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationLargestToSmallestWithN(cities, -5);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationLargestToSmallestWithN(cities, 0);
    }

    @Test
    void printCitiesPopulationHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationLargestToSmallestWithN(cities, 5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithNAsNegative() {
        app.printCitiesPopulationByContinentLargestToSmallestWithN(null, "Europe", -5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithNAsZero() {
        app.printCitiesPopulationByContinentLargestToSmallestWithN(null, "Europe", 0);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithNAsNormal() {
        app.printCitiesPopulationByContinentLargestToSmallestWithN(null, "Europe", 5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCitiesPopulationByContinentLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCitiesPopulationByContinentLargestToSmallestWithN(null, null, 0);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNullWithNAsNormalContinentAsNull() {
        app.printCitiesPopulationByContinentLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", -5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 0);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", -5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 0);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithNAsNegative() {
        app.printCitiesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", -5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithNAsZero() {
        app.printCitiesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", 0);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithNAsNormal() {
        app.printCitiesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", 5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCitiesPopulationByRegionLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCitiesPopulationByRegionLargestToSmallestWithN(null, null, 0);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNullWithNAsNormalContinentAsNull() {
        app.printCitiesPopulationByRegionLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", -5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 0);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", -5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 0);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithNAsNegative() {
        app.printCitiesPopulationByCountryLargestToSmallestWithN(null, "United Kingdom", -5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithNAsZero() {
        app.printCitiesPopulationByCountryLargestToSmallestWithN(null, "United Kingdom", 0);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithNAsNormal() {
        app.printCitiesPopulationByCountryLargestToSmallestWithN(null, "United Kingdom", 5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCitiesPopulationByCountryLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCitiesPopulationByCountryLargestToSmallestWithN(null, null, 0);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNullWithNAsNormalContinentAsNull() {
        app.printCitiesPopulationByCountryLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, "United Kingdom", -5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, "United Kingdom", 0);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, "United Kingdom", 5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, "United Kingdom", -5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, "United Kingdom", 0);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, "United Kingdom", 5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByCountryHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByCountryLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithNAsNegative() {
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(null, "England", -5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithNAsZero() {
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(null, "England", 0);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithNAsNormal() {
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(null, "England", 5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(null, null, 0);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNullWithNAsNormalContinentAsNull() {
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, "England", -5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, "England", 0);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, "England", 5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, "England", -5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, "England", 0);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, "England", 5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCitiesPopulationByDistrictHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCitiesPopulationByDistrictLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNullWithNAsNegative() {
        app.printCapitalCitiesPopulationLargestToSmallestWithN(null, -5);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNullWithNAsZero() {
        app.printCapitalCitiesPopulationLargestToSmallestWithN(null, 0);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNullWithNAsNormal() {
        app.printCapitalCitiesPopulationLargestToSmallestWithN(null, 5);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationLargestToSmallestWithN(cities, -5);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationLargestToSmallestWithN(cities, 0);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationLargestToSmallestWithN(cities, 5);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationLargestToSmallestWithN(cities, -5);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationLargestToSmallestWithN(cities, 0);
    }

    @Test
    void printCapitalCitiesPopulationHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationLargestToSmallestWithN(cities, 5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithNAsNegative() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(null, "Europe", -5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithNAsZero() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(null, "Europe", 0);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithNAsNormal() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(null, "Europe", 5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(null, null, 0);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNullWithNAsNormalContinentAsNull() {
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", -5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 0);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", -5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 0);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, "Europe", 5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCapitalCitiesPopulationByContinentHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithNAsNegative() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", -5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithNAsZero() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", 0);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithNAsNormal() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(null, "Caribbean", 5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithNAsNegativeContinentAsNull() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(null, null, -5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithNAsZeroContinentAsNull() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(null, null, 0);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNullWithNAsNormalContinentAsNull() {
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(null, null, 5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", -5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsZero() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 0);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestEmptyWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNegative() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", -5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithNAsZero() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 0);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNormal() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, "Caribbean", 5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNegativeContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, null, -5);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithNAsZeroContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 0);
    }

    @Test
    void printCapitalCitiesPopulationByRegionHighestToLowestTestNormalWithNAsNormalContinentAsNull() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
        cities.add(city);
        city = new City(459, "Liverpool", "GBR", "England", 461000);
        cities.add(city);
        city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
        cities.add(city);
        app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(cities, null, 5);
    }
}