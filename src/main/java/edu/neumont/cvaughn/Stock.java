package edu.neumont.cvaughn;

public class Stock {
    // Variables
    public String stock_symbol;
    public Long count_shares;
    public String price_per_share;
    public String type;
    //Getter / Setter
    /*
     * Price Per Share, returns a String
     */
    public String getPPS() { return price_per_share; }
    public void setPPS(String pps) { this.price_per_share = pps; }

    public String getSymbol() { return stock_symbol; }
    public void setSymbol(String symbol) { this.stock_symbol = symbol; }

    public Long getCount() { return count_shares; }
    public void setCount(Long count) { this.count_shares = count; }

    /*
     * Buy / Sell
     */
    public String type() { return type; }
    public void setType(String type) { this.type = type; }

    public double netWorth()
    {
        double total = (double) (count_shares * CashHandler.cashToInt(price_per_share));
        switch (type)
        {
            case "Buy":
            return -total;

            case "Sell":
            count_shares = (long) 0;
            return total;
        }
        return 0;
    }

    public double grossWorth()
    {
        return (double) (count_shares * CashHandler.cashToInt(price_per_share));
    }


}
