package se.Lexicon.Impl;

import se.Lexicon.Dao.PersonDao;
import se.Lexicon.Model.Person;
import se.Lexicon.db.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private Connection connection;

    public PersonDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private Person extract(ResultSet resultSet) throws SQLException {
        int personId = resultSet.getInt("person_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        return new Person(personId, firstName, lastName);
    }

    @Override
    public Person create(Person person) {
        String query = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, person.getFirst_name());
            statement.setString(2, person.getLast_name());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    person.setPerson_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating person failed, no ID obtained.");
                }
            }
            System.out.println("Created person: " + person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person findById(int person_id) {
        String query = "SELECT * FROM person WHERE person_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, person_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extract(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        String query = "SELECT * FROM person";
        List<Person> persons = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = extract(resultSet);
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Collection<Person> findByFirst_name(String first_name) {
        String query = "SELECT * FROM person WHERE first_name = ?";
        List<Person> persons = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, first_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = extract(resultSet);
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Collection<Person> findByLast_name(String last_name) {
        String query = "SELECT * FROM person WHERE last_name = ?";
        List<Person> persons = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, last_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = extract(resultSet);
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person update(Person person) {
        String query = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, person.getFirst_name());
            statement.setString(2, person.getLast_name());
            statement.setInt(3, person.getPerson_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int person_id) {
        String query = "DELETE FROM person WHERE person_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, person_id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
