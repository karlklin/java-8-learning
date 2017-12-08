package java8.in.action.streams.model;

import java.util.Arrays;
import java.util.List;

public class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        super();
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public static List<Transaction> getTransactions() {
        Trader raol = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raol, 2012, 3000), new Transaction(raol, 2011, 400), new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
        return transactions;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (year != that.year) return false;
        if (value != that.value) return false;
        return trader != null ? trader.equals(that.trader) : that.trader == null;
    }

    @Override
    public int hashCode() {
        int result = trader != null ? trader.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + value;
        return result;
    }
}
