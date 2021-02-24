package com.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ernest Chen
 * @date 2021/1/21.
 */
public class LambdaExpression {

    /**
     * 方法引用 && 构造器引用
     */
    public static void validLambda() {
        String external  = "EXTERNAL";
        List<String> stringCollection = Arrays.asList("hello", "lambda");
        List<String> externalCollection = stringCollection.stream().map(item ->{
            Long time = System.currentTimeMillis();
            //Variable used in lambda expression should be final or effectively final
            //external += "";
            return external + item + "-------" + time;
        }).collect(Collectors.toList());

        System.out.println(externalCollection);
    }

    public static void generateStream() {
        //Stream<Integer> stream = Stream.of(1, 2, 3);
        //Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
        Stream<List<Integer>> inputStream = Stream.of(
          Arrays.asList(1 ,2, 3),
          Arrays.asList(1 ,2),
          Arrays.asList(1)
        );
        //latMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起
        //最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
        Stream<Integer> outputStream = inputStream.flatMap(childStream -> childStream.stream());
        outputStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        LambdaExpression le = new LambdaExpression();
        //LambdaExpression.validLambda();
        LambdaExpression.generateStream();
    }

}
