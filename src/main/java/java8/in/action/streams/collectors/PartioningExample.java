package java8.in.action.streams.collectors;

import java8.in.action.example.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartioningExample {

    public static void main(String[] args) {
        Map<Boolean, Map<Integer, List<Transaction>>> size2YearTransactions = Transaction.getTransactions().stream().collect(Collectors.partitioningBy(t -> t.getValue() > 1000, Collectors.groupingBy(Transaction::getYear)));

        System.out.println(size2YearTransactions);
    }
}
