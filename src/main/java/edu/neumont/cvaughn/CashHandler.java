package edu.neumont.cvaughn;

final class CashHandler {
    public static int cashToInt(String cash)
    {
        return Integer.parseInt(cash.split("$")[1]);
    }
}
