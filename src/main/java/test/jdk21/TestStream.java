package test.jdk21;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("5", "9", "1");
        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println( names);


        var  a = 1;

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());

        switch (a) {
            case 1 -> System.out.println("1111111111");
            case 2-> System.out.println("2222222222222");
            case 3 -> System.out.println("33333333333");

            default -> System.out.println("0");
        }

        String a1= """
                 <html>
                        <body>
                            <h1>Hello, World!</h1>
                        </body>
                    </html>
                """;

        System.out.println(a1);

        Person person = new Person("Alice", 30,1,1,1,1);
        System.out.println(person.name());
        System.out.println(person.age());
        System.out.println(person.age1());


        if (a1 instanceof String str) {
            System.out.println(str.toUpperCase());  // 直接使用str，无需转换
        }
    }
    public record Person(String name, int age,Integer... age1) {

    }
}
