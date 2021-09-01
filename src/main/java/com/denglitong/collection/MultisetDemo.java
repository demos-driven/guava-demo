package com.denglitong.collection;

import com.google.common.collect.*;

import java.util.Arrays;

/**
 * @author litong.deng@foxmail.com
 * @date 2021/9/1
 */
public class MultisetDemo {

    public static void main(String[] args) {
        String line = "twinkle twinkle little star";
        Multiset<String> words = HashMultiset.create();
        words.addAll(Arrays.asList(line.split(" ")));
        System.out.println(words); // [twinkle x 2, star, little]

        // twinkle
        // twinkle
        // star
        // little
        words.iterator().forEachRemaining(System.out::println);
        System.out.println(words.size()); // 4

        System.out.println(words.count("twinkle")); // 2
        System.out.println(words.count("little")); // 1
        System.out.println(words.count("<null>")); // 0
        // twinkle 2
        // star 1
        // little 1
        words.entrySet().forEach(entry -> {
            System.out.println(entry.getElement() + " " + entry.getCount());
        });
        // twinkle
        // star
        // little
        words.elementSet().forEach(System.out::println);

        words.remove("twinkle", 2);
        System.out.println(words); // [star, little]
        words.remove("star"); // words.setCount("star", 0);
        System.out.println(words); // [little]
        words.setCount("twinkle", 3);
        System.out.println(words); // [twinkle x 3, little]

        HashMultiset.create();
        TreeMultiset.create();
        LinkedHashMultiset.create();
        ConcurrentHashMultiset.create();
        ImmutableMultiset.builder();
    }
}
