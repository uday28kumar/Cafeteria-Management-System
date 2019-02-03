/*
 * Developed by Uday Kumar
 * NIT Trichy, CA Department (MCA)
 * Software Engineer at McAfee, Bengaluru
 */
package mficafeteria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ukumar1
 */
public class MFICafeteria {

    /**
     * employees: Cafeteria has multiples employee.
     * breakfast
     * lunch
     * snack
     * dinner
     */ 
    ArrayList<Employee>employees;
    private Breakfast breakfast;
    private Lunch lunch;
    private Snack snack;
    private Dinner dinner;
    
    //constructor of MFICafeteria
    MFICafeteria(){
        employees = new ArrayList<>();
        breakfast = new Breakfast();
        lunch = new Lunch();
        snack = new Snack();
        dinner = new Dinner();
    }
    
    /* function to search employee using wwid
        returns object of existing employee or a new employee object if doesn't exists.
    */
    
    public Employee search_employee(int wwid){
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).wwid == wwid){
                return employees.get(i);
            }
        }
        return new Employee(wwid);
    }
    
    
    /* function for adding items 
    seperatly Breakfast, Lunch, Snacks and Dinner.
    name: Name of item
    Quantity: Quantity of item
    Price: Unit price of item
    Type: Type of item (breakfast, lunch, snacks and dinner
    Days available: availability of food on sun, mon, tue, wed, thu and fri.(denoted by 0 or 1)
    */
    public void add_item(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String name = sc.next();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        System.out.print("Enter food type (1. Breakfast 2. Lunch 3. Snacks 4. Dinner): ");
        int type = sc.nextInt();
        System.out.print("Enter the the days available(MON|TUE|WED|THU|FRI)(0/1):");
        int days[]=new int[5];
        for(int i=0;i<5;i++){
            days[i]=sc.nextInt();
        }
        switch(type){
            case 1:
                breakfast.insert_item(name, quantity, price, days);
                break;
            case 2:
                lunch.insert_item(name, quantity, price, days);
                break;
            case 3:
                snack.insert_item(name, quantity, price, days);
                break;  
            case 4:
                dinner.insert_item(name, quantity, price, days);
                break; 
        }
        System.out.println("Successfully inserted item...");
        return;
    }
    /* function to display all items available
    It display list of items in breakfast, lunch, snacks and dinnder.
    */
    public void show_items(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose items you want to list out.\n1. Breakfast. |2. Lunch. |3. Snacks. |4. Dinner.\nEnter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                breakfast.display();
                break;
            case 2:
                lunch.display();
                break;
            case 3:
                snack.display();
                break;
            case 4:
                dinner.display();
                break;
            default:
                System.out.println("Invalid choice...");
                break;
        }
    }
    
    /*function to order food
    Employee id: wwid of employee
    day: current day's number(0 to 5)
    choice: 1. breakfast
            2. lunch
            3. snacks
            4. dinner
    item_name: name of item
    quantity: quantity you want to buy
    
    */
    public void order_food(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id: ");
        int wwid = sc.nextInt();
        System.out.print("Enter the day number: (1 to 5): ");
        int day = sc.nextInt();
        System.out.println("1. Breakfast | 2. Lunch | 3. Snack | 4. Dinner");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        String ch= " ";
        ArrayList<Item> items;
        int total = 0;
        Bill bill = null;
        switch(choice){            
            case 1:
                total = 0;
                items = new ArrayList<>();
                do{
                    System.out.print("Enter item name: ");
                    String item_name = sc.next();
                    System.out.print("Enter Quantity: ");
                    int item_quantity = sc.nextInt();
                    Item item = breakfast.search(item_name, item_quantity, day);
                    if(item!= null){
                        items.add(item);
                        total+=item.get_Price();
                    }else{
                        System.out.println("Sorry! Item out of stock today...");
                    }
                    System.out.print("want to add more item(y/n): ");
                    ch = sc.next();
                }while(ch == "y");
                bill = new Bill(wwid, items, total);
                break;
            case 2:
                total = 0;
                items = new ArrayList<>();
                do{
                    System.out.print("Enter item name: ");
                    String item_name = sc.next();
                    System.out.print("Enter Quantity: ");
                    int item_quantity = sc.nextInt();
                    Item item = lunch.search(item_name, item_quantity, day);
                    if(item!= null){
                        items.add(item);
                        total+=item.get_Price();
                    }else{
                        System.out.println("Sorry! Item out of stock...");
                    }
                    System.out.print("want to add more item(y/n): ");
                    ch = sc.next();
                }while(ch == "y");
                bill = new Bill(wwid, items, total);
                break;   
            case 3:
                total = 0;
                items = new ArrayList<>();
                do{
                    System.out.print("Enter item name: ");
                    String item_name = sc.next();
                    System.out.print("Enter Quantity: ");
                    int item_quantity = sc.nextInt();
                    Item item = snack.search(item_name, item_quantity, day);
                    if(item!= null){
                        items.add(item);
                        total+=item.get_Price();
                    }else{
                        System.out.println("Sorry! Item out of stock...");
                    }
                    System.out.print("want to add more item(y/n): ");
                    ch = sc.next();
                }while(ch == "y");
                bill = new Bill(wwid, items, total);
                break;
            case 4:
                total = 0;
                items = new ArrayList<>();
                do{
                    System.out.print("Enter item name: ");
                    String item_name = sc.next();
                    System.out.print("Enter Quantity: ");
                    int item_quantity = sc.nextInt();
                    Item item = dinner.search(item_name, item_quantity, day);
                    if(item!= null){
                        items.add(item);
                        total+=item.get_Price();
                    }else{
                        System.out.println("Sorry! Item out of stock...");
                    }
                    System.out.print("want to add more item(y/n): ");
                    ch = sc.next();
                }while(ch == "y");
                bill = new Bill(wwid, items, total);
                break;
            default:
                System.out.println("Invalid input...");
                break;
        }
        printbill(bill,total);
        Employee current_emp = search_employee(wwid);
        if(current_emp.bills.containsKey(day)){
            current_emp.bills.get(day).add(bill);
        }else{
            ArrayList<Bill> b = new ArrayList<>();
            b.add(bill);
            current_emp.bills.put(day, b);
        }
        employees.remove(current_emp);
        employees.add(current_emp);
    }
    
    /*Generate 5 days' bill*/
    public void generate_bill(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id: ");
        int wwid = sc.nextInt();
        Employee emp = search_employee(wwid);
        Map<Integer, ArrayList<Bill>> all_bill = emp.bills;
        Iterator<Integer> iter = all_bill.keySet().iterator();
        int total = 0;
        while(iter.hasNext()){
            Integer it = iter.next();
            ArrayList<Bill>bill = all_bill.get(it);
            for(int i=0;i<bill.size();i++){
                Bill b = bill.get(i);
                ArrayList<Item> items = b.get_Items();
                for(int j=0;j<items.size();j++){
                    Item item = items.get(i);
                    System.out.println(item.get_Name()+"->"+item.get_Quantity()+"->"+item.get_Price());
                    total+=item.get_Price();
                }
            }
        }
        System.out.println("Total of this week: "+total);
    }
    
    /* Print current bill only*/
    public void printbill(Bill bill, int total){
        System.out.println("Your current bill is:-");
        System.out.println("Employee id: "+ bill.get_E_wwid());
        for(int i=0;i<bill.get_Items().size();i++){
            System.out.println(bill.get_Items().get(i).get_Name()+"-->"+bill.get_Items().get(i).get_Quantity()+"-->Rs."+bill.get_Items().get(i).get_Price());
        }
        System.out.println("Total: = Rs."+total);
    }
    
    /* main function*/
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        MFICafeteria mfi = new MFICafeteria();
        
        
        do{
            /* Menu to display */
            System.out.println("1. Add food items.\n2. List all available items.\n3. Order food items.\n4. Generate Bill of this week.\n0. Exit.");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    mfi.add_item();
                    break;
                case 2:
                    mfi.show_items();
                    break;
                case 3:
                    mfi.order_food();
                    break;
                case 4:
                    mfi.generate_bill();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter valid choice.");
                    break;
            }
        }while(true);
    }
}
