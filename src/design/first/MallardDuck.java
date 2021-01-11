package design.first;

/**
 * @author: chenhuarui
 * @date: 2020/11/18 08:36
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("i am a real mallard duck");
    }
}
