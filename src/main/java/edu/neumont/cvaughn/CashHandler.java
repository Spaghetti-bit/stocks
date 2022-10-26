package edu.neumont.cvaughn;

final class CashHandler {
    public static double cashToInt(String cash)
    {
        if (cash == null) return 0;
        
        String splitStr = cash.replace("$", "");
        return Double.parseDouble(splitStr);
    }
}
