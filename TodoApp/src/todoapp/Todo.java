package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  private String description;
  private boolean isItCompleted;
  //private static List<Todo> todos = new ArrayList<>();

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

  /*public static List<Todo> getTodos() {
    return todos;
  }

  public void intitAllTodosFromFile(){
    todos = readAllTodo();
  }

  private List<Todo> readAllTodo(){
    List <String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get("files/tasks.txt"));
    } catch (IOException e) {
      System.out.println("Something goes wrong with reading of the file.");
      //e.printStackTrace();
    }
    return convertListOfStringsToListOfTodo(lines);
  }

  private List<Todo> convertListOfStringsToListOfTodo(List<String> lines){
    List<Todo> todos = new ArrayList<>();
    for (String line : lines){
      Todo todoHolder = new Todo();
      String[] boolAndDesc = line.split(";");
      if (boolAndDesc[0].equals("X")){
        todoHolder.isItCompleted = true;
      }else {
        todoHolder.isItCompleted = false;
      }
      todoHolder.description = boolAndDesc[1];
      todos.add(todoHolder);
    }
    return todos;
  }*/



}
