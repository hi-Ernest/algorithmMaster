package design.first;

/**
 * @author: chenhuarui
 * @date: 2020/11/18 08:40
 */
public class Main {

    public static void main(String[] args) {
        //通过构造器 new对应实例
        Duck mallard = new MallardDuck();
        mallard.preFormFly();
        mallard.setFlyBehavior(new FlyNoWay());
        mallard.preFormFly();
        mallard.preFormQuack();
    }
}
