package se.Lexicon.data;

import se.Lexicon.model.Person;

import java.util.Collection;
import java.util.List;

public interface PeopleDao {

    Person create(Person person);

    Collection<Person> findAll();

    Person findById(int id);

    Collection<Person> findByLastName (String lastName);

    Collection<Person> findByFirstName (String firstName);

    Collection<Person> findByName(String name);

    Person update(Person person);

    boolean deleteById(int id);

    boolean deleteAll ();
}