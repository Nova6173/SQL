package se.Lexicon;

import se.Lexicon.dao.CityDao;
import se.Lexicon.impl.CityDaoJDBCImpl;
import se.Lexicon.model.City;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create an instance of CityDao
        CityDao cityDao = new CityDaoJDBCImpl();

        // Examples of how to use CityDao to interact with the database

        // Fetch all cities from the database
        List<City> allCities = cityDao.findAll();
        System.out.println("All Cities:");
        for (City city : allCities) {
            System.out.println(city);
        }
        System.out.println();

        // Fetch a city by a specific ID from the database
        City cityById = cityDao.findById(1);
        if (cityById != null) {
            System.out.println("City by ID:");
            System.out.println(cityById);
        } else {
            System.out.println("City with specified ID not found.");
        }
        System.out.println();

        // Add a new city to the database
        City newCity = new City("NewCity", "NC", "NewDistrict", 100000);
        City addedCity = cityDao.add(newCity);
        System.out.println("Added City:");
        System.out.println(addedCity);
        System.out.println();

        // Update an existing city in the database
        City cityToUpdate = cityDao.findById(addedCity.getId());
        if (cityToUpdate != null) {
            cityToUpdate.setName("UpdatedCity");
            City updatedCity = cityDao.update(cityToUpdate);
            System.out.println("Updated City:");
            System.out.println(updatedCity);
        } else {
            System.out.println("City to update not found.");
        }
        System.out.println();

        // Delete a city from the database
        int cityIdToDelete = addedCity.getId();
        City cityToDelete = cityDao.findById(cityIdToDelete);
        if (cityToDelete != null) {
            int rowsDeleted = cityDao.delete(cityToDelete);
            if (rowsDeleted > 0) {
                System.out.println("City with ID " + cityIdToDelete + " deleted successfully.");
            } else {
                System.out.println("Failed to delete city with ID " + cityIdToDelete + ".");
            }
        } else {
            System.out.println("City to delete not found.");
        }
    }
}
