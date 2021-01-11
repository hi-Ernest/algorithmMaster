package design.first;

/**
 * @author: chenhuarui
 * @date: 2020/11/18 08:33
 */
public abstract class Duck {

    QuackBehavior quackBehavior;

    FlyBehavior flyBehavior;

    public Duck() {}

    /**
     * 打印详情类
     */
    public abstract void display();

    public void preFormQuack() {
        quackBehavior.quack();
    }

    public void preFormFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("all ducks float, even decoys");
    }

    /**
     * 动态的设行为
     */
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}
