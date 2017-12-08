package java8.in.action.streams.collectors;

import java8.in.action.streams.model.Transaction;
import java8.in.action.streams.model.TransactionType;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java8.in.action.streams.model.Transaction.getTransactions;

public class GroupByCollectorExample {

    public static  void main (String[] args) {
        // grouping + simple example

        Map<TransactionType, List<Transaction>> transactionTypes = getTransactions().stream().collect(groupingBy(transaction -> {
            if (transaction.getValue() < 100) return TransactionType.LOW;
            else if (transaction.getValue() < 500) return TransactionType.MEDIUM;
            else return TransactionType.LARGE;
        }));

        System.out.println(transactionTypes);

        // grouping + nested grouping

        Map<String, Map<Integer, List<Transaction>>> trader2Year2Transactions = getTransactions().stream().
                collect(groupingBy(t -> t.getTrader().getName(),
                        groupingBy(t2 -> t2.getYear())));
        System.out.println(trader2Year2Transactions);

        // grouping + different collectors

        Map<TransactionType, Integer> transactionTypeCount = getTransactions().stream().collect(groupingBy(t1 -> {
            if (t1.getValue() < 100) return TransactionType.LOW;
            else if (t1.getValue() < 500) return TransactionType.MEDIUM;
            else return TransactionType.LARGE;
        }, Collectors.summingInt(Transaction::getValue)));

        System.out.println(transactionTypeCount);


        // grouping and different collector and collect then

        Map<TransactionType, Transaction> transactionTypeOptionalMap = getTransactions().stream().collect(groupingBy(t1 -> {
            if (t1.getValue() < 100) return TransactionType.LOW;
            else if (t1.getValue() < 500) return TransactionType.MEDIUM;
            else return TransactionType.LARGE;
        }, collectingAndThen(maxBy(Comparator.comparingInt(Transaction::getValue)), Optional::get)));

        System.out.println(transactionTypeOptionalMap);

        // grouping and mapping and toCollections

        Map<TransactionType, HashSet<Integer>> transactionType2Year = getTransactions().stream().collect(groupingBy(t1 -> {
            if (t1.getValue() < 100) return TransactionType.LOW;
            else if (t1.getValue() < 500) return TransactionType.MEDIUM;
            else return TransactionType.LARGE;
        }, mapping(t -> t.getYear(), Collectors.toCollection(HashSet::new))));

        System.out.println(transactionType2Year);
    }

}
