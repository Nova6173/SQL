

package se.Lexicon.dao;

import se.Lexicon.model.City;

import java.util.List;

// CityDao interface provides methods for accessing City data
public interface CityDao {
    City findById(int id); // Find a city by its ID
    List<City> findByCode(String code); // Find cities by country code
    List<City> findByName(String name); // Find cities by name
    List<City> findAll(); // Find all cities
    City add(City city); // Add a new city
    City update(City city); // Update an existing city
    int delete(City city); // Delete a city
}
