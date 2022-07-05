package service.interfaces;

public interface Executable<T>{
  default void execute(T t, String command){

  }
  default void execute(T t){

  }
  default String[] splitArgs(String command){
    return command.split(" ");
  }
}
