package todoapp;

import java.util.List;

public class Print {
  public static void printUsage() {
    System.out.println("Command Line Todo Application");
    System.out.println("=============================\n");
    System.out.println("Command line arguments: ");
    System.out.println("\t-l\tList all the tasks");
    System.out.println("\t-la\tList all undone tasks");
    System.out.println("\t-a\tAdds a new task");
    System.out.println("\t-r\tRemoves a task");
    System.out.println("\t-c\tChecks a task");
    System.out.println("\t-x\tCompletes a task");
    System.out.println("\t-xa\tCompletes all tasks");
    System.out.println("\t-o\tUncompletes a task");
    System.out.println("\t-oa\tUncompletes all tasks");
    System.out.println("\t-u\tPrint actual user/create a new one");
    System.out.println("=============================\n");
    System.out.println("How to use multiple user?");
    System.out.println("\t- You can use your default user without use of '-u' argument.");
    System.out.println("\t- If you want to use your own user just type: '-u $YOURUSERNAME' and it" +
        " will be created.");
    System.out.println("\t- After when you want to you use your user and not the default one just" +
        " " + "type for example: ");
    System.out.println("\t\t'-u John -a \"Work harder\"'");
  }

  public void listTasks(List<Todo> listOfTodos, boolean listAll) {
    if (listOfTodos.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      int counter = 1;
      if (listAll == true) {
        for (Todo td : listOfTodos) {
          printOutOneTask(td, counter);
          counter++;
        }
      } else {
        for (Todo td : listOfTodos) {
          if (!td.isItCompleted()) {
            printOutOneTask(td, counter);
            counter++;
          }
        }
      }
    }
  }

  public void printOutOneTask(Todo todo, int counter) {
    System.out.println(counter + " - " + (todo.isItCompleted() ? "[X]" : "[ ]") + " " + todo.getDescription());
  }

  public void checkOneTask(int wichTodo) {
    if (FileHandler.getTodos().size() < wichTodo) {
      System.out.println("Unable to check: index out of bound");
    } else {
      System.out.println(wichTodo + " - " + (FileHandler.getTodos().get(wichTodo - 1).isItCompleted() ?
          "[X]" : "[ ]") + " " + FileHandler.getTodos().get(wichTodo - 1).getDescription());
    }
  }

  public void printActualUser(FileHandler fileHandler) {
    String userName = fileHandler.getFileLocation().toString();
    userName = userName.substring(userName.indexOf("\\") + 1);
    userName = userName.substring(0, userName.indexOf("."));
    System.out.println("You are on this user: " + userName);
  }
}
