package Collection.Map;

import Collection.pojo.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/10/3 16:35
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Student,String> hmap = new HashMap<>();

        Student s1 = new Student(23,"zs");
        Student s2 = new Student(24,"ls");
        Student s3 = new Student(25,"ww");

        hmap.put(s1,"shanghai");
        hmap.put(s2,"shanghai");
        hmap.put(s3,"shanghai");

        Set<Student> students = hmap.keySet();
        for (Student student : students){
            System.out.println(student + " " + hmap.get(student));
        }


        System.out.println("-------------------");

        Set<Entry<Student, String>> entries = hmap.entrySet();
        for (Entry<Student, String> entry : entries){
            System.out.println(entry.getKey() + entry.getValue());
        }

        System.out.println("-------------------");
        hmap.forEach((student,s)-> System.out.println(student + s));
    }


}
