package todoapp;

import java.util.List;

public class Print {
  public static void printUsage() {
    System.out.println("Command Line Todo Application");
    System.out.println("=============================\n");
    System.out.println("Command line arguments: ");
    System.out.println("\t-l\tList all the tasks");
    System.out.println("\t-a\tAdds a new task");
    System.out.println("\t-r\tRemoves a task");
    System.out.println("\t-c\tCompletes a task");
  }

  public void listTasks(List<Todo> listOfTodos, boolean listAll) {
    if (listOfTodos.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      int counter = 1;
      if (listAll == true){
        for (Todo td : listOfTodos) {
          printOutOneTask(td,counter);
          counter++;
        }
      } else {
        for (Todo td : listOfTodos) {
          if (!td.isItCompleted()){
            printOutOneTask(td,counter);
            counter++;
          }
        }
      }
    }
  }

  private void printOutOneTask(Todo todo, int counter){
    System.out.println(counter + " - " + (todo.isItCompleted() ? "[X]" : "[ ]") + " " + todo.getDescription());
  }

  public void checkOneTask(int wichTodo) {
    if (FileHandler.getTodos().size() < wichTodo){
      System.out.println("Unable to check: index out of bound");
    } else {
      System.out.println(wichTodo + " - " + (FileHandler.getTodos().get(wichTodo-1).isItCompleted() ?
          "[X]" : "[ ]") + " " + FileHandler.getTodos().get(wichTodo-1).getDescription());
    }
  }


}
