package tmp;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

       Integer[] t = {1,2,3,4,5};
       List<Integer> list = Arrays.asList(t);

        System.out.println(list.subList(0,2));
        System.out.println(list.subList(2,5));
    }
}
