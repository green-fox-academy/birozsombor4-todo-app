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

  public void listTasks(List<Todo> listOfTodos) {
    if (listOfTodos.size() == 0){
      System.out.println("No todos for today! :)");
    }else {
      int counter = 1;
      for (Todo td : listOfTodos) {
        System.out.println(counter + " - " + (td.isItCompleted() ? "[X]" : "[ ]") + " " + td.getDescription());
        counter++;
      }
    }
  }




}
