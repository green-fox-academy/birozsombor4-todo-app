package todoapp;

public class Main {
  public static void main(String[] args) {
    ArgumentHandler argumentHandler = new ArgumentHandler(args);
    argumentHandler.interpretArg();
  }
}
