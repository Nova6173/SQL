package se.Lexicon.Dao;

import se.Lexicon.Model.Person;
import se.Lexicon.Model.TodoItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface TodoItemDao {
    TodoItem extract (ResultSet resultSet) throws SQLException;
    TodoItem create (TodoItem todoItem);
    Collection<TodoItem> getAll();


    TodoItem findById(int id);
    List<TodoItem> findByPersonId(int id);
    void save(TodoItem todoItem);
    boolean deleteById(int id);

    Collection<TodoItem> findAll ();

    Collection<TodoItem> findByDoneStatus (boolean b);

    Collection<TodoItem> findByAssigneeid (int personId);

    TodoItem update (TodoItem createdTodoItem);

    Collection<TodoItem> findByAssignee(Person assignee);

    Collection<TodoItem> findByUnassignedTodoItems ();

    boolean delete (int todoid);

}