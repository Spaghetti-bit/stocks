package edu.neumont.cvaughn;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import scala.collection.immutable.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        /*
        * Statement Date is the date the application was run.
        */
        Date statementDate = new Date();
        
        //Read Data
        /*
         * JSON Parser and Reader
         */
        JSONParser jParser = new JSONParser();
        try {
            ArrayList<Person> people = new ArrayList<Person>();
            //JSON Array
            File jsonFile = new File("C:\\Users\\LaptopNeumont-Sage\\CSC180 Workspace DIR\\Stomks\\stocks\\stock_transations-3.by.account.holder.json");
            // Scanner definition and modifiers
            Scanner fileReader = new Scanner(jsonFile);
            //fileReader.useDelimiter("\n");
            // END

            // Data from File
            String fileData = "";
            // Read and insert file data into the variable "fileData"
            while (fileReader.hasNextLine())
            {
                fileData += fileReader.nextLine();
            }
            JSONArray share_holders = (JSONArray) jParser.parse(fileData);
            /*
             * FORMAT:
             * {index}:
             *          {
             *              account_number: int,
             *              ssn: "xxx-xx-xxxx" (string),
             *              first_name: string,
             *              last_name: string,
             *              email: string,
             *              phone: string,
             *              beginning_balance: string?,
             *              stock_trades[]: stock
             *                      {
             *                          type: string,
             *                          stock_symbol: string,
             *                          count_shares: int,
             *                          price_per_share: string?
             *                      }
             *          }
             */
            for (int index = 0; index < share_holders.size(); index++)
            {
                JSONObject jsonObject = (JSONObject) share_holders.get(index);
                // Lambda Madness

                
                // key : value
                Person person = new Person();
                Stock stock = new Stock();
                Field[] personFields = Person.class.getFields();
                Field[] stockFields = Stock.class.getFields();

                jsonObject.keySet().forEach(keyStr -> 
                {
                    Object keyVal = jsonObject.get(keyStr);
                    String stringKey = (String) keyStr;
                    if (stringKey.equals("stock_trades"))
                    {
                        // TODO: Implement Stock Trades
                        // Stock Trades.... Yay!
                        if (keyVal instanceof JSONArray)
                        {
                            JSONArray stockArray = (JSONArray) keyVal;
                            for (int stockIndex = 0; stockIndex < stockArray.size(); stockIndex++)
                            {
                                JSONObject keyValObj = (JSONObject) stockArray.get(stockIndex);
                                keyValObj.keySet().forEach(keyValStr ->
                                {
                                    Object stockObj = keyValObj.get(keyValStr);
                                    for (int stockI = 0; stockI < stockFields.length; stockI++)
                                    {
                                        if (stockFields[stockI].getName().equals(keyValStr))
                                        {
                                            try {
                                                stockFields[stockI].set(stock, stockObj);
                                                break;
                                            } catch (IllegalArgumentException e) {
                                                e.printStackTrace();
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    
                                });
                            }
                            person.stock_trades.add(stock);
                        }
                    }
                    for (int i = 0; i < personFields.length; i++)
                    {

                        if (personFields[i].getName().equals(keyStr))
                        {
                            try {
                                personFields[i].set(person, keyVal);
                                break;
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                



                //Increment Index
                index++;
                people.add(person);
            }
            
            // Person / Stock Creation
            /*
             * <--Person--> has a(n); 
             * account number (int)
             * name (String)
             * social security number [ssn] (String)
             * email (String)
             * Phone Number (String)
             */
            System.out.println(":)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Output HTML
    }
}
