package design.first;

/**
 * @author: chenhuarui
 * @date: 2020/11/18 08:32
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("muteQuack");
    }
}
