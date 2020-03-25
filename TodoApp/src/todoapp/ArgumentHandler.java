
package todoapp;

public class ArgumentHandler {
  private String[] arguments;
  FileHandler fileHandler = new FileHandler();
  Todo todo = new Todo();
  Print print = new Print();

  public ArgumentHandler(String[] args) {
    this.arguments = args;
  }

  public void run() {
    fileHandler.intitAllTodosFromFile();
    interpretArg();
  }

  private void interpretArg() {
    if (this.arguments.length == 0) {
      Print.printUsage();
    } else {
      switch (arguments[0]) {
        case "-l":
          list();
          break;
        case "-a":
          add();
          break;
        case "-r":
          remove();
          break;
        case "-c":
          check();
          break;
        default:
          System.out.println("Unsupported argument.");
          break;
      }
    }
  }

  private void list() {
    if (this.arguments.length == 1) {
      print.listTasks(fileHandler.getTodos());
    } else {
      System.out.println("No other arguments needed for listing.");
    }
  }

  private void add() {
    if (this.arguments.length == 1) {
      System.out.println("Unable to add: no task provided");
    } else {
      fileHandler.addTodo(new Todo(arguments[1], false));
    }
  }

  private void remove() {
    if (this.arguments.length == 1) {
      System.out.println("Unable to remove: no index provided");
    } else {
      try {
        fileHandler.removeTodo(Integer.valueOf(arguments[1]));
      } catch (NumberFormatException e) {
        System.out.println("Unable to remove: index is not a number");
      }
    }
  }

  private void check() {
    if (this.arguments.length == 1) {
      System.out.println("Unable to check: no index provided");
    } else {
      try {
        print.checkOneTask(Integer.valueOf(arguments[1]));
      } catch (NumberFormatException e) {
        System.out.println("Unable to check: index is not a number");
      }
    }
  }
}
