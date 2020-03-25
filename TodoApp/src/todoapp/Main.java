package todoapp;

public class Main {
  public static void main(String[] args) {
    ArgumentHandler argumentHandler = new ArgumentHandler(args);
    argumentHandler.run();

/*    FileHandler fileHandler = new FileHandler();
    Todo todo = new Todo();
    Print print = new Print();

    fileHandler.intitAllTodosFromFile();*/

    /*if (args.length == 0) {
      print.printUsage();
    }*/
/*
    if (args[0].equals("-l")) {
      //print.listTasks(fileHandler.getTodos());
    }*/

    /*if (args[0].equals("-a")) {
      fileHandler.addTodo(new Todo("Do the project", false));
    }*/

    /*if (args[0].equals("-r")) {
    fileHandler.removeTodo(6);
    }*/

    /*if (args[0].equals("-c")) {
      print.checkOneTask(2);
    }*/




  }
}
