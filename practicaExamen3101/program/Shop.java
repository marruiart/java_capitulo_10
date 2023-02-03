package program;

import classes.*;
import exceptions.*;
import java.util.*;

public class Shop {
    private static Scanner s = new Scanner(System.in);

    public static void generateStock(Store store) throws alreadyExistsException {
        String code = "";
        String name = "";
        double price = 0;
        int units = 0;
        String[][] items = {
                { "8938422118", "Wine - Merlot Vina Carmen", "14.11", "128" },
                { "8272082840", "Eggs - Extra Large", "7.21", "659" },
                { "3375034261", "Chilli Paste, Hot Sambal Oelek", "18.63", "361" },
                { "5621387580", "Jam - Marmalade, Orange", "12.87", "37" },
                { "8353792497", "Pastry - Cherry Danish - Mini", "1.22", "628" },
                { "1777020874", "Wine - Mas Chicet Rose, Vintage", "5.0", "627" },
                { "2192152639", "Pancetta", "9.43", "132" },
                { "2483350847", "Cut Wakame - Hanawakaba", "8.27", "714" },
                { "3523772632", "Lid - High Heat, Super Clear", "16.52", "136" },
                { "6703184881", "Soap - Mr.clean Floor Soap", "4.13", "661" },
                { "9169674891", "Brandy Cherry - Mcguinness", "1.98", "404" },
                { "6279812054", "Table Cloth 144x90 White", "18.94", "398" },
                { "3469167387", "Salmon - Atlantic, Fresh, Whole", "9.78", "996" },
                { "9632388458", "Wine - White, French Cross", "5.11", "531" },
                { "8610868987", "Muffin Mix - Blueberry", "18.3", "282" },
                { "7373424036", "Clams - Littleneck, Whole", "14.48", "519" },
                { "7074031711", "Broccoli - Fresh", "2.65", "497" },
                { "1901003233", "Tea - Darjeeling, Azzura", "19.29", "261" },
                { "1028515656", "Garbag Bags - Black", "15.67", "775" },
                { "5342637518", "Quail - Whole, Boneless", "5.66", "292" },
                { "7461333584", "Pickle - Dill", "10.65", "361" },
                { "9833112904", "Pepper - Red Thai", "9.15", "925" },
                { "2881615148", "Bread Base - Toscano", "11.55", "555" },
                { "1807253336", "Flour - Strong", "2.49", "497" },
                { "6206427861", "Chocolate Liqueur - Godet White", "17.56", "547" },
                { "1223243031", "Tomatoes - Hot House", "4.39", "819" },
                { "3896081220", "Lid - 10,12,16 Oz", "4.61", "680" },
                { "9325930358", "Pork - Back, Long Cut, Boneless", "19.25", "452" },
                { "2217783968", "Soup Bowl Clear 8oz92008", "8.32", "897" },
                { "3829063482", "Coffee - Flavoured", "8.35", "170" },
                { "4998074121", "Toothpick Frilled", "10.73", "691" },
                { "5519713075", "Brandy - Bar", "6.35", "838" },
                { "8909804616", "Appetizer - Veg Assortment", "15.97", "630" },
                { "6368433769", "Maintenance Removal Charge", "5.82", "866" },
                { "1270650613", "Sambuca Cream", "14.55", "486" },
                { "5152482808", "Cleaner - Comet", "19.68", "560" },
                { "6961547784", "Scallops 60/80 Iqf", "8.56", "803" },
                { "5137934586", "Spice - Montreal Steak Spice", "8.45", "933" },
                { "3678056752", "Chips - Assorted", "12.44", "451" },
                { "5901105478", "Wine - Segura Viudas Aria Brut", "16.55", "195" },
                { "7942137081", "Beer - Sleeman Fine Porter", "7.56", "287" },
                { "3233179207", "Vinegar - White Wine", "19.2", "811" },
                { "5868255464", "Quinoa", "2.88", "660" },
                { "1394998614", "Cape Capensis - Fillet", "13.53", "108" },
                { "2326911907", "Muffin Batt - Ban Dream Zero", "16.01", "625" },
                { "3708167055", "Cranberries - Fresh", "5.01", "264" },
                { "6806557127", "Asparagus - White, Fresh", "3.67", "653" },
                { "9048679878", "Lemonade - Pineapple Passion", "16.74", "746" },
                { "2877571455", "Tuna - Bluefin", "8.06", "473" },
                { "8161011955", "Nut - Hazelnut, Ground, Natural", "14.01", "228" },
                { "4693743138", "Sauce - Caesar Dressing", "1.88", "651" },
                { "4867961937", "Coffee - Decaffeinato Coffee", "2.4", "266" },
                { "9362046925", "Ham Black Forest", "7.54", "813" },
                { "2835883642", "Sproutsmustard Cress", "13.92", "700" },
                { "5096165623", "Turkey - Breast, Double", "15.98", "873" },
                { "3921094040", "Cheese - Romano, Grated", "14.22", "20" },
                { "1273621973", "Beef - Flank Steak", "7.09", "475" },
                { "4618719726", "Pail - 4l White, With Handle", "19.44", "645" },
                { "5260061291", "Chicken - Ground", "2.63", "400" },
                { "9285459103", "Venison - Liver", "13.89", "745" },
                { "2757253470", "Coffee Caramel Biscotti", "18.76", "759" },
                { "1692085762", "Tomatoes", "7.34", "990" },
                { "4235995723", "Horseradish - Prepared", "18.57", "140" },
                { "5390159064", "Walkers Special Old Whiskey", "16.52", "725" },
                { "6045055452", "Compound - Passion Fruit", "2.31", "352" },
                { "2662345121", "Versatainer Nc - 9388", "11.11", "230" },
                { "2751974410", "Tart Shells - Sweet, 2", "15.32", "570" },
                { "8605933386", "Cornflakes", "3.13", "505" },
                { "2260354548", "Pork Loin Bine - In Frenched", "17.02", "836" },
                { "9104175074", "Latex Rubber Gloves Size 9", "7.99", "540" },
                { "2008890349", "Tamarillo", "15.9", "965" },
                { "1682164277", "Gatorade - Cool Blue Raspberry", "13.44", "357" },
                { "5156304211", "Wine - Red, Cabernet Sauvignon", "16.87", "952" },
                { "2830032728", "Chicken - Base, Ultimate", "13.72", "365" },
                { "9807378174", "Corn - Cream, Canned", "16.74", "502" },
                { "8415754841", "Turkey - Breast, Double", "1.46", "109" },
                { "6815954369", "Venison - Ground", "3.04", "879" },
                { "4331667402", "Seedlings - Mix, Organic", "19.82", "206" },
                { "6670868243", "Arizona - Green Tea", "3.43", "963" },
                { "8956957541", "Kellogs All Bran Bars", "1.32", "15" },
                { "5409934660", "Wine - Montecillo Rioja Crianza", "1.39", "824" },
                { "1571348708", "Squid - Breaded", "9.97", "513" },
                { "7933211375", "Plastic Wrap", "13.21", "50" },
                { "2175772400", "Cheese - Provolone", "5.88", "815" },
                { "8685469742", "Steam Pan Full Lid", "17.98", "436" },
                { "5277059693", "Shrimp - 150 - 250", "1.27", "901" },
                { "9285760137", "Soup - Campbells Asian Noodle", "14.04", "359" },
                { "1584196723", "Pomegranates", "17.3", "590" },
                { "2823515101", "Muffin Carrot - Individual", "14.47", "128" },
                { "7281734808", "Flour Dark Rye", "5.0", "306" },
                { "7353744407", "Magnotta - Bel Paese White", "14.45", "915" },
                { "3393138894", "Salt - Table", "4.72", "487" },
                { "9936106015", "Macaroons - Homestyle Two Bit", "12.48", "488" },
                { "7364478358", "Boogies", "14.0", "963" },
                { "8312618813", "Salmon Steak - Cohoe 6 Oz", "14.26", "197" },
                { "3648834041", "Lamb - Shoulder, Boneless", "9.62", "543" },
                { "2472978040", "Wine - Casillero Del Diablo", "3.12", "149" },
                { "9729597538", "Sauce - Balsamic Viniagrette", "1.9", "932" },
                { "3692873830", "Nut - Hazelnut, Whole", "16.17", "464" },
                { "6866368528", "Wine - Red, Pinot Noir, Chateau", "1.78", "768" } };

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                switch (j) {
                    case 0 -> code = items[i][j];
                    case 1 -> name = items[i][j];
                    case 2 -> price = Double.parseDouble(items[i][j]);
                    case 3 -> units = Integer.parseInt(items[i][j]);
                }
            }
            try {
                store.addItemToStock(new Item(code, name, price, units));
            } catch (nullException sin) {
                System.out.println(sin.getMessage());
            }
        }
    }

    private static void printConsultingMenu() {
        System.out.println("\n¿Qué desea consultar?");
        System.out.println("1. Listar todos los productos");
        System.out.println("2. Filtrar productos por nombre");
        System.out.println("3. Ordenar por precio ascendente");
        System.out.println("4. Ordenar por precio descendente");
        System.out.println("5. Ordenar de A a Z");
        System.out.println("6. Ordenar de Z a A");
        System.out.println("7. Filtrar por precio");
        System.out.println("8. Consultar si disponemos de un producto");
        System.out.println("Otro. Salir");
    }

    public static void consult(Store store)
            throws stockNotFoundException, nullException, notEnoughQuantityException {
        Purchase carrito = new Purchase(store);
        int r;
        String code;
        try {
            do {
                printConsultingMenu();
                r = Integer.parseInt(s.nextLine());
                switch (r) {
                    case 1:
                        Print.printList(carrito.getStore().getAllItems());
                        break;
                    case 2:
                        System.out.print("Introduzca el nombre del artículo: ");
                        Print.printList(carrito.getStore().filterByName(s.nextLine()));
                        break;
                    case 3:
                    Print.printList(carrito.getStore().orderPriceAsc());
                        break;
                    case 4:
                        Print.printList(carrito.getStore().orderPriceDes());
                        break;
                    case 5:
                        Print.printList(carrito.getStore().orderNameAsc());
                        break;
                    case 6:
                        Print.printList(carrito.getStore().orderNameDes());
                        break;
                    case 7:
                        System.out.print("Introduzca el precio mínimo: ");
                        double min = Double.parseDouble(s.nextLine());
                        System.out.print("Introduzca el precio máximo: ");
                        double max = Double.parseDouble(s.nextLine());
                        Print.printList(carrito.getStore().filterByPrice(min, max));
                        break;
                    case 8:
                        System.out.print("Código del producto: ");
                        code = s.nextLine();
                        Item a = carrito.getStore().getItem(code);
                        System.out.println(String.format("\nDisponemos de : %d ud de %s (%.2f euros/ud)",
                                a.getUnits(), a.getName(), a.getPrice()));
                        break;
                    default:
                        System.out.println("Volviendo al menú principal...");
                }

            } while (true && r < 9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printPurchasingMenu() {
        System.out.println("\nEstá usted comprando ¿Qué desea?");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Eliminar producto del carrito");
        System.out.println("3. Hacer consulta");
        System.out.println("4. Finalizar compra");
        System.out.println("Otro. Salir");
    }

    public static void finishShopping(Store store)
            throws stockNotFoundException, nullException, notEnoughQuantityException {
        Purchase carrito = new Purchase(store);
        int r;
        String code;
        int cantidad;
        try {
            do {
                printPurchasingMenu();
                r = Integer.parseInt(s.nextLine());
                switch (r) {
                    case 1:
                        System.out.print("Código del producto: ");
                        code = s.nextLine();
                        System.out.print("Cantidad: ");
                        cantidad = Integer.parseInt(s.nextLine());
                        try {
                            System.out.println("\nArticulo añadido\n" + carrito.addItemsToCart(code, cantidad));
                        } catch (notEnoughQuantityException nea) {
                            System.out.println(nea.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Código del producto: ");
                        code = s.nextLine();
                        System.out.print("Cantidad: ");
                        cantidad = Integer.parseInt(s.nextLine());
                        System.out.println("\nArticulo eliminado\n" + carrito.removeItemsFromCart(code, cantidad));
                        break;
                    case 3:
                        consult(store);
                        break;
                    case 4:
                        System.out.println(carrito.finishPurchase());
                        break;
                    default:
                        System.out.println("Volviendo al menú principal...");
                }

            } while (true && r < 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printReturnTicket() {
        System.out.println("\nEstá usted devolviendo productos ¿Qué desea?");
        System.out.println("1. Devolver producto");
        System.out.println("2. Consultar ticket de compra");
        System.out.println("3. Finalizar devolución");
        System.out.println("Otro. Salir");
    }

    public static void makeReturn(Store store) throws notSoldException {
        int r;
        String ticket;
        String code;
        int cantidad;
        System.out.print("Introduzca el código del ticket de compra: ");
        try {
            ticket = s.nextLine();
            Return devolucion = new Return(store, ticket);
            do {
                printReturnTicket();
                r = Integer.parseInt(s.nextLine());
                switch (r) {
                    case 1:
                        System.out.print("Código del producto: ");
                        code = s.nextLine();
                        System.out.print("Cantidad: ");
                        cantidad = Integer.parseInt(s.nextLine());
                        System.out.println("\nArticulo devuelto: " + devolucion.addItemsToReturnCart(code, cantidad));
                        break;
                    case 2:
                        System.out.println(devolucion.getAssociatedPurchase());
                        break;
                    case 3:
                        System.out.println("Muchas gracias, aquí tiene su ticket de devolución.");
                        System.out.println(devolucion.finishReturn());
                        break;
                    default:
                        System.out.println("Volviendo al menú principal...");
                }

            } while (true && r < 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printStoreDataMenu() {
        System.out.println("\nEstá usted devolviendo productos ¿Qué desea?");
        System.out.println("1. Consultar todas las compras");
        System.out.println("2. Consultar todas las devoluciones");
        System.out.println("Otro. Salir");
    }

    public static void consultStoreData(Store store) {
        System.out.print("Introduzca la contraseña del administrador: ");
        String pass = s.nextLine();
        int r;
        try {
            if (pass.equals("1234")) {
                do {
                    printStoreDataMenu();
                    r = Integer.parseInt(s.nextLine());
                    switch (r) {
                        case 1 -> store.printPurchases();
                        case 2 -> store.printReturns();
                        default -> System.out.println("Volviendo al menú principal...");
                    }

                } while (true && r < 3);
            } else
                System.out.println("\nLa contraseña no es correcta.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("¿Qué desea?");
        System.out.println("1. Realizar una compra");
        System.out.println("2. Realizar una devolución");
        System.out.println("3. Consultar datos del almacén");
        System.out.println("Otro. Me voy, adiós");
    }

    public static void main(String[] args)
            throws stockNotFoundException, notEnoughQuantityException, nullException, notSoldException,
            alreadyExistsException {
        Store store = new Store();
        int r;
        generateStock(store);
        do {
            printMenu();
            r = Integer.parseInt(s.nextLine());
            switch (r) {
                case 1 -> finishShopping(store);
                case 2 -> makeReturn(store);
                case 3 -> consultStoreData(store);
                default -> System.out.println("Muchas gracias, adiós.");
            }

        } while (true && r < 4);
        s.close();
    }
}
