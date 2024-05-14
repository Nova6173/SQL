package se.Lexicon.Model;

import java.time.LocalDate;

public class TodoItem {

    private int todoid;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean isDone;
    private int assigneeid;

    public TodoItem(int todoid, String title, String description, LocalDate deadline, boolean isDone, int assigneeid) {
        this.todoid = todoid;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isDone = isDone;
        this.assigneeid = assigneeid;
    }

    public TodoItem (String walkTheDog, String walkTheDog1, LocalDate now, boolean b, int personId) {

        this.title = walkTheDog;
        this.description = walkTheDog1;
        this.deadline = now;
        this.isDone = b;
        this.assigneeid = personId;
    }

    // Getters
    public int getTodoid() {
        return todoid;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public int getAssigneeid() {
        return assigneeid;
    }

    // Setters
    public void setTodoid(int todoid) {
        this.todoid = todoid;
    }

    public void setAssigneeid(int assigneeid) {
        this.assigneeid = assigneeid;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    // toString
    @Override
    public String toString() {
        return "TodoItem{" +
                "todoid=" + todoid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", isDone=" + isDone +
                ", assigneeid=" + assigneeid +
                '}';
    }

    public void setLocalDate (String localDate) {
        this.deadline = LocalDate.parse(localDate);

    }

    public String getLocalDate () {
        return deadline.toString();
    }
}