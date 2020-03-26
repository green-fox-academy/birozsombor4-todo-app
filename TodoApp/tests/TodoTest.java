import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import todoapp.Todo;

public class TodoTest {
  Todo todo;

  @Before
  public void before() {
    todo = new Todo("Bake some cookie", false);
  }

  @Test
  public void getDescription_WithDefault_ReturnSame() {
    assertEquals("Bake some cookie", todo.getDescription());
  }

  @Test
  public void setDescription_WithNew_ReturnNew() {
    todo.setDescription("Go out");
    assertEquals("Go out", todo.getDescription());
  }

  @Test
  public void isItCompleted_WithDefault_ReturnSame() {
    assertFalse(todo.isItCompleted());
  }

  @Test
  public void setItCompleted_WithNew_ReturnNew() {
    todo.setItCompleted(true);
    assertTrue(todo.isItCompleted());
  }
}