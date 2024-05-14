package se.Lexicon;

import se.Lexicon.Impl.TodoItemDaoImpl;
import se.Lexicon.Dao.PersonDao;
import se.Lexicon.Dao.TodoItemDao;
import se.Lexicon.Model.Person;
import se.Lexicon.Model.TodoItem;
import se.Lexicon.db.MySQLConnection;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Create an instance of MySQLConnection
        Connection connection = MySQLConnection.getConnection();

        // Create an instance of PersonDaoImpl
        PersonDao personDao = new PersonDaoImpl(connection);


        // Create a new person
        Person newPerson = new Person("John", "Doe");

        // Add the new person to the database
        Person createdPerson = personDao.create(newPerson);
        System.out.println("Created person: " + createdPerson);

        // Find a person by ID
        Person foundPerson = personDao.findById(createdPerson.getPerson_id());
        System.out.println("Found person: " + foundPerson);

        // Find all people
        Collection<Person> allPeople = personDao.findAll();
        System.out.println("Found all people: " + allPeople);

        // Find people by first name
        Collection<Person> peopleByFirstName = personDao.findByFirst_name("John");
        System.out.println("Found people by first name: " + peopleByFirstName);

        // Find people by last name
        Collection<Person> peopleByLastName = personDao.findByLast_name("Doe");
        System.out.println("Found people by last name: " + peopleByLastName);

        // Update the person
        createdPerson.setFirst_name("Jane");
        createdPerson.setLast_name("Doe");
        Person updatedPerson = personDao.update(createdPerson);
        System.out.println("Person updated: " + updatedPerson);

        // Delete the person
        boolean deleted = personDao.delete(createdPerson.getPerson_id());
        System.out.println("Deleted person: " + deleted);

        // Create a new todoItem
        TodoItem newTodoItem = new TodoItem(
                1, "Walk the dog",
                "Walk the dog",
                LocalDate.now(),
                false,
                createdPerson.getPerson_id());

        // Create an instance of todoItemDao
        TodoItemDao todoItemDao = new TodoItemDaoImpl() {
            @Override
            public void save(TodoItem todoItem) {

            }

            @Override
            public boolean deleteById(int id) {
                return false;
            }

            @Override
            public Collection<TodoItem> findAll() {

                return List.of();
            }
        };

        // Add the new todoItem to the database
        TodoItem createdTodoItem = ((TodoItemDaoImpl) todoItemDao).create(newTodoItem);
        System.out.println("Created todoItem: " + createdTodoItem);

        // Find a todoItem by ID
        TodoItem findById = todoItemDao.findById(createdTodoItem.getTodoid());
        System.out.println("Found todoItem: " + findById);

        // Find all todoItems
        Collection<TodoItem> allTodoItems = todoItemDao.findAll();
        System.out.println("Found all todoItems: " + allTodoItems);

        // Find todoItems by done status
        Collection<TodoItem> todoItemsByDoneStatus = todoItemDao.findByDoneStatus(false);
        System.out.println("Found todoItems by done status: " + todoItemsByDoneStatus);

        // Find todoItems by assignee
        Collection<TodoItem> todoItemsByAssignee = todoItemDao.findByAssigneeid(createdPerson.getPerson_id());
        System.out.println("Found todoItems by assignee: " + todoItemsByAssignee);

        // Update the todoItem
        createdTodoItem.setAssigneeid(createdPerson.getPerson_id());
        createdTodoItem.setDone(true);
        TodoItem updatedTodoItem = todoItemDao.update(createdTodoItem);
        System.out.println("TodoItem updated: " + updatedTodoItem);

        // Delete the todoItem
        boolean deletedTodoItem = todoItemDao.delete(createdTodoItem.getTodoid());
        System.out.println("Deleted todoItem: " + deletedTodoItem);
    }
}