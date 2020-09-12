package tmp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenhuarui
 */
public class Main {

    public static void main(String[] args) {
       User user = new User(89);
       User user1 = new User(100);
       User user2 = new User(1);

       List<User> list = new LinkedList<>();
       list.add(user);
       list.add(user1);
       list.add(user2);

        //list.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());

        list.sort(Comparator.comparing(User::getId));
        for (User u : list) {
            System.out.println(u.getId());
        }
    }


    public static class User {
        private int id;

        public User(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
