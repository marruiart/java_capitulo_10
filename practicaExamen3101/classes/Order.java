package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import exceptions.stockNotFoundException;

public class Order {
    public static <T> ArrayList<T> orderList(ArrayList<T> list, Comparator<T> comparator) throws stockNotFoundException {
        Collections.sort(list, comparator);
        if (list.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos.");
        return list;
    }
}
