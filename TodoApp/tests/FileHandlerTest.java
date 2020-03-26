import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import todoapp.FileHandler;
import todoapp.Todo;

public class FileHandlerTest {
  FileHandler fileHandler;

  @BeforeClass
  public static void beforeClass() {
    try {
      Files.createFile(Paths.get("files/test.txt"));
    } catch (IOException e) {
      System.out.println("Something wrong with creating.");
    }
  }

  @AfterClass
  public static void afterClass() {
    try {
      Files.delete(Paths.get("files/test.txt"));
      Files.delete(Paths.get("files/create.txt"));
    } catch (IOException e) {
      System.out.println("Something wrong with deleting.");
    }
  }

  @Before
  public void before() {
    fileHandler = new FileHandler();
    fileHandler.setFileLocation(Paths.get("files/test.txt"));
    fileHandler.intitAllTodosFromFile();
  }

  @Test
  public void convertListOfStringsToListOfTodo_WithValidInput_ReturnsTheSameTodos() {
    List<String> lines = Arrays.asList("X;Go out", "O;Wake up");
    List<Todo> todos = Arrays.asList(new Todo("Go out", true), new Todo("Wake up", false));

    assertEquals(todos.get(0).getDescription(),
        fileHandler.convertListOfStringsToListOfTodo(lines).get(0).getDescription());
  }

  @Test
  public void convertListOfStringsToListOfTodo_WithInalidInput_ReturnsFalseTodos() {
    List<String> lines = Arrays.asList("X;Goasd out", "O;Wake up");
    List<Todo> todos = Arrays.asList(new Todo("Go out", true), new Todo("Wake up", false));

    assertNotEquals(todos.get(0).getDescription(),
        fileHandler.convertListOfStringsToListOfTodo(lines).get(0).getDescription());
  }

  @Test
  public void convertAStringsToTodo_WithValidInput_ReturnsSameTodo() {
    String line = "X;Go out";
    Todo todo = new Todo("Go out", true);

    assertEquals(todo.getDescription(),
        fileHandler.convertAStringToATodo(line).getDescription());
  }

  @Test
  public void convertAStringsToTodo_WithInalidInput_ReturnsFalseTodo() {
    String line = "X;Go out";
    Todo todo = new Todo("Goasd out", true);

    assertNotEquals(todo.getDescription(),
        fileHandler.convertAStringToATodo(line).getDescription());
  }

  @Test
  public void addTodo() {
    fileHandler.intitAllTodosFromFile();
    Todo test = new Todo("Test", false);
    fileHandler.addTodo(test);
    assertEquals(test.getDescription(),
        fileHandler.getTodos().get(fileHandler.getTodos().size() - 1).getDescription());

  }

  @Test
  public void removeTodo_WithAddingNewOne_ReturnsDoesntContainAfterRemoving() {
    fileHandler.intitAllTodosFromFile();
    Todo test = new Todo("TestRemove", false);
    fileHandler.addTodo(test);
    fileHandler.removeTodo(fileHandler.getTodos().size());

    boolean result = fileHandler.getTodos().contains(test);

    assertFalse(result);
  }

  @Test
  public void convertListOfTodosToListOfString_WithValidInput_ReturnsTheSameStrings() {
    List<Todo> todos = Arrays.asList(new Todo("Go out", true), new Todo("Wake up", false));
    List<String> lines = Arrays.asList("X;Go out", "O;Wake up");

    assertEquals(lines.get(0),
        fileHandler.convertListOfTodosToListOfString(todos).get(0));
  }

  @Test
  public void convertListOfTodosToListOfString_WithInalidInput_ReturnsFalseTodos() {
    List<Todo> todos = Arrays.asList(new Todo("Goasd out", true), new Todo("Wake up", false));
    List<String> lines = Arrays.asList("X;Go out", "O;Wake up");

    assertNotEquals(lines.get(0),
        fileHandler.convertListOfTodosToListOfString(todos).get(0));
  }

  @Test
  public void convertATodoToAString_WithValidInput_ReturnsSameTodo() {
    Todo todo = new Todo("Go out", true);
    String line = "X;Go out";

    assertEquals(line,
        fileHandler.convertATodoToAString(todo));
  }

  @Test
  public void convertATodoToAString_WithInalidInput_ReturnsFalseTodo() {
    Todo todo = new Todo("Goasd out", true);
    String line = "X;Go out";

    assertNotEquals(line,
        fileHandler.convertATodoToAString(todo));
  }

  @Test
  public void completeTodo_WithNewCompletedTodo_ReturnTrue() {
    fileHandler.intitAllTodosFromFile();
    Todo todo = new Todo("Go out", false);
    fileHandler.addTodo(todo);
    fileHandler.completeTodo(fileHandler.getTodos().size());
    boolean result = fileHandler.getTodos().get(fileHandler.getTodos().size() - 1).isItCompleted();
    assertTrue(result);
  }

  @Test
  public void completeAllTodo_WithIterateThroughAll_ReturnTrue() {
    fileHandler.intitAllTodosFromFile();
    fileHandler.completeAllTodo();
    boolean result = true;
    for (Todo td : fileHandler.getTodos()) {
      if (td.isItCompleted() == false) {
        result = false;
      }
    }
    assertTrue(result);
  }

  @Test
  public void uncompleteTodo_WithNewUncompletedTodo_ReturnFalse() {
    fileHandler.intitAllTodosFromFile();
    Todo todo = new Todo("Come back", true);
    fileHandler.addTodo(todo);
    fileHandler.uncompleteTodo(fileHandler.getTodos().size());
    boolean result = fileHandler.getTodos().get(fileHandler.getTodos().size() - 1).isItCompleted();
    assertFalse(result);
  }

  @Test
  public void uncompleteAllTodo_WithIterateThroughAll_ReturnFalse() {
    fileHandler.intitAllTodosFromFile();
    fileHandler.uncompleteAllTodo();
    boolean result = false;
    for (Todo td : fileHandler.getTodos()) {
      if (td.isItCompleted() == true) {
        result = false;
      }
    }
    assertFalse(result);
  }

  @Test
  public void changeFilePath_withExistingUser_SelectExistingFile() {
    String beforeChanging = fileHandler.getFileLocation().toString();
    fileHandler.changeFilePath("test");
    String afterChanging = fileHandler.getFileLocation().toString();
    assertEquals(beforeChanging, afterChanging);
  }

  @Test
  public void changeFilePath_withNotExistingUser_CreateNewFile() {
    boolean beforeCreatingExists = Files.exists(Paths.get("files/create.txt"));
    fileHandler.changeFilePath("create");
    boolean afterCreatingExists = Files.exists(Paths.get("files/create.txt"));
    assertNotEquals(beforeCreatingExists, afterCreatingExists);
  }

  @Test
  public void checkTheFileNamesForUser_withExistingFile_ReturnTrue() {
    boolean result = fileHandler.checkTheFileNamesForUsers("test");
    assertTrue(result);
  }

  @Test
  public void checkTheFileNamesForUser_withNotExistingFile_ReturnFalse() {
    boolean result = fileHandler.checkTheFileNamesForUsers("testasd");
    assertFalse(result);
  }
}