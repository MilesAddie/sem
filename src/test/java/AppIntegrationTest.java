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
}