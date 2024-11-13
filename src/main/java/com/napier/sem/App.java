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
                Integer id = rset.getInt("ID");
                String name = rset.getString("Name");
                String countryCode = rset.getString("CountryCode");
                String district = rset.getString("District");
                Integer population = rset.getInt("Population");
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
                Integer population = rset.getInt("population");
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

    public void printCityReport(ArrayList<City> cities){
        if(cities == null){
            System.out.println("No cities found");
            return;
        }
        for(City city : cities){
            System.out.println(city);
        }
    }

    public void printCountryReport(ArrayList<Country> countries){
        if(countries == null){
            System.out.println("No countries found");
            return;
        }
        for(Country country : countries){
            System.out.println(country);
        }
    }

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

    public ArrayList<City> printCitiesPopulationLargestToSmallest(ArrayList<City> cities){
        if(cities == null){
            System.out.println("No countries found");
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

    public ArrayList<City> printCitiesPopulationByContinentLargestToSmallest(ArrayList<City> cities, String continent){
        if (cities == null){
            System.out.println("No countries found");
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

    public ArrayList<City> printCitiesPopulationByRegionLargestToSmallest(ArrayList<City> cities, String region){
        if(cities == null){
            System.out.println("No countries found");
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
}