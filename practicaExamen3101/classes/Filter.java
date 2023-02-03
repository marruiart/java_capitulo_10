package classes;

import java.util.ArrayList;
import java.util.function.Predicate;
import exceptions.stockNotFoundException;

public class Filter {
    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> predicate) throws stockNotFoundException {
        if (list.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos.");
        list.removeIf(predicate);
        return list;
    }
}
