package classes;

import java.util.*;

public class Print {
    public static <T> void printList(ArrayList<T> list) {
        String str = "";
        for (T t : list) {
            str += t + "\n";
        }
        System.out.println(str);
    }

    public static <K, V> void printList(HashMap<K, V> hashmap) {
        ArrayList<V> list = new ArrayList<>();
        for (Map.Entry<K, V> h : hashmap.entrySet()) {
            list.add(h.getValue());
        }
        printList(list);
    }
}
