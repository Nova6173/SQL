package se.Lexicon.model;
import java.util.regex.Pattern;

// City class represents information about a city
public class City {
    private int id; // City ID
    private String name; // City name
    private String countryCode; // Country code
    private String district; // District where the city is located
    private int population; // Population of the city

    // Constructor for fetching data from the database
    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    // Constructor for inserting data into the database
    public City(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
        validateData();
    }
    // Method to validate indata
    public boolean validateData() {
        // validate that population is greater than 0
        if (population <= 0) {
            System.out.println ("Population must be greater than 0");
            return false;
        }
        // validate countrycode
        if (!Pattern.matches("[A-Z]{2}", countryCode)) {
            System.out.println("Country code must be 2 uppercase letters" + countryCode);

        }
        return false;
    }


    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // String representation of a City object
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}

