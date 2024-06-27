import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class streamex {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(2);
        list.add(3);
        list.add(-1);

        // TASK1. print all even elements
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0) {
                // System.out.println(list.get(i));
            }
        }

        //list.stream().filter(e -> e % 2 != 0 && e > 0).forEach(System.out::println);

        int count = (int) list.stream().filter(e -> e % 2 == 0).count();
        // System.out.println(count);
        // boolean b = list.stream().anyMatch(e -> e % 2 == 0);
        // System.out.println(b);
        
        // find all the odd numbers and then multiply all of them with 2
        list.stream().filter(e -> e % 2 != 0)
            .map(e -> e * 2).forEach(System.out::println);

        int max = list.stream().max((a, b) -> {
            if(a < b) {
                return -1;
            }
            return 0;
        }).get();

        // list.stream().sorted().forEach(System.out::println);
        // Collections.sort(list);

        // System.out.println(max);

    }
}