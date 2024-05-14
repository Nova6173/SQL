package se.Lexicon.Dao;

import se.Lexicon.Model.Person;

import java.util.Collection;

public interface PersonDao {
    Person create(Person person);
    Person findById(int person_id);
    Collection<Person> findAll();
    Collection<Person> findByFirst_name(String first_name);
    Collection<Person> findByLast_name(String last_name);
    Person update(Person person);
    boolean delete(int person_id);
}
