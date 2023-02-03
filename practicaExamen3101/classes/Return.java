package classes;

import java.util.*;
import java.text.*;
import exceptions.*;

public class Return {
    private final Store STORE;
    private final Purchase PURCHASE;
    private ArrayList<Item> itemsToReturn;
    private String returnCode;
    private DateFormat returnDate;
    private double returnedAmount;

    public Return(Store store, String purchaseCode) {
        this.STORE = store;
        this.PURCHASE = STORE.getPurchaseByCode(purchaseCode);
        this.itemsToReturn = new ArrayList<>();
    }

    public Store getStoreName() {
        return this.STORE;
    }

    public Purchase getAssociatedPurchase() {
        return this.PURCHASE;
    }

    public ArrayList<Item> getItemsToReturn() {
        return this.itemsToReturn;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public DateFormat getReturnDate() {
        return this.returnDate;
    }

    public Double getReturnedAmount() {
        return this.returnedAmount;
    }

    /* CRUD */

    public Item addItemToReturnCart(String code)
            throws stockNotFoundException, notEnoughQuantityException, nullException {
        return addItemsToReturnCart(code, 1);
    }

    public Item addItemsToReturnCart(String code, int units)
            throws stockNotFoundException, notEnoughQuantityException, nullException {
        Item item = getCartItem(code);
        if (item != null)
            units += item.getUnits();
        if (PURCHASE.getCartItem(code).getUnits() < units)
            throw new notEnoughQuantityException("No se compraron tantos artículos");
        else {
            int i = itemsToReturn.indexOf(item);
            if (i != -1)
                itemsToReturn.remove(i);
            item = STORE.getItem(code);
            item = new Item(code, item.getName(), item.getPrice(), units);
            itemsToReturn.add(item);
        }
        return item;
    }

    public Item removeFromCart(String code)
            throws notEnoughQuantityException, stockNotFoundException, nullException {
        return removeFromCart(code, 1);
    }

    public Item removeFromCart(String code, int units)
            throws notEnoughQuantityException, stockNotFoundException, nullException {
        Item item = getCartItem(code);
        if (itemsToReturn.contains(item)) {
            if (units < 0 || (item.getUnits() - units) < 0)
                throw new notEnoughQuantityException("\nNo se puede eliminar esa cantidad de artículos.");
            else if (item.getUnits() - units == 0)
                itemsToReturn.remove(item);
            else
                item.removeUnits(units);
        } else
            throw new notEnoughQuantityException("\nEl artículo no se encuentra en el carrito.");
        return item;
    }

    public String finishReturn()
            throws notSoldException, alreadyExistsException, notEnoughQuantityException, stockNotFoundException {
        if (itemsToReturn.isEmpty())
            throw new notSoldException("No se ha devuelto ningún artículo.");
        this.returnDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        this.returnCode = STORE.generateCode(((Integer) STORE.getReturns().size()).toString());
        for (Item item : itemsToReturn)
            STORE.returnStock(item.getCode(), item.getUnits());
        STORE.addReturn(this);
        return this.toString();
    }

    /* FILTERS */

    public Item getCartItem(String code) throws nullException {
        ArrayList<Item> aux = (ArrayList<Item>) itemsToReturn.clone();
        Item art = null;
        aux.removeIf(item -> !item.equals(new Item(code)));
        if (aux.size() > 0)
            art = aux.get(0);
        return art;
    }

    /* PRINT */

    public void printPurchaseTicket() {
        System.out.println(this.PURCHASE);
    }

    @Override
    public String toString() {
        this.returnedAmount = 0;
        String devolucion = String.format("  DEVOLUCIÓN       %70s\n", this.returnDate.format(new Date()));
        devolucion += "--------------------------------------------------------------------------------------------\n";
        for (Item a : itemsToReturn) {
            this.returnedAmount += (a.getPrice() * a.getUnits());
            devolucion += a;
        }
        devolucion += "--------------------------------------------------------------------------------------------\n";
        devolucion += String.format("%70s  TOTAL: -%.2f euros ", "", this.returnedAmount);
        return devolucion;
    }

    public Object getPurchaseCode() {
        return null;
    }

    public boolean containsKey(Object purchaseCode) {
        return false;
    }
}
