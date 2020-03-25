/*
package todoapp;

public class ArgumentHandler {
  private String[] arguments;

  public ArgumentHandler(String [] args){
    this.arguments = args;
  }

  private void centrum(){
    switch (arguments[0]){
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
        Print.printUsage();
        break;
    }
  }

  private void check() {
    if (this.arguments.length == 1){
      System.out.println("Unable to check: no index provided");
    } else{
      //CHECK The actual TODO
    }
  }

  private void remove() {

    if ((Integer.valueOf(arguments[1]) <= Todo.getTodos().size())){
        //REMOVE that TODO
    }else {
      System.out.println("There is no TODO with the given index!");
    }


  }

  private void list() {

  }

  private void add() {
    if (this.arguments.length == 1){
      System.out.println("Unable to add: no task provided");
    } else{
      //ADD new TODO to the LIST
    }
  }
}

*/
