package se.Lexicon.data;

import se.Lexicon.model.Person;
import se.Lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;


public interface TodoItemDao {

        TodoItem create(TodoItem todo);

        TodoItem findById(int id);

        Collection<TodoItem> findAll();

        Collection<TodoItem> findByAssignee(Person person);

        Collection<TodoItem> findByDone(boolean done);

        Collection<TodoItem> findByAssignedTodoItem(LocalDate deadLine);

        Collection<TodoItem> findByUnAssignedTodoItem(LocalDate deadLine);

        Collection<TodoItem> findByUnassignedTodoItems();

        Collection<TodoItem> findByAssignee(int personId);

        Collection<TodoItem> findByDone(int done);

        Collection<TodoItem> findByDeadLine(int deadLine);


    Collection<TodoItem> findByAssigneeTodoItem ();

    Collection<TodoItem> findByUnAssigneeTodoItem ();

    TodoItem update(TodoItem todo);

        boolean deleteById(int id);
    }


