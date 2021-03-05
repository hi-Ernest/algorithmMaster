package com.algorithm.z_datastruct;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Ernest Chen
 * @date 3/4/21 8:21 PM.
 */
public class Set {

     static class Person {
        private int id;
        private int score;
        public Person(int id, int score) {
            this.id = id;
            this.score = score;
        }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;

             Person person = (Person) o;

             if (id != person.id) return false;
             return score == person.score;
         }

         @Override
         public int hashCode() {
             int result = id;
             result = 31 * result + score;
             return result;
         }
     }

    public static void main(String[] args) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(23);
//        hashSet.add(23);
//        hashSet.add(44);
//        hashSet.add(55);
//        hashSet.remove(77);
//        Iterator<Integer> iterable = hashSet.iterator();
//        while (iterable.hasNext()) {
//            System.out.print(iterable.next() + " ");
//        }

        HashSet<Person> set = new HashSet<>();
        set.add(new Person(1,22));
        set.add(new Person(1,22));

        for (Person p : set) {
            System.out.println(p.id + " " + p.score);
        }

    }
}
