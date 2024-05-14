package se.Lexicon.Impl;

import se.Lexicon.Dao.TodoItemDao;
import se.Lexicon.db.MySQLConnection;
import se.Lexicon.Model.Person;
import se.Lexicon.Model.TodoItem;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDaoImpl implements TodoItemDao {

    private Connection connection;

    public TodoItemDaoImpl() {
        this.connection = connection;
    }

    @Override
    public TodoItem extract(ResultSet resultSet) throws SQLException {
        TodoItem todoItem = new TodoItem(
                resultSet.getInt("todoid"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                LocalDate.parse(resultSet.getString("LocalDate")),
                resultSet.getBoolean("isDone"),
                resultSet.getInt("assigneeid")
        );
        return todoItem;
    }

    @Override
    public TodoItem create(TodoItem todoItem) {
        String query = "INSERT INTO todoitem (title, description, LocalDate, isDone, assigneeid) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, todoItem.getTitle());
            statement.setString(2, todoItem.getDescription());
            statement.setString(3, todoItem.getLocalDate().toString());
            statement.setBoolean(4, todoItem.getIsDone());
            statement.setInt(5, todoItem.getAssigneeid());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                todoItem.setTodoid(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> getAll() {
        List<TodoItem> todoItems = new ArrayList<>();
        String query = "SELECT * FROM todoitem";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(extract(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public TodoItem findById (int id) {
        String query = "SELECT * FROM todoitem WHERE todoid = ?";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            statement.setInt (1, id);
            ResultSet resultSet = statement.executeQuery ();
            if (resultSet.next ()) {
                return extract (resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<TodoItem> findByPersonId (int id) {
        List<TodoItem> todoItems = new ArrayList<> ();
        String query = "SELECT * FROM todoitem WHERE assigneeid = ?";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            statement.setInt (1, id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()) {
                todoItems.add (extract (resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findAll () {
        return getAll ();
    }

    @Override
    public Collection<TodoItem> findByDoneStatus (boolean doneStatus) {
        List<TodoItem> todoItems = new ArrayList<> ();
        String query = "SELECT * FROM todoitem WHERE isDone = ?";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            statement.setBoolean (1, doneStatus);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()) {
                todoItems.add (extract (resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByAssigneeid (int assigneeid) {
        List<TodoItem> todoItems = new ArrayList<> ();
        String query = "SELECT * FROM todoitem WHERE assigneeid = ?";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            statement.setInt (1, assigneeid);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()) {
                todoItems.add (extract (resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return todoItems;
    }

    @Override
    public TodoItem update (TodoItem todoItem) {
        String query = "UPDATE todoitem SET title = ?, description = ?, deadline = ?, isDone = ?, assigneeid = ? WHERE todoid = ?";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            statement.setString (1, todoItem.getTitle ());
            statement.setString (2, todoItem.getDescription ());
            statement.setDate (3, Date.valueOf (todoItem.getDeadline ()));
            statement.setBoolean (4, todoItem.getIsDone ());
            statement.setInt (5, todoItem.getAssigneeid ());
            statement.setInt (6, todoItem.getTodoid ());
            statement.executeUpdate ();
            System.out.println ("TodoItem updated: " + todoItem);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findByAssignee (Person assignee) {
        List<TodoItem> todoItems = new ArrayList<> ();
        String query = "SELECT * FROM todoitem WHERE assigneeid = ?";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            statement.setInt (1, assignee.getPerson_id ());
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()) {
                todoItems.add (extract (resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoItems () {
        List<TodoItem> todoItems = new ArrayList<> ();
        String query = "SELECT * FROM todoitem WHERE assigneeid IS NULL";
        try (PreparedStatement statement = connection.prepareStatement (query)) {
            ResultSet resultSet = statement.executeQuery ();

            while (resultSet.next ()) {
                todoItems.add (extract (resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return todoItems;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM todoitem WHERE todoid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

    @Override
    public void save(TodoItem todoItem) {

        String query = "INSERT INTO todoitem (title, description, deadline, isDone, assigneeid) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, todoItem.getTitle());
            statement.setString(2, todoItem.getDescription());
            statement.setDate(3, Date.valueOf(todoItem.getDeadline()));
            statement.setBoolean(4, todoItem.getIsDone());
            statement.setInt(5, todoItem.getAssigneeid());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys(); // Get the generated result
            if (resultSet.next()) {
                todoItem.setTodoid(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }

    @Override
    public boolean deleteById (int id) {
        String query = "DELETE FROM todoitem WHERE todoid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

@Override
public boolean delete(int id) {
    String query = "DELETE FROM todoitem WHERE todoid = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}






