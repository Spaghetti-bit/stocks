package edu.neumont.cvaughn;

import java.util.ArrayList;
import java.util.Date;

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

    private double cashValue = CashHandler.cashToInt(beginning_balance);
    private double stockValue;

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
    
    public double cashWorth()
    {
        for (Stock stk : stock_trades) {
            cashValue += stk.netWorth();
        }
        return CashHandler.cashToInt(beginning_balance) + cashValue;
    }

    public double stockValue()
    {
        for (Stock stk : stock_trades) {
            stockValue += stk.grossWorth();
        }
        return stockValue;
    }

    public void GenerateStatement()
    {
        Date statementDate = new Date();
        String output = "AccNum: " + account_number + "\nCash Worth: " + cashWorth() + "\nStock Value: " +stockValue() + "\nSatement Date: " + statementDate.toString();
        System.out.println(output);
    }

}
