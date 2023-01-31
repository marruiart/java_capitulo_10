package classes;

import exceptions.*;

public class Item implements Comparable<Item> {
    private String code;
    private String name;
    private Double price;
    private int units;  

    public Item(String code) {
        this(code, null, null, 0);
    }

    public Item(String code, String name, Double price, int units) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.units = units;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getUnits() {
        return this.units;
    }

    public void setUnits(int units) throws notEnoughQuantityException {
        if (units <= 0)
            throw new notEnoughQuantityException("\nNo se puede asignar una cantidad negativa o nulo");
        this.units = units;
    }

    public void addUnits(int units) throws notEnoughQuantityException {
        if (units <= 0)
            throw new notEnoughQuantityException("\nNo se puede añadir una cantidad negativa o nulo");
        this.units += units;
    }

    public void removeUnits(int units) throws notEnoughQuantityException {
        if (units <= 0)
            throw new notEnoughQuantityException("\nNo se puede retirar una cantidad negativa o nulo");
        this.units -= units;
    }

    @Override
    public int compareTo(Item a) {
        return (this.getName()).compareTo(a.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass()) && (this.code).equals(((Item) obj).getCode());
    }

    @Override
    public String toString() {
        return String.format("   | %s - %-32s (%4d ud x %-5.2f EUR/ud)    %-8.2f|\n",
                code, name, units, price, price * units);
    }

}