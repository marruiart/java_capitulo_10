package classes;

import java.util.*;
import exceptions.*;

public class Store {
    private final String NAME;
    private static int n = 0;
    private HashMap<String, Item> stock;
    private HashMap<String, Purchase> purchases;
    private HashMap<String, Return> returns;

    public Store() {
        this("Store " + (++n));
    }

    public Store(String name) {
        this.NAME = name;
        this.stock = new HashMap<>();
        this.purchases = new HashMap<>();
        this.returns = new HashMap<>();
    }

    public String generateCode(String num) {
        String code = "";
        for (int item = 0; item < 10 - num.length(); item++) {
            code += "0";
        }
        return code + num;
    }

    public String getStoreName() {
        return this.NAME;
    }

    /* STOCK CRUD */

    public Item addItemToStock(Item item) throws nullException, alreadyExistsException {
        if (item == null)
            throw new nullException("\nNo se puede agregar un artículo nulo.");
        else if (stock.containsKey(item.getCode()))
            throw new alreadyExistsException("\nEse código ya existe en el almacén.");
        else
            stock.put(item.getCode(), item);
        return item;
    }

    public Item addItemToStock(String code, String name)
            throws nullException, alreadyExistsException, notEnoughQuantityException {
        return addItemToStock(new Item(code, name, null, 0));
    }

    public Item addItemToStock(String code, String name, Double price, int units)
            throws nullException, alreadyExistsException, notEnoughQuantityException {
        return addItemToStock(new Item(code, name, price, 0));
    }

    public ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (Map.Entry<String, Item> item : stock.entrySet()) {
            items.add(item.getValue());
        }
        return items;
    }

    public Item getItem(String code) throws stockNotFoundException {
        Item item = stock.get(code);
        if (item == null || item.getUnits() == 0)
            throw new stockNotFoundException("\nEl artículo no se encuentra en el almacén.");
        return item;
    }

    public Item updateItem(String code, Item replacement) throws stockNotFoundException, nullException {
        if (!stock.containsKey(code))
            throw new stockNotFoundException("\nEl artículo no se encuentra en el almacén.");
        else if (replacement == null)
            throw new nullException("\nNo se puede agregar un artículo nulo.");
        else {
            stock.put(code, replacement);
            return replacement;
        }
    }

    public Item updateItem(String code, String name, Double price, int units)
            throws stockNotFoundException, nullException, notEnoughQuantityException {
        return updateItem(code, new Item(code, name, price, units));
    }

    public Item deleteItem(Item item) throws stockNotFoundException {
        return deleteItem(item.getCode());
    }

    public Item deleteItem(String code) throws stockNotFoundException {
        if (!stock.containsKey(code))
            throw new stockNotFoundException("\nEl artículo no se encuentra en el almacén.");
        else {
            Item item = stock.get(code);
            stock.remove(code);
            return item;
        }
    }

    /* STOCK IN / OUT */

    public Item removeStock(String code, int removedUnits)
            throws notEnoughQuantityException, stockNotFoundException {
        Item item = getItem(code);
        if (item.getUnits() < removedUnits) {
            throw new notEnoughQuantityException(
                    String.format("\nNo hay suficiente stock en el almacén (código: %s).", code));
        }
        item.removeUnits(removedUnits);
        return item;
    }

    public Item returnStock(String code, int returnedUnits)
            throws notEnoughQuantityException, stockNotFoundException {
        Item item = getItem(code);
        item.addUnits(returnedUnits);
        return item;
    }

    /* PURCHASES / RETURNS CRUD */

    public HashMap<String, Purchase> getPurchases() {
        return this.purchases;
    }

    public HashMap<String, Return> getReturns() {
        return this.returns;
    }

    public Purchase getPurchaseByCode(String code) {
        return this.purchases.get(code);
    }

    public Return getReturnByCode(String code) {
        return this.returns.get(code);
    }

    public Purchase addPurchase(Purchase purchase) throws alreadyExistsException {
        if (purchase == null)
            return null;
        else if (purchases.containsKey(purchase.getPurchaseCode()))
            throw new alreadyExistsException("El código de compra ya existe.");
        else {
            this.purchases.put(purchase.getPurchaseCode(), purchase);
            return this.purchases.get(purchase.getPurchaseCode());
        }
    }

    public Return addReturn(Return ret) throws alreadyExistsException {
        if (ret == null)
            return null;
        else if (ret.containsKey(ret.getPurchaseCode()))
            throw new alreadyExistsException("El código de devolución ya existe.");
        else {
            this.returns.put(ret.getReturnCode(), ret);
            return this.returns.get(ret.getReturnCode());
        }
    }

    public Purchase updatePurchase(Purchase purchase) throws alreadyExistsException {
        if (purchase != null && purchases.containsKey(purchase.getPurchaseCode())) {
            this.purchases.put(purchase.getPurchaseCode(), purchase);
            return this.purchases.get(purchase.getPurchaseCode());
        }
        return null;
    }

    /* PRINT ITEMS IN STOCK */

    public void printItem(String code) throws stockNotFoundException {
        Item item = getItem(code);
        printItem(item);
    }

    public void printItem(Item item) {
        System.out.println(item);
    }

    public void printItems() {
        Print.printList(getAllItems());
    }

    public void printItems(ArrayList<Item> itemsList) {
        Print.printList(itemsList);
    }

    /* PRINT PURCHASES / RETURNS */

    public void printPurchases() {
        System.out.println("COMPRAS REALIZADAS\n");
        System.out.println(
                "==============================================================================================================================\n");
        Print.printList(purchases);
    }

    public void printReturns() {
        System.out.println("DEVOLUCIONES REALIZADAS\n");
        System.out.println(
                "==============================================================================================================================\n");
        Print.printList(returns);
    }

    /* FILTERS */

    public int getItemStockUnits(String code) throws stockNotFoundException {
        return getItem(code).getUnits();
    }

    public ArrayList<Item> filterByName(String name) throws stockNotFoundException {
        ArrayList<Item> articulos = getAllItems();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        articulos.removeIf(item -> !item.getName().startsWith(name));
        return articulos;
    }

    public ArrayList<Item> orderNameAsc() throws stockNotFoundException {
        ArrayList<Item> articulos = getAllItems();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos);
        return articulos;
    }

    public ArrayList<Item> orderNameDes() throws stockNotFoundException {
        ArrayList<Item> articulos = getAllItems();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos, Collections.reverseOrder());
        return articulos;
    }

    public ArrayList<Item> orderPriceAsc() throws stockNotFoundException {
        ArrayList<Item> articulos = getAllItems();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos, Item.priceComparator);
        return articulos;
    }

    public ArrayList<Item> orderPriceDec() throws stockNotFoundException {
        ArrayList<Item> articulos = getAllItems();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos, Item.priceComparator.reversed());
        return articulos;
    }

    @Override
    public String toString() {
        return this.NAME;
    }
}
