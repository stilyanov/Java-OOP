package InterfacesAndAbstraction.P04_SayHelloExtended;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    }

}
