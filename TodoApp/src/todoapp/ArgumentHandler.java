
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
          listUndoneTasks();
          break;
        case "-la":
          listAllTask();
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
        case "-x":
          complete();
          break;
        case "-xa":
          completeAll();
          break;
        case "-o":
          uncomplete();
          break;
        case "-oa":
          uncompletAll();
          break;
        default:
          System.out.println("Unsupported argument.");
          break;
      }
    }
  }

  private void uncompletAll() {
    if (this.arguments.length == 1) {
      fileHandler.uncompleteAllTodo();
    } else {
      System.out.println("No other arguments needed for uncomplete all tasks.");
    }
  }

  private void uncomplete() {
    if (this.arguments.length == 1) {
      System.out.println("Unable to uncomplete: no index provided");
    } else {
      try {
        fileHandler.uncompleteTodo(Integer.valueOf(arguments[1]));
      } catch (NumberFormatException e) {
        System.out.println("Unable to uncomplete: index is not a number");
      }
    }
  }

  private void completeAll() {
    if (this.arguments.length == 1) {
      fileHandler.completeAllTodo();
    } else {
      System.out.println("No other arguments needed for complete all tasks.");
    }

  }

  private void complete() {
    if (this.arguments.length == 1) {
      System.out.println("Unable to complete: no index provided");
    } else {
      try {
        fileHandler.completeTodo(Integer.valueOf(arguments[1]));
      } catch (NumberFormatException e) {
        System.out.println("Unable to complete: index is not a number");
      }
    }
  }

  private void listAllTask() {
    if (this.arguments.length == 1) {
      print.listTasks(fileHandler.getTodos(), true);
    } else {
      System.out.println("No other arguments needed for listing.");
    }
  }

  private void listUndoneTasks() {
    if (this.arguments.length == 1) {
      print.listTasks(fileHandler.getTodos(), false);
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
