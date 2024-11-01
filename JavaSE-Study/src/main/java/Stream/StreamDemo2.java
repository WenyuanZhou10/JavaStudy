package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Collections.addAll(list,"zhangsan,23","lisi,24","wangwu,25");
        Map<String, Integer> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(
                        s -> s.split(",")[0],
                        s -> Integer.parseInt(s.split(",")[1])
                ));
        Set<Map.Entry<String, Integer>> entries = collect.entrySet();
        for(Map.Entry entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(collect);
    }
}
