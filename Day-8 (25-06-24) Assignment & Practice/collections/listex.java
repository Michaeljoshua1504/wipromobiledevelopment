package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class listex {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(34);
        list.add(2);
        list.add(90);
        list.add(5);

        // list.remove(20);
        // list.remove(4);

        // print our list -->
        // 1. for-each
        for (Integer i : list) {
            // System.out.println(i.intValue());
        }
        // 2. Iterator
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            // System.out.println(it.next());
        }
        // 3. for-i loop
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
        }

        // 4. strings
        // System.out.println(list.toString());

        // 5. foreach
        myconsumer obj = new myconsumer();
        // list.forEach(obj);

        // 6. foreach lambda
        // list.forEach(e -> System.out.println(e));

        // 7. foreach optmised
        list.forEach(System.out::println);

    }

}

class myconsumer implements Consumer<Integer> {
    @Override
    public void accept(Integer t) {
        System.out.println(t);
    }
}
