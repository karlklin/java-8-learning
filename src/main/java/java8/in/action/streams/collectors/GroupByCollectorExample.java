package java8.in.action.streams.collectors;

import java8.in.action.streams.model.Transaction;
import java8.in.action.streams.model.TransactionType;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static java8.in.action.streams.model.Transaction.getTransactions;

/**
 * Simple and nested grouping examples using different collectors {@link Collectors#summingInt(ToIntFunction)}, {@link Collectors#collectingAndThen(Collector, Function)}
 */
public class GroupByCollectorExample {

    public static void main(String[] args) {
        // grouping + simple example: group the transaction as Low, Medium and Large if transaction value is less then 100, between 100 and 500, and greater then 500.
        Map<TransactionType, List<Transaction>> transactionTypes = getTransactions().stream()
                .collect(groupingBy(transaction -> {
                    if (transaction.getValue() < 100) return TransactionType.LOW;
                    else if (transaction.getValue() < 500) return TransactionType.MEDIUM;
                    else return TransactionType.LARGE;
                }));

        System.out.println(transactionTypes);

        // grouping + nested grouping: group transaction by trader name and then present transaction per year
        Map<String, Map<Integer, List<Transaction>>> trader2Year2Transactions = getTransactions().stream().
                collect(groupingBy(t -> t.getTrader().getName(),
                        groupingBy(t2 -> t2.getYear())));

        System.out.println(trader2Year2Transactions);

        // grouping + nested grouping using different collectors: group by transaction type and provide sum of each group
        Map<TransactionType, Integer> transactionTypeCount = getTransactions().stream()
                .collect(groupingBy(t1 -> {
                    if (t1.getValue() < 100) return TransactionType.LOW;
                    else if (t1.getValue() < 500) return TransactionType.MEDIUM;
                    else return TransactionType.LARGE;
                }, summingInt(Transaction::getValue)));

        System.out.println(transactionTypeCount);

        // grouping and different collector and collect then: group by transaction type and provide max value for each transaction and transfer from Option to Value object
        Map<TransactionType, Transaction> transactionType2MaxValueMap = getTransactions().stream()
                .collect(groupingBy(t1 -> {
                    if (t1.getValue() < 100) return TransactionType.LOW;
                    else if (t1.getValue() < 500) return TransactionType.MEDIUM;
                    else return TransactionType.LARGE;
                }, collectingAndThen(maxBy(comparingInt(Transaction::getValue)), Optional::get)));

        System.out.println(transactionType2MaxValueMap);

        // grouping and mapping and toCollections: group by transaction type to years with removing duplicates

        Map<TransactionType, HashSet<Integer>> transactionType2Year = getTransactions().stream()
                .collect(groupingBy(t1 -> {
                    if (t1.getValue() < 100) return TransactionType.LOW;
                    else if (t1.getValue() < 500) return TransactionType.MEDIUM;
                    else return TransactionType.LARGE;
                }, mapping(t -> t.getYear(), Collectors.toCollection(HashSet::new))));


        System.out.println(transactionType2Year);
    }

}
