package pl.camp.it.sklep.engine;

import pl.camp.it.sklep.Authenticator;
import pl.camp.it.sklep.database.ItemDB;
import pl.camp.it.sklep.database.UserDB;
import pl.camp.it.sklep.gui.GUI;
import pl.camp.it.sklep.gui.TableDraw;
import pl.camp.it.sklep.model.Item;
import pl.camp.it.sklep.model.User;

import java.util.Scanner;

public class Engine {
    public static void start() {
        final Scanner scanner = new Scanner(System.in);
        final ItemDB itemDB = new ItemDB();
        final UserDB userDB = new UserDB();

        boolean isWorking = Authenticator.authenticate(userDB);
        System.out.println(isWorking);
        while(isWorking){
            GUI.showMenu();
            switch (scanner.nextLine()){
                case "1":
                    GUI.showItems(itemDB.getItems());
                    break;
                case "2":
                    System.out.println("Podaj kod produktu: ");
                    Item itemSelected  = itemDB.checkItem(scanner.nextLine());
                    if (itemSelected == null) {
                    System.out.println("Zly kod");

                }else {
                        System.out.println("Podaj ilosc do kupienia: ");
                        int ilosc = scanner.nextInt();
                        scanner.nextLine();
                        if (ilosc <= itemSelected.getQuantity()) {
                            double wartosc = ilosc*itemSelected.getPrice();
                            System.out.println("Kwota do zaplaty: " + wartosc + " zl");
                            itemSelected.setQuantity(itemSelected.getQuantity()-ilosc);
                        } else System.out.println("Wprowadziles zbyt duza ilosc");
                    }
                    break;
                case "3":
                    if(Authenticator.loggedUser.getRole().equals(User.Role.ADMIN)){

                        itemDB.addItem(GUI.addItem());
                    }
                    break;
                case "4":
                    isWorking = false;
                    break;
                case "5":
                    TableDraw.drawTable(itemDB.getItems());
                    break;
                default:
                    System.out.println("Wprowadziles zla opcje.");
                    break;
            }
        }

    }
}
