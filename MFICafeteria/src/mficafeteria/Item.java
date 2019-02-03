/*
 * Developed by Uday Kumar
 * NIT Trichy, CA Department (MCA)
 * Software Engineer at McAfee, Bengaluru
 */
package mficafeteria;

/**
 *name: Name of item
 * quantity: Quantity of item
 * price: price of item
 * type: type of an item
 * days_available: available days (Mon to Fri)
 */
public class Item {
    private String name;
    private int quantity;
    private int price;
    private String type;
    private int days_available[];
    
    Item(String name, int quantity, int price, String type, int days_available[]){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.type=type;
        this.days_available=days_available;
    }
    
    public String get_Name(){
        return this.name;
    }
    public int get_Quantity(){
        return this.quantity;
    }
    public int get_Price(){
        return this.price;
    }
    public String get_type(){
        return this.type;
    }
    public int[] get_days_available(){
        return this.days_available;
    }
}
