package Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/10/3 16:56
 */
public class Streams {
    public static void main(String[] args) {
        int[] list = new int[10];
        for(int i = 0; i < 10; i++){
            list[i] = 10-i;
        }

        Arrays.stream(list).forEach(System.out::println);

        String s = "1 2 3 4 5";
        Arrays.stream(s.split(" ")).map(i -> i + "L").forEach(System.out::println);


    }
}
