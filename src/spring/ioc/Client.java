package spring.ioc;

public class Client {

    public static void main(String[] args) {
        Fruit fruit = Factory.getInstance("Apple");
        if (fruit != null) {
            fruit.eat();
        }
    }
}
