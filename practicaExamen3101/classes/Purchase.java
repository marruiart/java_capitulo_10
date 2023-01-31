package classes;

import java.util.*;
import java.text.*;
import exceptions.*;

public class Purchase {
    private final Store STORE;
    private ArrayList<Item> cart;
    private String purchaseCode;
    private DateFormat purchaseDate;
    private double amount;

    public Purchase() {
        this(new Store());
    }

    public Purchase(Store store) {
        this.STORE = store;
        this.cart = new ArrayList<>();
    }

    public Store getStore() {
        return this.STORE;
    }

    public ArrayList<Item> getShoppingCart() {
        return this.cart;
    }

    public String getPurchaseCode() {
        return this.purchaseCode;
    }

    public DateFormat getPurchaseDate() {
        return this.purchaseDate;
    }

    public double getPurchaseAmount() {
        return this.amount;
    }

    /* CRUD */

    public Item addItemToCart(String code)
            throws stockNotFoundException, notEnoughQuantityException, nullException {
        return addItemsToCart(code, 1);
    }

    public Item addItemsToCart(String code, int units)
            throws stockNotFoundException, notEnoughQuantityException, nullException {
        Item item = getCartItem(code);
        if (item != null)
            units += item.getUnits();
        if (STORE.getItemStockUnits(code) < units)
            throw new notEnoughQuantityException("No hay suficiente stock del artículo " + code);
        else {
            int i = cart.indexOf(item);
            if (i != -1)
                cart.remove(i);
            item = STORE.getItem(code);
            item = new Item(code, item.getName(), item.getPrice(), units);
            cart.add(item);
        }
        return item;
    }

    public Item removeItemFromCart(String code)
            throws notEnoughQuantityException, stockNotFoundException, nullException {
        return removeItemsFromCart(code, 1);
    }

    public Item removeItemsFromCart(String code, int units)
            throws notEnoughQuantityException, stockNotFoundException, nullException {
        Item item = getCartItem(code);
        if (cart.contains(item)) {
            if (units < 0 || (item.getUnits() - units) < 0)
                throw new notEnoughQuantityException("\nNo se puede eliminar esa cantidad de artículos.");
            else if (item.getUnits() - units == 0)
                cart.remove(item);
            else
                item.removeUnits(units);
        } else
            throw new notEnoughQuantityException("\nEl artículo no se encuentra en el carrito.");
        return item;
    }

    public String finishPurchase()
            throws alreadyExistsException, notSoldException, notEnoughQuantityException, stockNotFoundException {
        if (cart.isEmpty())
            throw new notSoldException("El carrito está vacío.");
        this.purchaseDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        this.purchaseCode = STORE.generateCode(((Integer) STORE.getPurchases().size()).toString());
        for (Item item : cart)
            STORE.removeStock(item.getCode(), item.getUnits());
        STORE.addPurchase(this);
        return this.toString();
    }

    /* FILTERS */

    public Item getCartItem(String code) throws nullException {
        Item art = null;
        if (!cart.isEmpty()) {
            ArrayList<Item> aux = (ArrayList<Item>) cart.clone();
            aux.removeIf(item -> !item.equals(new Item(code)));
            if (aux.size() > 0)
                art = aux.get(0);
        }
        return art;
    }

    /* PRINT */

    public void printCart() {
        Print.printList(cart);
    }

    @Override
    public String toString() {
        this.amount = 0;
        String str = String.format("  TICKET DE COMPRA nº %s      %50s\n", this.purchaseCode,
                this.purchaseDate.format(new Date()));
        str += "--------------------------------------------------------------------------------------------\n";
        for (Item item : cart) {
            this.amount += (item.getPrice() * item.getUnits());
            str += item + "\n";
        }
        str += "--------------------------------------------------------------------------------------------\n";
        str += String.format("%60s  IMPORTE TOTAL: %.2f euros ", "", this.amount);
        return str;
    }

}
