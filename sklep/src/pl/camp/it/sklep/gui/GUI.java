package pl.camp.it.sklep.gui;

import pl.camp.it.sklep.Authenticator;
import pl.camp.it.sklep.model.Item;
import pl.camp.it.sklep.model.User;

import java.util.Scanner;

public class GUI {
    public GUI() {
    }

    public static void showMenu(){
        System.out.println("1. Wyswietl liste produktow");
        System.out.println("2. Kup produkt");
        if(Authenticator.loggedUser.getRole().equals(User.Role.ADMIN)){
            System.out.println("3. Dodaj produkt");
        }
        System.out.println("4. Exit");
    }

    public static Item addItem(){
        Scanner scanner = new Scanner(System.in);
        Item newItem = new Item();
        System.out.println("Podaj nazwe: ");
        newItem.setName(scanner.nextLine());
        System.out.println("Podaj kod: ");
        newItem.setCode(scanner.nextLine());
        System.out.println("Podaj ilosc: ");
        newItem.setQuantity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Podaj cene: ");
        newItem.setPrice(scanner.nextDouble());
        scanner.nextLine();
        return newItem;
    }

    public static void showItems(Item[] items){
        for(Item element: items){
            if((element).getQuantity() > 0) {
                System.out.println(element.getName() + " " + element.getCode() + " " + element.getQuantity() + " " + element.getPrice());
            }
        }
    }

    public static User readLoginAndPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Password: ");
        return new User(login, scanner.nextLine());
    }
}
