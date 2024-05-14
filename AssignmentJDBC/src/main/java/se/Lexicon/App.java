package se.Lexicon;

import se.Lexicon.data.PeopleDao;
import se.Lexicon.data.impl.PeopleDaoImpl;
import se.Lexicon.model.Person;

import java.util.Collection;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        PeopleDaoImpl peopleDao = new PeopleDaoImpl () {
            @Override
            public Collection<Person> findByLastName (String lastName) {
                return List.of ();
            }

            @Override
            public Collection<Person> findByFirstName (String firstName) {
                return List.of ();
            }

            @Override
            public boolean deleteAll () {
                return false;
            }
        };

        Person person1 = new Person();

        person1.setFirstName("John");
        person1.setLastName("Doe");

        peopleDao.create(person1);

        System.out.println ("Person: " + person1.getFirstName () + " " + person1.getLastName () + " created");

        Person person2 = new Person();

        person2.setFirstName("Jane");
        person2.setLastName("Doe");

        peopleDao.create(person2);

        System.out.println ("Person: " + person2.getFirstName () + " " + person2.getLastName () + " created");






    }
}
