/*
 * Developed by Uday Kumar
 * NIT Trichy, CA Department (MCA)
 * Software Engineer at McAfee, Bengaluru
 */
package mficafeteria;

import java.util.ArrayList;

/**
 *Bill contains
 * e_wwid: wwid of an employee
 * items: list of items
 * total: grand total of one time bill
 */
public class Bill {
    private int e_wwid;
    private ArrayList<Item> items;
    private int total;
    
    Bill(int e_wwid, ArrayList<Item> items, int total){
        this.e_wwid = e_wwid;
        this.items = items;
        this.total = total;
    }
    
    public int get_E_wwid(){
        return this.e_wwid;
    }
    
    public ArrayList<Item> get_Items(){
        return this.items;
    }
    public int total(){
        return this.total;
    }
}
