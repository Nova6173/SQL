package se.Lexicon.data.impl;
import se.Lexicon.data.TodoItemDao;
import se.Lexicon.model.Person;
import se.Lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public abstract class TodoItemImpl implements TodoItemDao {

    @Override
    public TodoItem create(TodoItem todo) {
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return null;
    }

    @Override
    public Collection<TodoItem> findByDone(boolean done) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByAssignedTodoItem (LocalDate deadLine) {
        return List.of ();
    }

    @Override
    public Collection<TodoItem> findByDeadLine(int deadLine) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByAssignee(int personId) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByDone (int done) {
        return List.of ();
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByAssigneeTodoItem () {
        return null;
    }

    @Override
    public Collection<TodoItem> findByUnAssigneeTodoItem () {
        return null;
    }

    @Override
    public TodoItem update(TodoItem todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }


}
