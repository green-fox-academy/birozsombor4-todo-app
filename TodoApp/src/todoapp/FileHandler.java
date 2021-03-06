package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
  private Path fileLocation;
  private static List<Todo> todos = new ArrayList<>();

  public static List<Todo> getTodos() {
    return todos;
  }

  public Path getFileLocation() {
    return fileLocation;
  }

  public void setFileLocation(Path fileLocation) {
    this.fileLocation = fileLocation;
  }


  public void intitAllTodosFromFile() {
    todos = readAllTodo();
  }

  private List<Todo> readAllTodo() {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(this.fileLocation);
    } catch (IOException e) {
      System.out.println("Something goes wrong with reading of the file.");
    }
    return convertListOfStringsToListOfTodo(lines);
  }

  public List<Todo> convertListOfStringsToListOfTodo(List<String> lines) {
    List<Todo> todos = new ArrayList<>();
    for (String line : lines) {
      todos.add(convertAStringToATodo(line));
    }
    return todos;
  }

  public Todo convertAStringToATodo(String line) {
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
      Files.write(this.fileLocation, convertListOfTodosToListOfString(this.todos));
    } catch (IOException e) {
      System.out.println("Something went wrong with writing.");
    }
  }

  public List<String> convertListOfTodosToListOfString(List<Todo> todos) {
    List<String> lines = new ArrayList<>();
    for (Todo todo : todos) {
      lines.add(convertATodoToAString(todo));
    }
    return lines;
  }

  public String convertATodoToAString(Todo todo) {
    String line = (todo.isItCompleted() ? "X" : "O") + ";" + todo.getDescription();
    return line;
  }

  public void removeTodo(int whichTodo) {
    if (this.todos.size() < whichTodo) {
      System.out.println("Unable to remove: index out of bound");
    } else {
      this.todos.remove(whichTodo - 1);
      writeTodosToTheFile();
    }
  }

  public void completeTodo(int whichTodo) {
    if (this.todos.size() < whichTodo) {
      System.out.println("Unable to complete: index out of bound");
    } else {
      this.todos.get(whichTodo - 1).setItCompleted(true);
      writeTodosToTheFile();
    }
  }

  public void completeAllTodo() {
    for (Todo td : this.todos) {
      td.setItCompleted(true);
    }
    writeTodosToTheFile();
  }

  public void uncompleteTodo(int whichTodo) {
    if (this.todos.size() < whichTodo) {
      System.out.println("Unable to uncomplete: index out of bound");
    } else {
      this.todos.get(whichTodo - 1).setItCompleted(false);
      writeTodosToTheFile();
    }
  }

  public void uncompleteAllTodo() {
    for (Todo td : this.todos) {
      td.setItCompleted(false);
    }
    writeTodosToTheFile();
  }

  public void changeFilePath(String userName) {
    if (checkTheFileNamesForUsers(userName)) {
      System.out.println("You have selected this [" + userName + "] user");
      this.fileLocation = Paths.get("files/" + userName + ".txt");
    } else {
      System.out.println("You created a new user!");
      this.fileLocation = Paths.get("files/" + userName + ".txt");
      try {
        Files.createFile(this.fileLocation);
      } catch (IOException e) {
        System.out.println("Something goes wrong with creating the file.");
      }
    }
  }

  public boolean checkTheFileNamesForUsers(String userName) {
    if (Files.exists(Paths.get("files/" + userName + ".txt"))) {
      return true;
    } else {
      return false;
    }
  }
}
