package pl.camp.it.sklep.database;

import pl.camp.it.sklep.model.Item;

public class ItemDB {
    private Item[] items = new Item[2];

    public ItemDB() {
        this.items[0] = new Item("Suchy chleb", "001", 15, 100.07);
        this.items[1] = new Item("Woda", "007", 18, 420.00);
    }

    public Item checkItem(String code){
        for (Item element: this.items) {
            if(element.getCode().equals(code) && element.getQuantity() > 0){
                return element;
            }
        }
           return null;
    }

    public void addItem(Item item){
        Item[] items1= new Item[this.items.length+1];
        for(int i = 0; i< this.items.length; i++){
            items1[i] = this.items[i];
        }
        items1[items1.length-1] = item;
        this.items = items1;
    }

    public Item[] getItems() {
        return items;
    }
}
