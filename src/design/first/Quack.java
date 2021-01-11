package design.first;

/**
 * @author: chenhuarui
 * @date: 2020/11/18 08:31
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack");
    }
}
