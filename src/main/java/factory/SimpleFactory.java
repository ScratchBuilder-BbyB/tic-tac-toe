package factory;

public interface SimpleFactory <instance, descriptor>{
  instance getInstance(descriptor descriptor);
}
