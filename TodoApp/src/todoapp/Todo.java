package todoapp;

public class Todo {
  private String description;
  private boolean isItCompleted;

  public Todo() {
  }

  public Todo(String description, boolean isItCompleted) {
    this.description = description;
    this.isItCompleted = isItCompleted;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isItCompleted() {
    return isItCompleted;
  }

  public void setItCompleted(boolean itCompleted) {
    isItCompleted = itCompleted;
  }
}
