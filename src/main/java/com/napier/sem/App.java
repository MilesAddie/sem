package com.napier.sem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        if (args.length < 1) {
            a.connect("localhost:33060", 0);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }
//        ArrayList<City> cities = a.printCapitalCitiesPopulationLargestToSmallestWithN(a.getCities(), 5);
//        for (City city : cities)
//        {
//            System.out.println(city);
//        }
        // Disconnect from database
        a.disconnect();
    }

    public ArrayList<City> getCities() {
        ArrayList<City> cities = new ArrayList<>();
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * from city";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            //cycle
            while (rset.next()) {
                int id = rset.getInt("ID");
                String name = rset.getString("Name");
                String countryCode = rset.getString("CountryCode");
                String district = rset.getString("District");
                int population = rset.getInt("Population");
                City city = new City(id, name, countryCode, district, population);
                cities.add(city);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
        return  cities;
    }

    public ArrayList<Country> getCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * from country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            //cycle
            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                float surfaceArea = rset.getFloat("SurfaceArea");
                int indepYear = rset.getInt("IndepYear");
                int population = rset.getInt("Population");
                float lifeExpectancy = rset.getFloat("LifeExpectancy");
                float gnp = rset.getFloat("GNP");
                float gnpOld = rset.getFloat("GNPOld");
                String localName = rset.getString("LocalName");
                String governmentForm = rset.getString("GovernmentForm");
                String headOfState = rset.getString("HeadOfState");
                String capital = rset.getString("Capital");
                String code2 = rset.getString("Code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                countries.add(country);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
        return  countries;
    }

    public void report2() {
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * from country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            //cycle
            while (rset.next()) {
                String name = rset.getString("name");
                int population = rset.getInt("population");
                sb.append(name + "\t" + population + "\r\n");
            }
            new File("./output/").mkdir();
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(new File("./output/report1.txt")));
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return;
        }
    }


    /**
     * Connect to the MySQL database.
     *
     * @param conString
     * 		Use db:3306 for docker and localhost:33060 for local or Integration
     * 		Tests
     * @param
     */
    public void connect(String conString, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                //Added allowPublicKeyRetrieval=true to get Integration Tests
                // to work. Possibly due to accessing from another class?
                con = DriverManager.getConnection("jdbc:mysql://" + conString
                        + "/world?allowPublicKeyRetrieval=true&useSSL"
                        + "=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt "
                        + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    //Print a list of the cities and their details
    public void printCityReport(ArrayList<City> cities){
        if(cities == null){
            System.out.println("No cities found");
            return;
        }
        for(City city : cities){
            System.out.println(city);
        }
    }

    //print a list of the countries and their details
    public void printCountryReport(ArrayList<Country> countries){
        if(countries == null){
            System.out.println("No countries found");
            return;
        }
        for(Country country : countries){
            System.out.println(country);
        }
    }

    public void printCapitalCityReport(ArrayList<City> capitalCities){
        if(capitalCities == null){
            System.out.println("No capital cities found");
            return;
        }
        for(City city : capitalCities){
            System.out.println(city);
        }
    }

    //print out the countries from the largest population to the smallest
    public ArrayList<Country> printCountriesPopulationLargestToSmallest(ArrayList<Country> countries){
        if(countries == null){
            System.out.println("No countries found");
            return null;
        }
        for (int i = 0; i < countries.size(); i++){
            for (int j = i + 1; j < countries.size(); j++){
                Country temp;
                if (countries.get(i).getPopulation() < countries.get(j).getPopulation()){
                    temp = countries.get(i);
                    countries.set(i, countries.get(j));
                    countries.set(j, temp);
                }
            }
        }
        return countries;
    }

    //print out the top N populated countries
    public ArrayList<Country> printCountriesPopulationLargestToSmallestWithN(ArrayList<Country> countries, int n){
        if(countries == null){
            System.out.println("No countries found");
            return null;
        }
        if(n <= 0){
            System.out.println("No countries found");
            return null;
        }
        countries = printCountriesPopulationLargestToSmallest(countries);
        ArrayList<Country> sortedCountries = new ArrayList<>();
        int i = 0;
        while (n != 0 && countries.size() != i)
        {
            sortedCountries.add(countries.get(i));
            i++;n--;
        }
        return sortedCountries;
    }

    //print out the countries in a specific continent in order of largest population to the smallest
    public ArrayList<Country> printCountriesPopulationByContinentLargestToSmallest(ArrayList<Country> countries, String continent){
        if(countries == null){
            System.out.println("No countries found");
            return null;
        }
        if(continent == null){
            System.out.println("No continent found");
            return null;
        }
        countries.removeIf(country -> !Objects.equals(country.getContinent(), continent));
         return printCountriesPopulationLargestToSmallest(countries);
    }

    //print out the top N populated countries in a specific continent
    public ArrayList<Country> printCountriesPopulationByContinentLargestToSmallestWithN(ArrayList<Country> countries, String continent, int n){
        if(countries == null){
            System.out.println("No countries found");
            return null;
        }
        if(n <= 0){
            System.out.println("No countries found");
            return null;
        }
        if(continent == null){
            System.out.println("No continent found");
            return null;
        }
        countries = printCountriesPopulationByContinentLargestToSmallest(countries, continent);
        ArrayList<Country> sortedCountries = new ArrayList<>();
        int i = 0;
        while (n != 0 && countries.size() != i)
        {
            sortedCountries.add(countries.get(i));
            i++;n--;
        }
        return sortedCountries;
    }

    //print out the countries in a specific region in order of largest population to the smallest
    public ArrayList<Country> printCountriesPopulationByRegionLargestToSmallest(ArrayList<Country> countries, String region){
        if(countries == null){
            System.out.println("No countries found");
            return null;
        }
        if(region == null){
            System.out.println("No region found");
            return null;
        }
        countries.removeIf(country -> !Objects.equals(country.getRegion(), region));
        return printCountriesPopulationLargestToSmallest(countries);
    }

    //print out the top N populated countries in a specific region
    public ArrayList<Country> printCountriesPopulationByRegionLargestToSmallestWithN(ArrayList<Country> countries, String region, int n){
        if(countries == null){
            System.out.println("No countries found");
            return null;
        }
        if(n <= 0){
            System.out.println("No countries found");
            return null;
        }
        if(region == null){
            System.out.println("No region found");
            return null;
        }
        countries = printCountriesPopulationByRegionLargestToSmallest(countries, region);
        ArrayList<Country> sortedCountries = new ArrayList<>();
        int i = 0;
        while (n != 0 && countries.size() != 0)
        {
            sortedCountries.add(countries.get(i));
            i++;n--;
        }
        return sortedCountries;
    }

    //print out the cities in order of largest population to smallest
    public ArrayList<City> printCitiesPopulationLargestToSmallest(ArrayList<City> cities){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        for (int i = 0; i < cities.size(); i++) {
            for (int j = i + 1; j < cities.size(); j++) {
                City temp;
                if (cities.get(i).getPopulation() < cities.get(j).getPopulation()) {
                    temp = cities.get(i);
                    cities.set(i, cities.get(j));
                    cities.set(j, temp);
                }
            }
        }
        return cities;
    }

    //print out the top N populated cities
    public ArrayList<City> printCitiesPopulationLargestToSmallestWithN(ArrayList<City> cities, int n){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }

        cities = printCitiesPopulationLargestToSmallest(cities);
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //print out the cities in a specific continent in order of largest population to the smallest
    public ArrayList<City> printCitiesPopulationByContinentLargestToSmallest(ArrayList<City> cities, String continent){
        if (cities == null){
            System.out.println("No cities found");
            return null;
        }
        if (continent == null) {
            System.out.println("No continent found");
            return null;
        }

        ArrayList<Country> countries = getCountries();
        try
        {
            countries.removeIf(country -> !country.getContinent().equals(continent));
            ArrayList<City> sortedCities = new ArrayList<>();
            for (City city : cities)
            {
                for (Country country : countries)
                {
                    if (city.getCountryCode().equals(country.getCode()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            return printCitiesPopulationLargestToSmallest(sortedCities);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that continent found");
        }
        return null;
    }

    //print out the top N populated cities from specific continent
    public ArrayList<City> printCitiesPopulationByContinentLargestToSmallestWithN(ArrayList<City> cities, String continent, int n){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }
        if(continent == null) {
            System.out.println("No continent found");
            return null;
        }
        cities = printCitiesPopulationByContinentLargestToSmallest(cities, continent);
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //print out the cities in a specific region in order of largest population to the smallest
    public ArrayList<City> printCitiesPopulationByRegionLargestToSmallest(ArrayList<City> cities, String region){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(region == null){
            System.out.println("No region found");
            return null;
        }

        ArrayList<Country> countries = getCountries();
        try
        {
            countries.removeIf(country -> !country.getRegion().equals(region));
            ArrayList<City> sortedCities = new ArrayList<>();
            for (City city : cities)
            {
                for (Country country : countries)
                {
                    if (city.getCountryCode().equals(country.getCode()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            return printCitiesPopulationLargestToSmallest(sortedCities);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that region found");
        }
        return null;
    }

    //print out the top N populated cities from specific region
    public ArrayList<City> printCitiesPopulationByRegionLargestToSmallestWithN(ArrayList<City> cities, String region, int n){
        cities = printCitiesPopulationByRegionLargestToSmallest(cities, region);
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }
        if(region == null) {
            System.out.println("No region found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //print out the cities in a specific country in order of largest population to the smallest
    public ArrayList<City> printCitiesPopulationByCountryLargestToSmallest(ArrayList<City> cities, String countryName){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(countryName == null){
            System.out.println("No country found");
            return null;
        }

        ArrayList<Country> countries = getCountries();
        try
        {
            countries.removeIf(country -> !country.getName().equals(countryName));
            ArrayList<City> sortedCities = new ArrayList<>();
            for (City city : cities)
            {
                for (Country country : countries)
                {
                    if (city.getCountryCode().equals(country.getCode()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            return printCitiesPopulationLargestToSmallest(sortedCities);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that country found");
        }
        return null;
    }

    //print out the top N populated cities from specific country
    public ArrayList<City> printCitiesPopulationByCountryLargestToSmallestWithN(ArrayList<City> cities, String country, int n){
        cities = printCitiesPopulationByCountryLargestToSmallest(cities, country);
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }
        if(country == null) {
            System.out.println("No country found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //print out the cities in a specific district in order of largest population to the smallest
    public ArrayList<City> printCitiesPopulationByDistrictLargestToSmallest(ArrayList<City> cities, String district){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(district == null){
            System.out.println("No district found");
            return null;
        }

        ArrayList<City> sortedCities = new ArrayList<>();
        for (City city : cities)
        {
            if (city.getDistrict().equals(district))
            {
                sortedCities.add(city);
            }
        }
        return printCitiesPopulationLargestToSmallest(sortedCities);
    }

    //print out the top N populated cities from specific district
    public ArrayList<City> printCitiesPopulationByDistrictLargestToSmallestWithN(ArrayList<City> cities, String district, int n){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }
        if(district == null) {
            System.out.println("No district found");
            return null;
        }

        cities = printCitiesPopulationByDistrictLargestToSmallest(cities, district);
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //sort the capital cities in order of largest population to the smallest
    public ArrayList<City> sortCapitalCitiesPopulationLargestToSmallest(ArrayList<City> cities){
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        for (int i = 0; i < cities.size(); i++) {
            for (int j = i + 1; j < cities.size(); j++) {
                City temp;
                if (cities.get(i).getPopulation() < cities.get(j).getPopulation()) {
                    temp = cities.get(i);
                    cities.set(i, cities.get(j));
                    cities.set(j, temp);
                }
            }
        }
        return cities;
    }

    //print out the capital cities in order of largest population to the smallest
    public ArrayList<City> printCapitalCitiesPopulationLargestToSmallest(ArrayList<City> cities) {
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        try
        {
            for (Country country : getCountries())
            {
                for (City city : cities)
                {
                    if (Long.toString(city.getId()).equals(country.getCapital()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            return sortCapitalCitiesPopulationLargestToSmallest(sortedCities);
        }
        catch (Exception e)
        {
            System.out.println("No countries with those capitals found");
        }
        return null;
    }

    //print out the top N populated capital cities
    public ArrayList<City> printCapitalCitiesPopulationLargestToSmallestWithN(ArrayList<City> cities, int n){
        cities = printCapitalCitiesPopulationLargestToSmallest(cities);
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0 && cities.size() != 0){
            System.out.println("No cities found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n >= 0 && cities.size() != i)
        {
            System.out.println("i = "+i+"\nn = "+n);
            sortedCities.add(cities.get(i));
            i++;
            n--;
        }
        return sortedCities;
    }

    //print out the capital cities in a specific continent in order of largest population to the smallest
    public ArrayList<City> printCapitalCitiesPopulationByContinentLargestToSmallest(ArrayList<City> cities, String continent) {
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(continent == null){
            System.out.println("No continent found");
            return null;
        }
        ArrayList<Country> countries = getCountries();
        try
        {
            countries.removeIf(country -> !country.getContinent().equals(continent));
            ArrayList<City> sortedCities = new ArrayList<>();
            for (Country country : countries)
            {
                for (City city : cities)
                {
                    if (Long.toString(city.getId()).equals(country.getCapital()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            return sortCapitalCitiesPopulationLargestToSmallest(sortedCities);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that continent found");
        }
        return null;
    }

    //print out the top N populated capital cities from a specific continent
    public ArrayList<City> printCapitalCitiesPopulationByContinentLargestToSmallestWithN(ArrayList<City> cities, String continent, int n){
        cities = printCapitalCitiesPopulationByContinentLargestToSmallest(cities, continent);
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }
        if(continent == null){
            System.out.println("No continent found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //print out the capital cities in a specific region in order of largest population to the smallest
    public ArrayList<City> printCapitalCitiesPopulationByRegionLargestToSmallest(ArrayList<City> cities, String region) {
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(region == null){
            System.out.println("No region found");
            return null;
        }
        ArrayList<Country> countries = getCountries();
        try
        {
            countries.removeIf(country -> !country.getRegion().equals(region));
            ArrayList<City> sortedCities = new ArrayList<>();
            for (Country country : countries)
            {
                for (City city : cities)
                {
                    if (Long.toString(city.getId()).equals(country.getCapital()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            return sortCapitalCitiesPopulationLargestToSmallest(sortedCities);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that region found");
        }
        return null;
    }

    //print out the top N populated capital cities from a specific region
    public ArrayList<City> printCapitalCitiesPopulationByRegionLargestToSmallestWithN(ArrayList<City> cities, String region, int n){
        cities = printCapitalCitiesPopulationByRegionLargestToSmallest(cities, region);
        if(cities == null){
            System.out.println("No cities found");
            return null;
        }
        if(n <= 0){
            System.out.println("No cities found");
            return null;
        }
        if(region == null){
            System.out.println("No region found");
            return null;
        }
        ArrayList<City> sortedCities = new ArrayList<>();
        int i = 0;
        while (n != 0 && cities.size() != i)
        {
            sortedCities.add(cities.get(i));
            i++;n--;
        }
        return sortedCities;
    }

    //print out the population of a continent along with the population of people who do / don't live in cities
    public String printPopulationsContinent(String continent)
    {
        if (continent == null)
        {
            System.out.println("No continent found");
            return null;
        }
        try
        {
            ArrayList<Country> countriesContinent = new ArrayList<>();
            for (Country country : getCountries())
            {
                if (country.getContinent().equals(continent))
                {
                    countriesContinent.add(country);
                }
            }
            ArrayList<City> sortedCities = new ArrayList<>();
            for (City city : getCities())
            {
                for (Country country : countriesContinent)
                {
                    if (city.getCountryCode().equals(country.getCode()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            long populationTotal = 0;
            for (Country country : countriesContinent)
            {
                populationTotal += country.getPopulation();
            }
            long populationCityTotal = 0;
            for (City city : sortedCities)
            {
                populationCityTotal += city.getPopulation();
            }
            return "Population statistics of "+continent+"\nTotal = "+populationTotal+"\nPopulation in cities = "+populationCityTotal+"\nPopulation not in cities = "+(populationTotal-populationCityTotal);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that continent found");
        }
        return null;
    }

    //print out the population of a region along with the population of people who do / don't live in cities
    public String printPopulationsRegion(String region)
    {
        if (region == null)
        {
            System.out.println("No region found");
            return null;
        }
        try
        {
            ArrayList<Country> regionsContinent = new ArrayList<>();
            App app = new App();
            for (Country country : getCountries())
            {
                if (country.getRegion().equals(region))
                {
                    regionsContinent.add(country);
                }
            }
            ArrayList<City> sortedCities = new ArrayList<>();
            for (City city : getCities()) {
                for (Country country : regionsContinent) {
                    if (city.getCountryCode().equals(country.getCode())) {
                        sortedCities.add(city);
                    }
                }
            }
            long populationTotal = 0;
            for (Country country : regionsContinent)
            {
                populationTotal += country.getPopulation();
            }
            long populationCityTotal = 0;
            for (City city : sortedCities)
            {
                populationCityTotal += city.getPopulation();
            }
            return "Population statistics of "+region+"\nTotal = "+populationTotal+"\nPopulation in cities = "+populationCityTotal+"\nPopulation not in cities = "+(populationTotal-populationCityTotal);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that region found");
        }
        return null;
    }

    //print out the population of a country along with the population of people who do / don't live in cities
    public String printPopulationsCountry(String country)
    {
        if (country == null)
        {
            System.out.println("No Country found");
            return null;
        }
        try
        {
            ArrayList<Country> countriesCountry = new ArrayList<>();
            App app = new App();
            for (Country country2 : getCountries())
            {
                if (country2.getName().equals(country))
                {
                    countriesCountry.add(country2);
                }
            }
            ArrayList<City> sortedCities = new ArrayList<>();
            for (City city : getCities())
            {
                for (Country country3 : countriesCountry)
                {
                    if (city.getCountryCode().equals(country3.getCode()))
                    {
                        sortedCities.add(city);
                    }
                }
            }
            long populationTotal = 0;
            for (Country country4 : countriesCountry)
            {
                populationTotal += country4.getPopulation();
            }
            long populationCityTotal = 0;
            for (City city : sortedCities)
            {
                populationCityTotal += city.getPopulation();
            }
            return "Population statistics of "+country+"\nTotal = "+populationTotal+"\nPopulation in cities = "+populationCityTotal+"\nPopulation not in cities = "+(populationTotal-populationCityTotal);
        }
        catch (Exception e)
        {
            System.out.println("No cities with that country found");
        }
        return null;
    }
}