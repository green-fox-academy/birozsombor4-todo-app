import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import todoapp.FileHandler;
import todoapp.Todo;

public class FileHandlerTest {
  FileHandler fileHandler;

  @Before
  public void before() {
    fileHandler = new FileHandler();
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
}