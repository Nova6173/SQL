package se.Lexicon.model;

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
    }

    // Getters and setters
    // Getter methods
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

