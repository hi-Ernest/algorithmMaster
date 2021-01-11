package design.first;

/**
 * @author: chenhuarui
 * @date: 2020/11/18 08:35
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("can not fly");
    }
}
