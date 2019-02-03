/*
 * Developed by Uday Kumar
 * NIT Trichy, CA Department (MCA)
 * Software Engineer at McAfee, Bengaluru
 */
package mficafeteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *wwid: Id of an Employee
 * bills: bills of 5 days of an employee
 * 
 */

public class Employee {
    int wwid;
    Map<Integer, ArrayList<Bill>> bills;
    
    Employee(int wwid){
        this.wwid=wwid;
        this.bills=new HashMap<>();
    }
    public int get_wwid(){
        return this.wwid;
    }
}
