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

  public void setDescription(String description) {
    this.description = description;
  }

  public void setItCompleted(boolean itCompleted) {
    isItCompleted = itCompleted;
  }

  public String getDescription() {
    return description;
  }

  public boolean isItCompleted() {
    return isItCompleted;
  }
}
