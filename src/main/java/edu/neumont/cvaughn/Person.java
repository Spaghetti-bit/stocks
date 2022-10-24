package edu.neumont.cvaughn;

import java.util.ArrayList;

public class Person {

    // Person properties
    /**
     * Account Number of Share Holder
     */
    public Long account_number;
    /**
     * Social Security Number
     * Format: "xxx-xx-xxxx"
     */
    public String ssn;
    public String first_name;
    public String last_name;
    /**
     * FORMAT: sample@company.com
     */
    public String email;
    /**
     * FORMAT: "xxx-xxx-xxxx"
     */
    public String phone;
    /**
     * FORMAT: "$Amount"
     * This is a string because the JSON data is parsed as a string, will be cast into an int later on.
     */
    public String beginning_balance;
    /**
     * Holds all the stocks of the Person
     */
    public ArrayList<Stock> stock_trades = new ArrayList<Stock>();

    //Getters
    public Long getAccountNumber() { return account_number; }
    public String getSSN() { return ssn; }
    public String getFirstName() { return first_name; }
    public String getLastName() { return last_name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getBeginningBalance() { return beginning_balance; }
    public ArrayList<Stock> getStockTrades() { return stock_trades; }
    //Setters

    public Person() {

    }

    // :(
    

}
