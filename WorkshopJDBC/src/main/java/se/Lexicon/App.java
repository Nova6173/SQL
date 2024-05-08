package se.Lexicon;

import se.Lexicon.dao.CityDao;
import se.Lexicon.impl.CityDaoJDBCImpl;
import se.Lexicon.model.City;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create an instance of CityDao
        CityDao cityDao = new CityDaoJDBCImpl();

        // Retrieve a city with a specific id
        City cityById = cityDao.findById(1);
        System.out.println("City with id 1: " + cityById);

        // Retrieve all cities
        List<City> allCities = cityDao.findAll();
        System.out.println("All cities:");
        for (City city : allCities) {
            System.out.println(city);
        }

        // Add a new city
        City newCity = new City("NewCity", "NWC", "District", 100000);
        City addedCity = cityDao.add(newCity);
        System.out.println("Added city: " + addedCity);

        // Update an existing city
        City cityToUpdate = cityDao.findById(addedCity.getId());
        cityToUpdate.setName("UpdatedCity");
        City updatedCity = cityDao.update(cityToUpdate);
        System.out.println("Updated city: " + updatedCity);

        // Retrieve cities with a specific country code
        List<City> citiesByCode = cityDao.findByCode("SWE");
        System.out.println("Cities with country code 'SWE':");
        for (City city : citiesByCode) {
            System.out.println(city);
        }

        // Delete a city
        int rowsDeleted = cityDao.delete(addedCity);
        if (rowsDeleted > 0) {
            System.out.println("City deleted successfully.");
        } else {
            System.out.println("Failed to delete the city.");
        }
    }
}
