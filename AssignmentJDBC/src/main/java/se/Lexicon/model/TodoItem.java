package se.Lexicon.model;

import java.time.LocalDate;

public class TodoItem {

    private int id;
    private String title;
    private String description;
    private Person assignee;
    private LocalDate deadLine;
    private boolean done;

    public TodoItem(int id, String title, String description, Person assignee, LocalDate deadLine, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.deadLine = deadLine;
        this.done = done;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isOverdue() {
        return this.deadLine.isAfter (LocalDate.now ());
    }

    public void toggleDone() {
        done = !done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignee=" + assignee +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }
}
