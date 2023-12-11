package org.example;

public class SupersedeItem {
    private String type;
    private String itemNumber;
    public SupersedeItem(String type, String itemNumber){
        this.itemNumber = itemNumber;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getItemNumber() {
        return itemNumber;
    }
}
