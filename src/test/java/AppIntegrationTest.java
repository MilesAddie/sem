package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetCities()
    {
        City city = app.getCities().get(56);
        assertEquals(city.getId(), 57);
        assertEquals(city.getName(), "Huambo");
        assertEquals(city.getCountryCode(), "AGO");
        assertEquals(city.getDistrict(), "Huambo");
        assertEquals(city.getPopulation(), 163100);
    }

    @Test
    void testGetCountries()
    {
        Country country = app.getCountries().get(56);
        assertEquals(country.getCode(), "DEU");
        assertEquals(country.getName(), "Germany");
        assertEquals(country.getContinent(), "Europe");
        assertEquals(country.getRegion(), "Western Europe");
        assertEquals(country.getSurfaceArea(), 357022.00);
        assertEquals(country.getIndepYear(), 1955);
        assertEquals(country.getPopulation(), 82164700);
        assertEquals(country.getLifeExpectancy(), 77.4000015258789);
        assertEquals(country.getGnp(), 2133367.00);
        assertEquals(country.getGnpOld(), 2102826.00);
        assertEquals(country.getLocalName(), "Deutschland");
        assertEquals(country.getGovernmentForm(), "Federal Republic");
        assertEquals(country.getHeadOfState(), "Johannes Rau");
        assertEquals(country.getCapital(), "3068");
        assertEquals(country.getCode2(), "DE");
    }

    @Test
    void testGetCountriesPopulationHighestToLowest()
    {
        Country country = app.printCountriesPopulationLargestToSmallest(app.getCountries()).get(56);
        assertEquals(country.getCode(), "MDG");
        assertEquals(country.getName(), "Madagascar");
        assertEquals(country.getContinent(), "Africa");
        assertEquals(country.getRegion(), "Eastern Africa");
        assertEquals(country.getSurfaceArea(), 587041.00);
        assertEquals(country.getIndepYear(), 1960);
        assertEquals(country.getPopulation(), 15942000);
        assertEquals(country.getLifeExpectancy(), 55.0);
        assertEquals(country.getGnp(), 3750.00);
        assertEquals(country.getGnpOld(), 3545.00);
        assertEquals(country.getLocalName(), "Madagasikara/Madagascar");
        assertEquals(country.getGovernmentForm(), "Federal Republic");
        assertEquals(country.getHeadOfState(), "Didier Ratsiraka");
        assertEquals(country.getCapital(), "2455");
        assertEquals(country.getCode2(), "MG");
    }

    @Test
    void testGetCountriesPopulationByContinentHighestToLowest()
    {
        Country country = app.printCountriesPopulationByContinentLargestToSmallest(app.getCountries(), "Europe").get(40);
        assertEquals(country.getCode(), "MCO");
        assertEquals(country.getName(), "Monaco");
        assertEquals(country.getContinent(), "Europe");
        assertEquals(country.getRegion(), "Western Europe");
        assertEquals(country.getSurfaceArea(), 1.50);
        assertEquals(country.getIndepYear(), 1861);
        assertEquals(country.getPopulation(), 34000);
        assertEquals(country.getLifeExpectancy(), 78.80000305175781);
        assertEquals(country.getGnp(), 776.00);
        assertEquals(country.getGnpOld(), 0.0);
        assertEquals(country.getLocalName(), "Monaco");
        assertEquals(country.getGovernmentForm(), "Constitutional Monarchy");
        assertEquals(country.getHeadOfState(), "Rainier III");
        assertEquals(country.getCapital(), "2695");
        assertEquals(country.getCode2(), "MC");
    }

    @Test
    void testGetCountriesPopulationByRegionHighestToLowest()
    {
        Country country = app.printCountriesPopulationByRegionLargestToSmallest(app.getCountries(), "Caribbean").get(10);
        assertEquals(country.getCode(), "ANT");
        assertEquals(country.getName(), "Netherlands Antilles");
        assertEquals(country.getContinent(), "North America");
        assertEquals(country.getRegion(), "Caribbean");
        assertEquals(country.getSurfaceArea(), 800.00);
        assertEquals(country.getIndepYear(), 0);
        assertEquals(country.getPopulation(), 217000);
        assertEquals(country.getLifeExpectancy(), 74.69999694824219);
        assertEquals(country.getGnp(), 1941.00);
        assertEquals(country.getGnpOld(), 0.0);
        assertEquals(country.getLocalName(), "Nederlandse Antillen");
        assertEquals(country.getGovernmentForm(), "Nonmetropolitan Territory of The Netherlands");
        assertEquals(country.getHeadOfState(), "Beatrix");
        assertEquals(country.getCapital(), "33");
        assertEquals(country.getCode2(), "AN");
    }

    @Test
    void testGetCitiesPopulationHighestToLowest()
    {
        City city = app.printCitiesPopulationLargestToSmallest(app.getCities()).get(56);
        assertEquals(city.getId(), 1902);
        assertEquals(city.getName(), "Dalian");
        assertEquals(city.getCountryCode(), "CHN");
        assertEquals(city.getDistrict(), "Liaoning");
        assertEquals(city.getPopulation(), 2697000);
    }

    @Test
    void testGetCitiesPopulationByContinentHighestToLowest()
    {
        City city = app.printCitiesPopulationByContinentLargestToSmallest(app.getCities(), "Europe").get(56);
        assertEquals(city.getId(), 656);
        assertEquals(city.getName(), "Sevilla");
        assertEquals(city.getCountryCode(), "ESP");
        assertEquals(city.getDistrict(), "Andalusia");
        assertEquals(city.getPopulation(), 701927);
    }

    @Test
    void testGetCitiesPopulationByRegionHighestToLowest()
    {
        City city = app.printCitiesPopulationByRegionLargestToSmallest(app.getCities(), "Caribbean").get(56);
        assertEquals(city.getId(), 61);
        assertEquals(city.getName(), "South Hill");
        assertEquals(city.getCountryCode(), "AIA");
        assertEquals(city.getDistrict(), "–");
        assertEquals(city.getPopulation(), 961);
    }

    @Test
    void testGetCitiesPopulationByCountryHighestToLowest()
    {
        City city = app.printCitiesPopulationByCountryLargestToSmallest(app.getCities(), "United Kingdom").get(56);
        assertEquals(city.getId(), 513);
        assertEquals(city.getName(), "Gloucester");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getDistrict(), "England");
        assertEquals(city.getPopulation(), 107000);
    }

    @Test
    void testGetCitiesPopulationByDistrictHighestToLowest()
    {
        City city = app.printCitiesPopulationByDistrictLargestToSmallest(app.getCities(), "England").get(30);
        assertEquals(city.getId(), 494);
        assertEquals(city.getName(), "Reading");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getDistrict(), "England");
        assertEquals(city.getPopulation(), 148000);
    }

    @Test
    void testGetCapitalCitiesPopulationHighestToLowest()
    {
        City city = app.printCapitalCitiesPopulationLargestToSmallest(app.getCities()).get(30);
        assertEquals(city.getId(), 35);
        assertEquals(city.getName(), "Alger");
        assertEquals(city.getCountryCode(), "DZA");
        assertEquals(city.getDistrict(), "Alger");
        assertEquals(city.getPopulation(), 2168000);
    }

    @Test
    void testGetCapitalCitiesPopulationByContinentHighestToLowest()
    {
        City city = app.printCapitalCitiesPopulationByContinentLargestToSmallest(app.getCities(), "Europe").get(30);
        assertEquals(city.getId(), 201);
        assertEquals(city.getName(), "Sarajevo");
        assertEquals(city.getCountryCode(), "BIH");
        assertEquals(city.getDistrict(), "Federaatio");
        assertEquals(city.getPopulation(), 360000);
    }

    @Test
    void testGetCapitalCitiesPopulationByRegionHighestToLowest()
    {
        City city = app.printCapitalCitiesPopulationByRegionLargestToSmallest(app.getCities(), "Caribbean").get(5);
        assertEquals(city.getId(), 1530);
        assertEquals(city.getName(), "Kingston");
        assertEquals(city.getCountryCode(), "JAM");
        assertEquals(city.getDistrict(), "St. Andrew");
        assertEquals(city.getPopulation(), 103962);
    }

    @Test
    void testPopulationContinent()
    {
        String populationStatistics = app.printPopulationsContinent("Europe");
        assertEquals(populationStatistics, "Population statistics of Europe\n" +
                "Total = 730074600\n" +
                "Population in cities = 241942813\n" +
                "Population not in cities = 488131787");
    }

    @Test
    void testPopulationRegion()
    {
        String populationStatistics = app.printPopulationsRegion("Caribbean");
        assertEquals(populationStatistics, "Population statistics of Caribbean\n" +
                "Total = 38140000\n" +
                "Population in cities = 11067550\n" +
                "Population not in cities = 27072450");
    }

    @Test
    void testPopulationCountry()
    {
        String populationStatistics = app.printPopulationsCountry("United Kingdom");
        assertEquals(populationStatistics, "Population statistics of United Kingdom\n" +
                "Total = 59623400\n" +
                "Population in cities = 22436673\n" +
                "Population not in cities = 37186727");
    }

    @Test
    void testGetCountriesPopulationHighestToLowestWithN()
    {
        Country country = app.printCountriesPopulationLargestToSmallestWithN(app.getCountries(), 5).get(3);
        assertEquals(country.getCode(), "MDG");
        assertEquals(country.getName(), "Madagascar");
        assertEquals(country.getContinent(), "Africa");
        assertEquals(country.getRegion(), "Eastern Africa");
        assertEquals(country.getSurfaceArea(), 587041.00);
        assertEquals(country.getIndepYear(), 1960);
        assertEquals(country.getPopulation(), 15942000);
        assertEquals(country.getLifeExpectancy(), 55.0);
        assertEquals(country.getGnp(), 3750.00);
        assertEquals(country.getGnpOld(), 3545.00);
        assertEquals(country.getLocalName(), "Madagasikara/Madagascar");
        assertEquals(country.getGovernmentForm(), "Federal Republic");
        assertEquals(country.getHeadOfState(), "Didier Ratsiraka");
        assertEquals(country.getCapital(), "2455");
        assertEquals(country.getCode2(), "MG");
    }

    @Test
    void testGetCountriesPopulationByContinentHighestToLowestWithN()
    {
        Country country = app.printCountriesPopulationByContinentLargestToSmallestWithN(app.getCountries(), "Europe", 5).get(3);
        assertEquals(country.getCode(), "MCO");
        assertEquals(country.getName(), "Monaco");
        assertEquals(country.getContinent(), "Europe");
        assertEquals(country.getRegion(), "Western Europe");
        assertEquals(country.getSurfaceArea(), 1.50);
        assertEquals(country.getIndepYear(), 1861);
        assertEquals(country.getPopulation(), 34000);
        assertEquals(country.getLifeExpectancy(), 78.80000305175781);
        assertEquals(country.getGnp(), 776.00);
        assertEquals(country.getGnpOld(), 0.0);
        assertEquals(country.getLocalName(), "Monaco");
        assertEquals(country.getGovernmentForm(), "Constitutional Monarchy");
        assertEquals(country.getHeadOfState(), "Rainier III");
        assertEquals(country.getCapital(), "2695");
        assertEquals(country.getCode2(), "MC");
    }

    @Test
    void testGetCountriesPopulationByRegionHighestToLowestWithN()
    {
        Country country = app.printCountriesPopulationByRegionLargestToSmallestWithN(app.getCountries(), "Caribbean", 5).get(3);
        assertEquals(country.getCode(), "ANT");
        assertEquals(country.getName(), "Netherlands Antilles");
        assertEquals(country.getContinent(), "North America");
        assertEquals(country.getRegion(), "Caribbean");
        assertEquals(country.getSurfaceArea(), 800.00);
        assertEquals(country.getIndepYear(), 0);
        assertEquals(country.getPopulation(), 217000);
        assertEquals(country.getLifeExpectancy(), 74.69999694824219);
        assertEquals(country.getGnp(), 1941.00);
        assertEquals(country.getGnpOld(), 0.0);
        assertEquals(country.getLocalName(), "Nederlandse Antillen");
        assertEquals(country.getGovernmentForm(), "Nonmetropolitan Territory of The Netherlands");
        assertEquals(country.getHeadOfState(), "Beatrix");
        assertEquals(country.getCapital(), "33");
        assertEquals(country.getCode2(), "AN");
    }

    @Test
    void testGetCitiesPopulationHighestToLowestWithN()
    {
        City city = app.printCitiesPopulationLargestToSmallestWithN(app.getCities(), 5).get(3);
        assertEquals(city.getId(), 1902);
        assertEquals(city.getName(), "Dalian");
        assertEquals(city.getCountryCode(), "CHN");
        assertEquals(city.getDistrict(), "Liaoning");
        assertEquals(city.getPopulation(), 2697000);
    }

    @Test
    void testGetCitiesPopulationByContinentHighestToLowestWithN()
    {
        City city = app.printCitiesPopulationByContinentLargestToSmallestWithN(app.getCities(), "Europe", 5).get(3);
        assertEquals(city.getId(), 656);
        assertEquals(city.getName(), "Sevilla");
        assertEquals(city.getCountryCode(), "ESP");
        assertEquals(city.getDistrict(), "Andalusia");
        assertEquals(city.getPopulation(), 701927);
    }

    @Test
    void testGetCitiesPopulationByRegionHighestToLowestWithN()
    {
        City city = app.printCitiesPopulationByRegionLargestToSmallestWithN(app.getCities(), "Caribbean", 5).get(3);
        assertEquals(city.getId(), 61);
        assertEquals(city.getName(), "South Hill");
        assertEquals(city.getCountryCode(), "AIA");
        assertEquals(city.getDistrict(), "–");
        assertEquals(city.getPopulation(), 961);
    }

    @Test
    void testGetCitiesPopulationByCountryHighestToLowestWithN()
    {
        City city = app.printCitiesPopulationByCountryLargestToSmallestWithN(app.getCities(), "United Kingdom", 5).get(3);
        assertEquals(city.getId(), 513);
        assertEquals(city.getName(), "Gloucester");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getDistrict(), "England");
        assertEquals(city.getPopulation(), 107000);
    }

    @Test
    void testGetCitiesPopulationByDistrictHighestToLowestWithN()
    {
        City city = app.printCitiesPopulationByDistrictLargestToSmallestWithN(app.getCities(), "England", 5).get(3);
        assertEquals(city.getId(), 494);
        assertEquals(city.getName(), "Reading");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getDistrict(), "England");
        assertEquals(city.getPopulation(), 148000);
    }

    @Test
    void testGetCapitalCitiesPopulationHighestToLowestWithN()
    {
        City city = app.printCapitalCitiesPopulationLargestToSmallestWithN(app.getCities(), 5).get(3);
        assertEquals(city.getId(), 35);
        assertEquals(city.getName(), "Alger");
        assertEquals(city.getCountryCode(), "DZA");
        assertEquals(city.getDistrict(), "Alger");
        assertEquals(city.getPopulation(), 2168000);
    }

    @Test
    void testGetCapitalCitiesPopulationByContinentHighestToLowestWithN()
    {
        City city = app.printCapitalCitiesPopulationByContinentLargestToSmallestWithN(app.getCities(), "Europe", 5).get(3);
        assertEquals(city.getId(), 201);
        assertEquals(city.getName(), "Sarajevo");
        assertEquals(city.getCountryCode(), "BIH");
        assertEquals(city.getDistrict(), "Federaatio");
        assertEquals(city.getPopulation(), 360000);
    }

    @Test
    void testGetCapitalCitiesPopulationByRegionHighestToLowestWithN()
    {
        City city = app.printCapitalCitiesPopulationByRegionLargestToSmallestWithN(app.getCities(), "Caribbean", 5).get(3);
        assertEquals(city.getId(), 1530);
        assertEquals(city.getName(), "Kingston");
        assertEquals(city.getCountryCode(), "JAM");
        assertEquals(city.getDistrict(), "St. Andrew");
        assertEquals(city.getPopulation(), 103962);
    }
}