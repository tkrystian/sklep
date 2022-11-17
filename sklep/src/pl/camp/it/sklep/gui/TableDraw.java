package pl.camp.it.sklep.gui;

import pl.camp.it.sklep.model.Item;

public class TableDraw {
    private static int totalLength = 0;
    private static int nameLength = 7;
    private static int codeLength = 3;
    private static int quantityLength = 5;
    private static int priceLength = 4;

    public static void drawTable(Item[] items){
        for (Item item : items) {
            if (item.getName().length() > nameLength) {
                nameLength = item.getName().length();
            }
        }
        for (Item item : items) {
            if (item.getCode().length() > codeLength) {
                codeLength = item.getCode().length();
            }
        }
        for (Item item : items) {
            if (Integer.toString(item.getQuantity()).length() > quantityLength) {
                quantityLength = Integer.toString(item.getQuantity()).length();
            }
        }
        for (Item item : items) {
            if (Double.toString(item.getPrice()).length() > priceLength) {
                priceLength = Double.toString(item.getPrice()).length();
            }
        }
        totalLength = nameLength+codeLength+quantityLength+priceLength+5;
        printSeparator();
        printString("Produkt",nameLength);
        printString("Kod",codeLength);
        printString("Ilosc",quantityLength);
        printString("Cena",priceLength);
        printSeparator();
        for (Item item : items) {
            printString(item.getName(), nameLength);
            printString(item.getCode(), codeLength);
            printString(Integer.toString(item.getQuantity()), quantityLength);
            printString(Double.toString(item.getPrice()), priceLength);
            printSeparator();
        }
    }

    public static void printSeparator(){
        System.out.println();
        for(int i=0; i<totalLength; i++){
            System.out.print("-");
        }
        System.out.print("\n|");
    }

    public static void printString(String string, int length){
        System.out.print(string);
        for (int i = 0; i < length - string.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }
}
