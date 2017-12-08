package java8.in.action.streams.collectors;

import java8.in.action.streams.model.Transaction;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java8.in.action.streams.model.Transaction.getTransactions;

/**
 * Partitioning meaning dividing collectors into two parts based on predicate
 */
public class PartioningByCollectorExample {

    public static void main(String[] args) {
        Map<Boolean, List<Transaction>> size2Transactions = getTransactions().stream()
                .collect(partitioningBy(o -> o.getValue() > 100));

        Map<Boolean, Map<Integer, List<Transaction>>> size2Years = getTransactions().stream()
                .collect(partitioningBy(t -> t.getValue() > 1000,
                        groupingBy(Transaction::getYear)));

        System.out.println(size2Years);
    }
}
