package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
  private Path fileLocation = Paths.get("files/tasks.txt");
  private static List<Todo> todos = new ArrayList<>();

  public static List<Todo> getTodos() {
    return todos;
  }


  public void intitAllTodosFromFile() {
    todos = readAllTodo();
  }

  private List<Todo> readAllTodo() {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(fileLocation);
    } catch (IOException e) {
      System.out.println("Something goes wrong with reading of the file.");
    }
    return convertListOfStringsToListOfTodo(lines);
  }

  private List<Todo> convertListOfStringsToListOfTodo(List<String> lines) {
    List<Todo> todos = new ArrayList<>();
    for (String line : lines) {
      todos.add(convertAStringToATodo(line));
    }
    return todos;
  }

  private Todo convertAStringToATodo(String line) {
    Todo todoHolder = new Todo();
    String[] boolAndDesc = line.split(";");
    if (boolAndDesc[0].equals("X")) {
      todoHolder.setItCompleted(true);
    } else {
      todoHolder.setItCompleted(false);
    }
    todoHolder.setDescription(boolAndDesc[1]);
    return todoHolder;
  }

  public void addTodo(Todo newTodo) {
    todos.add(newTodo);
    writeTodosToTheFile();
  }

  private void writeTodosToTheFile() {
    try {
      Files.write(fileLocation, convertListOfTodosToListOfString(this.todos));
    } catch (IOException e) {
      System.out.println("Something went wrong with writing.");
    }
  }

  private List<String> convertListOfTodosToListOfString(List<Todo> todos) {
    List<String> lines = new ArrayList<>();
    for (Todo todo : todos) {
      lines.add(convertATodoToAString(todo));
    }
    return lines;
  }

  private String convertATodoToAString(Todo todo) {
    String line = (todo.isItCompleted() ? "X" : "O") + ";" + todo.getDescription();
    return line;
  }

  public void removeTodo(int whichTodo){
    if (this.todos.size() < whichTodo){
      System.out.println("Unable to remove: index out of bound");
    } else {
      this.todos.remove(whichTodo-1);
      writeTodosToTheFile();
    }
  }


}
