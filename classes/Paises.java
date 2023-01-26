package classes;

import java.util.HashMap;

public class Paises {
    public HashMap<String, String> capitales = new HashMap<String, String>();

    public Paises() {
        capitales.put("Espana", "Madrid");
        capitales.put("Portugal", "Lisboa");
        capitales.put("Francia", "París");
    }

    public String getCapital(String pais) {
        return capitales.get(pais);
    }

    public boolean agregar(String pais, String capital) {
        if (capitales.containsKey(pais))
            return false;
        capitales.put(pais, capital);
        return true;
    }
}
